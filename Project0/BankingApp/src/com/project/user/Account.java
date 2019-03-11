package com.project.user;

public class Account extends Customer {
	
	private float balance;
	
	public Account(String username, String password, String type, String name) {
		super(username, password, type, name);
	}
	
	
	public Account(String username, String password, String type, String name, float balance) {
		super(username, password, type, name);
		this .balance= balance;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public void deposit(float i) {
		balance += i;
	}

	public void withdraw(float i) {
		if (balance - i <0) {
			System.out.println("Insufficient Funds");
		} else {
			balance -= i;
		}
		
	}

	
}
