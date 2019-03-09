package com.bankApp.Account;


import com.bankApp.Interfaces.Accountable;
import com.bankApp.People.Person;

public class Account extends Person implements Accountable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int numberOfFields = 6;

	private Double currentBalance;
	private String accountHolders;
	
	public double getCurrentBalance() {
		return currentBalance;
	}

	@Override
	public String toString() {
		return "Account [currentBalance=" + currentBalance + ", accountHolders=" + accountHolders + ", "
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((accountHolders == null) ? 0 : accountHolders.hashCode());
		long temp;
		temp = Double.doubleToLongBits(currentBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountHolders == null) {
			if (other.accountHolders != null)
				return false;
		} else if (!accountHolders.equals(other.accountHolders))
			return false;
		if (Double.doubleToLongBits(currentBalance) != Double.doubleToLongBits(other.currentBalance))
			return false;
		return true;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getAccountHolders() {
		return accountHolders;
	}

	public void setAccountHolders(String accountHolders) {
		this.accountHolders = accountHolders;
	}

	public Account(String firstName, String lastName, String username, String password, double currentBalance,
			String accountHolders) {
		super(firstName, lastName, username, password);
		this.currentBalance = currentBalance;
		this.accountHolders = accountHolders;

	}

	@Override
	public boolean withdraw(double amt) {

		if (amt > currentBalance || amt < 0) {
			return false;
		} else {
			currentBalance -= amt;
			return true;
		}

	}

	@Override
	public boolean deposit(double amt) {
		if (amt < 0) {
			return false;
		} else {
			currentBalance += amt;
			return true;
		}

	}

	@Override
	public boolean transfer(String usrName, double amt) {

		Account to;

		if (loginInfo.get(usrName) instanceof Account) {
			to = (Account) loginInfo.get(usrName);

			// returns the result of the withdrawal from this account and a deposit from
			// the receivers account
			return withdraw(amt) && to.deposit(amt);

		} else {
			return false;
		}

	}

}
