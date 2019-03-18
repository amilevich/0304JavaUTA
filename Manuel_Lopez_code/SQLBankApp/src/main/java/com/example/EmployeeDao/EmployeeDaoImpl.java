package com.example.EmployeeDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.example.Employee.Employee;
import com.example.User.User;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private static String url = "jdbc:oracle:thin:@myfreedatabase.crugo2u5mbej.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "meme7";
	private static String password = "Arkange1";

	@Override
	public User personalInfo(String name) {
		User pet = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM PROJUSERTABLE WHERE USER_NAME=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pet = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_password"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("user_key"), rs.getInt("user_acct_status"), rs.getInt("ssn"), rs.getInt("acct_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return pet;
	}
	
	@Override
	public User accountInfo(String name) {
		User pet = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM PROJUSERTABLE WHERE USER_NAME=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pet = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_password"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("user_key"), rs.getInt("user_acct_status"), rs.getInt("ssn"), rs.getInt("acct_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return pet;
	}

	@Override
	public List<Employee> selectAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int approveUser(User p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE PROJUSERTABLE SET user_acct_status=1 WHERE user_name=?");
			ps.setString(1, p.getUserName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public void approveUser(String p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE PROJUSERTABLE SET user_acct_status=1 WHERE user_name=?");
			ps.setString(1, p);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int updateUser(User p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Pet SET type=? WHERE name=?");
			//ps.setString(1, p.getType());
			//ps.setString(2, p.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	@Override
	public int deleteUser(User p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM PROJUSERTABLE WHERE USER_NAME=?");
			ps.setString(1, p.getUserName());
			//ps.execute();
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int nextSequence() {
		// TODO Auto-generated method stub
		return 0;
	}

}
