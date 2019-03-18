package com.bank.daoUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.model.User;

public class DaoUserImpl implements DaoUser {

	private static String url = "jdbc:oracle:thin:@revaturedb.clyh6jvswypw.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "thebankman";
	private static String password = "bank";

	public User getUser(int userId) {
		User user = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE UserId = ?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User(rs.getInt("userId"), rs.getString("username"), rs.getString("password"),
						rs.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User getUserByName(String name) {
		User user = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE Username = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User(rs.getInt("userId"), rs.getString("username"), rs.getString("password"),
						rs.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public int nextUserSequence() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT user_seq.NEXTVAL FROM dual");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;
	}

	public int insertUser(User user) {
		int userid = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Users VALUES (?, ?, ?, ?)");
			userid = nextUserSequence();
			ps.setInt(1, userid);
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userid;
	}

}
