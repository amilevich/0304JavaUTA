package com.example.driver;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.example.dao.BankAcctDaoImpl;
import com.example.dao.UserDaoImpl;
import com.example.model.BankAcct;
import com.example.model.User;

public class Driver {
	
	
	
	
	final static Logger logger = Logger.getLogger(Driver.class);
	static Scanner myScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		
		boolean theLoop = true;
		
		logger.info("APP has started");
		
		do {
			System.out.println("Welcome, please select an option to continue.");
			System.out.println("1 to Make an Account");
			System.out.println("2 to Login");
			System.out.println("3 to quit");
		
			
			switch(myScanner.nextInt()) {
			case 1:
				logger.info("starting to make an account");
				makeAnAccount();
				break;
				
				
			case 2:
				logger.info("login");
				loginUser();
				break;
				
			case 3: 
				theLoop = false;
				break;	
				
			default:
				System.out.println("Option not available");
				break; 
			}
			
		}while(theLoop);
		
		myScanner.close();
		 
		}
	
	public static void makeAnAccount() {
		
		String userName;
		
		myScanner.nextLine();
		
		System.out.println("What is your first name?");
		String fName = myScanner.nextLine();
		
		System.out.println("What is yout last name?");
		String lName = myScanner.nextLine();
		
		System.out.println("Please enter a username for your account: ");
		userName = myScanner.nextLine();
		
		//while(User.userNameNotUnique(userName));
		
		System.out.println("Please enter a password for your account");
		String password = myScanner.nextLine();
		BankAcct account = new BankAcct();
		account.setAccountStatus(0);
		account.setBalance(0.0);
		BankAcctDaoImpl bankAcctDaoImpl = new BankAcctDaoImpl(); 
		bankAcctDaoImpl.insertBankAcct(account);
		User user = new User(); 
		
		user.setfName(fName);
		user.setlName(lName);
		user.setUserName(userName);
		user.setPassword(password);
		user.setType(3);
		user.setAccNumUser(0);
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.insertUser(user);
		
		
		int accNum = account.getAccountNumber();
		user.setAccNumUser(accNum);
		
		userDaoImpl.updateUser(user);
		
		
//		System.out.println("Would you like to add a joint account holder?");
//		System.out.println("If yes enter their first name and last name in the style of first:last ");
//		System.out.println("If no enter NONE");
			//String jointHolder = myScanner.nextLine();
			
		//BankAcct newAccount = new BankAcct(0, 0, 0);
		
		//if(BankAcct.setUpAccount(newAccount)) {
		//	System.out.println("Account was created");
		//}else {
		//	System.out.println("Account could not be created");
		//}
	}
	
	
	public static void loginUser() {
		
		System.out.println("Enter Username: ");
		String userName = myScanner.next();
		
		System.out.println("\n Enter Password: ");
		String password = myScanner.next();
		
		if(userName=="admin" & password=="password") {
			//do admin stuff
			//switch case 
		}
		else if(userName=="employee" & password=="password") {
			boolean employeeLoop = true;
			
			logger.info("Now in the transaction screen");
			do {
				
				System.out.println("Select your option: ");
				System.out.println("1 to view accounts");
				System.out.println("2 to approve accounts");
				System.out.println("3 to logout");
				
				switch(myScanner.nextInt()) {
				
				case 1:
					System.out.println("Enter the account you wish to view ");
					break;
				
				case 2: 
					System.out.println("Enter the account you want to approve");
					break;
					
				case 3: 
					employeeLoop = false;
					break;
			
				default:
					System.out.println("Option not available");
					break;
					
				}
			}while(employeeLoop);
			
		}
		else {
			boolean anotherLoop = true;
			double amount;
		
			logger.info("Now in the transaction screen");
			do {
				
				System.out.println("Select your banking option: ");
				System.out.println("1 to deposit");
				System.out.println("2 to withdraw");
				System.out.println("3 to transfer");
				System.out.println("4 to logout");
				
				User user;
				BankAcct account;
				switch(myScanner.nextInt()) {
				
				case 1:
					System.out.println("Enter amount to be deposited: ");
					amount = myScanner.nextDouble();
					
					UserDaoImpl userDaoImpl = new UserDaoImpl(); 
					
					user = userDaoImpl.selectUserByUsername(userName);
					
					int AcctNum = user.getAccNumUser();
					
					BankAcctDaoImpl bankAcctDaoImpl = new BankAcctDaoImpl();
					
					account = bankAcctDaoImpl.selectUserByAccountNum(AcctNum);
					
					double balance = account.getBalance();
					
					account.setBalance(balance + amount);
					
					bankAcctDaoImpl.updateBankAcct(account);
				
					
					
					
					
					/*if(user.deposit(amount)) {
						System.out.println("deposit of " + amount + " was successfu1");
					}else {
						System.out.println("deposit of " + amount + " was unsuccessful");
					}*/
					break;
					
				case 2:
					System.out.println("Enter amount to be withdrawn: ");
					amount = myScanner.nextDouble();
				
					/*if(user.withdraw(amount)) {
						System.out.println("withdraw of " + amount + " was successful");
					}else {
						System.out.println("withdraw of " + amount + " was unsuccessful");
					}*/
					
					break;
					
				case 3: 
					System.out.println("Enter the account you are transfering to: ");
					String to = myScanner.next();
					
					System.out.println("Enter the amount to  be transfered: ");
					amount = myScanner.nextDouble();
					
					
					/*if(user.transferTo(user, amount)) {
						System.out.println("Transfer of " + amount + "to " + to + " successful");
					}else {
						System.out.println("Transfer of " + amount + "to " + to + " unsuccessful");
					}*/
					
					break;
					
				case 4: 
					anotherLoop = false;
					break;
				
				default:
					System.out.println("Option not available");
					break;
						
				}
			}while(anotherLoop);
			
			
		}
		
		
		
		//User user = User.logIn(userName, password);
		
		
		/*if(user instanceof BankAcct) {
			transactionScreen((BankAcct) user);
		}else {
			System.out.println("invalid username or password");
		}*/
		
	}
	



	
	
	public static void EmployeeScreen(User employee) {
		boolean employeeLoop = true;
		double amount;
		
		logger.info("Now in the transaction screen");
		do {
			
			System.out.println("Select your option: ");
			System.out.println("1 to view accounts");
			System.out.println("2 to approve accounts");
			System.out.println("3 to logout");
			
			switch(myScanner.nextInt()) {
			
			case 1:
				System.out.println("Enter the account you wish to view ");
				break;
			
			case 2: 
				System.out.println("Enter the account you want to approve");
				break;
				
			case 3: 
				employeeLoop = false;
				break;
		
			default:
				System.out.println("Option not available");
				break;
				
			}
		}while(employeeLoop);
		
	}
		
	}
	
	
	

