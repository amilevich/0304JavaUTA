package com.banking;

import java.util.ArrayList;

public class Account
{
	public enum AccountType
	{
		CHECKING, SAVINGS, MONEY_MARKET_DEPOSIT, CERTIFICATE_DEPOSIT
	}
	
	public enum AccountState
	{
		PENDING_APPROVAL, OPEN, FROZEN, TERMINATED
	}
	
	private long accountNumber;
	private AccountType type;
	private ArrayList<Customer> owners;
	
	private AccountState state;
	private double balance;
//	
//	public Account(long accountNumber, Customer customer)
//	{
//		this(accountNumber, AccountType.CHECKING, customer);
//	}
	
	public Account(long accountNumber, AccountType type, Customer customer)
	{
		this.accountNumber = accountNumber;
		this.type = type;
		addOwner(customer);
		
		this.state = AccountState.PENDING_APPROVAL;
		balance = 0;
	}
	
	public long getAccountNumber()
	{
		return accountNumber;
	}
	
	// public account number mutator not needed
	
	public Account addOwner(Customer customer)
	{
		owners.add(customer);
		return this;
	}
	
	public boolean hasReadAccess(User user)	throws InvalidUserAccessException
	{
		if (user instanceof Employee)
			return true;
		for (Customer owner : owners)
		{
			if (user.equals(owner))
				return true;
		}
		throw new InvalidUserAccessException();
	}
	
	public boolean hasWriteAccess(User user)	throws InvalidUserAccessException
	{
		if (user instanceof Admin)
			return true;
		for (Customer owner : owners)
		{
			if (user.equals(owner))
				return true;
		}
		throw new InvalidUserAccessException();
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void setBalance(double balance) 
			throws AccountNotOpenException, InvalidBalanceException
	{
		if (state == AccountState.OPEN)
		{
			if (balance >= 0)
				this.balance = balance;
			else
				throw new InvalidBalanceException();
		}
		else
			throw new AccountNotOpenException();
	}
	
	public AccountState getState()
	{
		return state;
	}
	
	public void setState(AccountState state)
	{
		this.state = state;
	}
	
	public AccountType getType()
	{
		return type;
	}
	
	// Public Account Type mutator not needed
	
	public Object[] getAccountInfo()
	{
		Object[] accountInfo = new Object[5];
		accountInfo[0] = new Long(accountNumber);
		accountInfo[1] = type;
		accountInfo[2] = owners;
		accountInfo[3] = state;
		accountInfo[4] = new Double(balance);
		return accountInfo;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Account #" + accountNumber);
		sb.append("\n\t" + type);
		for (Customer owner : owners)
			sb.append("\t" + owner.getUsername());
		sb.append("\n\tAccount is: " + state);
		sb.append("\n\tCurrent Balance: " + balance);
		
		return sb.toString();
	}
}
