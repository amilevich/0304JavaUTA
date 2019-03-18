package project0.users;

import java.util.ArrayList;

import project0.account.Account;

public class Admin extends Employee{

	public Admin(String firstName, String lastName, String username, String password, ArrayList<Account> accounts) {
		super(firstName, lastName, username, password, accounts);
		super.setUserLevel(User.userLevel.ADMIN);
	}

	public boolean withdraw(Account acct, double amt) {
		return acct.withdraw(amt);
		
	}
	
	public boolean deposit(Account acct, double amt) {
		return acct.deposit(amt);
		
	}
	
	public boolean transfer(Account acct1, Account acct2, double amt) {
		return acct1.transferFunds(acct2, amt);
	}
	
	public void deleteAccount(Account acct) {
		acct.deleteAccount();
	}
}
