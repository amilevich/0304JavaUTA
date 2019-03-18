package com.banking.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.banking.account.Account;
import com.banking.exception.*;
import com.banking.user.*;
import com.banking.dao.*;

import org.apache.log4j.Logger;

public class Main
{
	final static Logger logger = Logger.getLogger(Main.class.getName());
	static UserDaoImpl userDB = new UserDaoImpl();
	static AccountDaoImpl accountDB = new AccountDaoImpl();

	public static void main(String[] args)
	{

		logger.info("APPLICATION START");
		System.out.println("Welcome to the Revature Banking Application");

		ArrayList<User> users = userDB.getAllUsers();
		ArrayList<Account> accounts = accountDB.getAllAccounts();
		if (users.size() == 0)
		{
			userDB.registerUser("admin", "password", 3, null);
			userDB.registerUser("employee", "password", 2, null);
			userDB.commitDB();
		}

		String loginInput = "";
		User currentUser = null;

		while (true)
		{
			System.out.println("========----------------========");
			loginInput = getUserInput("Please select an option (Login/Register/Exit): ").toUpperCase();
			if (loginInput.equals("QUIT") || loginInput.equals("EXIT"))
			{
				// Both userDB and accountDB commit the whole Database
				userDB.commitDB();
				logger.info("APPLICATION EXIT");
				System.exit(0);
			}

			// Did not choose Exit
			if (loginInput.equals("R") || loginInput.equals("REGISTER"))
			{
				// Register new customer and Commit Data
				currentUser = registerUser(users, 1);
				logger.info("Registered new user: " + currentUser);
				// Send them back to the login screen
			}
			// Did not choose Register
			else if (loginInput.equals("L") || loginInput.equals("LOGIN"))
			{
				currentUser = getUserLogin(users);
				logger.info("User logs in: " + currentUser);

				// Check at least one account exists
				// Find account user wants to use
				if (currentUser instanceof Employee && accounts.size() == 0)
				{
					System.out.println("There are currently no accounts availble for operation.");
					System.out.println("Logging out.");
					continue;
					// To login loop
				}

				Account currentAccount = null;
				while (currentAccount == null)
				{
					String accountInput = "";
					System.out.println("What account will you be working with today?");
					
					// Display accounts in memory
					ArrayList<Long> accountNums = new ArrayList<>();
					for (Account acct : accountDB.getAllAccounts())
						accountNums.add(acct.getAccountNumber());
					System.out.println("Current Accounts: " + accountNums);
					if (currentUser instanceof Customer)
						System.out.println("(Enter NEW if you would like to apply for an account)");

					accountInput = getUserInput("").toUpperCase();
					// Open Application for new account
					if (accountInput.equals("NEW"))
					{
						currentAccount = applyForAccount(currentUser, accounts);
						logger.info("New account registered");
						logger.info(currentUser + " created Account # " + currentAccount.getAccountNumber());
					}
					else // Use existing account
					{
						currentAccount = findAccount(accountInput, accounts);

						// Account found ; verify access for current user and get operation request
						String userOperation = getUserOperation(currentUser, currentAccount);

						switch (userOperation)
						{
						case "WITHDRAW":
							double withdrawAmount = -1;
							double currBalance = currentAccount.getBalance();
							System.out.println("Current balance is: " + currBalance);
							if (currBalance > 0)
							{
								while (withdrawAmount < 0)
								{
									withdrawAmount = getDoubleInput("How much would you like to withdraw?");
									try
									{
										currentAccount.requestWithdrawl(withdrawAmount);
										accountDB.updateAccountBalance(currentAccount.getAccountNumber(),
												currentAccount.getBalance());
										logger.info(currentUser + " withdrew " + withdrawAmount + " from Account #"
												+ currentAccount.getAccountNumber());
									}
									catch (AccountNotOpenException e)
									{
										System.out.println("This account is not open");
									}
									catch (InvalidBalanceException e)
									{
										System.out.println("Your maximum withdrawl is " + currBalance);
									}
									catch (NegativeMoneyException e)
									{
										System.out.println("Please enter a positive value to withdraw");
										e.printStackTrace();
									}
								}
							}
							break;
						case "DEPOSIT":
							double depositAmount = -1;
							System.out.println("Current Balance is: " + currentAccount.getBalance());
							while (depositAmount < 0)
							{
								depositAmount = getDoubleInput("How much would you like to deposit?");
								try
								{
									currentAccount.requestDeposit(depositAmount);
									accountDB.updateAccountBalance(currentAccount.getAccountNumber(),
											currentAccount.getBalance());
									logger.info(currentUser + " deposited " + depositAmount + " to Account #"
											+ currentAccount.getAccountNumber());
								}
								catch (AccountNotOpenException e)
								{
									System.out.println("This account is not open");
								}
								catch (InvalidBalanceException e)
								{
									System.out.println("Memory Error. Deposit not able to be processed at this time");
								}
								catch (NegativeMoneyException e)
								{
									System.out.println("Please enter a positive amount to deposit");
									e.printStackTrace();
								}
							}
							break;
						case "TRANSFER":
							double transferAmount = -1;
							System.out.println("Current Balance is: " + currentAccount.getBalance());
							// Only able to transfer out to another account
							Account targetAccount = null;
							while (transferAmount < 0)
							{
								transferAmount = getDoubleInput("How much would you like to transfer?");
								System.out.println("Which account will you be transferring to?");
								System.out.println(accounts);
								long targetInput = -1;
								while (targetAccount == null)
								{
									try
									{
										targetInput = Long.valueOf(getUserInput(""));
										for (Account account : accounts)
											if (account.getAccountNumber() == targetInput)
												targetAccount = account;
									}
									catch (NumberFormatException e)
									{
									}
								}
							}
							try
							{
								currentAccount.requestTransfer(transferAmount, targetAccount);
								logger.info(currentUser + " transferred " + transferAmount + " from Account #"
										+ currentAccount.getAccountNumber() + " to Account #"
										+ targetAccount.getAccountNumber());
							}
							catch (AccountNotOpenException e)
							{
							}
							catch (InvalidBalanceException e)
							{
							}
							catch (NegativeMoneyException e)
							{
							}
							catch (NullPointerException e)
							{
								e.printStackTrace();
								// Ideally, I don't end up here anyway
							}
							accountDB.updateAccountBalance(currentAccount.getAccountNumber(),
									currentAccount.getBalance());
							accountDB.updateAccountBalance(targetAccount.getAccountNumber(),
									targetAccount.getBalance());

							break;
						case "RESPOND TO APPLICATION":
							if (currentAccount.getState() == Account.AccountState.PENDING_APPROVAL)
							{
								System.out.println("Please select your decision for this account application");
								System.out.println("- APPROVE");
								System.out.println("- DENY");

								boolean validSelection = false;
								while (!validSelection)
								{
									String applicationResponse = getUserInput("").toUpperCase();
									if (applicationResponse.equals("APPROVE"))
									{
										currentAccount.approveAccount();
										accountDB.updateAccountState(currentAccount.getAccountNumber(),
												currentAccount.getState());
										logger.info("Application for Account #" + currentAccount.getAccountNumber()
												+ " has been approved by " + currentUser);
										validSelection = true;
									}
									else if (applicationResponse.equals("DENY"))
									{
										currentAccount.closeAccount();
										accountDB.updateAccountState(currentAccount.getAccountNumber(),
												currentAccount.getState());
										logger.info("Application for Account #" + currentAccount.getAccountNumber()
												+ " has been denied by " + currentUser);
										validSelection = true;
									}
								}
							}
							break;
						case "VIEW ACCOUNT INFO":
							System.out.println(currentAccount);
							break;
						case "VIEW ACCOUNT BALANCE":
							System.out.println(currentAccount.getBalance());
							break;
						case "VIEW CUSTOMER INFORMATION":
							System.out.println((ArrayList<Customer>) currentAccount.getAccountInfo()[2]);
							break;
						case "CLOSE":
							String confirmClose = "";
							while (confirmClose.equals(""))
							{
								confirmClose = getUserInput("Are you sure you want to close Account #"
										+ currentAccount.getAccountNumber() + "?").toUpperCase();
								if (confirmClose.equals("Y") || confirmClose.equals("YES"))
								{
									currentAccount.closeAccount();
									accountDB.updateAccountState(currentAccount.getAccountNumber(),
											currentAccount.getState());
									logger.info("Account #" + currentAccount.getAccountNumber()
											+ " has been terminated by " + currentUser);

								}
								else if (confirmClose.equals("N") || confirmClose.equals("NO"))
									;
								else
									confirmClose = "";
							}
							break;
						// no operations available to user for account
						case "":
							continue;
						}
						accountDB.commitDB();
						// UPDATE ACCOUNTS AFTER TRANSACTION AND COMMIT
						// End Switch Block
					}
				}
				// End Account Access
			}
			else
			{
				// Invalid User input
				System.out.println("\fInput not recognised");
			}
			// Loop back to main menu
		}

	}

