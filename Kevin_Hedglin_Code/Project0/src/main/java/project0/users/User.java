package project0.users;

import project0.account.Account;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class User implements Serializable{
	
	public static enum userLevel {
		CUSTOMER, EMPLOYEE, ADMIN
	}
	
	private static final long serialVersionUID = 9110193908388065501L;
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private ArrayList<String> accountIDs = new ArrayList<String>();
	private User.userLevel level = User.userLevel.CUSTOMER;
	
	
	protected static HashMap<String, User> users = new HashMap<String, User>();
	
	
	public User(String firstName, String lastName, String username, String password) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		User.users.put(this.username, this);
	}
	
	public static User login(String username, String pass) {
		if (users.containsKey(username) && users.get(username).getPassword().equals(pass)) {
			return users.get(username);
		} else {
			return null;
		}
	}
	
	public static User getUser(String username) {
		if (users.containsKey(username)) {
			return users.get(username);
		} 
		else {
			return null;
		}
	}
	
	public static ArrayList<User> getAllUsers() {
		return new ArrayList<User>(users.values());
	}
	
	public static boolean checkUsernameAvailability(String username)
	{
		if (users.containsKey(username))
			return false;
		else
			return true;
	}
	
	public static void saveUsers()
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("users.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.close();
			fos.close();
			System.out.printf("Serialized User data is saved in users.txt");
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void loadUsers()
	{
		try
		{
			FileInputStream fis = new FileInputStream("users.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			users = (HashMap<String, User>) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
			return;
		}catch(ClassNotFoundException c)
		{
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
	}
	
	public static void printAllUsers()
	{
		Set<Entry<String, User>> set = users.entrySet();
		Iterator<Entry<String, User>> iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			System.out.print("key: "+ mentry.getKey() + " & Value: ");
			System.out.println(mentry.getValue().toString());
		}
	}
	
	public void addAccountID(String acct)
	{
		this.accountIDs.add(acct);
	}
	
	public void removeAccountID(String acct)
	{
		this.accountIDs.remove(acct);
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

	public ArrayList<String> getAccountIDs() {
		return accountIDs;
	}

	public void setAccountIDs(ArrayList<String> ids) {
		this.accountIDs = ids;
	}

	public User.userLevel getUserLevel()
	{
		return this.level;
	}
	
	public void setUserLevel(User.userLevel level)
	{
		this.level = level;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", accounts=" + accountIDs + "]";
	}
	
}
