package com.example.AccountDao;
import com.example.Account.Account;
import com.example.User.User;

public interface AccountDao {
	// CREATE
	public int insertAccount(Account p);
	public Account getAccount(int acctNum);
	// UPDATE
	public int withdraw(int acctNum, double w);
	public int deposit(int acctNum, double d);
	public int transfer(Account p, int t);

}
