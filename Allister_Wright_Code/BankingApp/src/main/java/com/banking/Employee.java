package com.banking;

import java.util.ArrayList;

public class Employee extends User
{
	private static final long serialVersionUID = 2427650250642352064L;

	public Employee(String username, String password)
	{
		super(username, password);
	}
	
	public void approveApplication(Account acct)
	{
		acct.setState(Account.AccountState.OPEN);
	}
	
	public void denyApplication(Account acct)
	{
		acct.setState(Account.AccountState.TERMINATED);
	}
	
	@Override
	public ArrayList<String> getAccountOperations(Account acct)
	{
		// Array List used here for uniformity with Customer Access Rights
		ArrayList<String> options = new ArrayList<>();
		
		options.add("RESPOND TO APPLICATION");
		options.add("VIEW ACCOUNT INFO");
		options.add("VIEW ACCOUNT BALANCE");
		options.add("VIEW CUSTOMER INFO");
		
		return options;
	}
}
