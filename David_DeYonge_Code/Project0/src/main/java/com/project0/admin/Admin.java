package com.project0.admin;

import java.io.Serializable;
import java.util.ArrayList;

import com.project0.account.Account;
import com.project0.customer.Customer;
import com.project0.transactions.Transactions;
import com.project0.user.User;

public class Admin implements User,Transactions,Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8676963803109753930L;
	protected ArrayList<Customer> customerList;
	protected String Approve(Account account) {return null;}
	protected String Deny(Account account) {return null;}
	private String Cancel(Account account) {return null;}
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
	public void Register(){}
	@Override
	public void DisplayInfo(Customer customer) 
	{
	}
	@Override
	public void DisplayBalance(Customer customer,int accountNumber) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DisplayPersonalInfo(Customer cutomer)
	{
		// TODO Auto-generated method stub
		
	}
}
