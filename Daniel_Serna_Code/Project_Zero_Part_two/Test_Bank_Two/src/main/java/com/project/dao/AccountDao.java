package com.project.dao;

import java.util.List;

import com.project.model.Account;

public interface AccountDao {

	// CREATE
	public int insertAccount(Account a); // insert account into DB
	
	// READ
	public Account selectAccountByID(int id); 
	public List<Account> selectAllAccounts(); // select (DISPLAY) all accounts
	
	public List<Account> selectAllOpenAccounts(); // display all open accounts

	
	// UPDATE
	public int updateAccount(Account a); 
	public void updateAccountStatus(int id); 
	
	
	// DELETE
	public void deleteAccount(int id); 
}
