package com.dbbank.dao;

import java.util.List;

import com.dbbank.model.CustomerAccount;

public interface CustomerAccountDao {
	// CREATE
	public int insertCustomerAccount(CustomerAccount ca);
	
	// READ
	public List<String> selectCustomerAccountByCID(Integer CustomerAccountAID);
	public CustomerAccount selectCustomerAccountByAID(Integer CustomerAccountCID);
	
	// READ ALLL
	public List<CustomerAccount> selectAllCustomerAccounts();
	
	// UPDATE
	public int updateCustomerAccount(CustomerAccount ca);
	
	// DELETE
	public int deleteCustomerAccount(CustomerAccount ca);
}
