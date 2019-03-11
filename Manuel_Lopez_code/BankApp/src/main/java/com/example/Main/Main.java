package com.example.Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;
import com.exampel.Account.Account;
import com.example.People.Customer;
import com.example.User.User;

public class Main implements Serializable{
	
	final static Logger logger = Logger.getLogger(Main.class.getName());
	static Scanner reader = new Scanner(System.in);
	
	static ArrayList<User> userList = new ArrayList<User>();
	static ArrayList<Customer> customerList = new ArrayList();
	static ArrayList<Account> accountList = new ArrayList<Account>();
	

	public static void main(String[] args) {
		
		User user =new User();
		User user1 = new User();
		User user2 = new User();
		
		/*Customer x = new Customer();
		System.out.println(x.toString());
		double temp = x.getBalance();
		String y = x.getUserName();
		System.out.println(temp);
		System.out.println(y);
		System.out.println();*/
		
		user.setFirstName("Ragnar");
		user.setLastName("Lothbrok");
		user.setUserName("Ragnar_Lothbrok");
		user.setPassword("Viking1");
		user.setKey("2");
		userList.add(user);
		//System.out.println(userList.size());
		//System.out.println(userList);
		//System.out.println(userList.get(userList.size()-1));
		
		user1.setFirstName("Ivar");
		user1.setLastName("Lothbrok");
		user1.setUserName("Ivar_The_Boneless");
		user1.setPassword("Viking2");
		user1.setKey("1");
		userList.add(user1);
		//System.out.println(userList.size());
		//System.out.println(userList);
		//System.out.println(userList.get(userList.size()-1));
		
		user2.setFirstName("Bjorn");
		user2.setLastName("Lothbrok");
		user2.setUserName("Bjorn_Ironside");
		user2.setPassword("Viking3");
		userList.add(user2);
		//System.out.println(userList.size());
		//System.out.println(userList);
		//System.out.println(userList.get(userList.size()-1));
		
		start();

	}
	
	public static void addUser() {
		
	}
	
	public static void start() {
		//logger.info("Application was started");
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Press 1 to register - Press 2 to login - Press 3 to exit");
		System.out.print("Please input value: ");
		
		while(!reader.hasNextInt()) {														//keeps asking user for input if not integer
			System.out.println("Must eneter valid integer!");
			System.out.println("Press 1 to register - Press 2 to login - Press 3 to exit");
			System.out.print("Please input value: ");
			reader.next();								
		}
		int input = reader.nextInt();
		//System.out.println(input);
		if(input==1) {
			//System.out.println("in register");
			register();
		}
		else if(input==2) {
			//System.out.println("in login");
			login();
		}
		else if(input==3) {
			//System.out.println("in exit");
			logger.info("Application was exited");
			System.exit(0);
		}
		else
			start();
	}
	
	public static void register() {
		Scanner reader = new Scanner(System.in);
		User newUser = new User();
		String fn, ln, un, pw;
		System.out.println("Welcome to registration");
		System.out.print("Please enter the first name of the primary account holder: ");
		fn=reader.next();
		System.out.print("Please enter the last name of the primary account holder: ");
		ln=reader.next();
		System.out.print("Please enter the user name of the primart accounter holder: ");
		un=reader.next();
		System.out.print("Please enter the password of the primary account holder: ");
		pw=reader.next();
		
		newUser.setFirstName(fn);
		newUser.setLastName(ln);
		newUser.setUserName(un);
		newUser.setPassword(pw);
		userList.add(newUser);
		//logger.info("User was registered with firstName: "+fn+", lastName: "+ln+", userName: "+un+", password: "+pw);
		
		//System.out.println(userList.size());
		//System.out.println(userList);
		//System.out.println(userList.get(userList.size()-1));
		
		start();
	}
	
	public static void login() {
		Scanner reader = new Scanner(System.in);
    	System.out.print("Enter username: ");
    	String a=reader.next();
    	System.out.print("Enter password: ");
    	String b=reader.next();
    	
    	for(int i=0; i<userList.size(); i++) {
    		if(a.equals(userList.get(i).getUserName()) && b.equals(userList.get(i).getPassword())) {
    			//System.out.println("was able to log in");
    			//logger.info("User was able to login with username: "+a+", and password: "+b);
    			if(userList.get(i).getKey()=="2") {
    				//System.out.println("in admin");
    			}
    			else if(userList.get(i).getKey()=="1"){
    				//System.out.println("in employee");
    			}
    			else if(userList.get(i).getKey()==null) {
    				//System.out.println("in customer");
    				customerMenu(i);
    			}
    		}
    		/*else
    			System.out.println("Invalid Username or Password");
    			login();*/
    	}
	}
	
	public static void customerMenu(int userListIndex) {
		
		Scanner reader = new Scanner(System.in);
		String name;
		int depositAmount, withdrawlAmount, transferAmount;
		
		Customer c = new Customer();
		c.setUserName(userList.get(userListIndex).getUserName());
		name=c.getUserName();
		customerList.add(c);
		Boolean loop=false;
		//System.out.println(c.getUserName());
		//System.out.println();
		//String temp = c.getUserName();
		//System.out.println(temp);
		while(loop==false) {
			System.out.println("Hello "+name+"!!!");
			System.out.println("Customer balance is $"+c.getBalance());
			System.out.println("1. Make a deposit");
			System.out.println("2. Make a withdrawl");
			System.out.println("3. Transfer");
			System.out.println("4. Logout");
			System.out.print("What would you like to do: ");
			
			while(!reader.hasNextInt()) {														//keeps asking user for input if not integer
				System.out.println("Must eneter valid integer!");
				System.out.println("Customer balance is $"+c.getBalance());
				System.out.println("1. Make a deposit");
				System.out.println("2. Make a withdrawl");
				System.out.println("3. Transfer");
				System.out.println("4. Logout");
				System.out.print("What would you like to do: ");								
			}
			int input = reader.nextInt();
			//System.out.println(input);
			if(input==1) {
				//System.out.println("in make deposit");
				System.out.print("Please enter amount to deposit: $");
				depositAmount = reader.nextInt();
				c.makeDeposit(depositAmount);
				//logger.info("Customer "+c.getUserName()+" was able to make deposit");
				//customerMenu(userListIndex);
				//System.out.println(c);
				//System.out.println(c.toString());
				//System.out.println(c.getBalance());
			}
			else if(input==2) {
				//System.out.println("in withdrawl");
				System.out.print("Please enter amount to withdrawl: $");
				withdrawlAmount = reader.nextInt();
				if(withdrawlAmount > c.getBalance()) {
					System.out.println("Insufficient funds to process transaction!");
					//logger.info("Customer "+c.getUserName()+" was unable to make withdrawl");
				}
				else {
					c.makeWithdrawl(withdrawlAmount);
					//logger.info("Customer "+c.getUserName()+" was able to make withdrawl");
				}
				//customerMenu(userListIndex);
				//System.out.println(c);
				//System.out.println(c.toString());
				//System.out.println(c.getBalance());
			}
			else if(input==3) {
				System.out.println("in transfer");
			}
			else if(input==4){
				//System.out.println("in logout");
				//logger.info("Customer "+c.getUserName()+" logged out");
				start();
			}
			else {
				customerMenu(userListIndex);
			}
		}
	}

}
