package project0.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project0.account.Account;

public class AccountDaoImpl implements AccountDao{
	
	private static String url = "jdbc:oracle:thin:@mydbinstance.cajndw4aesdt.us-east-2.rds.amazonaws.com:1521:orcl";		
	private static String username = "user123";
	private static String password = "pass";
	
	public int insertAccount(Account a) {
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ACCOUNTS VALUES(?, ?, ?, ?)", 
					new String[] { "AccountID" });
			ps.setInt(1, a.getAccountID());
			ps.setString(2, a.getName());
			ps.setFloat(3, a.getBalance());
			int val = a.isApproved()? 1 : 0;
			ps.setInt(4, val);
			
			int id = 0;
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
			     id = Math.toIntExact(rs.getLong(1));
			}
			
			for(String owner : a.getOwners())
			{
				ps = conn.prepareStatement("INSERT INTO USERSACCOUNTSJOINTTABLE VALUES(?, ?)");
				ps.setString(1, owner);
				ps.setInt(2, id);
			
				ps.executeUpdate();
			}
			return id;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public Account selectAccountByID(int accountID) {
		Account account = null;
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			
			PreparedStatement ps = conn.prepareStatement("SELECT Username FROM UsersAccountsJointTable WHERE AccountID = ?");
			ps.setInt(1, accountID);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<String> owners = new ArrayList<String>();
			
			while(rs.next())
			{
				owners.add(rs.getString(1));
			}
			
			ps = conn.prepareStatement("SELECT * FROM Accounts WHERE AccountID = ?");
			ps.setInt(1, accountID);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				boolean val = false;
				if(rs.getInt(4) == 1)
				{
					val = true;
				}
				account = new Account(rs.getInt(1), rs.getString(2), rs.getFloat(3), val, owners);
			}
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return account;
	}
	
	public ArrayList<Account> selectAccountsByID(List<Integer> accountIDs) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		for(int accountID : accountIDs)
		{
			accounts.add(selectAccountByID(accountID));
		}
		return accounts;
	}

	public boolean deleteAccount(int accountID) {
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Accounts WHERE ACCOUNTID = ?");
			ps.setInt(1, accountID);
			ps.executeUpdate();
			
			ps = conn.prepareStatement("DELETE FROM UsersAccountsJointTable WHERE ACCOUNTID = ?");
			ps.setInt(1, accountID);
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public ArrayList<Account> selectAllUnapprovedAccounts() {
		ArrayList<Account> accounts = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			ArrayList<Integer> ids = new ArrayList<Integer>();
			PreparedStatement ps = conn.prepareStatement("SELECT AccountID FROM ACCOUNTS WHERE APPROVED = 0");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ids.add(rs.getInt(1));
			}
			accounts = selectAccountsByID(ids);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return accounts;
	}
	
	public ArrayList<String> selectAllAccountsByUser(String usr)
	{
		ArrayList<String> accounts = new ArrayList<String>();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT AccountID FROM UsersAccountsJointTable WHERE Username = ?");
			ps.setString(1, usr);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				accounts.add(rs.getString(1));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return accounts;
	}
	
	public ArrayList<String> selectAllOwnersOfAccount(int accountID)
	{
		ArrayList<String> owners = new ArrayList<String>();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT Username FROM UsersAccountsJointTable WHERE AccountID = ?");
			ps.setInt(1, accountID);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				owners.add(rs.getString(1));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return owners;
	}
	
	public boolean approveAccount(int accountID)
	{
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("UPDATE Accounts SET APPROVED = 1 WHERE AccountID = ?");
			ps.setInt(1, accountID);
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public int saveAccount(Account account)
	{
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("UPDATE Accounts SET AccountName = ?, Balance = ?, Approved = ? WHERE AccountID = ?");
			ps.setString(1, account.getName());
			ps.setFloat(2, account.getBalance());
			int val = account.isApproved()? 1 : 0;
			ps.setInt(3, val);
			ps.setInt(4, account.getAccountID());
			ps.executeUpdate();
			return account.getAccountID();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public ArrayList<Account> getAllAccounts() {
		ArrayList<Account> accounts = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			ArrayList<Integer> ids = new ArrayList<Integer>();
			PreparedStatement ps = conn.prepareStatement("SELECT AccountID FROM ACCOUNTS");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ids.add(rs.getInt(1));
			}
			accounts = selectAccountsByID(ids);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public int nextSequence() {
		// TODO Auto-generated method stub
		return 0;
	}

}

