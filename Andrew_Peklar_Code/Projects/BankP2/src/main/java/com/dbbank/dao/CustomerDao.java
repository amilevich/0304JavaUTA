package com.dbbank.dao;

import java.util.List;

import com.dbbank.model.Customer;

public interface CustomerDao {
	// CREATE
	public int insertCustomer(Customer c);
	
	// READ
	public Customer selectCustomerByID(Integer CustomerID);
	
	// READ ALLL
	public List<Customer> selectAllCustomers();
	
	// UPDATE
	public int updateCustomer(Customer u);
	
	// DELETE
	public int deleteCustomer(Customer u);
}
