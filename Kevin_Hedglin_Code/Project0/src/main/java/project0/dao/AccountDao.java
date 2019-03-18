package project0.dao;

import java.util.ArrayList;
import java.util.List;

import project0.account.Account;

public interface AccountDao {
	
	//CREATE
	public boolean insertAccount(Account a);
	
	//READ
	public Account selectAccountByID(String accountID);
	public ArrayList<Account> selectAccountsByID(List<String> accountIDs);
	public ArrayList<String> selectAllUnapprovedAccounts();
	public ArrayList<String> selectAllAccountsByUser(String username);
	public ArrayList<String> selectAllOwnersOfAccount(String accountID);
	
	//UPDATE
	public boolean approveAccount(String accountID);
	public boolean saveAccount(Account account);
	
	//DELETE
	public boolean deleteAccount(String accountID);

	int nextSequence();
}
