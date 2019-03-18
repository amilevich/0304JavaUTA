package com.example.Main;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.example.Account.Account;
import com.example.AccountDao.AccountDaoImpl;
import com.example.Employee.Employee;
import com.example.EmployeeDao.EmployeeDaoImpl;
import com.example.User.User;
import com.example.UserDao.*;

public class Main {
	
	final static Logger logger = Logger.getLogger(Main.class);
	static Scanner reader = new Scanner(System.in);
	static ArrayList<User> userList = new ArrayList<User>();
	//static UserDaoImpl userDaoImpl = new UserDaoImpl();
	//static EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();

	public static void main(String[] args) {
		
		//User user =new User();
		//User user1 = new User();
		
		/*user.setUserid();
		user.setFirstName("Tywin");
		user.setLastName("Lanister");
		user.setUserName("Tywin_Lanister");
		user.setPassword("password");
		user.setUserKey(1);
		user.setUserAcctStatus(1);
		user.setSsn();
		user.setAcctNum();
		userList.add(user);
		userDaoImpl.insertUser(user);*/
		
		/*user1.setUserid();
		user1.setFirstName("Mad");
		user1.setLastName("King");
		user1.setUserName("Mad_King");
		user1.setPassword("password");
		user1.setUserKey(2);
		user1.setUserAcctStatus(1);
		user1.setSsn();
		user1.setAcctNum();
		userList.add(user1);
		userDaoImpl.insertUser(user1);*/
		
		start();
	}
	
	public static void start() {
		logger.info("Application was started");
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Welcome to the Iron Bank App!");
		System.out.println("- Press 1 to Register ");
		System.out.println("- Press 2 to Login ");
		System.out.println("- Press 3 to Exit ");
		System.out.print("Please input value: ");
		
		while(!reader.hasNextInt()) {														//keeps asking user for input if not integer
			System.out.println();
			System.out.println("The Iron Bank does not tolerate nonsense!");
			System.out.println("You must enter a valid integer!");
			System.out.println();
			System.out.println("- Press 1 to Register ");
			System.out.println("- Press 2 to Login ");
			System.out.println("- Press 3 to Exit ");
			System.out.print("Please input value: ");	
			reader.next();
		}
		
		int input = reader.nextInt();
		
		if(input==1) {
			register();
		}
		else if(input==2) {
			login();
		}
		else if(input==3) {
			logger.info("Application was exited");
			System.exit(0);
		}
		else {
			System.out.println();
			start();
		}
		reader.close();
	}
	
	public static void register() {
		Scanner reader = new Scanner(System.in);
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User newUser = new User();
		String fn, ln, un, pw;
		int a;
		
		System.out.println();
		System.out.println("To Register for an Iron Bank account the following questions must be answered!");
		System.out.print("Enter the first name of the primary account holder: ");
		fn=reader.next();
		System.out.print("Enter the last name of the primary account holder: ");
		ln=reader.next();
		System.out.print("Enter the user name of the primart accounter holder: ");
		un=reader.next();
		System.out.print("Enter the password of the primary account holder: ");
		pw=reader.next();
		
		System.out.println();
		System.out.println("Your records will be reviewed by Iron Bank Overseers and a raven will be sent with application results");
		System.out.println();
		
		newUser.setUserid();
		newUser.setFirstName(fn);
		newUser.setLastName(ln);
		newUser.setUserName(un);
		newUser.setPassword(pw);
		newUser.setUserkey();
		newUser.setUserAcctStatus();
		newUser.setSsn();
		newUser.setAcctNum();
		userList.add(newUser);
		userDaoImpl.insertUser(newUser);
		
		logger.info("User was registered with firstName: "+fn+", lastName: "+ln+", userName: "+un+", password: "+pw);	
		
		start();
	}
	
