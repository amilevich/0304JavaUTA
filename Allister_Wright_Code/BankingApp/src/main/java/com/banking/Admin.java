package com.banking;

import java.util.ArrayList;

public class Admin extends Employee
{
	private static final long serialVersionUID = -7484753674657481449L;

	public Admin (String username, String password)
	{
		super(username, password);
	}
	
	@Override
	public ArrayList<String> getAccountOperations(Account acct)
	{
		// Array List used here for uniformity with Customer Access Rights
		ArrayList<String> options = super.getAccountOperations(acct);
		// regular employee options (approve/deny, view info, view customer info)
		
		options.add("WITHDRAW");
		options.add("DEPOSIT");
		options.add("TRANSFER");
		options.add("CLOSE");
		
		return options;
	}
}
