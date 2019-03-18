package com.banking.dao;

import java.util.ArrayList;

import com.banking.account.Account;

public interface AccountDao
{
	// CREATE
	public abstract long registerAccount(String bankUser, Account.AccountType type);
//	public abstract int addAccountOwner(long accountNumber, String bankUser);
	
	// READ
	public abstract ArrayList<Account> getAllAccounts();
	public abstract Account getAccountByNumber(long accountNumber);
	
	// UPDATE
	public abstract int updateAccountState(long number, Account.AccountState state);
	public abstract int updateAccountBalance(long number, double balance);
	public abstract int commitDB();
	
	// DELETE
	public abstract int deleteAccount(long number);
}
