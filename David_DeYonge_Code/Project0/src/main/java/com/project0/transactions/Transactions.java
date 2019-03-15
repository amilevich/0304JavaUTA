package com.project0.transactions;

import com.project0.account.Account;

public interface Transactions
{
	public void Withdraw(float amount,Account account);
	public void Deposit(float amount,Account account);
	public void Transfer(float amount,Account fromAccount,Account toAccount);
}
