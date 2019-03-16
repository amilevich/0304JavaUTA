package com.bankApp.BankUserDAO;

import com.bankApp.People.Account;
import com.bankApp.People.BankUser;

public interface BankUserDAO {
	boolean withdraw(double amt, int whichAccount, BankUser act);
	boolean deposit(double amt,int whichAccount, BankUser act);
	boolean transfer(double amt, int whichAccountFrom,int whichAccountTo, BankUser from);
	boolean insertBankUser(BankUser act);
	boolean insertAccount(BankUser acct);
	BankUser login(String usrName, String password);
	boolean addAccountHolder(Account act,String usrName);
}
