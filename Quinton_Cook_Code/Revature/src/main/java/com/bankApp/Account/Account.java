package com.bankApp.Account;

import com.bankApp.Interfaces.Accountable;
import com.bankApp.People.Employee;
import com.bankApp.People.Person;

public class Account extends Person implements Accountable {

	public static final int numberOfFields = 6;
	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getAccountHolders() {
		return accountHolders;
	}

	public void setAccountHolders(String accountHolders) {
		this.accountHolders = accountHolders;
	}

	double currentBalance;
	String accountHolders;

	
	public Account(String firstName, String lastName, String username, String password, double currentBalance,
			String accountHolders) {
		super(firstName, lastName, username, password);
		this.currentBalance = currentBalance;
		this.accountHolders = accountHolders;
	}

	@Override
	public boolean withdraw(double amt) {

		if (amt > currentBalance || amt < 0) {
			return false;
		} else {
			currentBalance -= amt;
			return true;
		}

	}

	@Override
	public boolean deposit(double amt) {
		if(amt < 0) {
			return false;
		}else {
			currentBalance += amt;
			return true;
		}
		
	}

	@Override
	public boolean transfer(Account act, double amt) {
		if(withdraw(amt)&&act.deposit(amt)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean login(String usrName, String pswd) {
		if(loginInfo.containsKey(usrName) && loginInfo.get(usrName).getPassword().equals(pswd)) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean applyForAccount(Account acct) {
		if(Employee.reviewAccount(acct)&&!(loginInfo.containsKey(acct.getUsername()))) {
			loginInfo.put(acct.getUsername(), acct);
			return true;
		}else {
			return false;
		}
	}

}
