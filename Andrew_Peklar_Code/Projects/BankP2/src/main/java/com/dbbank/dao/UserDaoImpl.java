package com.dbbank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbbank.model.Customer;
import com.dbbank.model.CustomerAccount;
import com.dbbank.model.Users;

public class UserDaoImpl implements UserDao {

	private static String url = "jdbc:oracle:thin:@sql034.cgrzwg2xzjmp.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "banker";
	private static String password = "banking";
	
	@Override
	public int insertUsers(Users u) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Users (userID, userName, userPass, accountType) VALUES(?,?,?,?)");
			ps.setInt(1, u.getUserID());
			ps.setString(2, u.getUserName());
			ps.setString(3, u.getUserPass());
			ps.setInt(4, u.getAccountType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Users selectUserByName(String userName2, String userPass) {
		Users account = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE userName=? AND userPass=?");
			ps.setString(1, userName2);
			ps.setString(2, userPass);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				account = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public List<Users> selectAllUsers() {
		List<Users> custACC = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) custACC.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return custACC;
	}

	@Override
	public int updateUser(Users u) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			CallableStatement storedProc = conn.prepareCall("{call NEW__APPROVED(?)}");
	        storedProc.setInt(1, u.getUserID());
	        storedProc.execute();
//			PreparedStatement ps = conn.prepareStatement("call NEW__APPROVED(?)");
//			ps.setInt(1, u.getUserID());
//			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUser(Users u) {
		/*
		CREATE OR REPLACE PROCEDURE DELETE_CUSTOMER (CID IN NUMBER) IS
		BEGIN
    		DELETE FROM Account         	WHERE	accountID 	= CID+100 IF EXISTS; 
    		DELETE FROM CustomerAccount 	WHERE	custID 		= CID IF EXISTS;
    		DELETE FROM Customer        WHERE 	customerID 	= CID IF EXISTS;
    		Delete FROM Users           WHERE 	userID 		= CID; 
    		---
    		DBMS_OUTPUT.PUT_LINE('Personal information update for employee with ID: '||CID);
    		COMMIT;
		END;
		 */
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			CallableStatement storedProc = conn.prepareCall("{call DELETE_CUSTOMER (?)}");
	        storedProc.setInt(1, u.getUserID());
	        storedProc.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Users selectUserByID(Integer UID) {
		// TODO Auto-generated method stub
		Users account = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE userID=?");
			ps.setInt(1, UID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				account = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public int unregisteredUser(String username2, String Password2) {
		Users u = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			CallableStatement storedProc = conn.prepareCall("{call NEW_USER(?,?)}");
	        storedProc.setString(1, username2);
	        storedProc.setString(2, Password2);
	        storedProc.execute();
//			PreparedStatement ps = conn.prepareStatement("call NEW__APPROVED(?)");
//			ps.setInt(1, u.getUserID());
//			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
