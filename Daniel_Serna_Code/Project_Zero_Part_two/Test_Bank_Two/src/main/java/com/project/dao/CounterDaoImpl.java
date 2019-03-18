package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.model.Counter;

public class CounterDaoImpl implements CounterDao {

	private static String url = "jdbc:oracle:thin:@oracle-instance1.cabkx1onjwc8.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "DanielJosephSerna";
	private static String password = "CherryPie0!";
	
	
	// insert new counter into counter table
	@Override
	public int insertCounter(Counter c) {
 
		try (Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO COUNTER VALUES(?)");
			ps.setInt(1,  c.getHoldLastUsedID());
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}

	// grab the counter from counter table
	@Override
	public int grabLastHeldID() {
		
		int customerCounter = 0;
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{		
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM COUNTER");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				customerCounter = rs.getInt(1); 
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return customerCounter;
	}

}
