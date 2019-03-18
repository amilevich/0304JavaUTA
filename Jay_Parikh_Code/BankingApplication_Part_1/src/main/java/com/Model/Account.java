package com.Model;

public class Account extends Customer{
	
	private Integer accountNumber = null;
	private double balance;
	private Integer status;
	
	public Account() {
		
	}
	
	public Account(Integer accountNumber, double money, int stat) {
		this.setAccountNumber(accountNumber);
		this.balance = money;
		this.setStatus(stat);
		
	}
	@Override
	public String toString() {
		return "account number:  "+ this.getAccountid() +" balance = " + balance  + " account status: " + accStatusPrint();
	}

	public String accStatusPrint() {
		String accStatus = null;
		if (this.status.equals(0)) {
			accStatus = "pending";
		} else if (this.status.equals(1)) {
			accStatus = "approved";
		}
		return accStatus;
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double num) {
		balance = num;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getAccountid() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

}
