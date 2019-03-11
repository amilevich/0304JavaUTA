package com.project.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.project.user.Account;
import com.project.user.Admin;
import com.project.user.Customer;
import com.project.user.Employee; 

public class Main {
public static void main(String[] args) {
		
	
	Map <String,String[]> hashMapUser = new HashMap<>(); //stores user info: password as key; location, name, username, type in String Array
	Map <String, Integer> Accounts = new HashMap<>(); //stores customer account info and references customer's password and account balance
	
	hashMapUser.put("070694", new String[] {"ksung24","070694","Kevin Sung", "customer"});
	//putting some data to test
	hashMapUser.put("abcdef", new String[] {"ejeon2","abcdef","Eunice Jeon", "customer"}); 
	hashMapUser.put("123456", new String[] {"dlee2","123456","Daniel Lee", "admin"}); 
	hashMapUser.put("123421", new String[] {"pding234","123421","Paolo Smith", "employee"}); 
	
	Accounts.put("ksung24",90);
	Accounts.put("ejeon2",420);

	String userName = null; //initializing variables
	String password = null;
	String name = null;
	String type= null;
	float balance = 0;
	
	Scanner start = new Scanner(System.in); 
	System.out.println("register or login?");
	String startAction = start.nextLine(); 
	switch(startAction) {
		case "register":
			String typeforReg = "customer";
			Scanner regname = new Scanner(System.in); //user inputs for name, username, password
			System.out.println("Full Name?");
			String rgnme = regname.nextLine(); 
			
			Scanner register = new Scanner(System.in); 
			System.out.println("Desired Username?");
			String reg = register.nextLine(); 
			
			Scanner pass = new Scanner(System.in); 
			System.out.println("Desired Password?");
			String ps = pass.nextLine();
			
			register(rgnme,reg, ps, typeforReg,hashMapUser,Accounts);
			break;
		default:
			break;
				
	}
	
    Scanner myObj = new Scanner(System.in); 
    System.out.println("Enter username");
    String userInput = myObj.nextLine(); // username  
	    
 
	 Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter password");
    String passwordInput = myObj2.nextLine();   //password
    
    for (String[] value : hashMapUser.values()) { //loops through and checks for the username and password
	   if(value[0].equals(userInput) && value[1].equals(passwordInput)) {
		   userName = value[0];
		   password= value[1];
		   name=value[2];
		   type= value[3];
		   if(type.equals("customer")) {
			   balance += Accounts.get(userName);
		   }
		   
	   	}  
	  }
    
    switch(type) {
    case "employee" :
    	employeeFunction(userName, password, name, type,hashMapUser, Accounts); //based on the type of employee, different methods are called
   	    	break;
    	
    case "admin" :
    	adminFunction(userName, password, name, type,hashMapUser, Accounts);
    		break;
    case "customer":
    	customerFunction(userName, password, name, type, balance,Accounts);
    		break;
   	   }
	}
	
//	public static void start (Map <String,String[]> hashMapUser, Map <String, Integer> Accounts) {
//		String userName = null; //initializing variables
//		String password = null;
//		String name = null;
//		float balance = 0;
//		
//		Scanner start = new Scanner(System.in); 
//		System.out.println("register or login?");
//		String startAction = start.nextLine(); 
//		switch(startAction) {
//			case "register":
//				String typeforReg = "customer";
//				Scanner regname = new Scanner(System.in); //user inputs for name, username, password
//				System.out.println("Full Name?");
//				String rgnme = regname.nextLine(); 
//				
//				Scanner register = new Scanner(System.in); 
//				System.out.println("Desired Username?");
//				String reg = register.nextLine(); 
//				
//				Scanner pass = new Scanner(System.in); 
//				System.out.println("Desired Password?");
//				String ps = pass.nextLine();
//				
//				register(rgnme,reg, ps, typeforReg,hashMapUser,Accounts);
//			case "login" : 
//				String type = null;
//				Scanner myObj = new Scanner(System.in); 
//			    System.out.println("Enter username");
//			    String userInput = myObj.nextLine(); // username  
//				    
//			 
//				Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
//			    System.out.println("Enter password");
//			    String passwordInput = myObj2.nextLine();   //password
//			    
//			    for (String[] value : hashMapUser.values()) { //loops through and checks for the username and password
//				   if(value[0].equals(userInput) && value[1].equals(passwordInput)) {
//					   name = value[0];
//					   password= value[1];
//					   userName=value[2];
//					   type= value[3];
//					   if(type.equals("customer")) {
//						   System.out.println(Accounts.get(userName));
//						   balance += Accounts.get(userName);
//					   }
//					   
//				   	}  
//				  }
//			    
//			    switch(type) {
//			    case "employee" :
//			    	employeeFunction(userName, password, name, type,hashMapUser, Accounts); //based on the type of employee, different methods are called
//			   	    	break;
//			    	
//			    case "admin" :
//			    	adminFunction(userName, password, name, type,hashMapUser, Accounts);
//			    		break;
//			    case "customer":
//			    	customerFunction(userName, password, name, type, balance,Accounts);
//			    		break;
//			   	   }
//			default:
//				System.out.println("Invalid Command");
//				start(hashMapUser,Accounts);
//		}
//		
//	    
//	}
	
