package com.project0.customer;

import java.io.Serializable;
import java.util.ArrayList;

import com.project0.account.Account;
import com.project0.transactions.Transactions;
import com.project0.user.User;

public class Customer implements User,Transactions,Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7552469046208815920L;
	
	protected ArrayList<Account> accounts;
	public void Apply() 
	{
		
	}
	@Override
	public void Withdraw(float amount, Account account)
	{
		
	}
	@Override
	public void Deposit(float amount, Account account)
	{
		
	}
	@Override
	public void Transfer(float amount, Account fromAccount, Account toAccount)
	{
		
	}
	@Override
	public void Login(String userName, String passWord)
	{
		
	}
	@Override
	public void Logout() 
	{
		
	}
	@Override
	public void Register()
	{
		
	}
	@Override
	public void DisplayInfo(Customer customer) 
	{
		
	}
	@Override
	public void DisplayBalance(Customer customer, int accountNumber) 
	{
		
	};
	
	@Override
	public void DisplayPersonalInfo(Customer customer) 
	{
		
	}
	
	
}