	public static void login() {
		Scanner reader = new Scanner(System.in);
		UserDaoImpl userDaoImpl1 = new UserDaoImpl();
		
		System.out.println();
		System.out.println("Provide Iron Bank Credentials!");
    	System.out.print("Enter username: ");
    	String a=reader.next();
    	System.out.print("Enter password: ");
    	String b=reader.next();
    	
    	User temp = new User();
    	temp = userDaoImpl1.selectUserByName(a,b);
    	
    	if(temp == null) {
    		System.out.println();
    		System.out.println("Credentials are not part of the Iron Bank records!");
    		System.out.println("There will be faceless consequences if you try to enter without access again!!");
    		System.out.println();
    		start();
    	}
    	
    	if(temp.getUserKey()==0) {
    		if(temp.getUserAcctStatus()==0) {
    			System.out.println();
        		System.out.println("Overseers have not approved your account yet!");
        		System.out.println();
        		start();
        	}
    		else if(temp.getUserAcctStatus()==1) {
    			logger.info("Logged in as customer");
    			customer(a);
    		}
    	}
    	else if(temp.getUserKey()==1) {
    		logger.info("Logged in as employee");
    		employee();
    	}
    	else if(temp.getUserKey()==2) {
    		logger.info("Logged in as admin");
    		admin();
    	}
    	reader.close();
	}
	
	public static void employee() {
		Scanner read = new Scanner(System.in);
		Employee e = new Employee();
		
		System.out.println();
		System.out.println("Iron Bank Employee Options");
		System.out.println("- Press 1 to approve account ");
		System.out.println("- Press 2 to deny account ");
		System.out.println("- Press 3 to view account information ");
		System.out.println("- Press 4 to view account balance ");
		System.out.println("- Press 5 to view personal information ");
		System.out.println("- Press 6 to return to main menu ");
		System.out.print("Enter Option: ");
		int x = read.nextInt();		
		System.out.println();
		
		if(x==1) {
			EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
			User n = new User();
			Scanner p = new Scanner(System.in);
			System.out.println("***Account Approval***");
			System.out.print("Enter account username to approve: ");
			String input = p.nextLine();
			n.setUserName(input);
			employeeDaoImpl.approveUser(n);
			System.out.println("Account has been approved!");
			
			UserDaoImpl user = new UserDaoImpl();						//
			AccountDaoImpl acc = new AccountDaoImpl();					//
			User u = new User();										//
			Account a = new Account();									// Create Account in Database when user gets approved
			u = user.selectUserByName(n.getUserName());					//
			a.setAcctNum(u.getAcctNum());								//
			a.setUserName1(u.getUserName());							//
			a.setUserName2(null);										//
			acc.insertAccount(a);										//
			logger.info("Employee approved account"+n.getUserName());
			employee();
		}
		else if(x==2) {
			EmployeeDaoImpl temp = new EmployeeDaoImpl();
			User u = new User();
			Scanner in = new Scanner(System.in);
			System.out.println("***Account Denial***");
			System.out.print("Enter account username to deny: ");
			String s = in.nextLine();
			u.setUserName(s);
			temp.deleteUser(u);
			System.out.println("User was deleted!");
			logger.info("Employee denied/deleted account"+u.getUserName());
			employee();
		}
		else if(x==3) {
			User us = new User();
			EmployeeDaoImpl tem = new EmployeeDaoImpl();
			Scanner in = new Scanner(System.in);
			System.out.println("***Account Information***");
			System.out.print("Enter username you wish to spy on: ");
			String s = in.nextLine();
			us = tem.accountInfo(s);
			System.out.println();
			System.out.println();
			System.out.println("Account Info collected on "+s+" - UserID: "+us.getUserid()+", Username: "+us.getUserName()+", Password: "+us.getPassword()+", UserKey: "+us.getUserKey()+", UserAcctStatus: "+us.getUserAcctStatus()+", AcctNumber: "+us.getAcctNum());
			System.out.println();
			employee();
		}
		else if(x==4) {
			Scanner in = new Scanner(System.in);
			System.out.println("***Account Balance Information***");
			System.out.print("Enter username you wish to spy on: ");
			String s = in.nextLine();
			UserDaoImpl user = new UserDaoImpl();
			AccountDaoImpl acc = new AccountDaoImpl();
			User u = new User();
			Account a = new Account();
			u = user.selectUserByName(s);
			a = acc.getAccount(u.getAcctNum());
			System.out.println();
			System.out.println();
			System.out.println("Account Balance Info collected on "+s+" - AcctNumber: "+a.getAcctNum()+", AcctBalance: "+a.getBalance());
			System.out.println();
			employee();
		}
		else if(x==5) {
			User us = new User();
			EmployeeDaoImpl tem = new EmployeeDaoImpl();
			Scanner in = new Scanner(System.in);
			System.out.println("***Personal Information***");
			System.out.print("Enter username you wish to spy on: ");
			String s = in.nextLine();
			us = tem.personalInfo(s);
			System.out.println();
			System.out.println();
			System.out.println("Personal Info collected on "+s+" - First name: "+us.getFirstName()+", Last name: "+us.getLastName()+", SSN: "+us.getSsn());
			System.out.println();
			employee();
		}
		else if(x==6) {
			start();
		}
		
	}
	
