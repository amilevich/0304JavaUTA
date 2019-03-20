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
import com.dbbank.model.Users;

public class CustomerDaoImpl implements CustomerDao {
	private static String url = "jdbc:oracle:thin:@sql034.cgrzwg2xzjmp.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "banker";
	private static String password = "banking";
	
	@Override
	public int insertCustomer(Customer c) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			//PreparedStatement ps = conn.prepareStatement("EXEC NEW_APPROVED_CUSTOMER(?,?,?)");
			CallableStatement ps = conn.prepareCall("{call NEW_APPROVED_CUSTOMER(?,?,?)}");
			ps.setInt(1, c.getCustomerID());
			ps.setString(2, c.getcFirstName());
			ps.setString(3, c.getcLastName());
			ps.execute(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Customer selectCustomerByID(Integer CustomerID) {
		Customer account = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE customerID=?");
			ps.setInt(1, CustomerID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				account = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> custACC = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) custACC.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return custACC;
	}
	
	
	@Override
	public int updateCustomer(Customer u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomer(Customer u) {
		// TODO Auto-generated method stub
		return 0;
	}

}
