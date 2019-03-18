package com.Customer.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	private static String url = "jdbc:oracle:thin:@oracle-instance1.cclfw9z8ofht.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Frank";
	private static String password = "hello";

	//CREATE
	@Override
	public int insertCustomer(Customer c) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO customers (username, password, firstname, lastname, personalinfo, accountnumber) VALUES (?,?,?,?,?,?)");
			//PreparedStatement ps2 = conn.prepareStatement("INSERT INTO accounts () VALUES (?,?,?)");
			ps.setString(1, c.getUserName());
			ps.setString(2, c.getPassWord());
			ps.setString(3, c.getFirstName());
			ps.setString(4, c.getLastName());
			ps.setString(5, c.getPersonalInfo());
			ps.setInt(6,    c.getAccountid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	//UPDATE
	@Override
	public int updateCustomer(Customer c) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE customers SET password=?, firstname=? , lastname=? , personalinfo=? WHERE username=?");		
			ps.setString(1, c.getPassWord());
			ps.setString(2, c.getFirstName());
			ps.setString(3, c.getLastName());
			ps.setString(4, c.getPersonalInfo());
			ps.setString(5, c.getUserName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//DELETE
	@Override
	public int deleteCustomer(Customer c) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM customers WHERE accountnumber=?");
			ps.setInt(1, c.getAccountid()); //needs some work still
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	//READ
	@Override
	public Customer selectCustomerByName(String userName) {
		Customer customer = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers WHERE username=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				customer = new Customer(rs.getString("username"), rs.getString("password"), rs.getString("firstname"),  rs.getString("lastname"),  rs.getString("personalinfo"), rs.getInt("accountnumber"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	
	//for adding the account to the customer on customer creation
	@Override
	public Integer selectAccountForCustomer() {
		Integer account = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(accountnumber) FROM accounts");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				account = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return account;
	}
	
	//get username through account number
	@Override
	public Customer selectCustomerByAccountid(Integer accountNumber) {
		Customer customer = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers WHERE accountnumber=?");
			ps.setInt(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				customer = new Customer(rs.getInt("cust_id"), rs.getString("username"), rs.getString("password"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("personalinfo"), rs.getInt("accountnumber"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	
	//userN, passW, fname, lname, perInfo
	public Customer selectCustomerById(int id){
		Customer customer = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers WHERE cust_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				customer = new Customer(rs.getString("username"), rs.getString("password"), rs.getString("firstname"),  rs.getString("lastname"),  rs.getString("personalinfo"), rs.getInt("accountnumber"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	
	@Override
	public List<Customer> selectAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				customers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public int nextSequence() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT cust_seq.NEXTVAL FROM dual");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
