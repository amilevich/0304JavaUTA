package project0.users;

import java.util.ArrayList;
import project0.account.Account;

public class Employee extends User{

	public Employee(String firstName, String lastName, String username, String password, ArrayList<Account> accounts) {
		super(firstName, lastName, username, password, accounts);
		super.setUserLevel(User.userLevel.EMPLOYEE);
	}

	public String getCustomerInfo(String username)
	{
		return User.getUser(username).toString();
	}
	
	public String getAccountInfo(String acctID) {
		return Account.getAccount(acctID).toString();
	}
	
	public ArrayList<User> getCustomers()
	{
		return User.getAllCustomers();
	}
	
	public ArrayList<String> getAllPendingAccounts()
	{
		return new ArrayList<String>(Account.getPendingAccounts());
	}
	
	public static boolean approveAccount(String acctID) {
		
		return Account.getAccount(acctID).approveAccount();
	}
}
