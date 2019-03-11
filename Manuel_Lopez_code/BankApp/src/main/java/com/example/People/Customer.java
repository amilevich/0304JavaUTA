package com.example.People;
import java.io.Serializable;
import com.example.User.User;

public class Customer extends User implements Serializable {
	
	double balance=100;
	String acctType="checking";
	String userName;
	
	public Customer(){
		
	}

	public Customer(double balance, String acctType, String userName) {
		this.balance = balance;
		this.acctType = acctType;
		this.userName = userName;
	}
	
	public void makeDeposit(int dep) {
		this.balance = this.balance+dep;
	}
	
	public void makeWithdrawl(int with) {
		this.balance = this.balance-with;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	@Override
	public String toString() {
		return "Customer [balance=" + balance + ", acctType=" + acctType + ", userName=" + userName + "]";
	}
	
}
