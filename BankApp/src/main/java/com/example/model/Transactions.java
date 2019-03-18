package com.example.model;

public interface Transactions {
	
	public boolean withdraw(double amount);
	
	public boolean deposit(double amount);

	public boolean transferTo(User to, double amount);

}
