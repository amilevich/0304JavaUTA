package com.bank;

import java.util.Scanner;

public class Main {

	static Activities activity = new Activities();
	public static int currentUserId = 0;

	public static void main(String[] args) {
		showMainMenu();
	}

	private static void showMainMenu() {
		boolean gotCorrect = false;
		while (!gotCorrect) {
			try {
				Scanner sc = new Scanner(System.in);
				int user_choice = 1;
				do {
					// display menu to user
					// ask user for his choice and validate it (make sure it is between 1 and 3)
					System.out.println("Welcome to the Java Bank.");
					System.out.println();
					System.out.println("1) Login to bank");
					System.out.println("2) Register a new user");
					System.out.println("3) Quit");
					System.out.println();
					System.out.print("Enter choice [1-3]: ");
					user_choice = sc.nextInt();
					sc.nextLine();
					switch (user_choice) {
					case 1: {
						System.out.println("Username: ");
						String un = sc.nextLine();
						System.out.println("Password: ");
						String pw = sc.nextLine();

						String userType = activity.validateUser(un, pw);
						if (userType.equals("Customer")) {
							currentUserId = activity.getUserIdByName(un);
							showCustomerMenu(un);
						} else if (userType.equals("admin")) {
							showAdminMenu();
						} else if (userType.equals("employee")) {
							showEmployeeMenu();
						}
						break;
					}
					case 2: {
						System.out.println("Enter a new username: ");
						String un = sc.nextLine();
						System.out.println("Enter a new password: ");
						String pw = sc.nextLine();
						activity.createNewUser(un, pw);
						break;
					}
					}
				} while (user_choice != 3);
				sc.close();
				System.out.println("Logged out, thank you.");
				gotCorrect = true;
			} catch (Exception e) {
				continue;
			}

		}
	}

