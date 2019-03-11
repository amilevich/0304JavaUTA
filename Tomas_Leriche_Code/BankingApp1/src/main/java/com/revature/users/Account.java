package com.revature.users;

import java.io.Serializable;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7885028626752708840L;
	private String accountID;
	private String accountType;
	private double balance;
	
	Account() {
		System.out.println("Account Made");
		
	}
	
	public Account(double balance) {
		this.balance = balance;
		System.out.println("=== Account application submitted with id: " + this.balance + " ===\n");
	}

	
	/*===========================================================================
	 * Withdraw, Deposit, and Transfer methods
	 * =========================================================================
	 */
	
	public void withdraw(double cash) {
		if (this.balance >= cash) {
			System.out.println("withdrawing... $" + cash);
			this.balance -= cash;
			System.out.println("Current holdings = $" + this.balance);
		}else {
			System.out.println("***************************************");
			System.out.println("****** ERROR: Insufficient Funds ******");
			System.out.println("***************************************");
		}
	}
	
	public void deposit(double cash) {
		if (cash > 0) {
			this.balance += cash;
			System.out.println("Depositing...\nCurrent holdings = $" 
			+ this.balance + " for reciever");
		}
	}
	
	public void transfer(Customer acc, double cash) {
		if (cash > 0 && cash < acc.getAccount().balance) {
			System.out.println("Transfering... $" + cash + " to " 
					+ acc.getFirstName() + " " + acc.getLastname());
			withdraw(cash);
			acc.getAccount().deposit(cash);
		}
		else {
			System.out.println("*** Invalid Entry, Try again\n*** Names must match what is"
					+ " stored and you must have sufficient funds");
		}
	}
	
	/*===========================================================================
	 * Getters and Setters
	 * =========================================================================
	 */
	
	
	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
