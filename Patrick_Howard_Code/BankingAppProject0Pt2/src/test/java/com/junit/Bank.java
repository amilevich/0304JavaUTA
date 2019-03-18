package com.junit;

public class Bank {

	public Bank() {
		System.out.println("Bank started.");
	}

	public Integer depositFunds(int balance, int value) {
		int total = balance + value;
		balance = total;
		return balance;
	}

	public Integer withdrawFunds(int balance, int value) {
		int total = value - balance;
		balance = total;
		return balance;
	}

	public boolean areUsersEqual(String s, String s2) {
		if (s.equals(s2))
			return true;
		else {
			return false;
		}
	}
}