	public static void register(String name, String username, String password, String type, Map <String, String[]> map, Map <String, Integer> map2) {
		String[]arr= {username, password, name, type}; 
		map.put(password, arr);
		map2.put(username, 0);
		System.out.println("Your Account has been registered successfully. Please Sign back in to perform actions. Your session will be terminated");
		System.exit(0);
	}
	
	public static void employeeFunction(String userName, String password, String name, String type, Map <String,String[]> map,  Map <String,Integer> map2  ) {
		Employee employee = new Employee(userName, password, name, type);
    	Scanner emp = new Scanner(System.in);  // Create a Scanner object
   	    System.out.println("What would you like to do? (customerlist, accountretrieval)");
   	    String actionemp  = emp.nextLine(); 
   	    	switch(actionemp) {
   	    		case "customerlist" :
   	    			employee.viewCustomers(map);
   	    			break;
   	    		case "accountretrieval" :
   	    			Scanner retrieval = new Scanner(System.in);
   	    			System.out.println("What is the username of the person's account you would like to view?");
   	    			String retrieve  = retrieval.nextLine(); 
   	    			employee.viewCustomerAccount(retrieve, map2);
   	    		default: 
   	    			System.out.println("Invalid");
   	    	}
   	   Scanner question = new Scanner(System.in);  // Create a Scanner object
   	   System.out.println("Would you like to perform another action? (yes or no)");
   	   String actionemp1  = question.nextLine(); 
   	   
   	   switch(actionemp1) {
   	   		case "yes": 
   	   			employeeFunction(userName, password, name, type,map,map2);
   	   }
	}
	
	public static void customerFunction(String userName, String password, String name, String type, float balance, Map <String, Integer> map) {
		System.out.println("Hello " + name + "!" + "Your Account Balance is: " + balance);
		Customer customer = new Account(userName, password, name, type);
    	Account account = new Account(userName, password, name, type, balance);
    	
    	Scanner myObj4 = new Scanner(System.in);  // Create a Scanner object
   	    System.out.println("What would you like to do? (deposit, withdraw, terminate)");
   	    String action  = myObj4.nextLine(); 
   	    switch (action) {
   	    	case "deposit":
   	    		Scanner myObj5 = new Scanner(System.in);
   	    		System.out.println("How much would you like to deposit?"); 
   	    		float amount = myObj5.nextFloat(); //amount to be deposited
   	    		account.deposit(amount);
   	    		System.out.println("Your new balance is: " + account.getBalance());
   	    		map.put(userName,(int) account.getBalance()); //updates map
   	    		System.out.println(map);
   	    		break;
   	    		
   	    	case "withdraw":
   	    		Scanner myObj6 = new Scanner(System.in);
   	    		System.out.println("How much would you like to withdraw?");
   	    		int amount2 = myObj6.nextInt();
   	    		account.withdraw(amount2);
   	    		map.put(userName,(int) account.getBalance()); //updates map
   	    		System.out.println("Your balance is:" + account.getBalance());
   	    		break;	
   	     default:
 	    	System.out.println("Invalid Command");
 	    } 
   	    
   	 Scanner question = new Scanner(System.in);  // Create a Scanner object
 	   System.out.println("Would you like to perform another action? (yes or no)");
 	   String actionemp1  = question.nextLine(); 
 	   
 	   switch(actionemp1) {
 	   		case "yes": 
 	   			customerFunction(userName, password, name, type,balance, map);
 	   }
	}
	
