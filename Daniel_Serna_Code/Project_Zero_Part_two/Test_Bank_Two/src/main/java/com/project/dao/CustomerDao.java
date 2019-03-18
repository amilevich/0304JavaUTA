package com.project.dao;

import java.util.List;

import com.project.model.Customer;

public interface CustomerDao {

	// CREATE
	public int insertCustomer(Customer c); // insert customer into DB
	
	// READ
	public Customer searchCustomerByUsername(String username); 
	public List<Customer> selectAllCustomers(); // select (DISPLAY) all customers

	
	// UPDATE
	// public int updateCustomer(Customer c); 
	
	// DELETE
	public void deleteCustomer(String un); 
}
