package com.revature.banking;

public interface ModifyAccount {

	boolean deposit (String account, double amount);
	boolean withdraw(String account, double amount);
	boolean transfer(String fromHere, String toThere, double amount);
}
