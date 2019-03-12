package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User implements ModifyAccount, Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 4436631430912342403L;
	private List<Integer> theirAccounts;

	
	public Customer(String username, String password) {
		super(username, password);
		this.theirAccounts = new ArrayList<>();
	}

	
	public void printInfo() {
		System.out.println("\nUsername: \t" + this.username + 
						   "\nPassword: \t" + this.password );
		System.out.println("Account(s): \t" + getTheirAccounts());
	}

	public void printAccounts() {
		System.out.println("Account(s): \t" + getTheirAccounts());
	}
	
	@Override
	public boolean deposit(String account, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdraw(String account, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transfer(String fromHere, String toThere, double amount) {
		// TODO Auto-generated method stub
		return false;
	}


	public List<Integer> getTheirAccounts() {
		return theirAccounts;
	}


	public void setTheirAccounts(List<Integer> theirAccounts) {
		this.theirAccounts = theirAccounts;
	}
		
}