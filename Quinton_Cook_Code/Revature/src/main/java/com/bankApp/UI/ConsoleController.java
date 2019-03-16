package com.bankApp.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bankApp.BankUserDAO.BankUserDAOImpl;
import com.bankApp.EmployeeDAO.EmployeeDAOImpl;
import com.bankApp.People.Account;
import com.bankApp.People.BankUser;
import com.bankApp.People.Employee;

public class ConsoleController {

	final static Logger logger = Logger.getLogger(ConsoleController.class.getName());
	static Scanner consoleReader = new Scanner(System.in);
	static BankUserDAOImpl bankUser = new BankUserDAOImpl();
	static EmployeeDAOImpl emp = new EmployeeDAOImpl();
	// this string will hold the accounts username if they are successfully
	// authenticated, this is used for logging purposes

	public static void main(String[] args) {

		boolean loop = true;

		logger.info("APPLICATION HAS STARTED");

		do {

			try {

				System.out.println("Welcome to the RCBA (Revature Console Banking Application)");
				System.out.println("1.) User Login");
				System.out.println("2.) Employee Login");
				System.out.println("3.) Apply for a Checking Account");
				System.out.println("4.) Quit");

				switch (consoleReader.nextInt()) {
				case 1:
					loginScreen();
					break;

				case 2:
					loginScreenEmployee();
					break;

				case 3:
					createAccountScreen();
					break;

				case 4:
					loop = false;
					break;

				default:
					System.out.println("Input not reconized");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Input not reconized");
			}

		} while (loop);

		consoleReader.close();

	}

	private static void loginScreenEmployee() {
		String usrName;
		String pswd;

		System.out.print("Username:");
		usrName = consoleReader.next();
		System.out.print("\nPassword:");
		pswd = consoleReader.next();

		Employee pete = emp.login(usrName, pswd);

		// cast user to the correct type and log the event
		if (pete != null) {
			logger.info("Account:" + usrName + " successfully authenticated");
			employeeScreen(pete);
		} else {
			logger.info("Account:" + usrName + " failed to authenticate");
			System.out.println("Invalid login credentials");
		}

	}

	private static void createAccountScreen() {
		// username must be declared up here to get the do while loop to work
		String userName;

		consoleReader.nextLine();

		System.out.println("To create an account the following fields must be filled in");

		System.out.print("What is the first name of the primary account holder:");
		String firstName = consoleReader.nextLine();

		System.out.print("\nWhat is the last name of the primary account holder:");
		String lastName = consoleReader.nextLine();

		System.out.print("\nPlease enter a unique userName for your account:");
		userName = consoleReader.nextLine();

		System.out.print("\nEnter the password you would like for this account:");
		String password = consoleReader.nextLine();

		BankUser newAccount = new BankUser(firstName, lastName, userName, password);

		if (bankUser.insertBankUser(newAccount)) {
			System.out.println("Account created successfully");
		} else {
			System.out.println("Account creation failure");
		}

	}// end createAccountScreen()

	private static void loginScreen() {
		String usrName;
		String pswd;

		System.out.print("Username:");
		usrName = consoleReader.next();
		System.out.print("\nPassword:");
		pswd = consoleReader.next();

		BankUser pete = bankUser.login(usrName, pswd);

		// cast user to the correct type and log the event
		if (pete != null) {
			logger.info("Account:" + usrName + " successfully authenticated");
			bankingScreen(pete);
		} else {
			logger.info("Account:" + usrName + " failed to authenticate");
			System.out.println("Invalid login credentials");
		}
	}

	private static void employeeScreen(Employee pete) {
		boolean loop = true;

		do {
			System.out.println("Welcome " + pete.getFirstName() + " " + pete.getLastName());
			System.out.println("What would you like to do?");
			System.out.println("1.) View account information");
			System.out.println("2.) Approve account");
			System.out.println("3.) Logout");
			if (pete.getAccountType() == 1) {
				System.out.println("4.) Delete Account");
			}

			int choice = consoleReader.nextInt();

			switch (choice) {
			case 1:
				System.out.println("what is the account number you would like to view");
				int acct = consoleReader.nextInt();
				for (BankUser i : emp.recallInformation(acct)) {
					System.out.println(i);
				}
				break;
				
			case 2:
				System.out.println("what is the account number you would like to approve");
				int acct2 = consoleReader.nextInt();
				emp.approveAccount(acct2);
				break;
				
			case 3:
				loop = false;
				break;
				
			case 4:
				System.out.println("what is the account number you like to cancel");
				int acct3 = consoleReader.nextInt();
				emp.deleteAccount(acct3);
				break;
			}

		} while (loop);
	}

	private static void bankingScreen(BankUser user) {
		boolean loop = true;
		double amt;

		do {
			try {
				int c = 0;
				System.out.println("Welcome:" + user.getFirstName() + " " + user.getLastName());

				for (Account i : user.getAccounts()) {
					System.out.println(Integer.toString(c)+".)" + i);
					c++;
				}

				// TODO make an add user to account option

				System.out.println("Would you like to:");
				System.out.println("1.) Make Deposit");
				System.out.println("2.) Transfer");
				System.out.println("3.) Withdraw");
				System.out.println("4.) Add joint account holder");
				System.out.println("5.) Logout");

				switch (consoleReader.nextInt()) {
				case 1:
					System.out.print("Deposit ammount:$");
					amt = consoleReader.nextDouble();

					System.out.println("to which account?:");
					int acct = consoleReader.nextInt();

					if (bankUser.deposit(amt, acct, user)) {
						printTransaction("Deposit", amt, "success", user.getAccount(acct).getAccountNumber());
					} else {
						printTransaction("Deposit", amt, "failure",user.getAccount(acct).getAccountNumber());
					}
					break;

				case 2:
					System.out.print("Account number you want to transfer to:");
					int to = consoleReader.nextInt();

					System.out.print("\nHow much money would you like to transfer :$");
					amt = consoleReader.nextDouble();

					System.out.print("\nFrom which account:");
					int from = consoleReader.nextInt();

					if (bankUser.transfer(amt, from, to, user)) {
						printTransfer(to, amt, "success", user.getAccount(from).getAccountNumber());
					} else {
						printTransfer(to, amt, "failure",user.getAccount(from).getAccountNumber());
					}
					break;

				case 3:
					System.out.print("How much money would you like to withdraw:$");
					amt = consoleReader.nextDouble();

					System.out.print("\nFrom which account:");
					int from2 = consoleReader.nextInt();

					if (bankUser.withdraw(amt, from2, user)) {
						printTransaction("Withdrawal", amt, "success",user.getAccount(from2).getAccountNumber());
					} else {
						printTransaction("Withdrawal", amt, "failure", user.getAccount(from2).getAccountNumber());
					}
					break;

				case 4:
					System.out.println("Enter the username of the person you want to be added");
					String usrName = consoleReader.next();
					
					System.out.println("Which account would you like to add them to");
					int i = consoleReader.nextInt();
					
					bankUser.addAccountHolder(user.getAccount(i), usrName);
					break;
					
				case 5:
					loop = false;
					break;

				default:
					System.out.println("Input not reconized");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Input not Reconized");
				bankingScreen(user);
			}

		} while (loop);
	}

	public static void printTransaction(String action,  double amt, String result, int accountNumber) {
		logger.info(action + " of $" + Double.toString(amt) + " from account " + Integer.toString(accountNumber) + " operation " + result);
		System.out.println("\n" + action + " of $" + amt + " " + result);
	}

	public static void printTransfer(int accountTo, double amt, String result, int accountNumber) {
		logger.info("transfer of $" + Double.toString(amt) + " from account " + Integer.toString(accountNumber) + " to account " + Integer.toString(accountTo)
				+ " operation " + result);
		System.out.println("\n" + "Transfer of $" + amt + " to account " + accountTo + " " + result);
	}
}
