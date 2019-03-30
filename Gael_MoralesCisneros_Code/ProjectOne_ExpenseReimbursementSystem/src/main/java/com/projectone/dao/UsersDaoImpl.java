package com.projectone.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projectone.models.Users;


public class UsersDaoImpl implements UsersDao{
	
	static{

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

    }
	
	private static String url = "jdbc:oracle:thin:@myfreedatabase.crugo2u5mbej.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "username";
	private static String password = "passw0rd";
	
	@Override
	public int insertUser(Users p) {
		System.out.println("Users 0");
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("Users 1");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_USERS(ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) VALUES(?,?,?,?,?,?)");
			System.out.println("Users 2");
			ps.setString(1, p.getErsUsername());
			ps.setString(2, p.getErsPassword());
			ps.setString(3, p.getUserFirstName());
			ps.setString(4, p.getUserLastName());
			ps.setString(5, p.getUserEmail());
			ps.setInt(6, p.getUserRoleId());
			System.out.println("Users 3");
			ps.executeUpdate();
			System.out.println("Users 4");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Users selectUserByName(String name, String pass) {
		Users pet = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=? AND ERS_PASSWORD=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pet = new Users(rs.getInt("ERS_USERS_ID"), rs.getString("ERS_USERNAME"), rs.getString("ERS_PASSWORD"), rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"), rs.getString("USER_EMAIL"), rs.getInt("USER_ROLE_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return pet;
	}
}
//ERS_USERS_ID NUMBER
//ERS_USERNAME VARCHAR2
//ERS_PASSWORD VARCHAR2
//USER_FIRST_NAME VARCHAR2
//USER_LAST_NAME VARCHAR2
//USER_EMAIL VARCHAR2
//USER_ROLE_ID NUMBER
