package com.example.dao;


import java.util.List;

import com.example.model.BankAcct;




public interface BankAcctDao {
	
	public int insertBankAcct(BankAcct ba);
	
	public double deposit(BankAcct ba);
	
	public double withdraw(BankAcct ba);

	public int approveAccount(int accountNumber, BankAcct ba);
	
	public int deleteAccount(BankAcct ba);
	
	public List<BankAcct> selectAllBankAccts();
	
	public BankAcct selectUserByAccountNum(int accountNumber);
	
	public void updateBankAcct(BankAcct ba);

	public int selectAccNumByMax();

	
	

}
