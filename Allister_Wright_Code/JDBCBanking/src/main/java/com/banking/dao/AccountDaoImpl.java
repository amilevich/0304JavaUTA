package com.banking.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.account.Account;
import com.banking.account.Account.AccountState;
import com.banking.account.Account.AccountType;
import com.banking.user.Customer;
import com.banking.user.User;

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
	public long registerAccount(String bankUser, AccountType type)
	{
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			CallableStatement cs = conn.prepareCall("{call register_account (?, ?, ?)}");
			cs.setString(1, bankUser);
			cs.setString(2, String.valueOf(type));
			cs.registerOutParameter(3, java.sql.Types.NUMERIC);
			cs.execute();
			return cs.getLong(3);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0L;
	}
	
	@Override
	public int addAccountOwner(long number, String bankUser)
	{
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("INSERT ");
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Account> getAllAccounts()
	{
		ArrayList<Account> accounts = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement(
					"SELECT OWNER_ASSOCIATION.account_number, "
					+ "OWNER_ASSOCIATION.customer_username, "
					+ "BANK_ACCOUNT.account_state, "
					+ "BANK_USER.username, "
					+ "BANK_USER.password, "
					+ "BANK_USER.full_name"
					+" FROM OWNER_ASSOCIATION" 		// START WITH JUNCTION TABLE
					+" RIGHT OUTER JOIN BANK_ACCOUNT" 		// GET ACCOUNT STATE
					+" RIGHT OUTER JOIN BANK_USER"); 		// GET CUSTOMER INFO	
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				accounts.add(new Account(
						Long.valueOf(rs.getString("account_number")), 
						Account.AccountType.valueOf(rs.getString("account_type")),
						Account.AccountState.valueOf(rs.getString("account_state")), 
						new Customer(	rs.getString("username"), 
										rs.getString("password"), 
										rs.getString("full_name"))));
			}
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
			PreparedStatement ps = conn.prepareStatement(
					"SELECT OWNER_ASSOCIATION.account_number, "
					+ "OWNER_ASSOCIATION.customer_username, "
					+ "BANK_ACCOUNT.account_state, "
					+ "BANK_USER.username, "
					+ "BANK_USER.password, "
					+ "BANK_USER.full_name"
					+" FROM OWNER_ASSOCIATION" 		// START WITH JUNCTION TABLE
					+" RIGHT OUTER JOIN BANK_ACCOUNT" 		// GET ACCOUNT STATE
					+" RIGHT OUTER JOIN BANK_USER"); 		// GET CUSTOMER INFO	
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				account = new Account(
						Long.valueOf(rs.getString("account_number")), 
						Account.AccountType.valueOf(rs.getString("account_type")),
						Account.AccountState.valueOf(rs.getString("account_state")), 
						new Customer(	rs.getString("username"), 
										rs.getString("password"), 
										rs.getString("full_name")));
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
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE BANK_ACCOUNT SET account_state = ? WHERE account_number = ?");
			ps.setString(1, state.toString());
			ps.setLong(2, number);
			ps.executeUpdate();
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
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE BANK_ACCOUNT SET balance = ? WHERE account_number = ?");
			ps.setDouble(1, balance);
			ps.setLong(2, number);
			ps.executeUpdate();
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
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("DROP FROM BANK_ACCOUNT WHERE account_number = ?");
			ps.setLong(1, number);
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

}
