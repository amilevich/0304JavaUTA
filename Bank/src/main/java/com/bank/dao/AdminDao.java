package com.bank.dao;

import java.util.List;

import com.bank.account.Account;
import com.bank.users.Customer;

public interface AdminDao 
{
	//create
	public int insertAccount(Account a);
	public int insertCustomer(Customer in);

	//read
	public List<Account> selectAccountByUserID(int id);
	//update
	public int updateAccount(Account a);
	public int updateCustomer(Customer in);
	//delete
	public int deleteAccount(Account a);
	public int deleteCustomer(Customer in);
	
	public Account selectAccount(int id);
	public Customer selectCustomer(int id);
	public Customer selectCustomer(String username);
	public List<Account> selectAllAccounts();
	public List<Customer> selectAllCustomers();

	public int getCustomerID();
	public int getAccountID();
	public int getJointID();
}
