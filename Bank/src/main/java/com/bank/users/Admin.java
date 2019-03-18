package com.bank.users;

import java.util.ArrayList;
import java.util.List;

import com.bank.account.Account;
import com.bank.daoimpl.AdminDaoImpl;

public class Admin 
{
	private ArrayList<Account> pending = new ArrayList<>();
	private AdminDaoImpl adi = new AdminDaoImpl();
	
	public int getPendingSize() {return pending.size();}
	
	public Account getPendingAccount(int i) {return pending.get(i);}
	public void addPendingAccount(Account account){pending.add(account);}
	
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
	public void viewAllAccounts()
	{
		List<Account> accounts = adi.selectAllAccounts();
		for (int i = 0; i < accounts.size(); i++) 
		{
			accounts.get(i).toString();
		}
	}
	public void viewAllCustomers()
	{
		List<Customer> customers = adi.selectAllCustomers();
		for (int i = 0; i < customers.size(); i++) 
		{
			customers.get(i).toString();
		}
	}
}
