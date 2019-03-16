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
	private static String password = "p4ssw0rd";

	public static void main(String[] args) {
		try {
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