	public static void customer(String un) {
		Scanner scan = new Scanner(System.in);
		UserDaoImpl user = new UserDaoImpl();
		AccountDaoImpl acc = new AccountDaoImpl();
		User u = new User();
		Account a = new Account();
		u = user.selectUserByName(un);
		a = acc.getAccount(u.getAcctNum());
		
		System.out.println();
		System.out.println("Iron Bank Customer Options");
		System.out.println("- Press 1 to Withdraw ");
		System.out.println("- Press 2 to Deposit ");
		System.out.println("- Press 3 to Transfer ");
		System.out.println("- Press 4 to Return to Main Menu");
		System.out.print("Enter Option: ");
		int n = scan.nextInt();
		
		if(n==1) {
			Scanner scan1 = new Scanner(System.in);
			System.out.println();
			System.out.print("Enter amount to Withdraw: $");
			double amt = scan1.nextInt();
			if(a.getBalance()-amt < 0) {
				System.out.println("Insufficent funds to process request!");
				customer(un);
			}
			double newB = a.getBalance() - amt;
			acc.withdraw(a.getAcctNum(), newB);
			System.out.println("Transaction complete!");
			logger.info("Customer "+u.getUserName()+" withdrew "+amt);
			customer(un);
		}
		else if(n==2) {
			Scanner scan2 = new Scanner(System.in);
			System.out.println();
			System.out.print("Enter amount to Deposit: $");
			double amt = scan2.nextInt();
			double newB = a.getBalance() + amt;
			acc.deposit(a.getAcctNum(), newB);
			System.out.println("Transaction complete!");
			logger.info("Customer "+u.getUserName()+" deposited "+amt);
			customer(un);
		}
		else if(n==3) {
			Scanner scan3 = new Scanner(System.in);
			System.out.println();
			System.out.print("Enter amount to Transfer: $");
			double amt = scan3.nextInt();
			System.out.print("Enter account username to transfer to: ");
			String des = scan3.next();
			
			if(a.getBalance()-amt < 0) {
				System.out.println("Insufficent funds to process request!");
				customer(un);
			}
			double newB = a.getBalance() - amt;
			acc.withdraw(a.getAcctNum(), newB);
			
			User uu = new User();
			Account aa = new Account();
			uu = user.selectUserByName(des);
			aa = acc.getAccount(uu.getAcctNum());
			
			double newB2 = aa.getBalance() + amt;
			acc.deposit(aa.getAcctNum(), newB2);
			System.out.println("Transaction complete!");
			logger.info("Customer "+u.getUserName()+" transfered "+amt+" to customer"+uu.getUserName());
			customer(un);
		}
		else if(n==4) {
			System.out.println();
			start();
		}
	}
	
