package project0.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import project0.account.Account;
import project0.users.User;

public class ConsoleUI {
	final static Logger logger = Logger.getLogger(ConsoleUI.class.getName());
	static Scanner scanner = new Scanner(System.in);

	static String username;
	static String accountID;
	
	public static void initialize()
	{
		logger.info("The banking app has started");
		startMenu();
	}
	
	public static void startMenu()
	{
		boolean loop = true;
		
		do {

			System.out.println("Project 0 banking app version 0.1");
			System.out.println("1: Login");
			System.out.println("2: Create an account");
			System.out.println("3: Exit");
			
			try {
				switch (scanner.nextInt()) {
					case 1:
						loginScreen();
						break;
	
					case 2:
						createAccountScreen();
						break;
	
					case 3:
						loop = false;
						exit();
						break;
	
					default:
						System.out.println("Input out of range");
						break;
				}

			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("Input not valid");
			}

		} while (loop);
		exit();
	}
	
	private static void loginScreen() {
		String username;
		String password;

		boolean loop = true;
		
		do {
			try {
				System.out.println("Username:");
				username = scanner.next();
				
				System.out.println("Password:");
				password = scanner.next();
		
				System.out.println(username + " " + password);
				User user = User.login(username, password);
		
				if (user == null) {
					
					logger.info("User:" + username + " failed to log in.");
					System.out.println("Invalid username or password");
					
				} else {
					logger.info("User:" + username + " successfully logged in.");
					ConsoleUI.username = username;
					loop = false;
					userScreen(user);
				}
			}catch(InputMismatchException e) {
				scanner.nextLine();
				System.out.println("Input not valid");
			}
		}
		while(loop);
	}
	
	private static void userMenuScreen(User user) {
		
		boolean loop = true;
		ArrayList<Account> accounts = user.getBankAccounts();
		int accountSize = accounts.size();
		
		System.out.println("Welcome " + user.getUsername());
		
		do {
			
			for(int i = 0; i < accounts.size(); i++)
			{
				System.out.println(i + 1 + ": Access account " + accounts.get(i).getName());
			}
			
			System.out.println(accountSize + 1 + ": Create a bank account");
			System.out.println(accountSize + 2 + ": Logout");
			System.out.println(accountSize + 3 + ": Exit");

			try {
				int input = scanner.nextInt();
				if(input > 0 && input <= accountSize)
				{
					ConsoleUI.accountID = accounts.get(input - 1).getAccountID();
					bankAccountOptionsScreen(accounts.get(input - 1));
				}
				else if(input == accountSize + 1)
				{
					createBankAccountScreen(user);
					break;
				}
				else if(input == accountSize + 2)
				{
					loop = false;
					ConsoleUI.logout();
					break;
				}
				else if(input == accountSize + 3)
				{
					loop = false;
					exit();
					break;
				}
				else
				{
					System.out.println("Input out of range");
				}

			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("Input not valid");
			}
		}
		while (loop);
	}
	
