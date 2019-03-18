package com.Customer.Dao;
import java.util.List;

import com.Model.Customer;

public interface CustomerDao {
	
	//CRUD methods
	//CREATE
	public int insertCustomer(Customer c);
	
	//READ
	public Customer selectCustomerByName(String name);
	public List<Customer> selectAllCustomers();
	
	// UPDATE
	public int updateCustomer(Customer c);
	
	// DELETE
	public int deleteCustomer(Customer c);

	int nextSequence();

	public Integer selectAccountForCustomer();

	public Customer selectCustomerByAccountid(Integer accountNumber);

	
	
}
