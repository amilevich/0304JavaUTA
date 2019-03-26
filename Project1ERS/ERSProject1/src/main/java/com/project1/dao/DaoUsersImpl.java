package com.project1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project1.model.Users;

public class DaoUsersImpl implements DaoUsers {
	
	private static String url = "jdbc:oracle:thin:@revaturedb.clyh6jvswypw.us-east-1.rds.amazonaws.com:1521:orcl";
	private static String username = "reimbursement";
	private static String password = "project1";

	@Override
	public int insertUser(Users user) {
		int user_Id = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO ERS_Users VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			user_Id = nextUsersSequence();
			ps.setInt(1, user_Id);
			ps.setInt(2, user.getErsUsersId());
			ps.setString(3, user.getErsUsername());
			ps.setString(4, user.getErsPassword());
			ps.setString(5, user.getUserFirstname());
			ps.setString(6, user.getUserLastname());
			ps.setString(7, user.getUserEmail());
			ps.setInt(8, user.getUserRoleId());
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
					"UPDATE ERS_Users SET ERS_Username = ?, ERS_Password = ?, User_First_Name = ?, User_Last_Name = ?, User_Email = ?,"
							+ " User_Role_Id = ?");
			ps.setString(3, user.getErsUsername());
			ps.setString(4, user.getErsPassword());
			ps.setString(5, user.getUserFirstname());
			ps.setString(6, user.getUserLastname());
			ps.setString(7, user.getUserEmail());
			ps.setInt(8, user.getUserRoleId());
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
				user = new Users(rs.getInt("ERS_Users_Id"), rs.getString("ERS_Username"), rs.getString("ERS_Password"),
						rs.getString("User_First_Name"), rs.getString("User_Last_Name"), rs.getString("User_Email"), rs.getInt("User_Role_Id"));
			}
		} catch (SQLException e) {
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


}
