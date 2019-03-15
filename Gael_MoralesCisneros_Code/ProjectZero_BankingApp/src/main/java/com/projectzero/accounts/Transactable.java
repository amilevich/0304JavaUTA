package com.projectzero.accounts;

import com.projectzero.accounts.WithdrawTooBigException;

//Interface to be implemented by User for transactions
public interface Transactable {

	public void withdraw(float wAmount) throws WithdrawTooBigException;
	
	public void deposit(float dAmount);
	
	public void transfer(float tAmount, String toAccount) throws WithdrawTooBigException;

}
