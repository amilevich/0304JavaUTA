package com.User.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.Model.User;

public class UserDaoImpl implements UserDao{

	private static String url = "jdbc:oracle:thin:@oracle-instance1.cmseb0jui8wp.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Jay";
	private static String password = "password";
	
	Logger Log = Logger.getGlobal();
	
	@Override
	public int insertUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Project1_Users VALUES (?,?,?,?,?,?)");
			ps.setString(1, u.getUserName());
			ps.setInt(2, u.getPassWord());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getStatus());
			Log.info("U Insert Query Prepared");
			ps.executeUpdate();
			Log.info("U Insert Query Executed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User selectUserByName(String name) {
		User user = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE Username=?");
			ps.setString(1, name);
			Log.info("U Select Query Prepared");
			ResultSet rs = ps.executeQuery();
			Log.info("U Select Query Executed");
			
			while (rs.next()) {
				user = new User(rs.getString("Username"),rs.getInt("Password"),rs.getString("First_Name"),rs.getString("Last name"),rs.getString("Email"), rs.getInt("Status"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
//	@Override
//	public List<User> selectAllUsers() {
//		List<User> users = new ArrayList<>();
//		try (Connection conn = DriverManager.getConnection(url, username, password)) {
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				users.add(new User());
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return users;
//	}

	@Override
	public int updateUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Users SET Password=?, First_Name=?, Last_Name=?, Email=?, Status=?  WHERE Username=?");
			
			ps.setInt(1, u.getPassWord());
			ps.setString(2, u.getFirstName());
			ps.setString(3, u.getLastName());
			ps.setString(4, u.getEmail());
			ps.setInt(5, u.getStatus());
			ps.setString(6, u.getUserName());
			Log.info("U Update Query Prepared");
			ps.executeUpdate();
			Log.info("U Update Query Executed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUser(String Username) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Project1_Users WHERE Username=?");
			ps.setString(1, Username);
			Log.info("U Delete Query Prepared");
			ps.executeUpdate();
			Log.info("R Delete Query Executed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