	private static void bankAccountOptionsScreen(Account account) {
		boolean loop = true;
		
		do {
			try {
				System.out.println("Your account balance is $" + account.getBalance());
				System.out.println("1: Withdraw");
				System.out.println("2: Deposit");
				System.out.println("3: Transfer");
				System.out.println("4: Logout");
				System.out.println("5: Exit");

				switch (scanner.nextInt()) {
					case 1:
						System.out.print("How much would you like to withdraw?");
						account.withdraw(scanner.nextDouble());
						break;
					case 2:
						System.out.print("How much would you like to deposit?");
						account.withdraw(scanner.nextDouble());
						break;
					case 3:
						System.out.print("Which user do you want to transfer funds to?");
						String usrTo = scanner.next();
						
						User userTo = User.getUser(usrTo);
						Account accountTo = null;
						ArrayList<Account> accounts = userTo.getBankAccounts();
						
						int accountSize = accounts.size();
						
						boolean loop2 = true;
						
						do {
							System.out.print("Which account?");
							for(int i = 0; i < accounts.size(); i++)
							{
								System.out.println(i + 1 + ": Access account " + accounts.get(i).getName());
							}
							
							int input = scanner.nextInt();
						
							if(input > 0 && input < accountSize)
							{
								accountTo = accounts.get(input - 1);
								loop2 = false;
							}
							else {
								System.out.println("invalid input");
							}
						}while(loop2);
	
						System.out.print("How much money would you like to transfer?");
						double amount = scanner.nextDouble();
	
						if (account.transferFunds(accountTo, amount)) {
							System.out.println("Transaction success, sent $" + amount + " to account "  + accountTo.getAccountID());
						} else {
							System.out.println("Transaction failed, could not send $" + amount + " to account "  + accountTo.getAccountID());
						}
						break;
					case 4:
						loop = false;
						logout();
						break;
					case 5:
						loop = false;
						exit();
					default:
						System.out.println("Input out of range");
						break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Input not valid");
				scanner.nextLine();
			}

		} while (loop);
	}
	
	private static void createAccountScreen() {
		
		boolean loop = true;
		String user = null;
		String password = null;
		String lastName = null;
		String firstName = null;
		do {
			try {
				System.out.println("Enter a unique username " + 
								   "(8-20 characters no white spaces or special characters)");
				user = scanner.next();
				
				if(User.checkUsernameAvailability(user))
				{
					if(user.matches("[a-zA-Z0-9\\._\\-]{8,20}"))
					{
						loop = false;
					}
					else
					{
						System.out.println("Invalid username format");
					}
				}
				else
				{
					System.out.println("User already exists.");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Input not valid");
				scanner.nextLine();
			}
		}while(loop);
		
		loop = true;
		do {
			try {
				System.out.println("What is your first name?");
				firstName = scanner.next();
				
				System.out.println("What is your last name?");
				lastName = scanner.next();
				
				loop = false;
			}
			catch(InputMismatchException e) {
				System.out.println("Input not valid");
				scanner.nextLine();
			}
			
		}while(loop);
		
		loop = true;
		do {

			System.out.println("Enter a password " + 
					"(8-20 characters no white spaces or special characters)");
			password = scanner.next();
			if(password.matches("[a-zA-Z0-9\\._\\-]{8,20}"))
			{
				loop = false;
			}
			else
			{
				System.out.println("Password improperly formatted.");
			}
			
		}while(loop);
		
		System.out.println(firstName + " " + lastName + " " + user + " " + password);
		//User.addUser(new User(firstName, lastName, user, password));
		System.out.println("User created successfully.");
		//ArrayList<User> users = User.getAllUsers();
//		for(User u : users)
//		{
//			System.out.println(u.getUsername());
//		}
		startMenu();
	}

	private static void createBankAccountScreen(User user) {
		boolean loop = true;
		String accountName;
		
		do {

			System.out.println("Enter a name for your new bank account:");
			accountName = scanner.next();
			
			if(accountName.matches("[a-zA-Z0-9\\._\\-]{8,20}"))
			{
				loop = false;
			}
			else
			{
				System.out.println("Account name improperly formatted.");
			}
			
		}while(loop);
		
		ArrayList<String> owners = new ArrayList<String>();
		owners.add(ConsoleUI.username);
		do {
			System.out.println("Current owners: " + String.join(", ", owners));
			System.out.println("Enter any users you wish to share this account with or enter 1 to continue:");
			
			String owner = scanner.next();
			if(owner.equals("1"))
			{
				loop = false;
			}
			else if(!User.checkUsernameAvailability(owner))
			{
				if(!owners.contains(owner))
				{
					owners.add(owner);
				}
				System.out.println("User added.");
			}
			else
			{
				System.out.println("User " + owner +" does not exist.");
			}
			
		}while(loop);
		
//		Account ac = new Account(accountName, owners);
//		ac.ge
		
		System.out.println("Your account " + accountName + " has been created and is awaiting approval.");
		
		userScreen(user);
	}
	
	public static void userScreen(User user) {
		if(user.getUserLevel() == User.userLevel.CUSTOMER)
		{
			userMenuScreen(user);
		}
		else if(user.getUserLevel() == User.userLevel.EMPLOYEE) 
		{
			employeeMenuScreen(user);
		}
		else if(user.getUserLevel() == User.userLevel.ADMIN)
		{
			adminMenuScreen(user);
		}
	}
	
	public static void employeeMenuScreen(User user)
	{
		boolean loop = true;
		
		do {

			System.out.println("Employee Menu");
			System.out.println("1: List all users");
			System.out.println("2: View User Info");
			System.out.println("3: View Account Info");
			System.out.println("4: Logout");
			System.out.println("5: Exit");
			
			try {

				switch (scanner.nextInt()) {
					case 1:
						break;
						
					case 2:
						break;
						
					case 3:
						break;
	
					case 4:
						loop = false;
						logout();
						break;
	
					case 5:
						loop = false;
						break;
	
					default:
						System.out.println("Input out of range");
						break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Input not valid");
			}

		} while (loop);
	}
	
	public static void adminMenuScreen(User user)
	{
		boolean loop = true;
		
		do {

			System.out.println("Admin Menu");
			System.out.println("1: List all users");
			System.out.println("2: View User Info");
			System.out.println("3: View Account Info");
			System.out.println("4: Logout");
			System.out.println("5: Exit");
			
			try {

				switch (scanner.nextInt()) {
					case 1:
						break;
						
					case 2:
						break;
						
					case 3:
						break;
	
					case 4:
						loop = false;
						logout();
						break;
	
					case 5:
						loop = false;
						break;
	
					default:
						System.out.println("Input out of range");
						break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Input not valid");
			}

		} while (loop);
	}
	public static void logout()
	{
		ConsoleUI.username = null;
		ConsoleUI.accountID = null;
		startMenu();
	}
	
	public static void exit() {
		scanner.close();
		System.exit(0);
	}
	
}
