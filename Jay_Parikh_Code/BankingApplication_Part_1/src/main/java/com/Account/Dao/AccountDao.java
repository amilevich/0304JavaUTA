package com.Account.Dao;

import java.util.List;

import com.Model.Account;

public interface AccountDao {

	//CRUD methods
	//CREATE
	public int insertAccount(Account a);
	
	//READ
	//public Account selectAccountByName(String name);
	public List<Account> selectAllAccounts();
	
	// UPDATE
	public int updateAccount(Account a);
	
	// DELETE
	public int deleteAccount(Integer a);

	int nextSequence();

	Account selectAccountById(int id);
}
