package com.bankApp.People;

import com.bankApp.Account.Account;

public class BankAdmin extends Employee {

	public BankAdmin(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);
		
		
	}

	public static boolean cancelAccount(Account act) {
		if(loginInfo.containsKey(act.getUsername())) {
			loginInfo.remove(act.username);
			return true;
			
		}else {
			return false;
		}
	}

	public static boolean transfer(Account from, Account to, double amt) {
		return from.transfer(to, amt);
	}

	public static boolean deposit(Account act, double amt) {
		return act.deposit(amt);
	}

	public static boolean withdraw(Account act, double amt) {
		return act.withdraw(amt);
	}

}