	public static void adminFunction(String userName, String password, String name, String type, Map <String, String[]> map, Map <String,Integer> map2) {
		Admin admin = new Admin(userName, password, name, type);
    	Scanner emp = new Scanner(System.in);  // Create a Scanner object
   	    System.out.println("What would you like to do? (customerlist, accountretrieval, withdraw, deposit)");
   	    String actionemp  = emp.nextLine(); 
   	    	switch(actionemp) {
   	    		case "customerlist" :
   	    			admin.viewCustomers(map);
   	    			break;
   	    		case "accountretrieval" :
   	    			Scanner retrieval = new Scanner(System.in);
   	    			System.out.println("What is the username of the person's account you would like to view?");
   	    			String retrieve  = retrieval.nextLine(); 
   	    			admin.viewCustomerAccount(retrieve, map2);
   	    			break;
   	    		case "deposit":
   	    			float balance = 0;
   	    			float amount;
   	    			float newBalance;
   	    			boolean bool = false;
   	    			Scanner nme = new Scanner(System.in);
   	    			System.out.println("What is the username of the person's account you would like to deposit into?");
   	    			String names  = nme.nextLine(); 
   	    			Iterator it = map2.entrySet().iterator();
   	    		    while (it.hasNext()) {
   	    		        Map.Entry pair = (Map.Entry)it.next();
   	    		        if (pair.getKey().equals(names)) {
   	    		           // System.out.println(pair.getKey() + " has an account balance of: " + pair.getValue());
   	    		        	balance=(int) pair.getValue();
   	    			        it.remove(); // avoids a ConcurrentModificationException
   	    			        bool= true;
   	    		        } 
   	    		       
   	    		    }
   	    		    if(bool) {
	   	    		 	Scanner deposit = new Scanner(System.in);
	   	    			System.out.println("How Much?");
	   	    			amount  = deposit.nextFloat();
	   	    			newBalance = admin.deposit(amount,balance);
	   	    			System.out.println("New Balance is:" + newBalance);
	   	    			map2.put(names, (int) newBalance);
   	    		    }
   	    		    break;
   	    		case"withdraw" :
   	    			float balance2 = 0;
   	    			float amount2 = 0;
   	    			float newBalance2;
   	    			boolean bool2 = false;
   	    			Scanner nme2 = new Scanner(System.in);
   	    			System.out.println("What is the username of the person's account you would like withdraw from?");
   	    			String nm2  = nme2.nextLine(); 
   	    			Iterator it2 = map2.entrySet().iterator();
   	    		    while (it2.hasNext()) {
   	    		        Map.Entry pair = (Map.Entry)it2.next();
   	    		        if (pair.getKey().equals(nm2)) {
   	    		           // System.out.println(pair.getKey() + " has an account balance of: " + pair.getValue());
   	    		        	balance2=(int) pair.getValue();
   	    			        it2.remove();
   	    			     bool2=true;// avoids a ConcurrentModificationException
   	    		        } 
   	    		    }
   	    		    if(bool2) {
	   	    		 	Scanner withdraw = new Scanner(System.in);
	   	    			System.out.println("How Much?");
	   	    			amount2  = withdraw.nextFloat();
	   	    			System.out.println();
	   	    			newBalance2 = admin.withdraw(amount2,balance2);
	   	    			System.out.println("New Balance is:" + newBalance2);
	   	    			map2.put(nm2, (int) newBalance2);
   	    		    } else {
   	    		    	System.out.println("Invalid Username");
   	    		    }
   	    		    break;
   	    		
   	    	}
   	   Scanner question = new Scanner(System.in);  // Create a Scanner object
   	   System.out.println("Would you like to perform another action? (yes or no)");
   	   String actionemp1  = question.nextLine(); 
   	   
   	   switch(actionemp1) {
   	   		case "yes": 
   	   			adminFunction(userName, password, name, type,map,map2);
   	   }
		
		
	}
}
