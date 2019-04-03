package com.ers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.ers.controller.HomeController;
import com.ers.model.Ticket;
import com.ers.model.User;

public class UserDaoImpl implements UserDao {
	
	final static Logger logger = Logger.getLogger(HomeController.class.getName());
	
	// insert
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String url = "jdbc:oracle:thin:@mysqldatabase3.cwjd6odobf4o.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "angellocastro";
	private static String password = "Nightmarish1.";

	@Override
	public int insertUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_Users VALUES(?,?,?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getType());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.info("NEW USER " + u.getUsername() + " FAILED TO REGISTER");
		}
		return 0;
	}

	@Override
	public ArrayList<User> selectAllUsers() {
		ArrayList<User> userArray = new ArrayList<User>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Users");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				userArray.add(new User(rs.getString("user_username"), rs.getString("user_password"), rs.getString("user_type")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userArray;
	}
	
	@Override
	public User selectUserByUsername(String a_user) {
		User user = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Users WHERE user_username=?");
			ps.setString(1, a_user);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User(rs.getString("user_username"), rs.getString("user_password"), rs.getString("user_type"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
