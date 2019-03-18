package com.Project0.Dao;

import java.util.ArrayList;

import com.Project0.Bank.Account;
import com.Project0.Bank.User;

public interface BankDao {
	public int createTables();

	public int returnMaxAccId();
	
	public ArrayList<Account> getAccountList();
	
	public ArrayList<User> getUserList();

}
