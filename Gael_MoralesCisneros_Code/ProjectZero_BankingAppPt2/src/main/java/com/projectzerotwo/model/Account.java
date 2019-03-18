package com.projectzerotwo.model;

public class Account {

	Integer accNumber = null;
	double balance;
	Integer status;

	public Account() {
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Integer getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(Integer accNumber) {
		this.accNumber = accNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "account number:\t\t" + accNumber + "\naccount balance:\t" + balance + "\naccount status:\t\t" + accStatus()
				+ "\n";
		// return "Account [accNumber=" + accNumber + ", balance=" + balance + ",
		// status=" + status + "]";
	}

	public Account(Integer accNumber, double balance, Integer status) {
		super();
		this.accNumber = accNumber;
		this.balance = balance;
		this.status = status;
	}

	public String accStatus() {
		String accStatus = null;
		if (this.status.equals(0)) {
			accStatus = "pending";
		} else if (this.status.equals(1)) {
			accStatus = "approved";
		}
		return accStatus;
	}

}
