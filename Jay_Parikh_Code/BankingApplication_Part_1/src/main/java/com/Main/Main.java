package com.Main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.Account.Dao.AccountDaoImpl;
import com.Customer.Dao.CustomerDaoImpl;
import com.Employee.Dao.EmployeeDaoImpl;
import com.Model.Account;
import com.Model.Customer;
import com.Model.Employee;

public class Main {
	
	final static Logger logger = Logger.getLogger(Main.class);
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		//System.out.println("Welcome to the Pizza Bank, would you like to (A) login or (B) create an account?");
		logger.info("Banking App Started");
		String input;
		do {
			System.out.println("Welcome to the Bank, would you like to (A) login or (B) create an account?");
			input = scan.next();
			switch(input) {
			case "A":
				loginMenu();
				break;
			case "B":
				registerAccount();
				break;
			
			default:
				System.out.println("Invalid input, please try again.");
			}
			
		}while(!input.equals("A") || !input.equals("B"));		
	}

	public static void loginMenu() {
		logger.info("Login Menu");
		boolean b = false;
		String logType;
		do {
			System.out.println();
			System.out.println("Would you like login through the (A) customer, (B) employee portal or (E) Exit?");
			logType = scan.next();
			switch(logType){
				case "A":
					customerLoginMenu();
					break;
				case "B":
					employeeLoginMenu();
					break;
				case "E":
					b = true;
					break;
				default:
					System.out.println("Invalid input, please try again.");
			}
		}while(!b);
	}

	private static void employeeLoginMenu() {
		logger.info("Employee Login");
		EmployeeDaoImpl empImpl = new EmployeeDaoImpl();
		
		System.out.println("To login, please enter your Username.");
		String userName = scan.next(); 
		System.out.println("Now please enter your Password.");
		String passWord = scan.next();
		Employee emp = empImpl.selectAccountByName(userName);
		
		if(emp.getUserName().equals(userName) && emp.getPassWord().equals(passWord)) {
			if(emp.getType().equals(0)) {
				employeeMenu();
			}else if(emp.getType().equals(1)){
				adminMenu();
			}else {
				System.out.println("Invalid input, please try again.");
				employeeLoginMenu();
			}
		}	
		
	}

	public static void adminMenu() {
		logger.info("Admin Logged in");
		boolean b = false;
		Customer c = new Customer();
		String acc;
		CustomerDaoImpl customerImpl = new CustomerDaoImpl();
		do {
			System.out.println();
			System.out.println("***Welcome to the Admin Portal***");
			System.out.println("What actions would you like to perform? "
					        + "\n" + "(A) View Accounts, (B) Edit an Account, (C) Approve an Account, "
					        + "\n" + "(D) Cancel an Account, (E) Withdraw, (F) Deposit, (G) Transfer, "
					        + "\n" + "or (H) Exit.");
			String admChoice = scan.next();
			switch(admChoice) {
			case "A":
				logger.info("Admin viewing accounts");
				viewAccounts();
				break;
			case "B":
				logger.info("Admin editing accounts");
				System.out.println("What is the username of the account you would like to edit?");
				acc = scan.next();
				c = customerImpl.selectCustomerByName(acc);
				editAccount(c);
				break;
			case "C":
				logger.info("Admin approving accounts");
				approveAccount();
				break;
			case "D":
				logger.info("Admin cancelling accounts");
				System.out.println("What is the username of the account you would like to cancel?");
				acc = scan.next();
				c = customerImpl.selectCustomerByName(acc);
				System.out.println(c);
				cancelAccount(c);
				break;
			case "E":
				logger.info("Adming withdrawing");
				System.out.println("What is the username of the account you would like to withdraw from?");
				acc = scan.next();
				c = customerImpl.selectCustomerByName(acc);
				withdraw(c);
				break;
			case "F":
				logger.info("Admin depositing");
				System.out.println("What is the username of the account you would like to deposit to?");
				acc = scan.next();
				c = customerImpl.selectCustomerByName(acc);
				deposit(c);
				break;
			case "G":
				logger.info("Admin transferring");
				System.out.println("What is the username of the account you would like to transfer from?");
				acc = scan.next();
				c = customerImpl.selectCustomerByName(acc);
				transfer(c);
				break;
			case "H":
				logger.info("Admin logout");
				b = true;
				break;
			default:
				System.out.println("Invalid input, please try again.");
			}
			
			
		}while(!b);
		
	}

	public static void editAccount(Customer c) {
		CustomerDaoImpl customerImpl = new CustomerDaoImpl();
	
		System.out.println("Change password");
		String passUp = scan.next();
		c.setPassWord(passUp);
		
		System.out.println("Change first name");
		String fnameUp = scan.next();
		c.setFirstName(fnameUp);
		
		System.out.println("Change last name");
		String lnameUp = scan.next();
		c.setLastName(lnameUp);
		
		System.out.println("Change SSN");
		String personalUp = scan.next();
		c.setPersonalInfo(personalUp);
		
		customerImpl.updateCustomer(c);
		
		System.out.println("Customers account info updated.");
		logger.info("Customers account info updated.");
	}

	public static void cancelAccount(Customer c) {
		AccountDaoImpl accImpl = new AccountDaoImpl();
		Account acc = accImpl.selectAccountById(c.getAccountid());
		accImpl.deleteAccount(acc.getAccountid());
		System.out.println(c.getFirstName() + " " + c.getLastName() + "'s account deleted.");
		logger.info(c.getFirstName() + " " + c.getLastName() + "'s account deleted.");
	}

	public static void employeeMenu() {
		logger.info("Employee Logged in");
		boolean b = false;
		do {
			System.out.println();
			System.out.println("***Welcome to the Employee Portal***");
			System.out.println("What actions would you like to perform? (A) View Accounts, (B) Approve an Account or (E) Exit.");
			String empChoice = scan.next();
			switch(empChoice) {
			case "A":
				logger.info("Employee viewing accounts");
				viewAccounts();
				break;
			case "B":
				logger.info("Employee approving accounts");
				approveAccount();
				break;
			case "E":
				logger.info("Employee Logout");
				b = true;
				break;
			default:
				System.out.println("Invalid input, please try again.");
			}
		}while(!b);
	}
	
	public static void viewAccounts() {
		CustomerDaoImpl customerImpl = new CustomerDaoImpl();
		AccountDaoImpl accImpl = new AccountDaoImpl();
		for(Account a : accImpl.selectAllAccounts()) {	
			System.out.println(customerImpl.selectCustomerByAccountid(a.getAccountid()).getUserName() + "'s " + a);
		}
	}

	public static void approveAccount() {
		CustomerDaoImpl customerImpl = new CustomerDaoImpl();
		AccountDaoImpl accImpl = new AccountDaoImpl();
		System.out.println("Accounts that are pending approval");
		for(Account a : accImpl.selectAllAccounts()) {
			
			if(a.getStatus() == 0) {
				System.out.println(customerImpl.selectCustomerByAccountid(a.getAccountid()).getFirstName() + "'s " + a);
			}
		}
		System.out.println("Input the account number that you want to approve.");
		int accountApprove = scan.nextInt();
		Account acc = accImpl.selectAccountById(accountApprove);
		acc.setStatus(1);
		accImpl.updateAccount(acc);		
		System.out.println(customerImpl.selectCustomerByAccountid(acc.getAccountid()).getFirstName() + "'s account approved!");
		logger.info(customerImpl.selectCustomerByAccountid(acc.getAccountid()).getFirstName() + "'s account approved!");
	}

	public static void customerLoginMenu() {
		//inputs
		CustomerDaoImpl customerImpl = new CustomerDaoImpl();
		AccountDaoImpl accImpl = new AccountDaoImpl();
		
		System.out.println("To login, please enter your Username.");
		String userName = scan.next(); 
		System.out.println("Now please enter your Password.");
		String passWord = scan.next();
		Customer custom = customerImpl.selectCustomerByName(userName);
		Account account = accImpl.selectAccountById(custom.getAccountid());
		//login check
		if(custom.getPassWord().equals(passWord)) {
			//approved account check here
			if(account.getStatus() == 1) {
				logger.info("Customer login successful");
				customerMenu(custom);
			}else {
				logger.info("Unapproved account login");
				System.out.println("Your account has not been approved yet.");
				customerLoginMenu();
			}
		}else {
			logger.info("Customer login failed");
			System.out.println("Username and Password do not match, please try again.");
			customerLoginMenu();
		}
	}

	public static void customerMenu(Customer c) {
		logger.info("Customer Logged in");
		boolean b = false;
		do {
			System.out.println();
			System.out.println("***Welcome " + c.getFirstName() + ", How can we help you today?***");
			System.out.println("(A) Withdraw, (B) Deposit, (C) Transfer, or (E) Exit."); //, or (D) Make your accout joint?
			String input = scan.next();
			switch(input) {
			case "A":
				logger.info("Customer withdrawing");
				withdraw(c);
				break;
			case "B":
				logger.info("Customer depositing");
				deposit(c);
				break;
			case "C":
				logger.info("Customer transferring");
				transfer(c);
				break;
			case "E":
				logger.info("Customer logging out");
				b = true;
				break;
			default:
				System.out.println("Invalid input, please try again.");
			}
			
		}while(!b);
		
	}
	
	public static int withdraw(Customer c) {
		AccountDaoImpl accImpl = new AccountDaoImpl();
		Account acc = accImpl.selectAccountById(c.getAccountid());
		System.out.println("How much woud you like to withdraw? Account Balance: " + acc.getBalance() + ".");
		double withdraw = scan.nextDouble();
		if(withdraw < acc.getBalance()) {
			acc.setBalance(acc.getBalance() - withdraw);
			accImpl.updateAccount(acc);
			logger.info("Withdraw successful");
			System.out.println(withdraw + " withdrawn successfully.");
		}else {
			logger.info("Withdraw amount too large");
			System.out.println("Withdrawal amount too large.");
		}
		return 0;
	}

    public static int deposit(Customer c) {
    	AccountDaoImpl accImpl = new AccountDaoImpl();
		Account acc = accImpl.selectAccountById(c.getAccountid());
		System.out.println("How much woud you like to deposit? Account Balance: " + acc.getBalance() + ".");
		double deposit = scan.nextDouble();
		acc.setBalance(acc.getBalance() + deposit);
		accImpl.updateAccount(acc);
		logger.info("Deposit successful");
		System.out.println(deposit + " deposited successfully.");
		return 0;
	}
    
    public static int transfer(Customer c) {
    	AccountDaoImpl accImpl = new AccountDaoImpl();
    	CustomerDaoImpl custImpl = new CustomerDaoImpl();
		Account acc = accImpl.selectAccountById(c.getAccountid());
		System.out.println("What is the account number of the account you would like to transfer to?");
		int tAcc = scan.nextInt();
		if(accImpl.selectAccountById(tAcc) != null) {
			Account transferAcc = new Account();
			transferAcc = accImpl.selectAccountById(tAcc);
			System.out.println("How much woud you like to transfer? Account Balance: " + acc.getBalance() + ".");
			double transfer = scan.nextInt();
			if(transfer < acc.getBalance()) {
				acc.setBalance(acc.getBalance() - transfer);
				accImpl.updateAccount(acc);
				transferAcc.setBalance(transferAcc.getBalance() + transfer);
				accImpl.updateAccount(transferAcc);
				logger.info("Transfer successful");
				System.out.println("Successfully transfered " + transfer + " to " + custImpl.selectCustomerByAccountid(transferAcc.getAccountid()).getFirstName() + ".");
			}else {
				logger.info("Transfer amount too large");
				System.out.println("Transfer amount too large.");
			}
		}else {
			logger.info("No account to transfer to");
			System.out.println("We are sorry but the selected account does not exist, please try again.");
		}	
		return 0;
	}
    
	public static void registerAccount() {
		AccountDaoImpl accImp = new AccountDaoImpl();
		CustomerDaoImpl customerImpl = new CustomerDaoImpl();
		
		Account newAcc = new Account();	
		newAcc.setBalance(0.0);
		newAcc.setStatus(0);
		accImp.insertAccount(newAcc);
		
		System.out.println("To create a new Account please enter your first name.");
		String fname = scan.next();
		System.out.println("Last name?");
		String lname = scan.next();
		System.out.println("What would you like your username to be?");
		String userName = scan.next();
		System.out.println("Create a password.");
		String passW = scan.next();
		System.out.println("Enter your SSN.");
		String ssn = scan.next();
		
		int accNum = customerImpl.selectAccountForCustomer();
		Customer customer = new Customer(userName, passW, fname, lname, ssn, accNum);
		customerImpl.insertCustomer(customer);
		System.out.println(customer.getFirstName() + "'s account created");
		logger.info(customer.getFirstName() + "'s account created");
	}
}
