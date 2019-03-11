package BankingApp;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 9098425649098514114L;
	private String userName;
	private String secondaryUser;

	private String accountName;
	private Double balance;

	private boolean isActive;
	private boolean isApproved;

	// Class Constructors
	public Account(String u, String a) {
		userName = u;
		accountName = a;
		balance = new Double(0.0);
		isActive = true;
		isApproved = false;
	}

	public Account(String u, String s, String a) {
		userName = u;
		secondaryUser = s;
		accountName = a;
		balance = new Double(0.0);
		isActive = true;
		isApproved = false;
	}

	public String getSecondaryUser() {
		return secondaryUser;
	}

	public void setSecondaryUser(String secondaryUser) {
		this.secondaryUser = secondaryUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double newBalance) {
		balance = newBalance;
	}
}
