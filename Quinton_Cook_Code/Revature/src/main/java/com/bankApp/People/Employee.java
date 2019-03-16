package com.bankApp.People;

import com.bankApp.BankUserDAO.BankUserDAO;

public class Employee extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * TODO Currently employees cannot login because there is no need for them to, yet.
	 */
	
	public Employee(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);
		// TODO Auto-generated constructor stub
	}

	public static String recallInformation(BankUserDAO act) {
		String info = act.toString();
		
		return info;
	}
	
	//currently this is just a rubber stamp, Accounts for everyone!
	public static boolean reviewAccount(BankUserDAO acct) {
		// TODO Auto-generated method stub
		return true;
	}

	public static double viewAccountBalance(BankUserDAO act) {
		// TODO Auto-generated method stub
		return act.getCurrentBalance();
	}

}
