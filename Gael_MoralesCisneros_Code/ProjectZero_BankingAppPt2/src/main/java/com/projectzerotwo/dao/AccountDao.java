package com.projectzerotwo.dao;

import java.util.List;

import com.projectzerotwo.model.Account;

public interface AccountDao {

	//create
	public int insertAccount(Account a);
	
	//read
	public Account selectAccountByAccNumber(Integer i);
	public List<Account> selectAllAccounts();
	
	//update
	public int updateAccount(Account a);
	
	//delete
	public int deleteAccount(Account a);
	
}
