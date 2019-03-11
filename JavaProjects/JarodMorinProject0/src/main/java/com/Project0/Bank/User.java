package com.Project0.Bank;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8090335941928816046L;
	protected String username, password, name;

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + "]";
	}

	public User(String username, String password, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	void openUserPortal(Bank banky, Scanner scanner) {
		boolean dontExitYet = true; // Opens a portal that displays options to the user that is logged in, prompts
									// the user to select one, and then initiates the selected task
		while (true) {
			int input = 0;
			viewJointApplications(banky, scanner);
			try {
				System.out.println("\n\n\n\n\n\n\n\n\n\nHello " + name + "!\n");
				System.out.println("Would you like to: ");
				System.out.print("1. View your accounts\n2. Apply for a new account\n3. Perform a transaction"
						+ "\n4. Request joint account\n5. Logout\nPlease enter the number of your selection: ");
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

	void openTransactionMenu(Bank banky, Scanner scanner) { // A secondary menu that appears when the transaction option
															// is selected
															// Displays the three transaction options withdraw, deposit
															// and transfer as well as an option to return to the
															// previous screen. The user is prompted to choose from
															// these options, and the selected task is initiated here
		while (true) {
			int input = 0;
			boolean wantsToLeave = false;
			try {
				System.out.println("Would you like to: ");
				System.out.print(
						"1. Withdraw from an account\n2. Deposit into an account\n3. Transfer into another account"
								+ "\n4. Return to portal\nPlease enter the number of your selection: ");
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
				withdraw(banky, scanner);
				wantsToLeave = true;
				break;
			case 2:
				deposit(banky, scanner);
				wantsToLeave = true;
				break;
			case 3:
				transfer(banky, scanner);
				wantsToLeave = true;
				break;
			case 4:
				wantsToLeave = true;
				break;
			default:
				System.out.println("\nInvalid selection. Plese input a number from the menu.");
				break;
			}
			if (wantsToLeave)
				break;
			Main.pauseScreen(scanner);
		}
	}

	void viewAccounts(Bank banky) { // This method displays all accounts associated with the current user, or that
									// no associated active accounts were found.
		boolean foundAccount = false;
		for (int x : banky.accountMap.keySet()) {
			if (banky.accountMap.get(x).getAccountUsers().contains(username)) {
				if (foundAccount == false) {
					foundAccount = true;
					System.out.println("\nYour active accounts are: ");
				}
				System.out.println(banky.accountMap.get(x));
			}

		}
		if (!foundAccount)
			System.out.println("\nNo active accounts found.");
	}

	void withdraw(Bank banky, Scanner scan) { // This option allows the user to withdraw from an account. Ensures that
												// the user has an active account and that the chosen account number is
												// accessible by the current user. The withdraw amount is also tested to
												// ensure it is non-negative and does not exceed the account balance.
												// Finally, the account balance is updated based on the withdrawn
												// amount.
		boolean foundAccount = false;
		int accnum = 0;
		for (int x : banky.accountMap.keySet()) {
			if (banky.accountMap.get(x).getAccountUsers().contains(username)) {
				foundAccount = true;
				break;
			}
		}
		if (!foundAccount) {
			System.out.println("\nNo active accounts found.");
			return;
		}

		System.out.print("Please enter the account number: ");
		while (true) {
			try {

				String strIn = null;
				strIn = scan.nextLine();
				try {
					accnum = Integer.parseInt(strIn);
				} catch (NumberFormatException e) {
					System.out.println("\nInvalid input. Please enter a number.");
					continue;
				}
			} catch (NoSuchElementException e) {
				System.out.println("\nInput not found. Please try again.");
				continue;
			}
			if (banky.accountMap.containsKey(accnum)) {
				if (banky.accountMap.get(accnum).getAccountUsers().contains(username)) {
					double amount = -1;
					System.out.print("\nPlease enter amount to withdraw: ");
					while (true) {
						try {

							String strIn = null;
							strIn = scan.nextLine();
							try {
								amount = Double.parseDouble(strIn);
							} catch (NumberFormatException e) {
								System.out.println("\nInvalid input. Please enter a number.");
								continue;
							}
						} catch (NoSuchElementException e) {
							System.out.println("\nInput not found. Please try again.");
							continue;
						}
						if (amount >= 0)
							break;
						else
							System.out.println("\nInvalid input. Please enter a non-negative amount.");
					}
					if (amount > banky.accountMap.get(accnum).getBalance()) {
						System.out.println(
								"Withdrawal amount exceeds balance.\nTransaction failed, returning to portal.");
						return;
					} else {
						banky.accountMap.get(accnum).setBalance(banky.accountMap.get(accnum).getBalance() - amount);
						System.out.println("Withdrawal successful.");
						return;
					}
				} else {
					System.out.println("\nYou do not have permission to access this account.");
				}
			} else {
				System.out.println("\nThis account number is invalid.");
			}
			System.out.println("\nYour active accounts are: ");
			for (int x : banky.accountMap.keySet()) {
				if (banky.accountMap.get(x).getAccountUsers().contains(username)) {
					System.out.println(banky.accountMap.get(x));
				}

			}
			System.out.println("Enter the account number to withdraw from: ");
		}
	}

	void deposit(Bank banky, Scanner scan) {// This option allows the user to deposit to an account. Ensures that
											// the user has an active account and that the chosen account number is
											// accessible by the current user. The deposit amount is also tested to
											// ensure it is non-negative. Finally the account balance is updated to
											// reflect the deposit.
		boolean foundAccount = false;
		int accnum = 0;
		for (int x : banky.accountMap.keySet()) {
			if (banky.accountMap.get(x).getAccountUsers().contains(username)) {
				foundAccount = true;
				break;
			}
		}
		if (!foundAccount) {
			System.out.println("\nNo active accounts found.");
			return;
		}

		System.out.print("Please enter the account number: ");
		while (true) {
			try {

				String strIn = null;
				strIn = scan.nextLine();
				try {
					accnum = Integer.parseInt(strIn);
				} catch (NumberFormatException e) {
					System.out.println("\nInvalid input. Please enter a number.");
					continue;
				}
			} catch (NoSuchElementException e) {
				System.out.println("\nInput not found. Please try again.");
				continue;
			}
			if (banky.accountMap.containsKey(accnum)) {
				if (banky.accountMap.get(accnum).getAccountUsers().contains(username)) {
					double amount = -1;
					System.out.print("\nPlease enter amount to deposit: ");
					while (true) {
						try {

							String strIn = null;
							strIn = scan.nextLine();
							try {
								amount = Double.parseDouble(strIn);
							} catch (NumberFormatException e) {
								System.out.println("\nInvalid input. Please enter a number.");
								continue;
							}
						} catch (NoSuchElementException e) {
							System.out.println("\nInput not found. Please try again.");
							continue;
						}
						if (amount >= 0)
							break;
						else
							System.out.println("\nInvalid input. Please enter a non-negative amount.");
					}

					banky.accountMap.get(accnum).setBalance(banky.accountMap.get(accnum).getBalance() + amount);
					System.out.println("Deposit successful.");
					return;
				} else {
					System.out.println("\nYou do not have permission to access this account.");
				}
			} else {
				System.out.println("\nThis account number is invalid.");
			}
			System.out.println("\nYour active accounts are: ");
			for (int x : banky.accountMap.keySet()) {
				if (banky.accountMap.get(x).getAccountUsers().contains(username)) {
					System.out.println(banky.accountMap.get(x));
				}

			}

			System.out.println("Enter the account number to deposit to: ");
		}
	}

	void transfer(Bank banky, Scanner scan) { // This option allows the user to transfer from one account to another
												// Ensures that the user has an active account and that the chosen
												// account number to transfer from is accessible by the current user.
												// The transfer amount is also tested to ensure it is non-negative and
												// does not exceed the sending account's balance. Finally, both
												// accounts' balances are updated based on the transferred amount
												// Note that the current user does not need permission to access the
												// receiving account in order to transfer to it
		boolean foundAccount = false;
		int accnum = 0;
		int accnum2 = 0;
		for (int x : banky.accountMap.keySet()) {
			if (banky.accountMap.get(x).getAccountUsers().contains(username)) {
				foundAccount = true;
				break;
			}
		}
		if (!foundAccount) {
			System.out.println("\nNo active accounts found.");
			return;
		}

		System.out.print("Please enter the account number you are transferring from: ");
		while (true) {
			try {

				String strIn = null;
				strIn = scan.nextLine();
				try {
					accnum = Integer.parseInt(strIn);
				} catch (NumberFormatException e) {
					System.out.println("\nInvalid input. Please enter a number.");
					continue;
				}
			} catch (NoSuchElementException e) {
				System.out.println("\nInput not found. Please try again.");
				continue;
			}
			if (banky.accountMap.containsKey(accnum)) {
				if (banky.accountMap.get(accnum).getAccountUsers().contains(username)) {
					System.out.print("Please enter the account number you are transferring to: ");
					while (true) {
						try {

							String strIn = null;
							strIn = scan.nextLine();
							try {
								accnum2 = Integer.parseInt(strIn);
							} catch (NumberFormatException e) {
								System.out.println("\nInvalid input. Please enter a number.");
								continue;
							}
						} catch (NoSuchElementException e) {
							System.out.println("\nInput not found. Please try again.");
							continue;
						}
						if (!banky.accountMap.containsKey(accnum2)) {
							System.out.println("That account number does not exist. Please process transaction again.");
							return;
						}
						if (accnum == accnum2) {
							System.out.println("Cannot transfer into same account. Please process transaction again");
							return;
						}

						double amount = -1;
						System.out.print("\nPlease enter amount to transfer: ");
						while (true) {
							try {

								String strIn = null;
								strIn = scan.nextLine();
								try {
									amount = Double.parseDouble(strIn);
								} catch (NumberFormatException e) {
									System.out.println("\nInvalid input. Please enter a number.");
									continue;
								}
							} catch (NoSuchElementException e) {
								System.out.println("\nInput not found. Please try again.");
								continue;
							}
							if (amount >= 0)
								break;
							else
								System.out.println("\nInvalid input. Please enter a non-negative amount.");
						}
						if (amount > banky.accountMap.get(accnum).getBalance()) {
							System.out.println(
									"Transfer amount exceeds balance.\nTransaction failed, returning to portal.");
							return;
						} else {
							banky.accountMap.get(accnum).setBalance(banky.accountMap.get(accnum).getBalance() - amount);
							banky.accountMap.get(accnum2)
									.setBalance(banky.accountMap.get(accnum2).getBalance() + amount);
							System.out.println("Transfer successful.");
							return;
						}
					}
				} else {
					System.out.println("\nYou do not have permission to access this account.");
				}

			} else {
				System.out.println("\nThis account number is invalid.");
			}
			System.out.println("\nYour active accounts are: ");
			for (int x : banky.accountMap.keySet()) {
				if (banky.accountMap.get(x).getAccountUsers().contains(username)) {
					System.out.println(banky.accountMap.get(x));
				}

			}
			System.out.println("Enter the account number to transfer from: ");
		}
	}

	void createAccount(Bank banky, Scanner scan) { // Allows a user to request a new bank account. It does not enter the
													// map of active accounts until it is approved. Instead, the account
													// is placed into an applications queue for an employee to approve
													// or deny
		double balance = -1;
		System.out.print("\nPlease enter your account balance: ");
		while (true) {
			try {

				String strIn = null;
				strIn = scan.nextLine();
				try {
					balance = Double.parseDouble(strIn);
				} catch (NumberFormatException e) {
					System.out.println("\nInvalid input. Please enter a number.");
					continue;
				}
			} catch (NoSuchElementException e) {
				System.out.println("\nInput not found. Please try again.");
				continue;
			}
			if (balance >= 0)
				break;
			else
				System.out.println("\nInvalid input. Please enter a non-negative balance.");
		}
		int accID = banky.generateUniqueAccountNumber();
		banky.addToAppQueue(new Account(accID, balance, username));
		System.out.println("Account application submitted, waiting for approval.");
	}

	void requestJointAccount(Bank banky, Scanner scan) { // allows a user to request joint membership in another
															// account. Upon entering an account number, the application
															// list of the chosen account will be updated to indicate
															// that a user has requested joint membership
		System.out.print("Please enter the account number you would like to become a joint accountholder of: ");
		int accnum = 0;
		while (true) {
			try {

				String strIn = null;
				strIn = scan.nextLine();
				try {
					accnum = Integer.parseInt(strIn);
				} catch (NumberFormatException e) {
					System.out.println("\nInvalid input. Please enter a number.");
					continue;
				}
			} catch (NoSuchElementException e) {
				System.out.println("\nInput not found. Please try again.");
				continue;
			}
			if (banky.accountMap.containsKey(accnum)) {
				banky.accountMap.get(accnum).addApp(username);
				System.out.println("Joint account request sent.");
				break;
			} else {
				System.out.print("Account number not found. Please enter an existing account number: ");
			}
		}
	}

	void viewJointApplications(Bank banky, Scanner scan) { // This method is called whenever a user logs in. If any
															// accounts associated with the current user have unresolved
															// applications for joint membership, the user is
															// immediately prompted to approve or deny the request upon
															// logging in. Denying the request simply removes it from
															// the queue, while approving the request also adds the
															// requesting user to the associated account's list of
															// approved users

		for (int x : banky.accountMap.keySet())
			if (banky.accountMap.get(x).accountUsers.contains(username))
				while (!banky.accountMap.get(x).appliedUsers.isEmpty()) {
					System.out.println("\nUser " + banky.accountMap.get(x).appliedUsers.getFirst()
							+ " would like to become a new joint accountholder to the account with" + " account number "
							+ banky.accountMap.get(x).getAccountNumber());
					System.out.println("Type 'y' to approve, or type 'n' to deny.");
					String input;
					while (true) {
						input = scan.nextLine();
						if (input.equals("y")) {
							banky.accountMap.get(x).addUser(banky.accountMap.get(x).appliedUsers.getFirst());
							banky.accountMap.get(x).appliedUsers.removeFirst();
							System.out.println("Accountholder added.");
							break;
						} else if (input.equals("n")) {
							banky.accountMap.get(x).appliedUsers.removeFirst();
							System.out.println("Accountholder denied.");
							break;
						} else {
							System.out.println("Invalid input. Please enter y/n.");
						}
					}
				}
	}

}
