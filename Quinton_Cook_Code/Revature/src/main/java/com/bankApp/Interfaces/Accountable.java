package com.bankApp.Interfaces;

public interface Accountable {
	boolean withdraw(double amt);
	boolean deposit(double amt);
	boolean transfer(String to, double amt);
}
