package com.Project0.Bank;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Employee extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8426102313623294750L;

	public Employee(String username, String password, String name) {
		super(username, password, name);
	}

	@Override
	void openUserPortal(Bank banky, Scanner scanner) {
		boolean dontExitYet = true;
		while (true) {
			int input = 0;
			try {
				System.out.println("\n\n\n\n\n\n\n\n\n\nHello " + name + "!\n");
				System.out.println("Would you like to: ");
				System.out.print("1. View your accounts\n2. Apply for a new account\n3. Perform a transaction"
						+ "\n4. View joint account requests\n5. View account applications\n6. View customer info\n7. Logout\nPlease enter the number of your selection: ");
				String strIn = null;
				strIn = scanner.nextLine();
				try {
					input = Integer.parseInt(strIn);
				} catch (NumberFormatException e) {
					System.out.println("\nInvalid input. Please enter a number.");
					Main.pauseScreen(scanner);
					continue;
				}
			} catch (NoSuchElementException e) {
				System.out.println("Input not found. Please try again");
				Main.pauseScreen(scanner);
				continue;
			}

			switch (input) {
			case 1:
				viewAccounts(banky);
				break;
			case 2:
				createAccount(banky, scanner);
				break;
			case 3:
				openTransactionMenu(banky, scanner);
				break;
			case 4:
				requestJointAccount(banky, scanner);
				break;
			case 5:
				viewAccountApplications(banky, scanner);
				break;
			case 6:
				viewCustomerInfo(banky,scanner);
				break;
			case 7:
				System.out.println("\nLogging out.\n\nGoodbye!");
				dontExitYet = false;
				break;
			default:
				System.out.println("\nInvalid selection. Plese input a number from the menu.");
				break;
			}
			Main.pauseScreen(scanner);
			if (!dontExitYet)
				break;
		}
	}

	void viewAccountApplications(Bank banky, Scanner scan) {
		if (banky.applicationQueue.isEmpty()) {
			System.out.println("\nThere are no applications pending approval.");
			System.out.println("Returning to home menu.");
			Main.pauseScreen(scan);
		} else
			while (!banky.applicationQueue.isEmpty()) {
				System.out.println("\nUser " + (String) banky.applicationQueue.getFirst().getAccountUsers().toArray()[0]
						+ " would like to open" + " a new account with balance "
						+ banky.applicationQueue.getFirst().getBalance());
				System.out.println("Type 'y' to approve, or type 'n' to deny.");
				String input;
				while (true) {
					input = scan.nextLine();
					if (input.equals("y")) {
						banky.addToAccountMap(banky.applicationQueue.getFirst());
						banky.applicationQueue.removeFirst();
						System.out.println("Account approved.");
						break;
					} else if (input.equals("n")) {
						banky.applicationQueue.removeFirst();
						System.out.println("Account denied.");
						break;
					} else {
						System.out.println("Invalid input. Please enter y/n.");
					}
				}
			}
	}

	void viewCustomerInfo(Bank banky, Scanner scan) {
		System.out.println("List of users: ");
		for(String customer : banky.userMap.keySet()) {
			System.out.println(banky.userMap.get(customer).getUsername());
		}
		String customer = null;
		System.out.println("Which user would you like to know about: ");
		while (true) {
			customer = scan.nextLine();
			if (!banky.userMap.containsKey(customer))
				System.out.println("Username not found. Please enter a valid username: ");
			else
				break;
		}
		System.out.println("Username: " + customer + "\nName: " + banky.userMap.get(customer).getName() + "\nAccounts: ");
		boolean foundAccount = false;
		for (int x : banky.accountMap.keySet()) {
			if (banky.accountMap.get(x).getAccountUsers().contains(customer)) {
				foundAccount = true;
				System.out.println(banky.accountMap.get(x));
			}
		}
		if (!foundAccount) {
			System.out.println("\nNo active accounts found.");
			return;
		}
		
	}
	
}
