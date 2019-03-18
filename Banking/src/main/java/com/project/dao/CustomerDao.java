package com.project.dao;

import java.util.List;


import com.models.beans.Customer;

public interface CustomerDao {
	
	public int insertCustomer(Customer c);
	
	public Customer selectByUsername(String username);
	
	public Customer selectByPassword(String password);

	public List<Customer> selectAllCustomer();
	
	
	public int updateCustomer(Customer c);
	
	public int deleteCustomer(Customer c);
	
	


}
