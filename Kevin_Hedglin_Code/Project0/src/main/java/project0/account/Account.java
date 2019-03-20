package project0.account;

import project0.dao.AccountDaoImpl;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class Account{
	
	final static Logger logger = Logger.getLogger(Account.class.getName());
	
	private int accountID;
	private String accountName = null;
	private boolean isApproved = false;
	private float balance = 0;
	private static AccountDaoImpl accountDao = new AccountDaoImpl();
	ArrayList<String> owners = new ArrayList<String>();
	
	public Account(int accountID, String accountName, float balance, boolean approved, ArrayList<String> owners) {
		this.accountID = accountID;
		this.accountName = accountName;
		this.balance = balance;
		this.isApproved = approved;
		this.owners = owners;
	}
	
	public Account(String accountName, float balance, boolean approved, ArrayList<String> owners) {
		this.accountName = accountName;
		this.balance = balance;
		this.isApproved = approved;
		this.owners = owners;
		this.accountID = Account.saveAccount(this);
	}

	public static ArrayList<Account> getPendingAccounts()
	{
		return accountDao.selectAllUnapprovedAccounts();
	}
	
	public static int saveAccount(Account account)
	{
		if(accountDao.selectAccountByID(account.getAccountID()) != null)
		{
			return accountDao.saveAccount(account);
		}
		else
		{
			return accountDao.insertAccount(account);
		}
	}
	
	public static Account getAccount(int id)
	{
		return accountDao.selectAccountByID(id);
	}
	
	public static ArrayList<Account> getAccounts(ArrayList<Integer> ids)
	{
		ArrayList<Account> accounts = new ArrayList<Account>();
		for(int i = 0; i < ids.size(); i++)
		{
			accounts.add(Account.getAccount(ids.get(i)));
		}
		return accounts;
	}
	
	public static ArrayList<Account> getAllAccounts()
	{
		return accountDao.getAllAccounts();
	}
	
	public boolean approveAccount()
	{
		boolean success = Account.accountDao.approveAccount(this.accountID);
		if(success)
		{
			this.isApproved = true;
			accountDao.saveAccount(this);
		}
		return success;
	}
	
	public boolean deleteAccount()
	{
		return Account.accountDao.deleteAccount(accountID);
	}
	
	public boolean withdraw(double amt) 
	{
		if(amt <= balance && amt > 0)
		{
			balance -= amt;
			logger.info("Bank Account " + this.accountName + " withdrew $" + amt);
			Account.saveAccount(this);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean deposit(double amt) 
	{
		if(amt > 0)
		{
			logger.info("Bank Account " + this.accountName + " deposited $" + amt);
			balance += amt;
			Account.saveAccount(this);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean transferFunds(Account acc, double amt)
	{
		if(this.withdraw(amt))
		{
			logger.info("Bank Account " + this.accountName + " transfered $" + amt + " to account " + acc.getName());
			acc.deposit(amt);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public float getBalance() {
		return balance;
	}

	public int getAccountID() {
		return this.accountID;
	}
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public String getName() {
		return this.accountName;
	}
	
	public boolean isApproved()
	{
		return isApproved;
	}
	
	public void setOwners(ArrayList<String> owners)
	{
		this.owners = owners;
	}
	
	public ArrayList<String> getOwners(){
		return this.owners;
	}
	
	@Override
	public String toString() {
		return "Account [isApproved=" + isApproved + ", balance=" + balance + "]";
	}

}