	private static void showCustomerMenu(String userName) {
		boolean gotCorrect = false;
		while (!gotCorrect) {
			try {
				Scanner sc = new Scanner(System.in);

				int user_choice;
				int noOfAccounts = 0;
				do {
					// display menu to user
					// ask user for his choice and validate it (make sure it is between 1 and 7)
					System.out.println("Customer Menu");
					System.out.println();
					System.out.println("1) View all customer information");
					System.out.println("2) Open a new bank account");
					System.out.println("3) Open a new joint bank account");
					System.out.println("4) Deposit to a bank account");
					System.out.println("5) Withdraw to bank account");
					System.out.println("6) Transfer funds");
					System.out.println("7) Quit");
					System.out.println();
					System.out.print("Enter choice [1-7]: ");
					user_choice = sc.nextInt();
					sc.nextLine();
					switch (user_choice) {
					case 1:
						activity.displayAccountsByUserName(userName);
						break;
					case 2: {
						System.out.println("Enter a name for your account: ");
						String an = sc.nextLine();

						activity.createNewAccount(currentUserId, an);
						break;
					}
					case 3: {
						System.out.println("Enter a name for joint bank account: ");
						String an = sc.nextLine();
						System.out.println("Enter secondary UserName for joint access: ");
						String su = sc.nextLine();
						if (activity.doesUserExist(su)) {
							activity.createNewJointAccount(userName, su, an);
						} else {
							System.out.println("Secondary user does not exist. Please Register as a User.");
						}

						break;
					}
					case 4:
						noOfAccounts = activity.displayAccountsByUserName(userName);
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number");
							int an = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter a deposit amount");
							double amt = sc.nextDouble();
							sc.nextLine();
							activity.deposit(an, amt);
						}
						break;
					case 5:
						noOfAccounts = activity.displayAccountsByUserName(userName);
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number");
							int an = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter a withdrawl amount");
							double amt = sc.nextDouble();
							sc.nextLine();
							activity.withdraw(an, amt);
						}
						break;
					case 6:
						noOfAccounts = activity.displayAccountsByUserName(userName);
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number you would like to transfer from");
							int anfrom = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter a user you would like to transfer to ");
							String un = sc.nextLine();
							noOfAccounts = activity.displayAccountsByUserName(un);
							System.out.println("Enter a account number you would like to transfer to");
							int anto = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter how much you would like to transfer");
							double amt = sc.nextDouble();
							sc.nextLine();
							activity.transfer(anfrom, anto, amt);
						}
						break;
					}
				} while (user_choice != 7);
				System.out.println("Logged out, thank you.");
				gotCorrect = true;
			} catch (Exception e) {
				continue;
			}

		}

	}

	private static void showEmployeeMenu() {
		boolean gotCorrect = false;
		while (!gotCorrect) {
			try {
				Scanner sc = new Scanner(System.in);

				int user_choice = 1;
				int noOfAccounts = 0;
				do {
					// display menu to user
					// ask user for his choice and validate it (make sure it is between 1 and 7)
					System.out.println("Employee Menu");
					System.out.println();
					System.out.println("1) View all customer information");
					System.out.println("2) Approve Account Application");
					System.out.println("3) Deny Account Application");
					System.out.println("4) Deposit to a bank account");
					System.out.println("5) Withdraw to bank account");
					System.out.println("6) Transfer funds");
					System.out.println("7) Quit");
					System.out.println();
					System.out.print("Enter choice [1-7]: ");
					user_choice = sc.nextInt();
					sc.nextLine();
					switch (user_choice) {
					case 1: {
						activity.displayAllAccounts();
						break;
					}
					case 2:
						noOfAccounts = activity.displayAllAccounts();
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number to Approve");
							int an = sc.nextInt();
							sc.nextLine();
							if (an > 0) {
								activity.changeAccountApprovalStatus(an, true);
								System.out.println("Account Approved!");
							}
						}
						break;
					case 3:
						noOfAccounts = activity.displayAllAccounts();
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number to Deny");
							int an = sc.nextInt();
							sc.nextLine();
							if (an > 0) {
								activity.changeAccountApprovalStatus(an, false);
								System.out.println("Account Denied!");
							}
						}
						break;
					case 4:
						noOfAccounts = activity.displayAccountsByUser(currentUserId);
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number");
							int an = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter a deposit amount");
							double amt = sc.nextDouble();
							sc.nextLine();
							activity.deposit(an, amt);
						}
						break;
					case 5:
						noOfAccounts = activity.displayAccountsByUser(currentUserId);
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number");
							int an = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter a withdrawl amount");
							double amt = sc.nextDouble();
							sc.nextLine();
							activity.withdraw(an, amt);
						}
						break;
					case 6:
						noOfAccounts = activity.displayAllAccounts();
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number you would like to transfer from");
							int anfrom = sc.nextInt();
							sc.nextLine();
							noOfAccounts = activity.displayAllAccounts();
							System.out.println("Enter a account number you would like to transfer to");
							int anto = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter how much you would like to transfer");
							double amt = sc.nextDouble();
							sc.nextLine();
							activity.transfer(anfrom, anto, amt);
						}
						break;
					// case 5: ... break;
					}
				} while (user_choice != 7);
				System.out.println("Logged out, thank you.");
				gotCorrect = true;
			} catch (Exception e) {
				continue;
			}

		}
	}

	private static void showAdminMenu() {
		boolean gotCorrect = false;
		while (!gotCorrect) {
			try {
				Scanner sc = new Scanner(System.in);

				int user_choice;
				int noOfAccounts = 0;
				do {
					// display menu to user
					// ask user for his choice and validate it
					System.out.println("Admin Menu");
					System.out.println();
					System.out.println("1) View all customer information");
					System.out.println("2) Approve Account Application");
					System.out.println("3) Deny Account Application");
					System.out.println("4) Deposit to a bank account");
					System.out.println("5) Withdraw to bank account");
					System.out.println("6) Transfer funds");
					System.out.println("7) Cancel Account");
					System.out.println("8) Quit");
					System.out.println();
					System.out.print("Enter choice [1-8]: ");
					user_choice = sc.nextInt();
					sc.nextLine();
					switch (user_choice) {
					case 1: {
						activity.displayAllAccounts();
						break;
					}
					case 2:
						noOfAccounts = activity.displayAllAccounts();
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number to Approve");
							int an = sc.nextInt();
							sc.nextLine();
							if (an > 0) {
								activity.changeAccountApprovalStatus(an, true);
								System.out.println("Account Approved!");
							}
						}
						break;
					case 3:
						noOfAccounts = activity.displayAllAccounts();
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number to Deny");
							int an = sc.nextInt();
							sc.nextLine();
							if (an > 0) {
								activity.changeAccountApprovalStatus(an, false);
								System.out.println("Account Denied!");
							}
						}
						break;
					case 4:
						noOfAccounts = activity.displayAccountsByUser(currentUserId);
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number");
							int an = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter a deposit amount");
							double amt = sc.nextDouble();
							sc.nextLine(); // throw away the newline character
							activity.deposit(an, amt);
						}
						break;
					case 5:
						noOfAccounts = activity.displayAccountsByUser(currentUserId);
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number");
							int an = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter a withdrawl amount");
							double amt = sc.nextDouble();
							sc.nextLine();
							activity.withdraw(an, amt);
						}
						break;
					case 6:
						noOfAccounts = activity.displayAllAccounts();
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number you would like to transfer from");
							int anfrom = sc.nextInt();
							sc.nextLine();
							noOfAccounts = activity.displayAllAccounts();
							System.out.println("Enter a account number you would like to transfer to");
							int anto = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter how much you would like to transfer");
							double amt = sc.nextDouble();
							sc.nextLine();
							activity.transfer(anfrom, anto, amt);
						}
						break;
					case 7:
						noOfAccounts = activity.displayAllAccounts();
						if (noOfAccounts > 0) {
							System.out.println("Enter a account number to cancel");
							int an = sc.nextInt();
							sc.nextLine();
							if (an > 0) {
								activity.cancelAccount(an);
								System.out.println("Account Canceled!");
							}
						}
						break;
					}

				} while (user_choice != 8);
				System.out.println("Logged out, thank you.");
				gotCorrect = true;
			} catch (Exception e) {
				continue;
			}

		}
	}

}
