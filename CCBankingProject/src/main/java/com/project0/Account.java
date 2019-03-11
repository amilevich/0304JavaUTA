package com.project0;

import java.io.Serializable;
import java.util.Random;

import org.apache.log4j.Logger;



public class Account implements Serializable {
	final static Logger logger = Logger.getLogger(Main.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -6093252087499423171L;
	private String userName;
	private String password;
	private String Name;
	private char AccountType;
	private int AccountID;
	private char Status;
	double Funds;

	
	
	public Account(String userName, String password, String Name, char AccountType) {
		this.userName = userName;
		this.password = password;
		this.Name = Name;
		this.AccountType = AccountType;
		
		Funds = 0.0;
		Status = 'W';
		
		Random ID = new Random();
		AccountID = ID.nextInt();
		AccountID = Math.abs(AccountID);
		
		
	}
	
	public double Deposit(double change){
		if(change < 0) {
			logger.warn("Amount entered was negative");
			System.out.println("Amount entered was negetive");
		}
		else{
			Funds=Funds+change;
			logger.info("$" + Funds + "deposited to " + AccountID);
		}
		
		return Funds;
		
	}
	
	public double Withdraw(double change) {
		if(change>Funds) {
			logger.warn("Tried withdrawing more than balance");
			System.out.println("Your withdraw amount exceeds your balance.");
		}
		else if(change <0) {
			logger.warn("Amount entered was negative");
			System.out.println("Amount entered was negetive");
		}
		else {
			logger.info("$" + Funds + "withrawn from" + AccountID);
			Funds=Funds-change;
		}
		return Funds;
		
	}

	@Override
	public String toString() {
		return "Account [userName=" + userName + ", Name=" + Name + ", AccountType=" + AccountType + ", AccountID="
				+ AccountID + ", Status=" + Status + ", Funds=" + Funds + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public char getAccountType() {
		return AccountType;
	}

	public void setAccountType(char accountType) {
		AccountType = accountType;
	}

	public int getAccountID() {
		return AccountID;
	}

	public void setAccountID(int accountID) {
		AccountID = accountID;
	}

	public char getStatus() {
		return Status;
	}

	public void setStatus(char status) {
		Status = status;
	}

	public double getFunds() {
		return Funds;
	}

	public void setFunds(double funds) {
		Funds = funds;
	}
	
	

}
