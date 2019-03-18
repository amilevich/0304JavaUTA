package com.projectzerotwo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projectzerotwo.model.User;

public class UserDaoImpl implements UserDao {

	private static String url = "jdbc:oracle:thin:@db-instance-0304uta.c4ngsdhhjuji.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "username";
	private static String password = "passw0rd";

	@Override
	public int insertUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users (accNumber, username, password, "
					+ "firstname, lastname, type) VALUES(?,?,?,?,?,?)");
			ps.setInt(1, u.getAccNumber());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getFirstname());
			ps.setString(5, u.getLastname());
			ps.setInt(6, u.getType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User selectUserByUsername(String un) {
		User user = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=?");
			ps.setString(1, un);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				users.add(new User(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getInt(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public User selectUserByAccountNum(Integer accNumber) {
		User user = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE accNumber=?");
			ps.setInt(1, accNumber);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Integer selectAccNumByMax() {
		Integer accNum = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(accNumber) FROM accounts");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				accNum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accNum;
	}

	@Override
	public int updateUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE users SET firstname=?, lastname=? WHERE username=?");
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE username=?");
			ps.setString(1, u.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
