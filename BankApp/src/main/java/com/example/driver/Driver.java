
package com.example.driver;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.example.dao.BankAcctDaoImpl;
import com.example.dao.UserDaoImpl;
import com.example.model.BankAcct;
import com.example.model.User;

public class Driver {
	
	
	User currentCustomer; 
	
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
		
		BankAcctDaoImpl bankAcctDaoImpl = new BankAcctDaoImpl(); 
		List<BankAcct> accounts = bankAcctDaoImpl.selectAllBankAccts();
		
		myScanner.nextLine();
		
		System.out.println("What is your first name?");
		String fName = myScanner.nextLine();
		
		System.out.println("What is yout last name?");
		String lName = myScanner.nextLine();
		
		System.out.println("Please enter a username for your account: ");
		String userName = myScanner.nextLine();
		
		
		System.out.println("Please enter a password for your account");
		String password = myScanner.nextLine();
		
		BankAcct account = new BankAcct();
		//System.out.println(account);
		account.setAccountStatus(0);
		account.setBalance(0.0);
		bankAcctDaoImpl = new BankAcctDaoImpl(); 
		
		
		bankAcctDaoImpl.insertBankAcct(account);
		
		accounts = bankAcctDaoImpl.selectAllBankAccts();
		System.out.println(accounts);
		//System.out.println(bankAcctDaoImpl.selectAllBankAccts());
		
		//int increment = account.getAccountNumber();
		//System.out.println(increment);
		User user = new User(); 
		
		user.setfName(fName);
		user.setlName(lName);
		user.setUserName(userName);
		user.setPassword(password);
		user.setType(3);
		//System.out.println(account);
		//user.setAccNumUser
		//System.out.println(account.getAccountNumber());
		
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.insertUser(user);
		
		//int accNum = account.getAccountNumber();
		int accNumber = bankAcctDaoImpl.selectAccNumByMax(); 
		user.setAccNumUser(accNumber);
		
