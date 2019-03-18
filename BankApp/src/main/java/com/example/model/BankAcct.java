package com.example.model;

public class BankAcct extends User implements Transactions{

	private int accountNumber;
	private int accountStatus;
	private double balance;
	
	public BankAcct() {
		// TODO Auto-generated constructor stub
	}
	


	@Override
	public String toString() {
		return "BankAcct [accountNumber=" + accountNumber + ", accountStatus=" + accountStatus + ", balance=" + balance
				+ "]";
	}



	public BankAcct(int accountNumber, int accountStatus, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountStatus = accountStatus;
		this.balance = balance;
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



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	@Override
	public boolean withdraw(double amount) {
		if(amount > balance) {
			return false;
		}else if(amount < 0){
		return false;
		}else {
			balance = balance - amount; 
			return true;
		}
	}

	@Override
	public boolean deposit(double amount) {
		if(amount < 0) {
			return false;
		}else {
			balance = balance + amount;
			return true;
		}
	}


	@Override
	public boolean transferTo(User to, double amount) {
		if(amount <= balance) {
			withdraw(amount);
			((BankAcct) to).deposit(amount);
			return true;
		}else 
	
		return false;
	}
	
	
}
