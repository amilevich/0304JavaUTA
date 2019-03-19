package com.project.driver;

import java.util.Scanner;

import com.project.dao.AccountDaoImpl;
import com.project.dao.CounterDaoImpl;
import com.project.dao.CustomerDaoImpl;
import com.project.dao.JunctionDaoImpl;
import com.project.model.Account;
import com.project.model.Counter;
import com.project.model.Customer;
import com.project.model.Junction;

public class Main {

	static Scanner allInput = new Scanner(System.in);
	
	public static void main(String[] args) {

		int userInput = 0; 
		
		while(true)
		{
			String username = ""; 
			String password = ""; 
			
			System.out.println("Banking Application");
			System.out.println();
			
			System.out.println("Select an option: ");
			System.out.println("1. Register");
			System.out.println("2. Log In");
			System.out.println("3. Exit");
			System.out.println();
			
			System.out.print("> ");
			userInput = allInput.nextInt(); 
			
			switch(userInput)
			{
				case 1:
					// register a new user
					Customer cus = registerNewCustomer(); 
					
					System.out.println("User registered check 1");
					
					// register customer with accound ID
					finalizeCustomerRegistration(cus); 
					
					System.out.println("User registered check 2");
					break; 
				case 2:
					allInput.nextLine(); 
					
					// log in user
					System.out.println("Enter a username: ");
					username = allInput.nextLine();
					System.out.println("Enter a password: ");
					password = allInput.nextLine(); 
					
					checkLogInCredentials(username, password); 
					
					username = ""; 
					password = ""; 
					
					break; 
				case 3:
					// exit baning app
					System.out.println("Exiting banking application.");
					System.exit(0);
				default:
					System.out.println("Invalid input, try again");
					break; 
			}
			
			
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//// LOG IN USER

	public static void checkLogInCredentials(String username, String password) {
		
		// for all ui inputs
		int adminInput = 0; 
		int customerInput = 0; 
		int employeeInput = 0;
		
		// customer balance
		double currentBalance = 0; 
		
		// customer withdraw var
		double customerWithdraw = 0;
		
		// customer deposit var
		double customerDeposit = 0;
		
		// customer transfer var
		double customerTransfer = 0; 
		
		// 2nd customer balance
		double secondCustomerTransfer = 0; 

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//// admin stuff
		
		
		
		
		// for admin withdraw
		double adminWithdraw = 0; 
		
		// returned withdraw from account
		double returnWithdraw = 0; 
		
		// for admin deposit
		double adminDeposit = 0; 
		
		// for admin transfer -> account id
		int adminTransfer = 0;
		
		// return current balance
		double returnTransfer = 0; 
		
		// balance to be taken 
		double takeFromBalance = 0; 
		
		// money to transfer to 2nd bank account
		double newTransferBalance = 0; 
		
		// check username and password
		boolean checkFields = false; 
		
		// verify account open
		boolean checkStatus = false; 
		
		// will need a customer, junction, account, customer dao impl, junction dao impl, and account dao impl objects
		Customer cus = null; 
		Junction jun = null; 
		Account acc = null; 
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl(); 
		JunctionDaoImpl junctionDaoImpl = new JunctionDaoImpl(); 
		AccountDaoImpl accountDaoImpl = new AccountDaoImpl(); 
		
		
		if(username.equals("admin") && password.equals("admin"))
		{
			
			while(true)
			{
				// open admin menu
				System.out.println("\nSelect one of the following.");
				System.out.println();
				System.out.println("1. View all acounts");
				System.out.println("2. Approve/Deny an account");
				System.out.println("3. Withdraw");
				System.out.println("4. Deposit");
				System.out.println("5. Transfer");
				System.out.println("6. Cancel account");
				System.out.println("7. Exit Banking App");
				System.out.println();
				System.out.print("> ");
				adminInput = allInput.nextInt(); 
							
							
				switch(adminInput)
				{
					case 1:
						// display all accounts					
						for(Account a :  accountDaoImpl.selectAllAccounts())
						{
							jun = junctionDaoImpl.selectJunctionByID(a.getAccount_id());
							
							System.out.println("Username: "+jun.getUserName()+ " ----> "+a.toString()); // displays account_id, balance, status
						}
						
						break; 
					case 2: 
						// display all open accounts
						for(Account a :  accountDaoImpl.selectAllOpenAccounts())
						{
							jun = junctionDaoImpl.selectJunctionByID(a.getAccount_id());
							
							System.out.println("Username: "+jun.getUserName()+ " ----> "+a.toString()); // displays account_id, balance, status
						}
						
						System.out.println("\nInsert a choice: ");
						System.out.println();
						System.out.println("1. Approve account. ");
						System.out.println("2. Deny (delete) account. ");
						System.out.println();
						System.out.print("> ");
						adminInput = allInput.nextInt(); 
						
						switch(adminInput)
						{
							case 1:
								// approve account
								System.out.println("Enter in an ACCOUNT_ID: ");
								adminInput = allInput.nextInt(); 
								
								// update account status 0 --> 1, and balance 0.0 --> 200.0
								accountDaoImpl.updateAccountStatus(adminInput);
								
								break;
							case 2:
								// deny (DELETE) account
								System.out.println("Enter in an ACCOUNT_ID: ");
								adminInput = allInput.nextInt();
								
								// delete account 
								accountDaoImpl.deleteAccount(adminInput);
								
								// grab username and account id
								jun = junctionDaoImpl.selectJunctionByID(adminInput); 
								
								if(jun == null)
								{
									break; 
								}
								
								// delete customer
								customerDaoImpl.deleteCustomer(jun.getUserName());
								
								// delete junction
								junctionDaoImpl.deleteJunction(adminInput);						
								
								break; 
							case 3:
								System.out.println("Exiting banking application.");
								System.exit(0);
							default: 
								System.out.println("Not valid input.");
								break;
						}
						
						// displayAllOpenAccounts();
						break; 
					case 3:  
						// take money from customer >:)
						
						// display all ongoing accounts					
						for(Account a :  accountDaoImpl.selectAllOnGoingAccounts())
						{
							jun = junctionDaoImpl.selectJunctionByID(a.getAccount_id());
							
							System.out.println("Username: "+jun.getUserName()+ " ----> "+a.toString()); // displays account_id, balance, status
						}
						
						// ask for admin input
						System.out.println("\nEnter the Account ID you wish to withdraw from: ");
						adminInput = allInput.nextInt(); 
						System.out.println();
						
						// get current balance
						returnWithdraw = accountDaoImpl.grabAccountBalance(adminInput);
						
						while(true)
						{
							System.out.println("Withdraw maximum is: "+returnWithdraw+" Insert amount to withdraw: ");
							adminWithdraw = allInput.nextDouble();
							
							// overdrafting check, otherwise withdraw
							if(adminWithdraw > returnWithdraw)
							{
								System.out.println("Overdrafting not allowed.\n");
							}
							else
							{
								// compute new balance
								returnWithdraw = returnWithdraw - adminWithdraw; 
								
								// update balance
								accountDaoImpl.updateAccountBalanceAfterWithdraw(adminInput, returnWithdraw);
								
								// return updated account
								acc = accountDaoImpl.selectAccountByID(adminInput);
								
								// display new balance
								System.out.println("New account balance: "+acc.getBalance());
								break;
							}
						}
						
						
						break; 
					case 4:
						// deposit money into an account
						// display all ongoing accounts					
						for(Account a :  accountDaoImpl.selectAllOnGoingAccounts())
						{
							jun = junctionDaoImpl.selectJunctionByID(a.getAccount_id());
							
							System.out.println("Username: "+jun.getUserName()+ " ----> "+a.toString()); // displays account_id, balance, status
						}
						
						// ask for admin input
						System.out.println("\nEnter the Account ID you wish to deposit to: ");
						adminInput = allInput.nextInt(); 
						System.out.println();
						
						System.out.println("Enter the amount to deposit: ");
						adminDeposit = allInput.nextDouble(); 
						
						// grab current balance
						acc = accountDaoImpl.selectAccountByID(adminInput);
						
						adminDeposit = adminDeposit + acc.getBalance();
						
						// add deposit to account 
						accountDaoImpl.updateAccountBalanceAfterDeposit(adminInput, adminDeposit);
						
						// grab updated balance
						acc = accountDaoImpl.selectAccountByID(adminInput);
						
						// display new balance
						System.out.println("New account balance: "+acc.getBalance());
						
						break;
					case 5: 
						// transfer money from one account to another
						// display all ongoing accounts					
						for(Account a :  accountDaoImpl.selectAllOnGoingAccounts())
						{
							jun = junctionDaoImpl.selectJunctionByID(a.getAccount_id());
							
							System.out.println("Username: "+jun.getUserName()+ " ----> "+a.toString()); // displays account_id, balance, status
						}
						
						// ask for account id to withdraw from
						System.out.println("\nEnter an account ID to transfer from: ");
						adminInput = allInput.nextInt(); 
						
						// withdraw from account, store full account balance
						returnTransfer = accountDaoImpl.grabAccountBalance(adminInput);
						
						while(true)
						{
							System.out.print("\nMaximum available for tranfer: "+returnTransfer+" Enter amount to tranfer: ");
							takeFromBalance = allInput.nextDouble();
							newTransferBalance = takeFromBalance; 
							
							if(takeFromBalance > returnTransfer)
							{
								System.out.println("\nYou cannot transfer more than you have.");
							}
							else
							{
								System.out.println("\nTransfer amount: "+takeFromBalance);
								returnTransfer = returnTransfer - takeFromBalance;
								
								break;
							}
						}
						
						// update first account with new balance ( ID, newBalance )
						accountDaoImpl.updateAccountBalanceAfterTransfer(adminInput, returnTransfer);
						
						// grab second account balance
						System.out.println("Enter an account ID to transfer to: ");
						adminInput = allInput.nextInt();
						
						// withdraw from account, store full account balance
						returnTransfer = accountDaoImpl.grabAccountBalance(adminInput);
						
						// calculate new balance for second account
						returnTransfer = newTransferBalance + returnTransfer;
						
						// update second account with new balance ( ID, newBalance )
						accountDaoImpl.updateAccountBalanceAfterTransfer(adminInput, returnTransfer);
						
						break; 
					case 6: 
						// cancel account
						// display all ongoing accounts					
						for(Account a :  accountDaoImpl.selectAllOnGoingAccounts())
						{
							jun = junctionDaoImpl.selectJunctionByID(a.getAccount_id());
							
							System.out.println("Username: "+jun.getUserName()+ " ----> "+a.toString()); // displays account_id, balance, status
						}
						System.out.println("\nCancel account.");
						System.out.println("Enter the account id: ");
						adminInput = allInput.nextInt();
						
						accountDaoImpl.updateAccountStatusCancel(adminInput);
						
						break;
					case 7: 
						// exit banking app
						System.out.println();
						System.out.println("Exiting banking applicaiton.");
						System.exit(0);
					default: 
						System.out.println("Not valid input.");
						break;
				}
			}
		}
	///// end admin stuff
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//// employee stuff
		
		else if(username.equals("employee") && password.equals("employee"))
		{
			
			
			// open employee menu
			System.out.println("\nSelect one of the following.");
			System.out.println();
			System.out.println("1. View all acounts");
			System.out.println("2. Approve/Deny an account");
			System.out.println("3. Exit");
			
			employeeInput = allInput.nextInt();
			
			switch(employeeInput)
			{
				case 1:
					// display all accounts					
					for(Account a :  accountDaoImpl.selectAllAccounts())
					{
						jun = junctionDaoImpl.selectJunctionByID(a.getAccount_id());
						
						System.out.println("Username: "+jun.getUserName()+ " ----> "+a.toString()); // displays account_id, balance, status
					}
					
					break;
				case 2:
					// display all open accounts
					for(Account a :  accountDaoImpl.selectAllOpenAccounts())
					{
						jun = junctionDaoImpl.selectJunctionByID(a.getAccount_id());
						
						System.out.println("Username: "+jun.getUserName()+ " ----> "+a.toString()); // displays account_id, balance, status
					}
					
					System.out.println("\nInsert a choice: ");
					System.out.println();
					System.out.println("1. Approve account. ");
					System.out.println("2. Deny (delete) account. ");
					System.out.println();
					System.out.print("> ");
					employeeInput = allInput.nextInt(); 
					
					switch(employeeInput)
					{
						case 1:
							// approve account
							System.out.println("Enter in an ACCOUNT_ID: ");
							employeeInput = allInput.nextInt(); 
							
							// update account status 0 --> 1, and balance 0.0 --> 200.0
							accountDaoImpl.updateAccountStatus(adminInput);
							
							break;
						case 2:
							// deny (DELETE) account
							System.out.println("Enter in an ACCOUNT_ID: ");
							employeeInput = allInput.nextInt();
							
							// delete account 
							accountDaoImpl.deleteAccount(employeeInput);
							
							// grab username and account id
							jun = junctionDaoImpl.selectJunctionByID(employeeInput); 
							
							if(jun == null)
							{
								break; 
							}
							
							// delete customer
							customerDaoImpl.deleteCustomer(jun.getUserName());
							
							// delete junction
							junctionDaoImpl.deleteJunction(employeeInput);						
							
							break; 
						case 3:
							System.out.println("Exiting banking application.");
							System.exit(0);
						default: 
							System.out.println("Not valid input.");
							break;
					}
					break; 
				case 3:
					// exit banking app
					System.out.println();
					System.out.println("Exiting banking applicaiton.");
					System.exit(0);
				default: 
					System.out.println("Not valid input.");
					break;
			}
		}
		
	////// end of employee stuff	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		
		
		
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////// customer stuff
		else
		{
			// check if username is correct (or exists)
			checkFields = verifyUserCredentials(username, password); 
			
			// check status of employee
			checkStatus = verifyUserStatus(username); 
			
			if(checkFields == true && checkStatus == true)
			{
				// customer menu
				System.out.println("Welcome: "+username);
				System.out.println();
				
				
				while(true)
				{
					// grab username and account id
					jun = junctionDaoImpl.selectJunctionByUsername(username);
					
					acc = accountDaoImpl.selectAccountByID(jun.getAccount_id());
					
					System.out.println("\n "+username+" Balance: "+acc.getBalance());
					
					System.out.println("Select an option.");
					System.out.println();
					System.out.println("1. Withdraw");
					System.out.println("2. Deposit");
					System.out.println("3. Transfer");
					System.out.println("4. Exit");
					System.out.print("> ");
					customerInput = allInput.nextInt(); 
					
					switch(customerInput)
					{
					case 1:
						// withdraw from account
						
						// grab username and account id
						jun = junctionDaoImpl.selectJunctionByUsername(username);
						
						// grab current balance
						currentBalance = accountDaoImpl.grabAccountBalance(jun.getAccount_id());
						
						while(true)
						{
							System.out.print("\nMaximum amount to withdraw: "+currentBalance+" Enter amount to withdraw: ");
							customerWithdraw = allInput.nextDouble();
							
							if(customerWithdraw > currentBalance)
							{
								System.out.println("You can not over-withdraw.");
							}
							else
							{
								break;
							}
						}
						
						// calculate the new balance and put it into DB
						currentBalance = currentBalance - customerWithdraw; 
						
						// update account balance (withdraw)
						 accountDaoImpl.updateAccountBalanceAfterWithdraw(jun.getAccount_id(), currentBalance);
						 
						 
						break;
					case 2:
						// deposit to account
						
						// grab username and account id
						jun = junctionDaoImpl.selectJunctionByUsername(username);
						
						// grab current balance
						currentBalance = accountDaoImpl.grabAccountBalance(jun.getAccount_id());
						
						System.out.print("Enter the amount to deposit: ");
						customerDeposit = allInput.nextDouble();
						
						customerDeposit = customerDeposit + currentBalance;
						
						// update account balance (deposit)
						accountDaoImpl.updateAccountBalanceAfterDeposit(jun.getAccount_id(), customerDeposit);
						
						break;
					case 3:
						// transfer money to another account
						String otherUsername = ""; 
						
						// create junction, junction dao impl, account, account dao impl object uninitialized
						Junction transferJun = new Junction(); 
						JunctionDaoImpl transferJunDaoImpl = new JunctionDaoImpl(); 
						Account transferAcc = new Account();
						AccountDaoImpl transferAccountDaoImpl = new AccountDaoImpl(); 
						
						allInput.nextLine();
						
						// grab username and account id
						jun = junctionDaoImpl.selectJunctionByUsername(username);
						
						// grab current balance
						currentBalance = accountDaoImpl.grabAccountBalance(jun.getAccount_id());
						
						acc = accountDaoImpl.selectAccountByID(jun.getAccount_id());
						
						System.out.println("\nTransfer funds.");
						
						while(true)
						{
							System.out.println("Enter a username: ");
							otherUsername = allInput.nextLine();
							
							// check if username exists
							transferJun = transferJunDaoImpl.selectJunctionByUsername(otherUsername);
							if(transferJun == null)
							{
								System.out.println("Username is not correct or does not exist.");
							}
							else
							{
								System.out.println("You will transfer funds to: "+transferJun.getUserName());
								break;
							}
							
						}
						
						// get fields for 2nd customer transferAcc
						transferAcc = transferAccountDaoImpl.selectAccountByID(transferJun.getAccount_id());
						
						// get balance of 2nd customer
						secondCustomerTransfer = transferAccountDaoImpl.grabAccountBalance(transferAcc.getAccount_id());
						
						
						while(true)
						{
							System.out.print("Maximum amount that can be transferred: "+currentBalance+" \nEnter the amount to transfer: ");
							customerTransfer = allInput.nextDouble(); // this will be added to second customer
							
							if(customerTransfer > currentBalance)
							{
								System.out.println("You do not have enough funds.");
							}
							else
							{
								break; 
							}
							
						}
						
						// calculate new balance for 2nd customer
						secondCustomerTransfer = secondCustomerTransfer + customerTransfer;
						
						// will update 2nd customer's balance 
						transferAccountDaoImpl.updateAccountBalanceAfterDeposit(transferAcc.getAccount_id(), secondCustomerTransfer);
						
						// calculate balance for 1st customer
						currentBalance = currentBalance - customerTransfer;
						
						// update 1st customer balance
						accountDaoImpl.updateAccountBalanceAfterDeposit(acc.getAccount_id(), currentBalance);
						
						
						break;
					case 4:
						// exit 
						System.out.println("\n\n\nExiting bank application");
						System.exit(0);
					default:
						System.out.println("Invalid input");
						break;
					}
				}
				
				
				
				
				
				
			}
			else if(checkFields == false)
			{
				System.out.println("Incorrect username or password.");
			}
			else if(checkStatus == false)
			{
				System.out.println("Account has not been activated.");
			}

		}
		
	}

	// verify login credentials
	public static boolean verifyUserCredentials(String username, String password) {
		
		// create a customer dao impl object
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl(); 
		
		// return searched for row in customer table
		Customer cus = customerDaoImpl.searchCustomerByUsername(username);
		
		// check if cus.userName matches verifyUserCredentials parameter username
		if(cus == null)
		{
			return false;
		}
		
		if(cus.getUserName().equals(username) == true)
		{
			return true;
		}
		
	return false;
}
	
	// verify user account is open
	public static boolean verifyUserStatus(String username) {
		
		// Steps:
		// 		create Junction object to retrieve account ID
		//		create Account object and pass in account ID as parameter
		
		// create a junction dao impl object
		JunctionDaoImpl junctionDaoImpl = new JunctionDaoImpl(); 
		
		// return account id in junction object
		Junction jun = junctionDaoImpl.selectJunctionByUsername(username); 
		
		// cannot find junction, because account doesn't exist... probably...
		if(jun == null)
		{
			return false; 
		}
		
		System.out.println("Junction ID: "+jun.getAccount_id());
		
		// create an account dao impl object
		AccountDaoImpl accountDaoImpl = new AccountDaoImpl(); 
		
		// return search for row in account table by account id
		Account acc = accountDaoImpl.selectAccountByID(jun.getAccount_id());
		
		if(acc == null)
		{
			System.out.println("Account is null as well :O");
		}
		
		if(acc.getStatus() == 0)
		{
			return false;
		}
		
	return true;
}
	
	
	
	///// END LOG IN
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//// REGISTER CUSTOMER START

	// grab firstname, lastname, username, password from user input
	public static Customer registerNewCustomer() 
	{
		System.out.println("\nIn register new customer function");
		
		// used for checking if username is unique
		boolean checkUser = false; 
		
		// CUSTOMER
		//
		// first_name VARCHAR2 (30),
		// last_name VARCHAR2 (30),
		// user_name VARCHAR2 (30) PRIMARY KEY,
		// pass_word VARCHAR2 (30)
				
		String firstName = "";
		String lastName = ""; 
		String userName = ""; 
		String passWord = "";
				
		// declare customer object
		Customer cus = null;
		
		// ask user to fill in fields
		System.out.println("\nRegister Test");
		System.out.println();
		
		allInput.nextLine();
		
		System.out.print("\nEnter your first name: ");
		firstName = allInput.nextLine();
		
		System.out.print("Enter your last name: ");
		lastName = allInput.nextLine();
		
		// create customer dao impl object for checking username
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl(); 
		
		// create customer object to hold fields (firstname, lastname, username, password)
		// Customer cus;
		
		// check input usernames must be unique
		while(true)
		{			
			System.out.print("Enter a user name: ");
			userName = allInput.nextLine();
			
			// search for username, if null then good
			cus = customerDaoImpl.searchCustomerByUsername(userName);
			
			// empty object means username is available
			if(cus == null)
			{
				System.out.println("\nUsername is unique");
				break; 
			}
			
			// if user input matches username in DB, then username taken
			if(cus.getUserName().equals(userName) == true)
			{
				System.out.println("\nUsername is taken."); 
			}
			
		}
		
		
			
		System.out.print("Enter a password: ");
		passWord = allInput.nextLine();
		
		// create a customer object
		cus = new Customer(firstName, lastName, userName, passWord); 
		
		// create a customer dao impl object
		// CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl(); 
		
		System.out.println("\nInserting customer");
		
		// call insert function with customer dao implements object
		customerDaoImpl.insertCustomer(cus); 
		
		System.out.println("AFTER CUSTOMER INSERT");
		
		return cus; 
		
	}
	
	public static void finalizeCustomerRegistration(Customer cus) {
		// ACCOUNT
		// 
		// account_id NUMBER(30) PRIMARY KEY,
		// balance NUMBER(9,2),
		// status number(1,0)
				
		int account_id = 0; 
		double balance = 0.00; 
		int status = 0; // a boolean of some sort
		
		// declare a customer counter object and name
		Counter counter;
				
		// store customer counter for account ID
		int customerCounter; 
		
		// create new object CounterDaoImpl
		CounterDaoImpl customerCounterDaoImpl = new CounterDaoImpl(); 
				
		// grab the single int in table counter
		customerCounter = customerCounterDaoImpl.grabLastHeldID();
				
		// spot check
		System.out.println("\nAccount ID before DB pull: "+customerCounter);
				
		// increment ID for new registering customer
		customerCounter = customerCounter + 1; 
		
		// GRAB ACCOUNT ID HERE
		account_id = customerCounter; 
				
		// make new counter object initialized with ID
		counter = new Counter(customerCounter); 
				
		// call insert function for counter
		customerCounterDaoImpl.insertCounter(counter);
				
		// print counter for self checking purposes
		System.out.println("\nThis is will be the account ID: "+customerCounter);
		
		
		
		
		
		
		
		///////////////////////////////////////////////////////////////////////
		////////// account will also be filled here 
		
		// declare an account object 
		Account acc; 
		
		// create an account object 
		acc = new Account(account_id, balance, status); 
		
		// create account dao impl object
		AccountDaoImpl accountDaoImpl = new AccountDaoImpl(); 
		
		// creating account
		System.out.println("\nBefore account insert");
		
		// insert account obj into account table
		accountDaoImpl.insertAccount(acc);
		
		System.out.println("After account insert");
		
		////////// end account portion
		////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		////////////////////////////////////////////////////////////////////////
		//////// begin junction table insertion
		
		// make a junction object
		Junction jun = new Junction(cus.getUserName(), account_id); 
		
		// create a junction dao impl object 
		JunctionDaoImpl junctionDaoImpl = new JunctionDaoImpl();
		
		System.out.println("\nBefore junction insert");
		
		// insert into junction table
		junctionDaoImpl.insertJunction(jun);
		
		System.out.println("After junction insert\n");
		
		///////// end junction insertion section
		/////////////////////////////////////////////////////////////////////////
		
		
		
		
		
	}
	
	//// REGISTER CUSTOMER END
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
