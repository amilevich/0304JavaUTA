package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.User;

public class UserDaoImpl implements UserDao {
	
	
	private static String url = "jdbc:oracle:thin:@sql0304.crsxfsopgb48.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "GenWood";
	private static String password = "GenW2921";

	@Override
	public int insertUser(User u) {
			try (Connection conn = DriverManager.getConnection(url, username, password)) {

				PreparedStatement ps = conn.prepareStatement("INSERT INTO USERS VALUES (?,?,?,?,?,?)");
				ps.setString(1, u.getfName());
				ps.setString(2, u.getlName());
				ps.setString(3, u.getUserName());
				ps.setString(4, u.getPassword());
				ps.setInt(5, u.getType());
				ps.setInt(6, u.getAccNumUser());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return 0;
		}


	@Override
	public List<User> selectAllUsers() {
		List<User> user = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6)));
			}
		}catch (SQLException e) {
			e.printStackTrace();
			}
			return user;
	}

	@Override
	public int updateUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Users SET fName=?, lName = ?, userName=?, password =?, type=?, AccNumUser=? WHERE userName=?");
			ps.setString(1, u.getfName());
			ps.setString(2, u.getlName());
			ps.setString(3, u.getUserName());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getType());
			ps.setInt(6, u.getAccNumUser());
			ps.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();}
		return 0;
	}


	@Override
	public User selectUserByUsername(String userName) {
		User user = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE userName = ?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();	
			
			while(rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
			}}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return user;
		
	}



	
	}
	
	