	// ****** CONSOLE INTERFACE FUNCTIONS ******
	public static String getUserInput(String message)
	{
		Scanner stdin = new Scanner(System.in);
		System.out.print(message);
		return stdin.nextLine();
	}

	public static double getDoubleInput(String message)
	{
		Double result = -1d;
		String input = "";
		while (result == -1)
		{
			input = getUserInput(message);
			try
			{
				result = Double.valueOf(input);
			}
			catch (NumberFormatException e)
			{
			}
		}
		return result;
	}

	public static int getIntInput(String message)
	{
		Integer result = -1;
		String input = "";
		while (result == -1)
		{
			input = getUserInput(message);
			try
			{
				result = Integer.valueOf(input);
			}
			catch (NumberFormatException e)
			{
			}
		}
		return result;
	}

	// ****** REGISTER NEW USER ******
	public static User registerUser(ArrayList<User> users, int userType)
	{
		String username, password;
		User currentUser = null;

		boolean isAvailable;
		do
		{
			username = getUserInput("\fPlease enter a new username: ");
			isAvailable = true;
			for (User u : users)
			{
				if (u.getUsername().equals(username))
					isAvailable = false;
			}
		}
		while (!isAvailable);

		boolean isValidated = false;
		do
		{
			password = getUserInput("Please enter a new password: ");
			String pwCheck = getUserInput("Please confirm your password: ");
			isValidated = password.equals(pwCheck);
		}
		while (!isValidated);
		// Username available and password validated

		// Create new user of requested type
		// Only register Customers for now
		// Other registration can be handled as requirements expand
		switch (userType)
		{
		case 1:
			System.out.println("Welcome to our service! We're just going to need your name.");
			// Get personal information from Customers
			String name = getUserInput("Please enter your full name below:\n");
			userDB.registerUser(username, password, 1, name);
			currentUser = new Customer(name, username, password);
			break;
		case 2:
			userDB.registerUser(username, password, 2, null);
			currentUser = new Employee(username, password);
			break;
		case 3:
			userDB.registerUser(username, password, 3, null);
			currentUser = new Admin(username, password);
			break;
		}

		users.add(currentUser);
		userDB.commitDB();
		System.out.println("Your registration is complete! Thank you for choosing Revature Banking.");
		return currentUser;
	}

