package com.models.beans;

public class Account {

	String username;
	double balance;
	boolean status;
	
	public Account() {
	}
	
	
	
	
	public Account(String username, double balance, boolean status) {
		super();
		this.username = username;
		this.balance = balance;
		this.status = status;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public double getBalance() {
		return balance;
	}




	public void setBalance(double balance) {
		this.balance = balance;
	}




	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}

	



}
	
	
	
	
	
		

