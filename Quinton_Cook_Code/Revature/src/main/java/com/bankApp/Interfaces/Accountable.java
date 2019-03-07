package com.bankApp.Interfaces;

import com.bankApp.Account.Account;

public interface Accountable {
	boolean withdraw(double amt);
	boolean deposit(double amt);
	boolean transfer(Account to, double amt);
}
