package com.example.model;

public class Account {

	int acc_id;
	Integer pet_id;
	double balance;
	
	
	
	public Account() {
		
	}
	
	public Account(Integer pet_id, double balance ) {
		super();
		this.pet_id = pet_id;
		this.balance = balance;
		
	}
	
	public Account(int acc_id, Integer pet_id, double balance) {
		super();
		this.acc_id = acc_id;
		this.pet_id = pet_id;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account [acc_id=" + acc_id + ", pet_id=" + pet_id + ", balance=" + balance + "]";
	}
	public int getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}
	public Integer getPet_id() {
		return pet_id;
	}
	public void setPet_id(Integer pet_id) {
		this.pet_id = pet_id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
