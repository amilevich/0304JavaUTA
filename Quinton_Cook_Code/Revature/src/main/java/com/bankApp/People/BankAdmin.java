package com.bankApp.People;

import com.bankApp.Account.Account;

public class BankAdmin extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankAdmin(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);

	}

	public static boolean cancelAccount(Account act) {
		if (loginInfo.containsKey(act.getUsername())) {
			loginInfo.remove(act.getUsername());
			return true;

		} else {
			return false;
		}
	}

	// TODO the functionality is here to transfer funds however
	// I'm unsure of the design choice. A bank admin will have to have an Account
	// object to work with
	// this will be resolved later
	public static boolean transfer(Account from, String to, double amt) {
		return from.transfer(to, amt);
	}

	public static boolean deposit(Account act, double amt) {
		return act.deposit(amt);
	}

	public static boolean withdraw(Account act, double amt) {
		return act.withdraw(amt);
	}

}
