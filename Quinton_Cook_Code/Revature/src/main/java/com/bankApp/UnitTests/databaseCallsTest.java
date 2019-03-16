package com.bankApp.UnitTests;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.bankApp.BankUserDAO.BankUserDAOImpl;

public class databaseCallsTest {
	
	
	private static String url = "jdbc:oracle:thin:@atworkdb.c05sxxntbuck.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "chinook";
	private static String passwordDB = "p4ssw0rd";

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(url, username, passwordDB);
			String insertUser = "INSERT INTO BANK_USER VALUES(?,?,?,?)";
			PreparedStatement cStmt = conn.prepareStatement(insertUser);

			cStmt.setString(1, "FUCK");
			cStmt.setString(2, "SQL");
			cStmt.setString(3, "AND ORACLE");
			cStmt.setString(4, "1234");

			System.out.println(cStmt.executeUpdate());

			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
