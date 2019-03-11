package project0.users;

import java.util.ArrayList;

import project0.account.Account;

public class Employee extends User{
	
	
	private static final long serialVersionUID = -2356012502525195201L;

	public Employee(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);
		super.setUserLevel(User.userLevel.EMPLOYEE);
	}

	public ArrayList<String> getCustomerInfo(ArrayList<User> users)
	{
		ArrayList<String> info = new ArrayList<String>();
		for(User u : users)
		{
			info.add(u.toString());
		}
		return info;
	}
	
	public ArrayList<User> getAllCustomers()
	{
		return User.getAllUsers();
	}
	
	public static void approveAccount(Account acct) {
		acct.approveAccount();
	}
	
	public static void rejectAccount(Account acct) {
		acct.rejectAccount();
	}

	public static String getAccountInfo(Account acct) {
		return acct.toString();
	}
}
