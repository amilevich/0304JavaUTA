package com.dbbank.model;

public class Account {
	
	Integer	accountID;
	double	accountBalance;

	public Account() {
	}

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Accounts [accountID=" + accountID + ", accountBalance=" + accountBalance + "]";
	}

	public Account(Integer accountID, double accountBalance) {
		super();
		this.accountID = accountID;
		this.accountBalance = accountBalance;
	}
}
