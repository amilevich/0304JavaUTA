package com.bankApp.People;

import com.bankApp.Account.Account;

public class Employee extends Person {

	public Employee(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);
		// TODO Auto-generated constructor stub
	}

	public static String[] recallInformation(Account act) {
		String[] info = { act.getFirstName(), act.getLastName(), act.getUsername(), act.getPassword(),
				act.getAccountHolders(), Double.toString(act.getCurrentBalance()) };
		
		return info;

	}

	public static boolean reviewAccount(Account acct) {
		// TODO Auto-generated method stub
		return true;
	}

	public static double viewAccountBalance(Account act) {
		// TODO Auto-generated method stub
		return act.getCurrentBalance();
	}

}
