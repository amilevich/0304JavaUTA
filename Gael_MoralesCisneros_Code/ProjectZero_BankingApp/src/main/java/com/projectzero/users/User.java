package com.projectzero.users;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.projectzero.accounts.Account;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String username;
	public static String password;
	public static String firstName;
	public static String lastName;
	public static String ssn;

	public User() {
	}

	public User(String username, String password) {
		super();
		User.username = username;
		User.password = password;
	}
	
	//filename for Serialization
	public static final String filename = "./Customer";
	//Hashmap to store username and deserialized object for authentication
	public static HashMap<String, User> loginInfo = new HashMap<>();

	//method to authenticate normal user
	public static User authenticate(String un, String pw) {
		//check if username is in hashmap and if the password matches the hashmap password
		if (loginInfo.containsKey(un) && loginInfo.get(un).getPassword().equals(pw)) {
			//returns username if successful, null if failed
			return loginInfo.get(un);
		} else {
			return null;
		}

	}

	public static String getUsername() {
		return username;
	}

	public static String getFirstName() {
		return firstName;
	}

	public static void setFirstName(String firstName) {
		User.firstName = firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String lastName) {
		User.lastName = lastName;
	}

	public static String getSsn() {
		return ssn;
	}

	public static void setSsn(String ssn) {
		User.ssn = ssn;
	}

	public void setUsername(String username) {
		User.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		User.password = password;
	}

	//method to check if username is already being used
	public static boolean userNameAlreadyUsed(String un) {
		//true or false if username in hashmap
		return loginInfo.containsKey(un);
	}

	
	//method to insert User account for authentication purposes
	public static void InsertUserObject() {

		try {
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(System.getProperty("user.dir") + "\\" + filename + ".txt"));

			Account acct = (Account) ois.readObject();
			loginInfo.put(acct.getUsername(), acct);
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("No previous User account found. Please create one");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//method to Serialize account when closing app
	public static void close(Account obj) {

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(System.getProperty("user.dir") + "\\" + filename + ".txt", false))) {
			oos.writeObject(obj);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
