package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Junction;

public class JunctionDaoImpl implements JunctionDao{

	private static String url = "jdbc:oracle:thin:@oracle-instance1.cabkx1onjwc8.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "DanielJosephSerna";
	private static String password = "CherryPie0!";
	
	@Override
	public int insertJunction(Junction j) {

		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO JUNCTION VALUES (?,?)"); 
			ps.setString(1, j.getUserName()); System.out.println("Set user name");
			ps.setInt(2, j.getAccount_id()); System.out.println("Set account id");
			ps.executeUpdate();
			System.out.println("Update junction");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("End of junction insert");
		
		return 0;
	}

	@Override
	public Junction selectJunctionByID(int id) {
		Junction jun = null; 
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM JUNCTION WHERE ACCOUNT_ID=?");
			ps.setInt( 1, id);
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()) 
			{
				jun = new Junction(rs.getString("USER_NAME"), rs.getInt("ACCOUNT_ID"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return jun;
	}
	
	@Override
	public Junction selectJunctionByUsername(String user)
	{
		Junction jun = null;
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM JUNCTION WHERE USER_NAME=?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				jun = new Junction(rs.getString("USER_NAME"), rs.getInt("ACCOUNT_ID"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return jun;
	}

	@Override
	public List<Junction> selectAllJunctions() {
		
		List<Junction> junctions = new ArrayList<>(); 
		
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM JUNCTION");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				junctions.add(new Junction(rs.getString(1), rs.getInt(2)));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return junctions;
	}

	@Override
	public int updateJunction(Junction j) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteJunction(int id) {
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("DELETE FROM JUNCTION WHERE ACCOUNT_ID="+id);
			ps.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
