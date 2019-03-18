package com.bank.dao;

import java.util.List;

import com.bank.account.Account;
import com.bank.users.Customer;

public interface CustomerDao 
{

	//read
	public List<Account> selectAccountByUserID(int id);
	
	public int updateAccount(Account a);
	
	public List<Account> selectAllAccounts(Customer in);
}
