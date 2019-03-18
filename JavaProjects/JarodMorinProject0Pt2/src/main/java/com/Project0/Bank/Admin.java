package com.Project0.Bank;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.Project0.DoaImpl.AccountDaoImpl;

public class Admin extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7056838996656929140L;

	public Admin(String username, String password, String name) {
		super(username, password, name);
	}

	@Override
	void openUserPortal(Bank banky, Scanner scanner) { // this method displays a menu to admins that log in that
														// lists the options available to them and prompts them to
														// select one. When an option is chosen, the associated task is
														// initiated. These options contain all those available to
														// employees, except the request joint account option which is
														// unnecesary for admins who already have access to every
														// account, in addition to the cancel account option which is
														// exclusive to admins
		boolean dontExitYet = true;
		while (true) {
			viewJointApplications(banky, scanner);
			int input = 0;
			try {
				System.out.println("\n\n\n\n\n\n\n\n\n\nHello " + name + "!\n");
				System.out.println("Would you like to: ");
				System.out.print("1. View your accounts\n2. Create a new account\n3. Perform a transaction"
						+ "\n4. View account applications\n5. View customer info\n6. Cancel account\n7. Logout\nPlease enter the number of your selection: ");
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
				viewAccountApplications(banky, scanner);
				break;
			case 5:
				viewCustomerInfo(banky, scanner);
				break;
			case 6:
				cancelAccount(banky, scanner);
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

	@Override
	void viewAccounts(Bank banky) { // This method displays all accounts in the bank
		if (banky.accountMap.isEmpty()) {
			System.out.println("\nNo active accounts found.");
			return;
		}

		System.out.println("\nAll active accounts are: ");
		for (int x : banky.accountMap.keySet()) {
			System.out.println(banky.accountMap.get(x));
		}
	}

	void cancelAccount(Bank banky, Scanner scan) {	// Irreversibly removes an account from accountMap by account number.
		if (banky.accountMap.isEmpty()) {
			System.out.println("\nNo active accounts found.");
			return;
		}
		
		System.out.print("Please enter the account number you would like to cancel: ");
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
				AccountDaoImpl accDaoImpl = new AccountDaoImpl();
				accDaoImpl.removeAccount(banky.accountMap.get(accnum));
				banky.accountMap.remove(accnum);
				System.out.println("Account canceled.");
				break;
			}
		}
	}

	@Override
	void withdraw(Bank banky, Scanner scan) { // This option allows the user to withdraw from an account. Functions like
												// that of the parent user class method but does not check for account
												// permissions
		if (banky.accountMap.isEmpty()) {
			System.out.println("\nNo active accounts found.");
			return;
		}
		
		System.out.print("Please enter the account number: ");
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
					System.out.println("Withdrawal amount exceeds balance.\nTransaction failed, returning to portal.");
					return;
				} else {
					banky.accountMap.get(accnum).setBalance(banky.accountMap.get(accnum).getBalance() - amount);
					AccountDaoImpl accDaoImpl = new AccountDaoImpl();
					accDaoImpl.updateBalance(banky.accountMap.get(accnum));
					System.out.println("Withdrawal successful.");
					return;
				}

			} else {
				System.out.println("\nThis account number is invalid.");
			}
			System.out.println("Enter the account number to withdraw from: ");
		}
	}

	@Override
	void deposit(Bank banky, Scanner scan) { // Functions as the User deposit method, but does not check for account
												// permissions
		if (banky.accountMap.isEmpty()) {
			System.out.println("\nNo active accounts found.");
			return;
		}
		int accnum = 0;
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
				AccountDaoImpl accDaoImpl = new AccountDaoImpl();
				accDaoImpl.updateBalance(banky.accountMap.get(accnum));
				System.out.println("Deposit successful.");
				return;
			} else {
				System.out.println("\nThis account number is invalid.");
			}
			System.out.println("Enter the account number to deposit to: ");
		}
	}

	@Override
	void transfer(Bank banky, Scanner scan) { // Functions as the User method transfer, but does not check for account
												// permissions
		if (banky.accountMap.isEmpty()) {
			System.out.println("\nNo active accounts found.");
			return;
		}
		int accnum = 0;
		int accnum2 = 0;

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
						System.out
								.println("Transfer amount exceeds balance.\nTransaction failed, returning to portal.");
						return;
					} else {
						banky.accountMap.get(accnum).setBalance(banky.accountMap.get(accnum).getBalance() - amount);
						AccountDaoImpl accDaoImpl = new AccountDaoImpl();
						accDaoImpl.updateBalance(banky.accountMap.get(accnum));
						banky.accountMap.get(accnum2)
								.setBalance(banky.accountMap.get(accnum2).getBalance() + amount);
						accDaoImpl.updateBalance(banky.accountMap.get(accnum2));
						System.out.println("Transfer successful.");
						return;
					}
				}

			} else {
				System.out.println("\nThis account number is invalid.");
			}
			System.out.println("Enter the account number to transfer from: ");
		}
	}

}
