package com.bankApp.People;

public class Account {
	private double currentBalance;
	private int accountNumber;
	private int accountStatus;
	
	@Override
	public int hashCode() {
		final int prime = 1997;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + accountStatus;
		long temp;
		temp = Double.doubleToLongBits(currentBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (accountStatus != other.accountStatus)
			return false;
		if (Double.doubleToLongBits(currentBalance) != Double.doubleToLongBits(other.currentBalance))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [currentBalance=" + currentBalance + ", accountNumber=" + accountNumber + ", accountStatus="
				+ accountStatus + "]";
	}
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
