package com.bank.daoAccount;

import java.util.List;

import com.bank.model.Account;

public interface DaoAccount {

	public Account getAccount(int accountId);

	public int insertAccount(Account a);

	public Account getAccountByName(int u, String an);

	public List<Account> selectAllAccounts();

	public int updateAccount(Account a);

	public int deleteAccount(int accountId);
}
