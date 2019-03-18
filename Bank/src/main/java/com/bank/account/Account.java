package com.bank.account;

import java.util.Arrays;

public class Account 
{


	private double balance;
	private int id;
	private int ownerID;
	private int[] secondaryOwnerID;
	
	
	public Account() {}


	public Account(int id,double balance, int ownerID) 
	{
		super();
		this.id = id;
		this.balance = balance;
		this.ownerID = ownerID;
		this.secondaryOwnerID = new int[4];
	}


	public double getBalance() {return balance;}

	public String getBalanceString() {return new String(""+balance);}

	public void setBalance(double balance) {this.balance = balance;}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public int getOwnerID() {return ownerID;}

	public void setOwnerID(int ownerID) {this.ownerID = ownerID;}

	public int[] getSecondaryOwnerID() {return secondaryOwnerID;}
	
	public int getSecondaryOwnerID(int i) {return secondaryOwnerID[i];}

	public void setSecondaryOwnerID(int i,int value) 
	{
		if (i < this.secondaryOwnerID.length && i > -1) 
		this.secondaryOwnerID[i] = value;
	}


	@Override
	public String toString()
	{
		return "Account [balance=" + balance + ", id=" + id + ", ownerID=" + ownerID + ", secondaryOwnerID="
				+ Arrays.toString(secondaryOwnerID) + "]";
	}

	

}
