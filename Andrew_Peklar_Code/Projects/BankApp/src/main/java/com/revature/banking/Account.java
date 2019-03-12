package com.revature.banking;

import java.util.List;
import java.io.Serializable;
import java.util.Comparator;

public class Account implements Serializable, Comparator<Account> {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4158567444432130879L;
	
	private int aID;
	private double aBalance;
	private String oneOwner;
	private List<String> aOwners;

	public Account(int aID, List<String> aOwners) {
		super();
		this.aID = aID;
		this.aOwners = aOwners;
		this.aBalance = 8.00; // starting amount
	}

	public Account(int aID, String aOwner) {
		super();
		this.aID = aID;
		this.setOneOwner(aOwners.get(0));
		this.aBalance = 8.00; // starting amount
	}

	public int getaID() {
		return aID;
	}

	public void setaID(int aID) {
		this.aID = aID;
	}

	public double getaBalance() {
		return aBalance;
	}

	public void setaBalance(double aBalance) {
		this.aBalance = aBalance;
	}

	public List<String> getaOwners() {
		return aOwners;
	}

	public void setaOwners(List<String> aOwners) {
		this.aOwners = aOwners;
	}

	@Override
	public int compare(Account arg0, Account arg1) {
		return arg0.aID - arg1.aID;
	}

	public boolean accessCheck(String user) {
		for (String x : aOwners)
			if (x.equals(user))
				return true;
		return false;
	}

	// checks if account balance is negative
	// TODO: rework
	public boolean negBalanceCheck(double amount) {
		return ((this.getaBalance() - amount) < 0) ? true : false;
	}

	// withdraw method
	// TODO: check into changing with set instead of direct change
	public boolean withdraw(double amount) {
		if (amount < 0) {
			System.out.println("\nCannot withdraw a negative amount\n\n");
			return false;
		} else if (amount > this.aBalance) {
			System.out.println("\nInsufficient funds for transaction.\n\n");
			return false;
		} else {
			this.aBalance = this.aBalance - amount;
			return true;
		}
	}

	public void deposit(double amount) {
		this.aBalance = this.aBalance + amount;
		System.out.println("\n$" + amount + " added to account!");
		System.out.println("Current balance: $" + this.aBalance + "\n");
	}

	// TODO: modify print owners
	public void printAccountInfo() {
		System.out.println("" + this.aID + "\t\t" + this.getaOwners() + "\t\t" + this.aBalance);
	}

	public String getOneOwner() {
		return oneOwner;
	}

	public void setOneOwner(String oneOwner) {
		this.oneOwner = oneOwner;
	}

}
