package com.banking;

public class Customer extends User
{

	private String name, phoneNumber, licenseNumber;
	transient private String ssn;
	
	public Customer(String name, String phone, String license, String social,
			String username, String password)
	{
		super(username, password);
		this.name = name;
		phoneNumber = phone;
		licenseNumber = license;
		ssn = social;
	}
	
	public Account applyForAccount(long accountNumber)
	{
		return applyForAccount(accountNumber, Account.AccountType.CHECKING);
	}
	
	public Account applyForAccount(long accountNumber, Account.AccountType type)
	{
		return new Account(accountNumber, type, this);
	}
	
	public Account applyForJointAccount(long accountNumber, 
			Account.AccountType type, Customer partner)
	{
		Account acct = applyForAccount(accountNumber, type);
		return acct.addOwner(partner);
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append("\t" + phoneNumber);
		sb.append("\t" + licenseNumber);
		sb.append("\t" + "***-**-" + ssn.substring(7));
		
		return sb.toString();
	}
}
