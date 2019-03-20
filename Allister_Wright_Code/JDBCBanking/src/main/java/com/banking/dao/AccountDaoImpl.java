package com.banking.dao;

//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
//import java.sql.Types;
import java.util.ArrayList;

import com.banking.account.Account;
import com.banking.account.Account.AccountState;
import com.banking.user.Customer;

public class AccountDaoImpl implements AccountDao
{
	private static String jdbcText = "jdbc:oracle:thin:@";
	private static String endpoint = "oracle-instance0304-awright.cx5jdxctrerc.us-east-2.rds.amazonaws.com";
	private static String port = ":1521";
	private static String sid = ":ORCL";
	private static String url = jdbcText + endpoint + port + sid;

	private static String username = "cassion";
	private static String password = "stateandrevolution";

	@Override
	public int registerAccount(Customer customer, Account account)
	{
		System.out.println("## Submitting new account ...");
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			// Add account to Account Table
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO BANK_ACCOUNT "
					+ "(account_number, account_balance, account_type, account_state) "
					+ "VALUES (?, ?, ?, ?)");
			ps.setLong(1, account.getAccountNumber());
			ps.setDouble(2, account.getBalance());
			ps.setString(3, account.getType().toString());
			ps.setString(4, account.getState().toString());
			
			ps.executeQuery();
			commitDB();
			// Make sure new account exists for jdbc to find in next insert
			
			// Add Customer and Account to Junction Table
			return 0;
		}
		catch (SQLIntegrityConstraintViolationException e)
		{
			// Account already exists, confirm user association
			addJointOwner(customer, account);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public int addJointOwner(Customer customer, Account account)
	{
		System.out.println("## Adding owner ...");
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			// Add account to Account Table
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO OWNER_ASSOCIATION "
					+ "(customer_username, account_number) "
					+ "VALUES (?, ?)");
			ps.setString(1, customer.getUsername());
			ps.setLong(2, account.getAccountNumber());
			ps.executeQuery();
			
			commitDB();
			return 0;
		}
		catch (SQLException e)
		{
			System.out.println("Come back to this when oracle fixes https://blog.dbi-services.com/12cr2-application-containers-and-foreign-keys/");
//			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Account> getAllAccounts()
	{
		System.out.println("## Fetching most recent account information ...");
		ArrayList<Account> accounts = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql =
				"SELECT " + 
				"OWNER_ASSOCIATION.account_number, " + 
				"OWNER_ASSOCIATION.customer_username, " + 
				"BANK_ACCOUNT.account_type, " + 
				"BANK_ACCOUNT.account_state, " + 
				"BANK_ACCOUNT.account_balance, " + 
				"BANK_USER.user_pass, " + 
				"BANK_USER.full_name " + 
				"FROM OWNER_ASSOCIATION " +  
				"FULL OUTER JOIN BANK_ACCOUNT ON OWNER_ASSOCIATION.account_number = BANK_ACCOUNT.account_number " + 
				"LEFT OUTER JOIN BANK_USER ON OWNER_ASSOCIATION.customer_username = BANK_USER.username " + 
				"ORDER BY OWNER_ASSOCIATION.account_number";
			PreparedStatement ps = conn.prepareStatement( sql );
			ResultSet rs = ps.executeQuery();

			// track account for joint owners
			long lastAccount = -1;
			while (rs.next())
			{
//				System.out.println("** GOT ONE **");
				try
				{
					long accountNum = (long) rs.getInt("account_number");
					if (accountNum > 0)
					{
//						System.out.println("** ACCOUNT " + accountNum + " **");
						Customer owner = new Customer(
								rs.getString("full_name"),
								rs.getString("customer_username"),
								rs.getString("user_pass"));
						Account currAccount;
						if (lastAccount != accountNum)
						{
							currAccount = new Account(accountNum, 
									Account.AccountType.valueOf(rs.getString("account_type")),
									Account.AccountState.valueOf(rs.getString("account_state")),
									rs.getDouble("account_balance"), 
									owner);
							accounts.add(currAccount);
						}
						else
							accounts.get(accounts.size() - 1).addOwner(owner);
						lastAccount = accountNum;
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("***** NO ACCOUNTS FOUND *****");
					return new ArrayList<Account>();
				}
//				System.out.println("** READY TO CRY **");
			}
//			System.out.println("** KILL ME **");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account getAccountByNumber(long accountNumber)
	{
		Account account = null;
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql =
					"SELECT " + 
					"OWNER_ASSOCIATION.account_number, " + 
					"OWNER_ASSOCIATION.customer_username, " + 
					"BANK_ACCOUNT.account_type, " + 
					"BANK_ACCOUNT.account_state, " + 
					"BANK_ACCOUNT.account_balance, " + 
					"BANK_USER.user_pass, " + 
					"BANK_USER.full_name " + 
					"FROM OWNER_ASSOCIATION " +  
					"FULL OUTER JOIN BANK_ACCOUNT ON OWNER_ASSOCIATION.account_number = BANK_ACCOUNT.account_number " + 
					"LEFT OUTER JOIN BANK_USER ON OWNER_ASSOCIATION.customer_username = BANK_USER.username " +
					"ORDER BY OWNER_ASSOCIATION.account_number";
				PreparedStatement ps = conn.prepareStatement( sql );
				ResultSet rs = ps.executeQuery();

				long lastAccount = -1;
				while (rs.next())
				{
					// if we hit this block more than once, add owners
					try
					{
						long accountNum = (long) rs.getInt("account_number");
						if (accountNum > 0)
						{
							Customer owner = new Customer(
									rs.getString("full_name"),
									rs.getString("customer_username"),
									rs.getString("user_pass"));
							Account currAccount;
							if (lastAccount != accountNum)
							{
								currAccount = new Account(accountNum, 
										Account.AccountType.valueOf(rs.getString("account_type")),
										Account.AccountState.valueOf(rs.getString("account_state")),
										rs.getDouble("account_balance"), 
										owner);
								account = currAccount;
							}
							else
								account.addOwner(owner);
							lastAccount = accountNum;
						}
					}
					catch (NumberFormatException e)
					{
						System.out.println("***** ACCOUNT NOT FOUND *****");
						return null;
					}
				}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public int updateAccountState(long number, AccountState state)
	{
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn
					.prepareStatement("UPDATE BANK_ACCOUNT SET account_state = ? WHERE account_number = ?");
			ps.setString(1, state.toString());
			ps.setLong(2, number);
			ps.executeUpdate();
			System.out.println("Account # " + number + " set to " + state.toString());
			commitDB();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateAccountBalance(long number, double balance)
	{
		System.out.println("## Processing transaction ...");
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn
					.prepareStatement("UPDATE BANK_ACCOUNT SET account_balance = ? WHERE account_number = ?");
			ps.setDouble(1, balance);
			ps.setLong(2, number);
			ps.executeUpdate();
			System.out.println("Account # " + number + " now has $" + balance);
			commitDB();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public int commitDB()
	{
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("COMMIT");
			ps.executeUpdate();
			System.out.println("## Database updated ##");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAccount(long number)
	{
		System.out.println("## Deleting Account ...");
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("DROP FROM BANK_ACCOUNT WHERE account_number = ?");
			ps.setLong(1, number);
			ps.executeUpdate();
			commitDB();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

}
