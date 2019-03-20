package com.banking.account;

//import java.io.Serializable;
import java.util.ArrayList;
import com.banking.user.*;
import com.banking.exception.*;

public class Account// implements Serializable
{
//	private static final long serialVersionUID = 739061165271502623L;

	public enum AccountType
	{
		CHECKING(1), SAVINGS(2), MONEY_MARKET_DEPOSIT(3), CERTIFICATE_DEPOSIT(4), 
		NUM_ACCOUNT_TYPE(5);
		
		private int value;
		AccountType(int value)
		{
			this.value = value;
		}
		
		public int getValue()
		{
			return value;
		}
		
		public static AccountType convertIntToType(int iType) {
			for (AccountType type : AccountType.values()) {
				if (type.getValue() == iType) {
					return type;
				}
			}
			return null;
		}
	}
	
	public enum AccountState
	{
		PENDING_APPROVAL, OPEN, FROZEN, TERMINATED, 
		NUM_ACCOUNT_STATE
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
	
	public Account(long accountNumber, AccountType type, AccountState state, double balance, Customer customer)
	{
		this.accountNumber = accountNumber;
		this.type = type;
		owners = new ArrayList<>();
		addOwner(customer);
		
		this.state = state;
		this.balance = balance;
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
	
	public boolean hasWriteAccess(User user)	
			throws InvalidUserAccessException, AccountNotOpenException
	{
		if (user instanceof Admin)
			return true;
		if (state != AccountState.OPEN)
			throw new AccountNotOpenException();
//		System.out.println("Checking access of " + user.getUsername());
		for (Customer owner : owners)
		{
//			System.out.println("Checking against " + owner.getUsername());
			if (user.getUsername().equals(owner.getUsername()))
				return true;
		}
		throw new InvalidUserAccessException();
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	private void setBalance(double balance) 
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
	
	public void requestDeposit(double amount)
		throws AccountNotOpenException, NegativeMoneyException, InvalidBalanceException
	{
		if (amount < 0)
			throw new NegativeMoneyException();
		try
		{
			setBalance(balance + amount);
		}
		catch (AccountNotOpenException e)
		{
			throw e;
		}
		// Just in case there's an overflow on the deposit
		catch (InvalidBalanceException e)
		{
			throw e;
		}
	}
	
	public void requestWithdrawl(double amount)
			throws AccountNotOpenException, NegativeMoneyException, InvalidBalanceException
	{
		if (amount < 0)
			throw new NegativeMoneyException();
		try
		{
			setBalance(balance - amount);
		}
		catch (AccountNotOpenException e)
		{
			throw e;
		}
		// Maxmium withdrawl amount
		catch (InvalidBalanceException e)
		{
			throw e;
		}
	}
	
	public void requestTransfer(double amount, Account target)
			throws AccountNotOpenException, NegativeMoneyException, InvalidBalanceException
	{
		if (amount < 0)
			throw new NegativeMoneyException();
		try
		{
			this.requestWithdrawl(amount);
		}
		catch (AccountNotOpenException e)
		{
			throw e;
		}
		// Maximum transfer/withdrawl amount
		catch (InvalidBalanceException e)
		{
			throw e;
		}
		
		try
		{
			target.requestDeposit(amount);
		}
		// refund this account in case of failure
		catch (AccountNotOpenException e)
		{
			this.requestDeposit(amount);
			throw e;
		}
		// Just in case there's an overflow on the deposit
		catch (InvalidBalanceException e)
		{
			this.requestDeposit(amount);
			throw e;
		}
	}
	
	public void approveAccount()
	{
		state = AccountState.OPEN;
	}
	
	public void closeAccount()
	{
		state = AccountState.TERMINATED;
	}
	
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
		sb.append("\n");
		
		return sb.toString();
	}
}
