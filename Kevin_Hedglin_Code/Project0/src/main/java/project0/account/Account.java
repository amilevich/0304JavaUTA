package project0.account;

import project0.dao.AccountDaoImpl;
import java.util.ArrayList;
import java.util.UUID;

import org.apache.log4j.Logger;

public class Account{
	
	final static Logger logger = Logger.getLogger(Account.class.getName());
	
	private String accountID = null;
	private String accountName = null;
	private boolean isApproved = false;
	private float balance = 0;
	private static AccountDaoImpl acountDao = new AccountDaoImpl();
	ArrayList<String> owners = new ArrayList<String>();
	
	public Account(String accountID, String accountName, float balance, boolean approved, ArrayList<String> owners) {
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
		generateID();
	}

	public static ArrayList<String> getPendingAccounts()
	{
		return acountDao.selectAllUnapprovedAccounts();
	}
	
	public static boolean insertAccount(Account account)
	{
		return acountDao.insertAccount(account);
	}
	
	public static boolean saveAccount(Account account)
	{
		return acountDao.saveAccount(account);
	}
	
	public static Account getAccount(String id)
	{
		return acountDao.selectAccountByID(id);
	}
	
	public static ArrayList<Account> getAccounts(ArrayList<String> ids)
	{
		ArrayList<Account> accounts = new ArrayList<Account>();
		for(int i = 0; i < ids.size(); i++)
		{
			accounts.add(Account.getAccount(ids.get(i)));
		}
		return accounts;
	}
	
	public static void printAccounts()
	{
		
	}
	
	public boolean approveAccount()
	{
		return Account.acountDao.approveAccount(this.accountID);
	}
	
	public void deleteAccount()
	{
		Account.acountDao.deleteAccount(accountID);
	}
	
	public boolean withdraw(double amt) 
	{
		if(amt <= balance && amt > 0)
		{
			balance -= amt;
			logger.info("Bank Account " + this.accountName + " withdrew $" + amt);
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

	public String getAccountID() {
		return this.accountID;
	}
	
	public String getName() {
		return this.accountName;
	}
	
	public boolean isApproved()
	{
		return isApproved;
	}
	
	public void generateID() {
		this.accountID = UUID.randomUUID().toString();
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
