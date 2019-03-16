package com.bankApp.People;

import java.util.ArrayList;

public class BankUser extends Person {
	ArrayList<Account> accounts = new ArrayList<Account>();
	

	public BankUser(String username, String firstName, String lastName , String password) {
		super(firstName, lastName, username, password);
		// TODO Auto-generated constructor stub
	}

	public Account getAccount(int whichAccount) {
		// TODO Auto-generated method stub
		return accounts.get(whichAccount);
	}

	public void addAccount(Account tmp) {
		accounts.add(tmp);
	}


}
