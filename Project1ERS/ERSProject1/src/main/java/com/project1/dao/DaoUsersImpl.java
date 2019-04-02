package com.project1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project1.model.Users;

public class DaoUsersImpl implements DaoUsers {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String url = "jdbc:oracle:thin:@revaturedb.clyh6jvswypw.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "reimburse";
	private static String password = "project1";

	public static String encrypt(String str) {
		int code;
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			code = Math.round((float) Math.random() * 8 + 1);
			result += code + Integer.toHexString(((int) str.charAt(i)) ^ code) + "-";
		}
		return result.substring(0, result.lastIndexOf("-"));
	}

	public static String decrypt(String str) {
		str = str.replace("-", "");
		String result = "";
		for (int i = 0; i < str.length(); i += 3) {
			String hex = str.substring(i + 1, i + 3);
			result += (char) (Integer.parseInt(hex, 16) ^ (Integer.parseInt(String.valueOf(str.charAt(i)))));
		}
		return result;
	}

	@Override
	public int insertUser(Users user) {
		int user_Id = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_Users VALUES (?, ?, ?, ?, ?, ?, ?)");
			user_Id = nextUsersSequence();
			ps.setInt(1, user_Id);
			ps.setString(2, user.getErsUsername());
			ps.setString(3, encrypt(user.getErsPassword()));
			ps.setString(4, user.getUserFirstname());
			ps.setString(5, user.getUserLastname());
			ps.setString(6, user.getUserEmail());
			ps.setInt(7, 1);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user_Id;
	}

	@Override
	public int updateUser(Users user) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE ERS_Users SET ERS_Username = ?, ERS_Password = ?, User_First_Name = ?, User_Last_Name = ?, User_Email = ? "
							+ " WHERE ERS_USERS_ID = ?");
			ps.setString(1, user.getErsUsername());
			ps.setString(2, encrypt(user.getErsPassword()));
			ps.setString(3, user.getUserFirstname());
			ps.setString(4, user.getUserLastname());
			ps.setString(5, user.getUserEmail());
			ps.setInt(6, user.getErsUsersId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user.getErsUsersId();
	}

	@Override
	public Users validateUser(String ers_username, String ers_password) {
		Users user = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Users WHERE ERS_Username = ?");
			ps.setString(1, ers_username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new Users(rs.getInt("ERS_Users_Id"), rs.getString("ERS_Username"), decrypt(rs.getString("ERS_Password")),
						rs.getString("User_First_Name"), rs.getString("User_Last_Name"), rs.getString("User_Email"),
						rs.getInt("User_Role_Id"));
			}
		} catch (SQLException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return user;
	}

	private int nextUsersSequence() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT users_seq.NEXTVAL FROM dual");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;
	}

	@Override
	public Users getUserById(int userId) {
		Users user = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Users WHERE ERS_Users_Id = ?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new Users(rs.getInt("ERS_Users_Id"), rs.getString("ERS_Username"), decrypt(rs.getString("ERS_Password")),
						rs.getString("User_First_Name"), rs.getString("User_Last_Name"), rs.getString("User_Email"),
						rs.getInt("User_Role_Id"));
			}
		} catch (SQLException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return user;
	}

}
