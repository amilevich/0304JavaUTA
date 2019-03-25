package com.reimb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.reimb.model.Users;

public class UsersDaoImpl implements UsersDao {

	
	private static final String url = "jdbc:oracle:thin:@mydbinstance.cq9eowkcfnni.us-east-2.rds.amazonaws.com:1521:orcl";
	private static final String username = "project1user";
	private static final String password = "1234";
	
	
	@Override
	public List<Users> selectAllUsers() {
		List<Users> users = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("select * from Users u inner join USER_ROLES ur on ur.user_role_id = u.USER_ROLE_ID");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				users.add(new Users(rs.getInt("user_id"), 
								rs.getString("user_name"), 
								rs.getString("user_password"), 
								rs.getString("user_first_name"),
								rs.getString("user_last_name"),
								rs.getString("user_email"),
								rs.getInt("user_role_id"),
								rs.getString("user_role")));			 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
		
	}


	@Override
	public Users selectUserById(int id) {
		Users user = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("select * from Users u inner join USER_ROLES ur on ur.user_role_id = u.USER_ROLE_ID" + 
					 " where user_id = ?");
			ps.setInt(1, id);
			//ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new Users(rs.getInt("user_id"), 
								rs.getString("user_name"), 
								rs.getString("user_password"), 
								rs.getString("user_first_name"),
								rs.getString("user_last_name"),
								rs.getString("user_email"),
								rs.getInt("user_role_id"),
								rs.getString("user_role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
