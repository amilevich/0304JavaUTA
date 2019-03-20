package project0.users;

import java.util.ArrayList;
import project0.account.Account;
import project0.dao.UserDaoImpl;

public class Employee extends User{

	private static UserDaoImpl userDao = new UserDaoImpl();
	
	public Employee(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);
		super.setUserLevel(User.userLevel.EMPLOYEE);
	}
	
	public static ArrayList<String> getAllCustomerUsernames() {
		return userDao.selectAllCustomerUsernames();
	}

	public String getCustomerInfo(String username)
	{
		return User.getUser(username).toString();
	}
	
	public String getAccountInfo(int acctID) {
		return Account.getAccount(acctID).toString();
	}
	
	public ArrayList<Account> getAllPendingAccounts()
	{
		return Account.getPendingAccounts();
	}
	
	public static boolean approveAccount(int acctID) {
		
		return Account.getAccount(acctID).approveAccount();
	}
}
