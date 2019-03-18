package com.project.model;

public class Account {

	int account_id;
	double balance; 
	int status; // should i use a boolean?
	
	public Account()
	{
		
	}
	
	public Account(int account_id, double balance, int status)
	{
		super(); 
		this.account_id = account_id; 
		this.balance = balance; 
		this.status = status; 
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", balance=" + balance + ", status=" + status + "]";
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
