package project0.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import project0.account.Account;
import project0.users.Admin;
import project0.users.Employee;
import project0.users.User;

public class UserDaoImpl implements UserDao{
	
	private static String url = "jdbc:oracle:thin:@mydbinstance.cajndw4aesdt.us-east-2.rds.amazonaws.com:1521:orcl";		
	private static String username = "user123";
	private static String password = "pass";
	private static AccountDaoImpl accountDao = new AccountDaoImpl();
	
	public boolean insertUser(User u) {
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO USERS VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getFirstName());
			ps.setString(3, u.getLastName());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getUserLevel().getValue());
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public User selectUserByUsername(String usr) {
		User user = null;
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE Username = ?");
			ps.setString(1, usr);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				switch(rs.getInt(5))
				{
					case 0:
						user = new User(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4), getBankAccounts(usr));
						break;
					case 1:
						//user = new Employee(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4), getBankAccounts(usr));
						break;
					case 2:
						//user = new Admin(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4), getBankAccounts(usr));
						break;
					default:
						break;
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	public User login(String usr, String pass)
	{
		User user = null;
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE Username = ? AND Password = ?");
			ps.setString(1, usr);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				switch(rs.getInt(5))
				{
					case 0:
						user = new User(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4), getBankAccounts(usr));
						break;
					case 1:
						//user = new Employee(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4));
						break;
					case 2:
						//user = new Admin(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4));
						break;
					default:
						break;
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	public ArrayList<Account> getBankAccounts(String user)
	{
		ArrayList<Account> accounts = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT AccountID FROM UsersAccountsJointTable WHERE Username = ?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				accounts.add(accountDao.selectAccountByID(rs.getString(1)));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return accounts;
	}

	public boolean deleteUser(String usr) {
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("DELETE FROM USERS WHERE Username = ?");
			ps.setString(1, usr);
			ps.executeUpdate();
			
			ps = conn.prepareStatement("DELETE FROM UsersAccountsJointTable WHERE Username = ?");
			ps.setString(1, usr);
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
	public ArrayList<User> selectAllCustomers() {
		ArrayList<User> users = new ArrayList<User>();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE USERLEVEl = 0");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				users.add(new User(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4), getBankAccounts(rs.getString(1))));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return users;
	}
	
	public ArrayList<User> selectAllCustomers(ArrayList<String> usernames)
	{
		ArrayList<User> users = new ArrayList<User>();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			ArrayList<String> conditions = new ArrayList<String>();
			for(String username : usernames)
			{
				conditions.add("Username = " + username);
			}
			String statement = "SELECT * FROM USERS WHERE " + String.join(" OR ", conditions);
			
			PreparedStatement ps = conn.prepareStatement(statement);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				users.add(new User(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4), getBankAccounts(rs.getString(1))));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int nextSequence() {
		// TODO Auto-generated method stub
		return 0;
	}

}

