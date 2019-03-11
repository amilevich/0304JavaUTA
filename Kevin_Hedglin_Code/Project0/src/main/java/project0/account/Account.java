package project0.account;

import project0.users.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.logging.Logger;

public class Account implements Serializable{
	
	private static final long serialVersionUID = 8929309847189983319L;
	
	final static Logger logger = Logger.getLogger(Account.class.getName());
	
	protected static HashMap<String, Account> accounts = new HashMap<String, Account>();
	protected static HashSet<String> approvedAccounts = new HashSet<String>();
	protected static HashSet<String> pendingAccounts = new HashSet<String>();
	
	private String accountID = null;
	private String accountName = null;
	private boolean isApproved = false;
	private double balance = 0;
	private HashSet<String> owners = new HashSet<String>();
	
	
	public Account(String accountName, ArrayList<String> owners) {
		this.accountID = UUID.randomUUID().toString();
		this.accountName = accountName;
		for(String owner : owners)
		{
			this.owners.add(owner);
			User.getUser(owner).addAccountID(this.accountID);
		}
		
		accounts.put(this.accountID, this);
		pendingAccounts.add(this.accountID);
	}
	
	public static HashSet<String> getApprovedAccounts()
	{
		return approvedAccounts;
	}
	
	public static HashSet<String> getPendingAccounts()
	{
		return pendingAccounts;
	}
	
	public static void saveAccounts()
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("pendingAccounts.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(pendingAccounts);
			oos.close();
			fos.close();
			System.out.printf("Pending account data is saved in pendingAccounts.txt");
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		try
		{
			FileOutputStream fos = new FileOutputStream("accounts.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(approvedAccounts);
			oos.close();
			fos.close();
			System.out.printf("account data is saved in accounts.txt");
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void loadAccounts()
	{
		try
		{
			FileInputStream fis = new FileInputStream("pendingAccounts.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			accounts = (HashMap<String, Account>) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
			return;
		}catch(ClassNotFoundException c){
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
	}
	
	public static Account getAccount(String id)
	{
		return accounts.get(id);
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
		Set<Entry<String, Account>> set = accounts.entrySet();
		Iterator<Entry<String, Account>> iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			System.out.print("key: "+ mentry.getKey() + " & Value: ");
			System.out.println(mentry.getValue().toString());
		}
	}
	
	public void approveAccount()
	{
		if(!isApproved)
		{
			Account.pendingAccounts.remove(accountID);
			Account.approvedAccounts.add(accountID);
			isApproved = true;
		}
	}
	
	public void rejectAccount()
	{
		if(!isApproved)
		{
			Account.pendingAccounts.remove(accountID);
			for(String owner: owners) {
				User u = User.getUser(owner);
				if(u != null)
				{
					u.removeAccountID(accountID);
				}
			}
		}
	}
	
	public void cancelAccount()
	{
		Account.pendingAccounts.remove(accountID);
		Account.accounts.remove(accountID);
		for(String owner: owners) {
			User u = User.getUser(owner);
			if(u != null)
			{
				u.removeAccountID(accountID);
			}
		}
	}
	
	public boolean withdraw(double amt) 
	{
		if(amt <= balance && amt > 0)
		{
			balance -= amt;
			logger.info("Bank Account " + this.accountName + " belonging to " + String.join(", ",this.getOwners())
					+ " withdrew $" + amt);
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
			logger.info("Bank Account " + this.accountName + " belonging to " + String.join(", ",this.getOwners())
			+ " deposited $" + amt);
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
			logger.info("Bank Account " + this.accountName + " belonging to " + String.join(", ",this.getOwners())
			+ " transfered $" + amt + " to account " + acc.getName() + " belonging to " + String.join(", ", acc.getOwners()));
			acc.deposit(amt);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public double getBalance() {
		return balance;
	}

	public HashSet<String> getOwners() {
		return owners;
	}

	public String getAccountID() {
		return this.accountID;
	}
	
	public String getName() {
		return this.accountName;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Account [isApproved=" + isApproved + ", balance=" + balance + ", owners=" + owners + "]";
	}

}
