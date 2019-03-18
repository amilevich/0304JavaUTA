package project0.users;

import project0.account.Account;
import project0.dao.UserDaoImpl;
import java.util.ArrayList;

public class User{
	
	public static enum userLevel {
		CUSTOMER(0), EMPLOYEE(1), ADMIN(2);
		
		private final int value;
	    private userLevel(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	}
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private ArrayList<Account> bankAccounts = new ArrayList<Account>();
	private User.userLevel level = User.userLevel.CUSTOMER;
	private static UserDaoImpl userDao = new UserDaoImpl();
	
	
	public User(String firstName, String lastName, String username, String password, ArrayList<Account> accounts) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.bankAccounts = accounts;
	}
	
	public static User login(String username, String pass) {
		return userDao.login(username, pass);
	}
	
	public static boolean saveUser(User u) {
		return userDao.insertUser(u);
	}
	
	public static User loadUser(String user) {
		return userDao.selectUserByUsername(user);
	}
	
	public static User getUser(String username) {
		return userDao.selectUserByUsername(username);
	}
	
	public static ArrayList<User> getAllCustomers() {
		return userDao.selectAllCustomers();
	}
	
	public static boolean checkUsernameAvailability(String username)
	{
		if (userDao.selectUserByUsername(username) != null)
			return false;
		else
			return true;
	}
	
	public static void printAllUsers()
	{
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User.userLevel getUserLevel()
	{
		return this.level;
	}
	
	public void setUserLevel(User.userLevel level)
	{
		this.level = level;
	}
	
	public ArrayList<Account> getBankAccounts()
	{
		return this.bankAccounts;
	}

	@Override
	public String toString() {
		
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + "]";
	}
	
}
