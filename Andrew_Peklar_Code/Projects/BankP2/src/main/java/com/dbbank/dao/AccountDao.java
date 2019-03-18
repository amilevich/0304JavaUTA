package com.dbbank.dao;

import java.util.List;

import com.dbbank.model.Account;

public interface AccountDao {
	// CREATE
	public int insertAccount(Account a);
	
	// READ
	public Account selectAccountByID(Integer accountID);
	
	// READ ALLL
	public List<Account> selectAllAccounts();
	
	// UPDATE
	public int updateAccount(Account a);
	
	// DELETE
	public int deleteAccount(Account a);
}
