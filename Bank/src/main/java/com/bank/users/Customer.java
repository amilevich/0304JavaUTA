package com.bank.users;

import com.bank.account.Account;
import com.bank.daoimpl.CustomerDaoImpl;

import java.util.List;

public class Customer
{
    private CustomerDaoImpl cdi = new CustomerDaoImpl();
	private String userName;
	private String passWord;
	private int id;
	private int mainAccountID;
	private int jointID;
	public Customer() {}
	public Customer(int id,String userName, String passWord, int mainAccountID, int jointID)
	{
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.id = id;
		this.mainAccountID = mainAccountID;
		this.jointID = jointID;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getPassWord() 
	{
		return passWord;
	}
	public void setPassWord(String passWord) 
	{
		this.passWord = passWord;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getMainAccountID()
	{
		return mainAccountID;
	}
	public void setMainAccountID(int mainAccountID) 
	{
		this.mainAccountID = mainAccountID;
	}
	public int getJointID()
	{
		return jointID;
	}
	public void setJointID(int jointID) 
	{
		this.jointID = jointID;
	}
	
	
	public void printString() 
	{
		System.out.println("Userame: " + userName + "\n Password: " + passWord + "\n UserID: " + id + "\n Main AccountID: "
				+ mainAccountID + "\n Joint AccountID: " + jointID + "");
	}


	public void accountWithdraw(Account account , double amount)
	{
		if(amount <= account.getBalance())
			account.setBalance(account.getBalance()-amount);

		else
			System.out.println("Insufficient funds");
		cdi.updateAccount(account);
	}
	public void accountDeposit(Account account , double amount)
	{
		account.setBalance(account.getBalance()+amount);
		cdi.updateAccount(account);
	}
}
