package com.bankApp.UI;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bankApp.BankUserDAO.BankUserDAO;
import com.bankApp.People.Person;

public class ConsoleController {
		
	final static Logger logger = Logger.getLogger(ConsoleController.class.getName());
	static Scanner consoleReader = new Scanner(System.in);
	// this string will hold the accounts username if they are successfully
	// authenticated, this is used for logging purposes
	static String name;

	
	
	public static void main(String[] args) {
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  

			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@atworkdb.c05sxxntbuck.us-east-2.rds.amazonaws.com:1521:ORCL","the_manager1","p4ssw0rd"); 
		
			CallableStatement cStmt = con.prepareCall("{call add_bank_user('?','?','?','?')}");
			System.out.println(cStmt.toString());
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		
		boolean loop = true;
		
		logger.info("APPLICATION HAS STARTED");

		do {

			try {

				System.out.println("Welcome to the RCBA (Revature Console Banking Application)");
				System.out.println("1.) Login");
				System.out.println("2.) Create Account");
				System.out.println("3.) Quit");

				switch (consoleReader.nextInt()) {
				case 1:
					loginScreen();
					break;

				case 2:
					createAccountScreen();
					break;

				case 3:
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

	// TODO there's no input checking here, may need some later
	private static void createAccountScreen() {
		// username must be declared up here to get the do while loop to work
		String userName;

		consoleReader.nextLine();

		System.out.println("To create an account the following fields must be filled in");

		System.out.print("What is the first name of the primary account holder:");
		String firstName = consoleReader.nextLine();

		System.out.print("\nWhat is the last name of the primary account holder:");
		String lastName = consoleReader.nextLine();

		do {
			System.out.print("\nPlease enter a unique userName for your account:");
			userName = consoleReader.nextLine();

			// loop while the hashmap loginInfo has this specific username
		} while (Person.userNameNotUnique(userName));

		System.out.print("\nEnter the password you would like for this account:");
		String password = consoleReader.nextLine();

		System.out.print("\nif you would you like to add any joint account holders please enter their"
				+ " first and last names in the following form [first:last] \nfor example john:smith jane:smith"
				+ " if you don't want any, enter NONE");
		String jointHolders = consoleReader.nextLine();

		// TODO currently accounts can be created with no money in them
		BankUserDAO newAccount = new BankUserDAO(firstName, lastName, userName, password, 0, jointHolders);

		if (BankUserDAO.applyForAccount(newAccount)) {
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

		Person user = Person.login(usrName, pswd);

		if (user instanceof BankUserDAO) {
			// cast user to the correct type and log the event
			logger.info("Account:" + usrName + " successfully authenticated");
			bankingScreen((BankUserDAO) user);
		} else {
			logger.info("Account:" + usrName + " failed to authenticate");
			System.out.println("Invalid login credentials");
		}

	}

	private static void bankingScreen(BankUserDAO user) {
		boolean loop = true;
		double amt;

		do {
			try {
				System.out.println("Your account balance is $"+user.getCurrentBalance());
				System.out.println("Would you like to:");
				System.out.println("1.) Make Deposit");
				System.out.println("2.) Transfer");
				System.out.println("3.) Withdraw");
				System.out.println("4.) Logout");
				
				name = user.getUsername();

				switch (consoleReader.nextInt()) {
				case 1:
					System.out.print("Deposit ammount:$");
					amt = consoleReader.nextDouble();
					if (user.deposit(amt)) {
						printTransaction("Deposit", amt, "success");
					} else {
						printTransaction("Deposit", amt, "failure");
					}
					break;

				case 2:
					System.out.print("Account username you want to transfer to:");
					String to;
					to = consoleReader.next();

					System.out.print("How much money would you like to transfer :$");
					amt = consoleReader.nextDouble();

					if (user.transfer(to, amt)) {
						printTransaction(to, amt, "success");
					} else {
						printTransaction(to, amt, "failure");
					}
					break;

				case 3:
					System.out.print("How much money would you like to withdraw:$");
					amt = consoleReader.nextDouble();

					if (user.withdraw(amt)) {
						printTransaction("Withdrawal", amt, "success");
					} else {
						printTransaction("Withdrawal", amt, "failure");
					}
					break;

				case 4:
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

	public static void printTransaction(String action, String result, double amt) {
		logger.info(action + " of $" + Double.toString(amt)+ " from account "+ name + " operation " + result);
		System.out.println("\n" + action + " of $" + amt + " " + result);
	}

	public static void printTransaction(String accountTo, double amt, String result) {
		logger.info("transfer of $" + Double.toString(amt)+ " from account "+ name + " to account "+accountTo +" operation " + result);
		System.out.println("\n" + "Transfer of $" + amt + " to account " + accountTo + " " + result);
	}
}
