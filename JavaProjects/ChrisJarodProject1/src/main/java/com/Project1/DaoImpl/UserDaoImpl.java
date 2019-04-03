package com.Project1.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Project1.Dao.UserDao;
import com.Project1.Model.User;

public class UserDaoImpl implements UserDao{

	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {	

			e.printStackTrace();

		}

	}
	private static String url = "jdbc:oracle:thin:@erssql.ctjqi18j2emr.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "BigBoss";
	private static String password = "BigBosss";
	
	@Override
	public int insertUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO Users "
					+ "(user_id, username, password, firstname, " + 
					"lastname, email, user_role_id) VALUES(?,?,?,?,?,?,?)");
			ps.setLong(1, u.getUserId());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getFirstName());
			ps.setString(5, u.getLastName());
			ps.setString(6, u.getEmail());
			ps.setLong(7, u.getRoleId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User selectUserByUsername(String userName) {
		User user = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users "
					+ "WHERE username = ?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getInt(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User selectUserByUserId(int userId) {
		User user = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users "
					+ "WHERE user_id = ?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getInt(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> selectAllUsers() {
		List<User> user = new ArrayList<User>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			user.add( new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public int returnMaxUserId() {
		int res = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement s = conn.createStatement();
			ResultSet resSet = s.executeQuery("SELECT MAX(user_id) FROM Users");
			if (resSet.next()) {
				res = resSet.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
			return res;
	}

}
