package com.bank.model;

public class Account {

	private int accountId;

	private String accountName;
	private Double balance;

	private int isActive;
	private int isApproved;

	public Account() {

	}

	// Class Constructors
	public Account(int accountId, String accountName, Double balance, int isActive, int isApproved) {
		accountId = accountId;
		accountName = accountName;
		balance = balance;
		isActive = isActive;
		isApproved = isApproved;
	}

	public Account(String accountName, Double balance, int isActive, int isApproved) {
		accountName = accountName;
		balance = balance;
		isActive = isActive;
		isApproved = isApproved;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}

}
