package com.project0.account;

public class Account
{
	private float balance;
	private String primaryOwner;
	private String[] secondaryOwners;
	private String accountState;
	public Account(float balance, String primaryOwner, String[] secondaryOwners, String accountState) {
		super();
		this.balance = balance;
		this.primaryOwner = primaryOwner;
		this.secondaryOwners = secondaryOwners;
		this.accountState = accountState;
	}
	public float getBalance() 
	{
		return balance;
	}
	public void setBalance(float balance) 
	{
		this.balance = balance;
	}
	public String getPrimaryOwner()
	{
		return primaryOwner;
	}
	public void setPrimaryOwner(String primaryOwner)
 {
		this.primaryOwner = primaryOwner;
	}
	public String[] getSecondaryOwners() 
	{
		return secondaryOwners;
	}
	public String getSecondaryOwner(int index) 
	{
		return secondaryOwners[index];
	}
	public void setSecondaryOwners(String[] secondaryOwners)
	{
		this.secondaryOwners = secondaryOwners;
	}
	public void setSecondaryOwner(String secondaryOwners,int index)
	{
		this.secondaryOwners[index] = secondaryOwners;
	}
	public String getAccountState() 
	{
		return accountState;
	}
	public void setAccountState(String accountState) 
	{
		this.accountState = accountState;
	}
	
}
