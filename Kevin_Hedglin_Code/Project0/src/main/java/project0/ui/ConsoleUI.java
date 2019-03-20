package project0.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import project0.account.Account;
import project0.users.Employee;
import project0.users.User;

public class ConsoleUI {
	final static Logger logger = Logger.getLogger(ConsoleUI.class.getName());
	static Scanner scanner = new Scanner(System.in);

	static User user;
	
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
						System.out.println("Invalid input.");
						stall();
						break;
				}

			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("Input not an integer");
				stall();
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
		
				User user = User.login(username, password);
		
				if (user == null) {
					
					logger.info("User:" + username + " failed to log in.");
					System.out.println("Invalid username or password");
					stall();
					
				} else {
					logger.info("User:" + username + " successfully logged in.");
					ConsoleUI.user = User.getUser(username);
					loop = false;
					userScreen();
				}
			}catch(InputMismatchException e) {
				stall();
			}
		}
		while(loop);
	}
	
	private static void userMenuScreen() {
		
		boolean loop = true;
		ArrayList<Account> accounts = user.getBankAccounts();
		int accountSize = accounts.size();
		
		System.out.println("Welcome " + user.getUsername());
		
		do {
			
			for(int i = 0; i < accounts.size(); i++)
			{
				System.out.println(i + 1 + ": Access account " + accounts.get(i).getName());
			}
			
			System.out.println(accountSize + 1 + ": Create a new bank account");
			System.out.println(accountSize + 2 + ": Logout");

			try {
				int input = scanner.nextInt();
				if(input > 0 && input <= accountSize)
				{
					Account a = accounts.get(input - 1);
					if(a.isApproved())
					{
						bankAccountOptionsScreen(Account.getAccount(a.getAccountID()));
					}
					else
					{
						System.out.println("This account is still pending approval by an admin.");
						stall();
					}
				}
				else if(input == accountSize + 1)
				{
					createBankAccountScreen();
					break;
				}
				else if(input == accountSize + 2)
				{
					loop = false;
					ConsoleUI.logout();
					break;
				}
				else
				{
					System.out.println("Input out of range");
					stall();
				}

			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("Input not an integer");
				stall();
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

				switch (scanner.nextInt()) {
					case 1:
						System.out.print("How much would you like to withdraw?");
						account.withdraw(scanner.nextDouble());
						break;
					case 2:
						System.out.print("How much would you like to deposit?");
						account.deposit(scanner.nextDouble());
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
								stall();
							}
						}while(loop2);
	
						System.out.print("How much money would you like to transfer?");
						double amount = scanner.nextDouble();
	
						if (account.transferFunds(accountTo, amount)) {
							System.out.println("Transaction success, sent $" + amount + " to account "  + accountTo.getAccountID());
							stall();
						} else {
							System.out.println("Transaction failed, could not send $" + amount + " to account "  + accountTo.getAccountID());
							stall();
						}
						break;
					case 4:
						loop = false;
						logout();
						break;
					default:
						System.out.println("Input out of range");
						stall();
						break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Input not valid");
				scanner.nextLine();
				stall();
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
						stall();
					}
				}
				else
				{
					System.out.println("User already exists.");
					stall();
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Input not valid");
				scanner.nextLine();
				stall();
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
				stall();
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
				stall();
			}
			
		}while(loop);
		
		User.saveUser(new User(firstName, lastName, user, password));
		System.out.println("User created successfully.");
		stall();
		startMenu();
	}

	private static void createBankAccountScreen() {
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
				stall();
			}
			
		}while(loop);
		
		ArrayList<String> owners = new ArrayList<String>();
		owners.add(ConsoleUI.user.getUsername());
		loop = true;
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
				stall();
			}
			else
			{
				System.out.println("User " + owner +" does not exist.");
				stall();
			}
			
		}while(loop);
		
		Account ac = new Account(accountName, 0, false, owners);
		
		System.out.println("Your account " + ac.getName() + " has been created and is awaiting approval.");
		stall();
		userScreen();
	}
	
	public static void userScreen() {
		if(user.getUserLevel() == User.userLevel.CUSTOMER)
		{
			userMenuScreen();
		}
		else 
		{
			priviledgedMenuScreen();
		}
	}
	
	public static void priviledgedMenuScreen()
	{
		boolean loop = true;
		
		do {

			System.out.println("Employee/Admin Menu");
			System.out.println("1: List all users");
			System.out.println("2: List all unapproved accounts");
			System.out.println("3: List all accounts");
			System.out.println("4: Select user");
			System.out.println("5: Select an account");
			System.out.println("6: Logout");
			
			try {

				switch (scanner.nextInt()) {
					case 1:
						ArrayList<String> unames = Employee.getAllCustomerUsernames();
						for(String u : unames)
						{
							System.out.println(u);
						}
						stall();
						break;
					case 2:
						ArrayList<Account> pending = Account.getPendingAccounts();
						for(Account ac : pending)
						{
							System.out.println("Account id: " + ac.getAccountID() + " Name: " + ac.getName() + " Owned by: "  + String.join(", ", ac.getOwners()));
						}
						stall();
						break;
					case 3:
						ArrayList<Account> all = Account.getAllAccounts();
						for(Account ac : all)
						{
							System.out.println("Account id: " + ac.getAccountID() + " Name: " + ac.getName() + " Owned by: "  + String.join(", ", ac.getOwners()));
						}
						stall();
						break;
					case 4:
						boolean loop2 = true;
						do {
							try {
								System.out.println("Enter a username to view their account information:");
								User usr = User.getUser(scanner.next());
								
								if(usr != null)
								{
									loop2 = true;
									viewUserInfo(usr);
								}
								else
								{
									System.out.println("This user does not exist.");
									stall();
								}
							}
							catch(InputMismatchException e) {
								System.out.println("Input not valid");
								scanner.nextLine();
								stall();
							}
						}while(loop2);
						loop = false;
						break;
					case 5:
						loop2 = true;
						do {
							try {
								System.out.println("Enter a bank account id to view the account information:");
								Account ac = Account.getAccount(scanner.nextInt());
								
								if(ac != null)
								{
									loop2 = true;
									editAccountScreen(ac);
								}
								else
								{
									System.out.println("This account id does not exist.");
									stall();
								}
							}
							catch(InputMismatchException e) {
								System.out.println("Input not valid");
								scanner.nextLine();
								stall();
							}
						}while(loop2);
						break;
					case 6:
						loop = false;
						logout();
						break;
					default:
						System.out.println("Input out of range");
						stall();
						break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Input not an integer");
				scanner.nextLine();
				stall();
			}

		} while (loop);
	}
	
	public static void viewUserInfo(User viewUser)
	{
		boolean loop = true;
		
		ArrayList<Account> accounts = viewUser.getBankAccounts();
		
		do {

			System.out.println("View data of user " + viewUser.getUsername() + ".");
			System.out.println("1: View user info");
			System.out.println("2: List bank accounts of user");
			System.out.println("3: Select bank account");
			System.out.println("4: Back");
			System.out.println("5: Logout");
			
			try {
				
				switch (scanner.nextInt()) {
					case 1:
						viewUser.toString();
						break;
					case 2:
						for(Account a : accounts)
						{
							System.out.println("account name: " + a.getName() + " id: " + a.getAccountID());
						}
						stall();
						break;
					case 3:
						boolean loop2 = true;
						do {
							try {
								System.out.println("Enter the integer id of one of " + viewUser.getUsername() + "'s bank accounts.");
								Account ac = null;
								int id = scanner.nextInt();
								
								for(Account a : accounts)
								{
									if(a.getAccountID() == id)
									{
										ac = a;
									}
								}
								
								if(ac != null)
								{
									loop2 = true;
									editAccountScreen(ac);
								}
								else
								{
									System.out.println("This account does not exist for " + viewUser.getUsername());
									stall();
								}
							}
							catch(InputMismatchException e) {
								System.out.println("Input not valid");
								scanner.nextLine();
								stall();
							}
						}
						while(loop2);
						loop = false;
						break;
					case 4:
						loop = false;
						priviledgedMenuScreen();
						break;
					case 5:
						loop = false;
						logout();
						break;
					default:
						System.out.println("Input out of range");
						stall();
						break;
				}
				
			}catch (InputMismatchException e) {
				System.out.println("Input not an integer");
				scanner.nextLine();
				stall();
			}
			
		}
		while(loop);

	}
	
	public static void editAccountScreen(Account account)
	{
		boolean loop = true;
		
		do {
			System.out.println("The balance in this account is $" + account.getBalance());
			System.out.println("1: Withdraw");
			System.out.println("2: Deposit");
			System.out.println("3: Transfer");
			System.out.println("4: Approve Account");
			System.out.println("5: Delete Account");
			System.out.println("6: Back");
			System.out.println("7: Logout");
			
			try {
				switch (scanner.nextInt()) {
					case 1:
						if(user.getUserLevel().getValue() < 2)
						{
							System.out.print("You must be admin level to access this function.");
							stall();
						}
						else
						{
							System.out.print("How much would you like to withdraw?");
							if(!account.withdraw(scanner.nextDouble()))
							{
								System.out.print("You cannot overdraw from this account");
								stall();
							}
						}
						break;
					case 2:
						if(user.getUserLevel().getValue() < 2)
						{
							System.out.print("You must be admin level to access this function.");
							stall();
						}
						else
						{
							System.out.print("How much would you like to deposit?");
							account.deposit(scanner.nextDouble());
						}
						break;
					case 3:
						if(user.getUserLevel().getValue() < 2)
						{
							System.out.print("You must be admin level to access this function.");
							stall();
						}
						else
						{
							System.out.print("Which user do you want to transfer funds to?");
							String usrTo = scanner.next();
							Account accountTo = null;
							User userTo = User.getUser(usrTo);
							if(userTo != null)
							{
								ArrayList<Account> accounts = userTo.getBankAccounts();
								
								int accountSize = accounts.size();
								
								boolean loop2 = true;
								
								do {
									System.out.println("Which account?");
									for(int i = 0; i < accounts.size(); i++)
									{
										System.out.println(i + 1 + ": " + accounts.get(i).getName());
									}
									
									int input = scanner.nextInt();
								
									if(input > 0 && input <= accountSize)
									{
										accountTo = accounts.get(input - 1);
										loop2 = false;
									}
									else {
										System.out.println("invalid input");
										stall();
									}
								}while(loop2);
								System.out.print("How much money would you like to transfer?");
								double amount = scanner.nextDouble();
			
								if (account.transferFunds(accountTo, amount)) {
									System.out.println("Transaction success, sent $" + amount + " to account "  + accountTo.getAccountID());
									stall();
								} else {
									System.out.println("Transaction failed, you cannot overdraw");
									stall();
								}
							}
							else
							{
								System.out.println("This user does not exist.");
								stall();
							}
						}
						break;
					case 4:
						if(account.approveAccount())
						{
							System.out.println("Account approved.");
							stall();
						}
						else
						{
							System.out.println("Something went wrong.");
							stall();
						}
						break;
					case 5:
						if(user.getUserLevel().getValue() < 2)
						{
							System.out.print("You must be admin level to access this function.");
							stall();
						}
						else
						{
							if(account.deleteAccount())
							{
								System.out.println("Account deleted. Returning to menu.");
								stall();
								loop = false;
								priviledgedMenuScreen();
							}
							else
							{
								System.out.println("Something went wrong.");
								stall();
							}
						}
						break;
					case 6:
						loop = false;
						priviledgedMenuScreen();
						break;
					case 7:
						loop = false;
						logout();
						break;
					default:
						System.out.println("Input out of range");
						stall();
						break;
				}
			}catch (InputMismatchException e) {
				System.out.println("Input not an integer");
				//scanner.nextLine();
				stall();
			}
			

		}while(loop);
		
		
	}
	
	public static void stall() {
		System.out.println("(Press any key + enter to continue.)");
		scanner.next();
	}
	
	public static void logout()
	{
		ConsoleUI.user = null;
		startMenu();
	}
	
	public static void exit() {
		scanner.close();
		System.exit(0);
	}
	
}
