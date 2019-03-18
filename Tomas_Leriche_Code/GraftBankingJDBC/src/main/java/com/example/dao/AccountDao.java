package com.example.dao;

import java.util.List;

import com.example.model.Account;
import com.example.model.Pet;

public interface AccountDao {

	
	public int insertAccount(Account a);
	
	public List<Account> selectAllAccounts();
	
	public Account selectAccountById(int id);
	
	public int deleteAccountById(Account a);
	
	public int updateAccountWhereId(Account a);
	
}