	public static void admin() {
		Scanner read = new Scanner(System.in);
		Employee e = new Employee();
		
		System.out.println();
		System.out.println("Iron Bank Admin Options");
		System.out.println("- Press 1 to approve account ");
		System.out.println("- Press 2 to deny account ");
		System.out.println("- Press 3 to view user information ");
		System.out.println("- Press 4 to withdraw");
		System.out.println("- Press 5 to deposit");
		System.out.println("- Press 6 transfer");
		System.out.println("- Press 7 to Return to Main Menu");
		System.out.print("Enter Option: ");
		int x = read.nextInt();		
		System.out.println();
		
		if(x==1) {
			EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
			User n = new User();
			Scanner p = new Scanner(System.in);
			System.out.println("***Account Approval***");
			System.out.print("Enter account username to approve: ");
			String input = p.nextLine();
			n.setUserName(input);
			employeeDaoImpl.approveUser(n);
			System.out.println("Account has been approved!");
			
			UserDaoImpl user = new UserDaoImpl();						//
			AccountDaoImpl acc = new AccountDaoImpl();					//
			User u = new User();										//
			Account a = new Account();									// Create Account in Database when user gets approved
			u = user.selectUserByName(n.getUserName());					//
			a.setAcctNum(u.getAcctNum());								//
			a.setUserName1(u.getUserName());							//
			a.setUserName2(null);										//
			acc.insertAccount(a);										//
			logger.info("Admin approved account"+n.getUserName());
			admin();
		}
		else if(x==2) {
			EmployeeDaoImpl temp = new EmployeeDaoImpl();
			User u = new User();
			Scanner in = new Scanner(System.in);
			System.out.println("***Account Denial***");
			System.out.print("Enter account username to deny: ");
			String s = in.nextLine();
			u.setUserName(s);
			temp.deleteUser(u);
			System.out.println("User was deleted!");
			logger.info("Admin denied/deleted account"+u.getUserName());
			admin();
		}
		else if(x==3) {
			User us = new User();
			EmployeeDaoImpl tem = new EmployeeDaoImpl();
			Scanner in = new Scanner(System.in);
			System.out.println("***Account Information***");
			System.out.print("Enter username you wish to spy on: ");
			String s = in.nextLine();
			us = tem.accountInfo(s);
			UserDaoImpl user = new UserDaoImpl();
			AccountDaoImpl acc = new AccountDaoImpl();
			User u = new User();
			Account a = new Account();
			u = user.selectUserByName(s);
			a = acc.getAccount(u.getAcctNum());
			System.out.println();
			System.out.println();
			System.out.println("Account Info collected on "+s+" - UserID: "+us.getUserid()+", Username: "+us.getUserName()+", Password: "+us.getPassword()+", FirstName: "+us.getFirstName()+", LastName: "+us.getLastName()+", UserKey: "+us.getUserKey()+", UserAcctStatus: "+us.getUserAcctStatus()+", SSN: "+us.getSsn()+", AcctNumber: "+us.getAcctNum());
			System.out.println("Account Balance Info collected on "+s+" - AcctNumber: "+a.getAcctNum()+", AcctBalance: "+a.getBalance());
			System.out.println();
			admin();
		}
		else if(x==4) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter account username to withdraw from: ");
			String un = scan.nextLine();
			UserDaoImpl user = new UserDaoImpl();
			AccountDaoImpl acc = new AccountDaoImpl();
			User u = new User();
			Account a = new Account();
			u = user.selectUserByName(un);
			a = acc.getAccount(u.getAcctNum());
			System.out.print("Enter amount to Withdraw: $");
			double amt = scan.nextInt();
			if(a.getBalance()-amt < 0) {
				System.out.println("Insufficent funds to process request!");
				admin();
			}
			double newB = a.getBalance() - amt;
			acc.withdraw(a.getAcctNum(), newB);
			System.out.println("Transaction complete!");
			logger.info("Admin forced Customer "+u.getUserName()+" to withdraw "+amt);
			admin();
		}
		else if(x==5) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter account user to deposit to: ");
			String un = scan.nextLine();
			UserDaoImpl user = new UserDaoImpl();
			AccountDaoImpl acc = new AccountDaoImpl();
			User u = new User();
			Account a = new Account();
			u = user.selectUserByName(un);
			a = acc.getAccount(u.getAcctNum());
			System.out.print("Enter amount to Deposit: $");
			double amt = scan.nextInt();
			double newB = a.getBalance() + amt;
			acc.deposit(a.getAcctNum(), newB);
			System.out.println("Transaction complete!");
			logger.info("Admin forced Customer "+u.getUserName()+" to deposited "+amt);
			admin();
		}
		else if(x==6) {
		}
		else if(x==7) {
			start();
		}
	}

}
