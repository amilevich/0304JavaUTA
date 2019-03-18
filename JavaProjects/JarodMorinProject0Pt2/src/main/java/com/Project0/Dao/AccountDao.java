package com.Project0.Dao;

import com.Project0.Bank.Account;

public interface AccountDao {
	public int updateBalance(Account acc);
	public int addAccount(Account acc, String username);
	public int removeAccount(Account acc);
}
