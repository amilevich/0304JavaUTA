package com.Project0.DoaImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Project0.Bank.User;
import com.Project0.Dao.UserDao;

public class UserDaoImpl implements UserDao {

	private static String url = "jdbc:oracle:thin:@bankdb.ctjqi18j2emr.us-east-2.rds.amazonaws.com:1521:bankdb";
	private static String username = "Banky";
	private static String password = "DankBank";

	@Override
	public int addUser(User user) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Users (username, password, name, userType) VALUES('" + user.getUsername() + "','"
					+ user.getPassword() + "','" + user.getName() + "',1)");
			ps.executeUpdate();
		} catch (SQLException e) {
		//	e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int addEmployee(User user) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Users (username, password, name, userType) VALUES('" + user.getUsername() + "','"
					+ user.getPassword() + "','" + user.getName() + "',2)");
			ps.executeUpdate();
		} catch (SQLException e) {
		//	e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int addAdmin(User user) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Users (username, password, name, userType) VALUES('" + user.getUsername() + "','"
					+ user.getPassword() + "','" + user.getName() + "',3)");
			ps.executeUpdate();
		} catch (SQLException e) {
		//	e.printStackTrace();
		}
		return 0;
	}

}
