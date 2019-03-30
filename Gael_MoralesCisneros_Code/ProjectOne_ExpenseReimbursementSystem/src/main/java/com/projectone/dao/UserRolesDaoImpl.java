package com.projectone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projectone.models.UserRoles;
import com.projectone.models.Users;

public class UserRolesDaoImpl implements UserRolesDao{
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
	public int insertUserRole(UserRoles p) {
		System.out.println("0");
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("UserRoles 1");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_USER_ROLES(USER_ROLE) VALUES(?)");
			System.out.println("UserRoles 2");
			//ps.setInt(1, p.getErsUserRoleId());
			ps.setString(1, p.getUserRole());
			System.out.println("UserRoles 3");
			ps.executeUpdate();
			System.out.println("UserRoles 4");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public UserRoles selectUserRolesByName(Integer x) {
		UserRoles pet = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USER_ROLES WHERE ERS_USER_ROLE_ID=?");
			ps.setInt(1, x);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pet = new UserRoles(rs.getInt("ERS_USER_ROLE_ID"), rs.getString("USER_ROLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return pet;
	}

}
