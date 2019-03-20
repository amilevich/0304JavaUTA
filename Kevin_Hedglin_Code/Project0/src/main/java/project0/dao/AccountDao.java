package project0.dao;

import java.util.ArrayList;
import java.util.List;

import project0.account.Account;

public interface AccountDao {
	
	//CREATE
	public int insertAccount(Account a);
	
	//READ
	public Account selectAccountByID(int accountID);
	public ArrayList<Account> selectAccountsByID(List<Integer> accountIDs);
	public ArrayList<Account> selectAllUnapprovedAccounts();
	public ArrayList<String> selectAllAccountsByUser(String username);
	public ArrayList<String> selectAllOwnersOfAccount(int accountID);
	public ArrayList<Account> getAllAccounts();
	
	//UPDATE
	public boolean approveAccount(int accountID);
	public int saveAccount(Account account);
	
	//DELETE
	public boolean deleteAccount(int accountID);

	int nextSequence();
}
