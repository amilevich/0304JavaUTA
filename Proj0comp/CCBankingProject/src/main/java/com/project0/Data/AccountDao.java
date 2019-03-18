package com.project0.Data;

import java.util.List;

import com.project0.Build.Account;

public interface AccountDao {
	
		//Insert into database
		public int insertAccount(Account Alpha);
		
		//Select all accounts from database
		//public List<Account> selectAllAccounts();
		
		//Display all from database	
		public void displayAccounts();
		
		//Select from database by Username and Password
		public Account selectAccount(String Uname, String pass);
		
		//Delete an account
		public int deleteAccount(int Beta);
		
		
		//Update Funds of Account
		public int updateAccount(Account Alpha);
		
		//Select Using ID
		public Account FindByID(int T_ID);
		
		//Select by username
		public Account FindByUser(String Uname);
		
		//Find Users With waiting Status
		public List<Account> FindPending();
		
		//Update Status of Account
		public void updateStatus(Account Alpha);

}
