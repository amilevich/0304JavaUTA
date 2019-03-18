package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	private static String url = "jdbc:oracle:thin:@oracle-instance1.cabkx1onjwc8.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "DanielJosephSerna";
	private static String password = "CherryPie0!";
	
	@Override
	public int insertCustomer(Customer c) {

		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?,?,?)"); 
			ps.setString(1, c.getFirstName()); System.out.println("SET FIRST NAME");
			ps.setString(2, c.getLastName()); System.out.println("SET LAST NAME");
			ps.setString(3, c.getUserName()); System.out.println("SET USER NAME");
			ps.setString(4, c.getPassWord()); System.out.println("SET PASS");
			ps.executeUpdate();
			ps.close(); 
			System.out.println("Print update");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("EVERYTHING SET");
		
		return 0;
	}
	
	@Override
	public Customer searchCustomerByUsername(String user) {
		
	Customer customer = null; 
	try(Connection conn = DriverManager.getConnection(url, username, password))
	{
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE USER_NAME=?");
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery(); 
			
		System.out.println("BEFORE WHILE");
			
		while(rs.next()) 
		{
			customer = new Customer(rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("USER_NAME"), rs.getString("PASS_WORD"));
			System.out.println("INSIDE WHILE");
		}
			
		System.out.println("AFTER WHILE");
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
		
	return customer;
	
}
	
	@Override
	public List<Customer> selectAllCustomers() {
		List<Customer> customers = new ArrayList<>(); 
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM CUSTOMER");
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()) 
			{
				customers.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return customers;
	}
	
//	@Override
//	public int updateCustomer(Customer c) {
//		return 0;
//	}
	
	@Override
	public void deleteCustomer(String un) {
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement("DELETE FROM CUSTOMER WHERE USER_NAME=?");
			ps.setString(1, un);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
