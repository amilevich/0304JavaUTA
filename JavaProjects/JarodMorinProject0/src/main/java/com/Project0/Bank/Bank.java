package com.Project0.Bank;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Bank implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8327679895495650563L;
	Map<String, User> userMap = new HashMap<String, User>(); // stores registered users, mapped to username
	Map<Integer, Account> accountMap = new HashMap<Integer, Account>(); // stores active bank accounts,
																		// mapped to account ID numbers
	LinkedList<Account> applicationQueue = new LinkedList<Account>(); // stores Account objects that are in the
																		// application process. Upon Employee
																		// approval these are moved to
																		// accountMap and become usable

	void userLogin(Bank banky, Scanner scan) { // Prompts user for username/password combination.
		String username, password;
		System.out.println("\nPlease enter your username: ");
		username = scan.nextLine();
		if (!userMap.containsKey(username)) { // Return to home screen if given username is not valid
			System.out.println("Username not found. Returning to home screen.");
			Main.pauseScreen(scan);
			return;
		}
		System.out.println("Please enter your password: ");
		password = scan.nextLine();
		if (userMap.get(username).getPassword().equals(password)) {
			userMap.get(username).openUserPortal(banky, scan); // Upon successful login, move to user portal (second
																// menu of options, varies with user type: user,
																// employee and admin each view different menus with
																// different options

		} else {
			System.out.println("Incorrect password. Returning to home screen."); // Return to home screen if given
																					// password does not match stored
																					// password
		}
	}

	void createUser(Scanner scan) {
		String username, password, name; // function used to register a new username/password login combo, as well a
											// name to associate with the user
		System.out.println("\nPlease enter desired username: ");
		while (true) {
			username = scan.nextLine();
			if (userMap.containsKey(username)) // determine if given username input is unique, prompt for a new input if
												// not
				System.out.println("Username already taken. Please enter a different username: ");
			else
				break;
		}
		System.out.println("Please enter desired password: ");
		password = scan.nextLine();
		System.out.println("Please enter your name: ");
		name = scan.nextLine();
		userMap.put(username, new User(username, password, name)); // create new User object with given username,
																	// password and name and store in UserMap
		System.out.println("New account \"" + username + "\" created.");
	}

	void createEmployee(String username, String password, String name) { // create new employee. Cannot be called during
																			// runtime, used by me to hardcode employees
																			// for testing
		userMap.put(username, new Employee(username, password, name));
	}

	void createAdmin(String username, String password, String name) { // inaccessible during runtime, only used to
																		// instantiate an admin and place into userMap
		userMap.put(username, new Admin(username, password, name));
	}

	int generateUniqueAccountNumber() { // returns a number that differs from every account number key stored in
										// accountMap
		int number = 0;
		while (accountMap.containsKey(number))
			number++;
		return number;
	}

	void addToAccountMap(Account acc) { // adds an account to accountMap. The account id of the given Account is
										// ignored, and a new unique account number is generated to ensure uniqueness
		int x = generateUniqueAccountNumber();
		String accountHolder = (String) acc.accountUsers.toArray()[0];
		accountMap.put(x, new Account(x, acc.balance, accountHolder));
	}

	void addToAppQueue(Account acc) {	// adds an account object to the applicationQueue
		applicationQueue.add(acc);
	}

	@Override
	public String toString() {
		return "Bank [userMap=" + userMap + ", accountMap=" + accountMap + ", applicationQueue=" + applicationQueue
				+ "]";
	}

}
