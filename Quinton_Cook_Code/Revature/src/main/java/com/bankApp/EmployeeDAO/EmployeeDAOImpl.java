package com.bankApp.EmployeeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bankApp.People.BankUser;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static final String url = "jdbc:oracle:thin:@atworkdb.c05sxxntbuck.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static final String username = "chinook";
	private static final String passwordDB = "p4ssw0rd";
	
	@Override
	public boolean approveAccount(int act) {
		
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, passwordDB);
			
			String SQLStatement = "UPDATE CHECKING_ACCOUNT SET ACCOUNT_STATUS = ? WHERE ACCOUNT_NUMBER = ?";
			
			PreparedStatement ps = conn.prepareStatement(SQLStatement);
			ps.setInt(1, 1);
			ps.setInt(2, act);
			
			boolean saveForCloseConnection = ps.execute();
			
			//cleanup and escape
			conn.close();
			return saveForCloseConnection;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	@Override
	public boolean deleteAccount(int act) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BankUser[] recallInformation(int act) {
		// TODO Auto-generated method stub
		return null;
	}

}
