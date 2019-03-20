package com.bank.users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.account.Account;
import com.bank.daoimpl.AdminDaoImpl;
import com.bank.utility.Util;

public class Admin
{
	private ArrayList<Account> pending = new ArrayList<>();
	private AdminDaoImpl adi = new AdminDaoImpl();

	public void clearPending(){pending.clear();}
	public int getPendingSize() {return pending.size();}
	
	public Account getPendingAccount(int i) {return pending.get(i);}
	public void addPendingAccount(Account account){pending.add(account);}
	
	
	public int getCustomerID()
	{
		return adi.getCustomerID();
	}

	public int getAccountID()
	{
		return adi.getAccountID();
	}

	public int getJointID()
	{return adi.getJointID();}
	
	
	
	
	public void Approve(Account account){adi.insertAccount(account);}
	
	public void Deny(Account account)
	{
		for (int i = 0; i < pending.size(); i++)
		{
			if (pending.get(i).getId() == account.getId())
				pending.remove(i);
		}
	}
	public void addCustomer(Customer victim){adi.insertCustomer(victim);}
	public void deleteCustomer(Customer victim){adi.deleteCustomer(victim);}
	public void deleteAccount(Account victim){adi.deleteAccount(victim);}
	public Account getAccount(int id) {return adi.selectAccount(id);}
	public Customer getCustomer(int id) {return adi.selectCustomer(id);}
	public Customer getCustomer(String username) {return adi.selectCustomer(username);}
	public void viewAllAccounts()
	{
		List<Account> accounts = adi.selectAllAccounts();
		for (int i = 0; i < accounts.size(); i++) 
		{
			accounts.get(i).printString();
		}
	}
	public void viewAllCustomers()
	{
		List<Customer> customers = adi.selectAllCustomers();
		for (int i = 0; i < customers.size(); i++) 
		{
			customers.get(i).printString();
		}
	}

	public void accountWithdraw(Account account , double amount)
	{
		if(amount <= account.getBalance())
			account.setBalance(account.getBalance()-amount);

		else
			System.out.println("Insufficient funds");
		adi.updateAccount(account);
	}
	public void accountDeposit(Account account , double amount)
	{
		account.setBalance(account.getBalance()+amount);
		adi.updateAccount(account);
	}
    public void accountTransfer(Account accountFrom,Account accountTo , double amount)
    {
        if(amount <= accountTo.getBalance())
        {
            accountTo.setBalance(accountTo.getBalance()-amount);
            accountFrom.setBalance(accountFrom.getBalance()+amount);
        }

        else
            System.out.println("Insufficient funds");
        adi.updateAccount(accountTo);
        adi.updateAccount(accountFrom);
    }
}
