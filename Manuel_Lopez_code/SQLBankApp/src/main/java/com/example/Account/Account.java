package com.example.Account;

public class Account {
	int acctNum, acctType;
	double balance;
	String userName1, userName2;
	public Account(){
		balance = 100;
		acctType=1;
	}
	public Account(int acctNum, int acctType, double balance, String userName1, String userName2) {
		super();
		this.acctNum = acctNum;
		this.acctType = acctType;
		this.balance = balance;
		this.userName1 = userName1;
		this.userName2 = userName2;
	}
	public int getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}
	public int getAcctType() {
		return acctType;
	}
	public void setAcctType(int acctType) {
		this.acctType = acctType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getUserName1() {
		return userName1;
	}
	public void setUserName1(String userName1) {
		this.userName1 = userName1;
	}
	public String getUserName2() {
		return userName2;
	}
	public void setUserName2(String userName2) {
		this.userName2 = userName2;
	}
	@Override
	public String toString() {
		return "Account [acctNum=" + acctNum + ", acctType=" + acctType + ", balance=" + balance + ", userName1="
				+ userName1 + ", userName2=" + userName2 + "]";
	}

}
