package com.bankApp.People;

import com.bankApp.BankUserDAO.BankUserDAO;

public class Employee extends Person {

	private int accountType;
	
	public Employee(String firstName, String lastName, String username, String password, int accountType) {
		super(firstName, lastName, username, password);
		this.setAccountType(accountType);
	}

	public static String recallInformation(BankUserDAO act) {
		String info = act.toString();
		
		return info;
	}
	
	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

}
