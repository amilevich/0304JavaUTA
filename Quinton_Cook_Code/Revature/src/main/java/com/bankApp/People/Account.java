package com.bankApp.People;

public class Account {
	private double currentBalance;
	private int accountNumber;
	private int accountStatus;
	
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public Account(double currentBalance, int accountNumber, int accountStatus) {
		super();
		this.currentBalance = currentBalance;
		this.accountNumber = accountNumber;
		this.accountStatus = accountStatus;
	}
	
	
}