	// ****** LOGIN EXISTING USER ******
	public static User getUserLogin(ArrayList<User> users)
	{
		User currentUser = null;

		boolean loggedIn = false;
		while (!loggedIn)
		{
			String username = getUserInput("Please enter your username: ");
			String password = getUserInput("Please enter your password: ");

			if ((currentUser = userDB.getUserLogin(username, password)) != null)
				loggedIn = true;
		}
		// Login successful,
		return currentUser;
	}

	// ****** APPLY FOR ACCOUNT ******
	public static Account applyForAccount(User currentUser, ArrayList<Account> accounts)
	{
		Account currentAccount = null;

		String accountSelectMessage = "What type of account would you like to create? (1/2)"
				+ "\n1. CHECKING \n2. SAVINGS \n# ";

		int accountType = 0;
		while (accountType == 0)
		{
			accountType = getIntInput(accountSelectMessage);
		}
		// Add the new account with the current user
		currentAccount = ((Customer) currentUser).applyForAccount(accountDB,
				Account.AccountType.values()[accountType - 1]);
		accounts.add(currentAccount);

		// get any joint account holders
//		System.out.println("For this account, will there be any joint partners?");
//		System.out.println("For each of the joint holders, please enter their full name below.");
//		System.out.println("Once you are done, please enter NONE or leave the field empty.");
//		boolean jointLoopingFlag = true;
//
//		String[] closeJointLoop =
//			{ "", "no", "none", "NO", "NONE" };
//		while (jointLoopingFlag)
//		{
//			String jointOwner = getUserInput("").trim();
//			for (String option : closeJointLoop)
//			{
//				if (jointOwner.equals(option))
//					jointLoopingFlag = false;
//			}
//			if (jointLoopingFlag) // if not exiting
//				currentAccount.addOwner(new Customer(jointOwner, null, null));
//		}
		// Account Registration Complete
		System.out.println("Thank you for opening an account with Revature Banking!");
		System.out.println("We will have one of our associates review your application as soon as possible!");
		System.out.println("Your account number will be " + currentAccount.getAccountNumber());

		return currentAccount;
	}

	// ****** ACCESS EXISTING ACCOUNT ******
	public static Account findAccount(String accountInput, ArrayList<Account> accounts)
	{
		Account currentAccount = null;

		// While account not located
		while (currentAccount == null)
		{
			long targetAccount = -1;
			try
			{
				targetAccount = Long.valueOf(accountInput);
			}
			catch (NumberFormatException e)
			{

			}
			for (Account acct : accounts)
			{
				if (acct.getAccountNumber() == targetAccount)
				{
					currentAccount = acct;
					break;
				}
			}
			// Accounts searched
			if (currentAccount == null)
			{
				System.out.println("Sorry. We weren't able to find that account");
				accountInput = getUserInput("Please check your account number: ");
			}
		}
		return currentAccount;
	}

	// ****** OPERATE ON ACCOUNT ******
	public static String getUserOperation(User currentUser, Account currentAccount)
	{
		ArrayList<String> legalOperations = currentUser.getAccountOperations(currentAccount);
		// Ready to operate on account
		// Display options
		for (String op : legalOperations)
			System.out.println(op);

		String userOperation = "";
		boolean validCommand = false;
		while (!validCommand)
		{
			userOperation = getUserInput("------\nPlease select an option from the list above: ").toUpperCase();
			for (String op : legalOperations)
				if (userOperation.equals(op))
					validCommand = true;
		}
		return userOperation;
	}

	// ****** OBJECT SERIALIZATION ******
//	static Object readObject(String filename)
//	{
//		
//	}
//
//	static void writeObject(String filename, Object obj)
//	{
//		
//	}
}
