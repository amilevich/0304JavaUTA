package com.banking.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.user.*;

public class UserDaoImpl implements UserDao
{
	private static String jdbcText = "jdbc:oracle:thin:@";
	private static String endpoint = "oracle-instance0304-awright.cx5jdxctrerc.us-east-2.rds.amazonaws.com";
	private static String port = ":1521";
	private static String sid = ":ORCL";
	private static String url = jdbcText + endpoint + port + sid;

	private static String username = "cassion";
	private static String password = "stateandrevolution";

	@Override
	public int registerUser(String bankUser, String bankPass, int typeKey, String fullName)
	{
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			CallableStatement cs = conn.prepareCall("{call register_user (?, ?, ?, ?)");
			cs.setString(1, bankUser);
			cs.setString(2, bankPass);
			cs.setInt(3, typeKey);
			cs.setString(4, fullName);
			cs.execute();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<User> getAllUsers()
	{
		ArrayList<User> users = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BANK_USER");
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				users.add(getUserByType(rs.getString("username"), rs.getString("password"),
						rs.getInt("user_type"), rs.getString("full_name")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUserByName(String bankUser)
	{
		User user = null;
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM BANK_USER WHERE username = ?");
			ps.setString(1, bankUser);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
				user = getUserByType(rs.getString("username"), rs.getString("password"), 
						rs.getInt("user_type"), rs.getString("full_name"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserLogin(String bankUser, String bankPass)
	{
		User user = null;
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM BANK_USER WHERE username = ? AND password = ?");
			ps.setString(1, bankUser);
			ps.setString(2, bankPass);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
				user = getUserByType(rs.getString("username"), rs.getString("password"), 
						rs.getInt("user_type"), rs.getString("full_name"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public int updatePasswordByName(String bankUser, String bankPass)
	{
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE BANK_USER SET password = ? WHERE username = ?");
			ps.setString(1, bankPass);
			ps.setString(2, bankUser);
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUser(String bankUser)
	{
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM BANK_USER WHERE username = ?");
			ps.setString(1, bankUser);
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
	
	private static User getUserByType(String username, String password, int userType, String fullName)
	{
		switch (userType)
		{
		case 0:
			return new Customer(username, password, fullName);
		case 1:
			return new Employee(username, password);
		case 2:
			return new Admin(username, password);
		default:
			return null;
		}
	}

}
