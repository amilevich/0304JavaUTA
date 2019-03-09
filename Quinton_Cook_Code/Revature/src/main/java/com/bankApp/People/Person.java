package com.bankApp.People;

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

import com.bankApp.Account.Account;

/*
 * this will be the bean that all of the AccountHolders and Employee objects
 * extend, we're all human after all
 */
public class Person implements Serializable {
	// default save location
	private static final String filename = "Account";
	private static final String counterFile = "counter.sv";
	private static final long serialVersionUID = 1L;
	private static int counter;

	private String firstName;
	private String lastName;
	private String username;
	private String password;

	// stores all of the accounts in memory this allows all users to authenticate
	protected static HashMap<String, Person> loginInfo = new HashMap<String, Person>();

	public Person(String firstName, String lastName, String username, String password) {
		super();
		// I dont want spaces in usernames so I have this replace all spaces with
		// underscores
		username.replace(' ', '_');

		this.firstName = firstName;
		this.lastName = lastName;

		// strip out any whitespace at the beginning or end of the string
		this.username = username.trim();
		this.password = password;
	}

	// *********************************************************************************************************

	// static methods
	public static Person login(String usrName, String pswd) {
		if (loginInfo.containsKey(usrName) && loginInfo.get(usrName).getPassword().equals(pswd)) {
			return loginInfo.get(usrName);
		} else {
			return null;
		}
	}

	public static boolean userNameNotUnique(String usrName) {
		return loginInfo.containsKey(usrName);
	}

	public static void load() {

		// first the counter int is loaded so that we know how many account files to
		// load
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(System.getProperty("user.dir") + "\\" + counterFile));

			counter = (int) ois.readObject();

			ois.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// next for each of the accounts load them into the loginInfo hashmap
		for (int i = 0; i < counter; i++) {

			try {
				// recall that all user account save files are saved under the name
				// Account[i].sv
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
						System.getProperty("user.dir") + "\\" + filename + Integer.toString(i) + ".sv"));

				Account acct = (Account) ois.readObject();

				loginInfo.put(acct.getUsername(), acct);

				ois.close();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// TODO not terribly efficient, each time a person is closed this will write the
	// whole loginInfo to a file

	// writes all of the approved accounts in loginInfo to a file on the computer
	public static void close() {

		Iterator<Entry<String, Person>> it = loginInfo.entrySet().iterator();

		/*
		 * this method will iterate through the loginInfo hashmap, create a new file for
		 * each account under the name Account[n].sv this will overwrite any previous
		 * save file that exists in the current working directory
		 */
		while (it.hasNext()) {

			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
					System.getProperty("user.dir") + "\\" + filename + Integer.toString(counter) + ".sv", false))) {
				counter++;
				oos.writeObject(it.next().getValue());

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		// saves counters value for the load method in the file counterFile
		try {

			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(System.getProperty("user.dir") + "\\" + counterFile, false));

			oos.writeObject(counter);

			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static boolean applyForAccount(Account acct) {

		// if the bank approves the account and if the username is unique, accept the
		// account
		if (Employee.reviewAccount(acct) && !(loginInfo.containsKey(acct.getUsername()))) {
			loginInfo.put(acct.getUsername(), acct);
			return true;
		} else {
			return false;
		}
	}

	// adding this because I anticipate employees will have to login at some point

	/*
	 * public static boolean applyForAccount(Employee acct) {
	 * 
	 * // if the user name is unique add the account to the loginInfo hashmap if
	 * (!(loginInfo.containsKey(acct.getUsername()))) {
	 * loginInfo.put(acct.getUsername(), acct); return true; } else { return false;
	 * } }
	 */

	// ****************************************************************************************************

	// end static methods

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + "]";
	}

	// this was auto generated, I wanted a to string
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	// *********************************************************************************************

	// setters and getters
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

}
