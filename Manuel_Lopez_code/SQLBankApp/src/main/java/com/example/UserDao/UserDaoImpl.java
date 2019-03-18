package com.example.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.User.User;

public class UserDaoImpl implements UserDao{
	/*
	 * JDBC API
	 * 
	 * Important Interfaces: Connection - allows us to connect to our db Statement -
	 * allows for SQL injection PreparedStatement - precompiles the SQL string
	 * without parameters once the parameters are added, they are only treated as
	 * values, never keywords CallableStatement - stored procedures
	 * 
	 * Statement vs PreparedStatement 1. PS has better readibility 2. PS more secure
	 * than statement (no SQL injections)
	 * 
	 * To connect to our database, we need 4 things: 1. URL 2. Username 3. Password
	 * 4. Driver (the jar that implements JDBC)
	 * 
	 * URL = endpoint + port + database name
	 */
	
	/*private static String url = "jdbc:oracle:thin:@myfreedatabase.crugo2u5mbej.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "meme7";
	private static String password = "Arkange1";*/
	
	private static String url = "jdbc:oracle:thin:@myfreedatabase.crugo2u5mbej.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "meme7";
	private static String password = "Arkange1";
	
	@Override
	public int insertUser(User p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO PROJUSERTABLE VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, p.getUserid());
			ps.setString(2, p.getUserName());
			ps.setString(3, p.getPassword());
			ps.setString(4, p.getFirstName());
			ps.setString(5, p.getLastName());
			ps.setInt(6, p.getUserKey());
			ps.setInt(7, p.getUserAcctStatus());
			ps.setInt(8, p.getSsn());
			ps.setInt(9, p.getAcctNum());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public User selectUserByName(String name, String pass) {
		User pet = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM PROJUSERTABLE WHERE USER_NAME=? AND USER_PASSWORD=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pet = new User(rs.getString("user_name"), rs.getString("user_password"), rs.getInt("user_acct_status"), rs.getInt("user_key"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return pet;
	}
	
	@Override
	public User selectUserByName(String name) {
		User pet = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM PROJUSERTABLE WHERE USER_NAME=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pet = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_password"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("user_key"), rs.getInt("user_acct_status"), rs.getInt("ssn"), rs.getInt("acct_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return pet;
	}
	
	/*@Override
	public User personalInfo(String username) {
		User pet = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM PROJUSERTABLE WHERE USER_NAME=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pet = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_password"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("user_key"), rs.getInt("user_acct_status"), rs.getInt("ssn"), rs.getInt("acct_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return pet;
	}*/
	
	public List<User> selectAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int updateUser(User p) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int deleteUser(User p) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int nextSequence() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
