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

	void userLogin(Bank banky, Scanner scan) {
		String username, password;
		System.out.println("\nPlease enter your username: ");
		username = scan.nextLine();
		if (!userMap.containsKey(username)) {
			System.out.println("Username not found. Returning to home screen.");
			Main.pauseScreen(scan);
			return;
		}
		System.out.println("Please enter your password: ");
		password = scan.nextLine();
		if (userMap.get(username).getPassword().equals(password)) {
			userMap.get(username).openUserPortal(banky, scan);
		} else {
			System.out.println("Incorrect password. Returning to home screen.");
		}
	}

	void createUser(Scanner scan) {
		String username, password, name;
		System.out.println("\nPlease enter desired username: ");
		while (true) {
			username = scan.nextLine();
			if (userMap.containsKey(username))
				System.out.println("Username already taken. Please enter a different username: ");
			else
				break;
		}
		System.out.println("Please enter desired password: ");
		password = scan.nextLine();
		System.out.println("Please enter your name: ");
		name = scan.nextLine();
		userMap.put(username, new User(username, password, name));
		System.out.println("New account \"" + username + "\" created.");
	}
	/*
	 * void createEmployee(Scanner scan) { String username, password, name;
	 * System.out.println("\nPlease enter desired username: "); while (true) {
	 * username = scan.nextLine(); if (userMap.containsKey(username)) System.out.
	 * println("Username already taken. Please enter a different username: "); else
	 * break; } System.out.println("Please enter desired password: "); password =
	 * scan.nextLine(); System.out.println("Please enter your name: "); name =
	 * scan.nextLine(); userMap.put(username, new Employee(username, password,
	 * name)); System.out.println("New account \"" + username + "\" created."); }
	 */

	void createEmployee(String username, String password, String name) {
		userMap.put(username, new Employee(username, password, name));
	}

	int generateUniqueAccountNumber() {
		int number = 0;
		while (accountMap.containsKey(number))
			number++;
		return number;
	}

	void addToAccountMap(Account acc) {
		int x = generateUniqueAccountNumber();
		String accountHolder = (String) acc.accountUsers.toArray()[0];
		accountMap.put(x, new Account(x, acc.balance, accountHolder));
	}

	void addToAppQueue(Account acc) {
		applicationQueue.add(acc);
	}

	@Override
	public String toString() {
		return "Bank [userMap=" + userMap + ", accountMap=" + accountMap + ", applicationQueue=" + applicationQueue
				+ "]";
	}

}
