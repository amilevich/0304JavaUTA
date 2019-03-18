package com.project.dao;

import java.util.List;


import com.models.beans.Account;

public interface AccountDao {
	
	
	public int insertAccount(Account a);
	
	public Account selectByUsername(String username);
	
	public Account selectBystatus(Boolean status);

	public List<Account> selectAllAccount();
	
	public int updateAccount(Account a);
	
	public int deleteAccount(Account a);
}
