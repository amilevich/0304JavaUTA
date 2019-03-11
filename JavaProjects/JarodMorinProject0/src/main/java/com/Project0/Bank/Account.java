package com.Project0.Bank;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8183105530996279274L;
	int accountNumber;
	double balance;
	Set<String> accountUsers = new HashSet<String>();
	LinkedList<String> appliedUsers = new LinkedList<String>();
	
	public Account(int accountNumber, double balance, String username) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountUsers.add(username);
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Set<String> getAccountUsers() {
		return accountUsers;
	}
	public void addUser(String username) {
		accountUsers.add(username);
	}
	
	public void addApp(String username) {
		appliedUsers.add(username);
	}
	
	public void removeApp(String username) {
		appliedUsers.add(username);
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", accountUsers=" + accountUsers
				+ "]";
	}
}
