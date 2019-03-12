package com.revature.banking;

import java.io.Serializable;

public class Administrator extends Employee implements ModifyAccount, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4258132073258033065L;

	public Administrator(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean deposit(String account, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdraw(String account, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transfer(String fromHere, String toThere, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