		userDaoImpl.updateUser(user);
		//System.out.println(user);

		
	}
	
	
	public static void loginUser() {
		
		System.out.println("Enter Username: ");
		String userName = myScanner.next();
		
		System.out.println("\n Enter Password: ");
		String password = myScanner.next();
		
		if(userName.equals("admin") & password.equals("password")) { 
			adminScreen(); 
		}
		else if(userName.equals("employee") & password.equals("password")) {
			employeeScreen("employee"); 
			
		}
		else {
			customerScreen(userName);}
			
			
		}
		
		
		public static void adminScreen() {
			boolean adminLoop = true;
			
			logger.info("Now in the admin screen");
			do {
				
				System.out.println("Select your option: ");
				System.out.println("1 to view account");
				System.out.println("2 to approve account");
				System.out.println("3 to cancel an account");
				System.out.println("4 to logout");
				
				switch(myScanner.nextInt()) {
				
				case 1:
					System.out.println("Enter the account you wish to view ");
					Integer accNum = myScanner.nextInt();
					
					BankAcctDaoImpl bankAcctDaoImpl = new BankAcctDaoImpl();
					UserDaoImpl userDaoImpl = new UserDaoImpl();
					User u = new User();
					
					for(BankAcct a : bankAcctDaoImpl.selectAllBankAccts()) {
						u = userDaoImpl.selectUserByAcctNum(a.getAccountNumber());
						System.out.println(u.getfName() + a);
					}
					break;
				
				case 2: 
					System.out.println("Enter the account you want to approve ");
					accNum = myScanner.nextInt();
					
					bankAcctDaoImpl = new BankAcctDaoImpl();
					
					BankAcct account = new BankAcct();
					
					account = bankAcctDaoImpl.selectUserByAccountNum(accNum);
					
					account.setAccountStatus(1);
					
					bankAcctDaoImpl.updateBankAcct(account);
					break;
					
				case 3:
					System.out.println("Enter the account you want to cancel ");
					accNum = myScanner.nextInt();
					
					bankAcctDaoImpl = new BankAcctDaoImpl();
					
					account = new BankAcct();
					
					account = bankAcctDaoImpl.selectUserByAccountNum(accNum);
					
					//account.setAccountStatus(1);
					
					bankAcctDaoImpl.deleteAccount(account);
					break;
					
				case 4: 
					adminLoop = false;
					break;
			
				default:
					System.out.println("Option not available");
					break;
					
				}
			}while(adminLoop);}
		
		
		
		public static void employeeScreen(String userName) {
			
			boolean employeeLoop = true;
			
			logger.info("Now in the employee screen");
			do {
				
				System.out.println("Select your option: ");
				System.out.println("1 to view account");
				System.out.println("2 to approve account");
				System.out.println("3 to logout");
				
				switch(myScanner.nextInt()) {
				
				case 1:
					System.out.println("Enter the account you wish to view ");
					Integer accNum = myScanner.nextInt();
					
					BankAcctDaoImpl bankAcctDaoImpl = new BankAcctDaoImpl();
					UserDaoImpl userDaoImpl = new UserDaoImpl();
					User u = new User();
					
					for(BankAcct a : bankAcctDaoImpl.selectAllBankAccts()) {
						u = userDaoImpl.selectUserByAcctNum(a.getAccountNumber());
						System.out.println(u.getfName() + a);
					}
					break;
				
				case 2: 
					System.out.println("Enter the account you want to approve");
					
					bankAcctDaoImpl = new BankAcctDaoImpl();
					
					BankAcct account = new BankAcct();
					
					accNum = account.getAccountNumber();
					
					account = bankAcctDaoImpl.selectUserByAccountNum(accNum);
					
					account.setAccountStatus(1);
					
					bankAcctDaoImpl.updateBankAcct(account);
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
		
		public static void customerScreen(String userName) {
			
			boolean anotherLoop = true;
			//double amount;
		
			logger.info("Now in the transaction screen");
			do {
				
				System.out.println("Select your banking option: ");
				System.out.println("1 to deposit");
				System.out.println("2 to withdraw");
				System.out.println("3 to transfer");
				System.out.println("4 to logout");
				
				User user;
				//BankAcct account;
				
				switch(myScanner.nextInt()) {
				
				case 1:
					System.out.println("Enter amount to be deposited: ");
					double amount = myScanner.nextDouble();
					
					UserDaoImpl userDaoImpl = new UserDaoImpl(); 
					System.out.println(userName);
					user = userDaoImpl.selectUserByUsername(userName);
					System.out.println(user + "user object");
					
					//int AcctNum = user.getAccNumUser();
					int AccNum = userDaoImpl.getAccNumByUserName(userName);
					
					System.out.println(AccNum + "account object");
					
					BankAcctDaoImpl bankAcctDaoImpl = new BankAcctDaoImpl();
					
					BankAcct account = bankAcctDaoImpl.selectUserByAccountNum(AccNum);
					System.out.println(account);
					
					double balance = account.getBalance();
					System.out.println(balance);
					
					account.setBalance(balance + amount);
					System.out.println(balance+amount);
					System.out.println(account.getBalance());
					bankAcctDaoImpl.updateBankAcct(account);
					
					
					System.out.println("done depositing");
					break;
					
				case 2:
					System.out.println("Enter amount to be withdrawn: ");
					amount = myScanner.nextDouble();
					
					userDaoImpl = new UserDaoImpl(); 
					
					user = userDaoImpl.selectUserByUsername(userName);
					
					AccNum = user.getAccNumUser();
					
					bankAcctDaoImpl = new BankAcctDaoImpl();
					
					account = bankAcctDaoImpl.selectUserByAccountNum(AccNum);
					
					balance = account.getBalance();
					
					account.setBalance(balance - amount);
					
					bankAcctDaoImpl.updateBankAcct(account);
				
					
					break;
					
				case 3: 
					System.out.println("Enter the account you are transfering to: ");
					int to = myScanner.nextInt();
					
					System.out.println("Enter the amount to  be transfered: ");
					amount = myScanner.nextDouble();
					
					bankAcctDaoImpl = new BankAcctDaoImpl();
					BankAcct from = new BankAcct();
					BankAcct accountTo = bankAcctDaoImpl.selectUserByAccountNum(to);
					
					if(amount > from.getBalance()) {
						System.out.println("exceeds withdraw amount avaiable");
					}
						
					balance = from.getBalance() - amount;
					from.setBalance(balance);
					balance = accountTo.getBalance() + amount;
					accountTo.setBalance(balance);
					
					bankAcctDaoImpl.updateBankAcct(from);
					bankAcctDaoImpl.updateBankAcct(accountTo);
	
					
					break;
					
				case 4: 
					anotherLoop = false;
					break;
				
				default:
					System.out.println("Option not available");
					break;
						
				}
			}while(anotherLoop);}
			
		}
			
		
	
	
		
	

