package com.example.driver;


import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.example.dao.AccountDaoImpl;
import com.example.dao.EmployeeDaoImpl;
import com.example.dao.PetDaoImpl;
import com.example.model.Account;
import com.example.model.Employee;
import com.example.model.Pet;

public class Main {

	final static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Pet petOne = new Pet("New", "Newly");

//		petOne.setPet_id(50);
//		System.out.println(petOne);
		//Pet petTwo = new Pet(null, "Jimmy", "Centipede");	
		//Pet petThree = new Pet(null, "Frank", "Doggo");
		
		
//		###########    Here are the possible Logger outputs to use:   #############################
//		if(logger.isInfoEnabled()) {
//			logger.info("this is info");
//		}
//		
		logger.info("Main.java started running.\n");
//		logger.error("message about error ", new IndexOutOfBoundsException());
//		logger.fatal("fatal message");
//		logger.warn("warning message");
		
//		###########################################################################################
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
		AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		
		Pet s = petDaoImpl.selectPetById(1);
		
//		System.out.println(s);
		
//		petDaoImpl.insertPet(petOne);
//		petDaoImpl.insertPet(petTwo);
//		petDaoImpl.insertPet(petThree);
		
//		petDaoImpl.deletePetByName(petOne);
//		petDaoImpl.deletePetById(s);
		


		//System.out.println(s);

		
		//System.out.println(petDaoImpl.selectAllPets());
		
//		petOne.setType("Hamster");
		s.setName("Jarbit");
		s.setType("Robturkey");
		s.setHasAccount("1");
		petDaoImpl.updatePetNameWhereId(s);
		
		List<Pet> pets = petDaoImpl.selectAllPets();
		List<Account> accounts = accountDaoImpl.selectAllAccounts();
		List<Employee> employees = employeeDaoImpl.selectAllEmployees();
		
		
		printArray(pets);
		printArrayAccounts(accounts);
		printArrayEmployees(employees);
		
		
		
		//==========================================================================================		
		//==========================================================================================
		//==========================================================================================		
		
		Scanner scan = new Scanner(System.in);
		String ans;
		boolean cycle1 = true;
		boolean cycle2 = true;
		boolean loggedin = false;
		
		System.out.println("                                   /\\\r\n" + 
				"                              /\\  //\\\\\r\n" + 
				"                       /\\    //\\\\///\\\\\\        /\\\r\n" + 
				"                      //\\\\  ///\\////\\\\\\\\  /\\  //\\\\\r\n" + 
				"         /\\          /  ^ \\/^ ^/^  ^  ^ \\/^ \\/  ^ \\\r\n" + 
				"        / ^\\    /\\  / ^   /  ^/ ^ ^ ^   ^\\ ^/  ^^  \\\r\n" + 
				"       /^   \\ We Have Your Money... So You Dont Have To ©   *\r\n" + 
				"      /  ^ ^ \\/^  ^\\ ^ ^ ^   ^  ^   ^   ____  ^   ^  \\     /|\\\r\n" + 
				"     / ^ ^  ^ \\ ^  _\\___________________|  |_____^ ^  \\   /||o\\\r\n" + 
				"    / ^^  ^ ^ ^\\  /__Mountainous Graft Banking___\\ ^ ^ \\ /|o|||\\\r\n" + 
				"   /  ^  ^^ ^ ^  /______________Inc.______________\\  ^  /|||||o|\\\r\n" + 
				"  /^ ^  ^ ^^  ^    ||___|___||||||||||||___|__|||      /||o||||||\\\r\n" + 
				" / ^   ^   ^    ^  ||___|___||||||||||||___|__|||          | |\r\n" + 
				"/ ^ ^ ^  ^  ^  ^   ||||||||||||||||||||||||||||||oooooooooo| |ooooooo\r\n" + 
				"ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		System.out.println("\n|+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|");
		System.out.println("|++ Welcome to the Mountainous Graft Banking Application: ++|");
		System.out.println("|+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|");
		System.out.print("\nGreetings Application User!");
		
		String uname;
		String pword;
		Pet currentUser = null;
		Employee currentEmployee = null;
		
		while (cycle1 && !loggedin) {
			
			System.out.print("\nLogin as one of the following: 1 = Customer, 2 = Employee, 3 = Exit, 4 = Register \n>_");
			
			ans = scan.next().toLowerCase().trim();
			switch(ans) {
			
			case "1": case "customer":
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("|#############################|");
				System.out.println("|##  Customer Portal Login  ##|");
				System.out.println("|#############################|");
				System.out.println("\nEnter your Username: ");
				uname = scan.next();
				System.out.println("Enter your Password: ");
				pword = scan.next();
				System.out.println(uname +" "+ pword);
				
				for (Pet elem : pets) {
					if (elem.getName().equals(uname) && elem.getPassword().equals(pword)) {
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						System.out.println("Welcome! " + elem.getName() + " " + elem.getType() + ", logging you in....");
						currentUser = elem;
						logger.info("Customer logged in with name: \"" + elem.getName() + " " + elem.getType() + "\"");

						if (elem.getAccountApproved().equals("0")) {
							printWait();
							System.out.println("*******************************************************");
							System.out.println("******** Your account is still pending approval *******");
							System.out.println("******** But we can't wait to have your money *********");
							System.out.println("*******************************************************");
						}
						
						cycle1 = false;
						break;
					}					
				}
				
				if (cycle1) {
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("**** Incorrect Username and Password combination ****");
					System.out.println("\nPlease Try Again");
					logger.warn("Failed Login attemp using name: \"" + uname + "\", and password \"" + pword + "\"");
				}
				
				break;
				
			case "2": case "employee":
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("|@@@@@@@@@@@@@@@@@@@@@@@@@@|");
				System.out.println("|@@    Employee Portal   @@|");
				System.out.println("|@@@@@@@@@@@@@@@@@@@@@@@@@@|");
				System.out.println("\nEnter your Username: ");
				uname = scan.next();
				System.out.println("Enter your Password: ");
				pword = scan.next();
				System.out.println(uname +" "+ pword);
				
				for (Employee elem : employees) {
					if (elem.getFirstname().equals(uname) && elem.getPassword().equals(pword)) {
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						System.out.println("Welcome! Employee " + elem.getFirstname() + " " + elem.getLastname() + ", logging you in....");
						currentEmployee = elem;
						logger.info("Employee logged in with name: \"" + elem.getFirstname() + " " + elem.getLastname() + "\"");
						cycle1 = false;
					}					
				}
				
				if (cycle1) {
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("**** Incorrect Username and Password combination ****");
					System.out.println("\nPlease Try Again");
					logger.warn("Failed Login attemp using name: \"" + uname + "\", and password \"" + pword + "\"");
					
				}
				break;
				
			case "3": case "exit":
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				printBye();
				System.out.println("\n\n|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
				System.out.println("|-=-=-=-=-=-= Exiting System =-=-=-=-=-=-|");
				System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=| \n");
				
				cycle1 = false;
				cycle2 = false;
				break;
				
			case "4": case "register":
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("We are not accepting new customers at this time...");
				System.out.println("Ill have this working before presenting on wednesday");
				
			default:
				
			}
			
		}
		cycle1 = true;
		
		Pet customer;
		int numans;
		
		while (currentEmployee != null) {
			
			
			//============================================================================
			//=====================  STAFF LOGGED IN  ===================================
			//============================================================================
			//============================================================================
			
			while (currentEmployee.getType().equals("Staff") && cycle1) {
				
				System.out.println("--- Staff Menu Options ---"
						+ "\n--------------------------\nSelect an action:");
				System.out.print("1 = View Accounts, \n2 = View Customers, \n3 = Approve Accounts,\n4 = Deny Accounts,\n5 = Exit \n>_");
				
				ans = scan.next().toLowerCase().trim();
				
				switch(ans) {
				case "1": case "view accounts":
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("|---- Accounts Information ----");
					printArrayAccounts(accounts);
					break;
				case "2": case "view customers":
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("|---- Customers Information ----");
					printArray(pets);
					break;
				case "3": case "approve accounts":
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("|---- Accounts Awaiting Approval ----");
					printArrayAccountsToApprove(pets);
					
					System.out.println("Select ID of customer to approve their account:");
					
					numans = scan.nextInt();
					
					customer = petDaoImpl.selectPetById(numans);
					
					for (Pet p : pets) {
						if ( p.isHasAccount().equals("1") && p.getAccountApproved().equals("0")) {
							
							if (customer == null) {
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("*** ERROR: Invalid Selection ***\n"
										+ "*** Customer Does Not Exist ***");
								break;
							}
							else if ( customer.getPet_id() != (p.getPet_id())){
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("*** Invalid Selection.. ***\n"
										+ "*** That Account is not awaiting approval. ***");
								break;
							}else {
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("************************");
								System.out.println("*** Account Approved ***");
								System.out.println("************************");
								logger.info("Employee: " + currentEmployee.getEmp_id() + ", ID: " 
										+  currentEmployee.getFirstname()
										+ " approved account for: \"" + p.getName() + " " + p.getType() + "\"");
								
								customer.setAccountApproved("1");
								petDaoImpl.updatePetNameWhereId(customer);
								pets = petDaoImpl.selectAllPets();
								
//								cycle1 = false;
								break;
							}
						}
					}
					
					break;
				case "4": case "deny account":
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("|---- Accounts Awaiting Approval ----");
					printArrayAccountsToApprove(pets);
					
					System.out.println("Select ID of customer to DENY their account:");
					
					numans = scan.nextInt();
					
					customer = petDaoImpl.selectPetById(numans);
					
					for (Pet p : pets) {
						if ( p.isHasAccount().equals("1") && p.getAccountApproved().equals("0")) {
							
							if (customer == null) {
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("*** ERROR: Invalid Selection ***\n"
										+ "*** Customer Does Not Exist ***");
								break;
							}
							else if ( customer.getPet_id() != (p.getPet_id())){
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("*** Invalid Selection.. ***\n"
										+ "*** That Account is not awaiting approval. ***");
								break;
							}else {
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("************************");
								System.out.println("*** Account Denied ***");
								System.out.println("************************");
								logger.info("Employee: " + currentEmployee.getFirstname() + ", denied account for:  " + p.getName());
								customer.setHasAccount("0");
								petDaoImpl.updatePetNameWhereId(customer);
								pets = petDaoImpl.selectAllPets();
								
//								cycle1 = false;
								break;
							}
						}
					}
					
					break;
				case "5": case "exit":
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					printBye();
					System.out.println("\n\n|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					System.out.println("|-=-=-=-=-=-= Exiting System =-=-=-=-=-=-|");
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=| \n");
					logger.info("Employee: " + currentEmployee.getFirstname() + " Exited the System.");
					cycle1 = false;
					break;
					

				}
			}
			
			//============================================================================
			//=====================   ADMIN LOGGED IN  ===================================
			//============================================================================
			//============================================================================
			
			while (currentEmployee.getType().equals("Admin") && cycle1) {
				
				
				System.out.println("--- Admin Menu Options ---"
						+ "\n--------------------------\nSelect an action:");
				System.out.print("1 = View Accounts, \n2 = View Customers, \n3 = Approve Accounts,\n4 = Deny Accounts,"
						+ "\n5 = Delete Customer, \n6 = Delete Employee, \n7 = Cancel Account,\n8 = Exit \n>_");
				
				ans = scan.next().toLowerCase().trim();
				
				switch(ans) {
				case "1": case "view accounts":
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("|---- Accounts Information ----");
					printArrayAccounts(accounts);
					break;
				case "2": case "view customers":
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("|---- Customers Information ----");
					printArray(pets);
					break;
				case "3": case "approve accounts":
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("|---- Accounts Awaiting Approval ----");
					printArrayAccountsToApprove(pets);
					
					System.out.println("Select ID of customer to approve their account:");
					
					numans = scan.nextInt();
					
					customer = petDaoImpl.selectPetById(numans);
					
					for (Pet p : pets) {
						if ( p.isHasAccount().equals("1") && p.getAccountApproved().equals("0")) {
							
							if (customer == null) {
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("*** ERROR: Invalid Selection ***\n"
										+ "*** Customer Does Not Exist ***");
								break;
							}
							else if ( customer.getPet_id() != (p.getPet_id())){
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("*** Invalid Selection.. ***\n"
										+ "*** That Account is not awaiting approval. ***");
								break;
							}else {
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("************************");
								System.out.println("*** Account Approved ***");
								System.out.println("************************");
								logger.info("Employee: " + currentEmployee.getFirstname() + ", approved account for:  " + p.getName());
								customer.setAccountApproved("1");
								petDaoImpl.updatePetNameWhereId(customer);
								pets = petDaoImpl.selectAllPets();
								
//								cycle1 = false;
								break;
							}
						}
					}
					
					break;
				case "4": case "deny account":
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("|---- Accounts Awaiting Approval ----");
					printArrayAccountsToApprove(pets);
					
					System.out.println("Select ID of customer to DENY their account:");
					
					numans = scan.nextInt();
					
					customer = petDaoImpl.selectPetById(numans);
					
					for (Pet p : pets) {
						if ( p.isHasAccount().equals("1") && p.getAccountApproved().equals("0")) {
							
							if (customer == null) {
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("*** ERROR: Invalid Selection ***\n"
										+ "*** Customer Does Not Exist ***");
								break;
							}
							else if ( customer.getPet_id() != (p.getPet_id())){
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("*** Invalid Selection.. ***\n"
										+ "*** That Account is not awaiting approval. ***");
								break;
							}else {
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("************************");
								System.out.println("*** Account Denied ***");
								System.out.println("************************");
								
								logger.info("Employee: " + currentEmployee.getFirstname() + ", denied account for:  " + p.getName());
								customer.setHasAccount("0");
								petDaoImpl.updatePetNameWhereId(customer);
								pets = petDaoImpl.selectAllPets();
								
//								cycle1 = false;
								break;
							}
						}
					}
					
					break;
				case "5": case "delete customer":
					
					System.out.println("Deleting Customer");
					printArray(pets);
					System.out.println("Choose ID of Customer to DELETE:");
					numans = scan.nextInt();
					Pet a = petDaoImpl.selectPetById(numans);
					
					for (Pet p : pets) {
						if (a == null) {
							System.out.println("*** That Customer doesnt exist ***");
							
							break;
						}else if (p.getPet_id() == numans) {
							logger.info("Employee: " + currentEmployee.getFirstname() + ", Deleted Customer:  " + p.getName());
							petDaoImpl.deletePetById(a);
							pets = petDaoImpl.selectAllPets();
							accounts = accountDaoImpl.selectAllAccounts();
							
							
							break;
						}
					}

					
					break;
				case "6": case "delete employee":
					
					System.out.println("Deleting Employee");
					printArrayEmployees(employees);
					System.out.println("Choose ID of Employee to DELETE:");
					numans = scan.nextInt();
					Employee e = employeeDaoImpl.selectEmployeeById(numans);
					
					for (Employee p : employees) {
						if (e == null) {
							System.out.println("*** That Employee doesnt exist ***");
							
							break;
						}else if (p.getEmp_id() == numans) {
							logger.info("Employee: " + currentEmployee.getFirstname() + ", Deleted Employee:  " + p.getFirstname());
							employeeDaoImpl.deleteEmployeeById(e);
							employees = employeeDaoImpl.selectAllEmployees();
							
							
							break;
						}
					}
					break;
				case "7": case "cancel account":
					System.out.println("Deleting Account");
					printArrayAccounts(accounts);
					System.out.println("Choose ID of Account to DELETE:");
					numans = scan.nextInt();
					Account b = accountDaoImpl.selectAccountById(numans);
					
					for (Account p : accounts) {
						if (b == null) {
							System.out.println("*** That Employee doesnt exist ***");
							
							break;
						}else if (p.getAcc_id() == numans) {

							logger.info("Employee: " + currentEmployee.getFirstname() + ", Deleted Account:  " + p.getAcc_id());
							accountDaoImpl.deleteAccountById(b);
							accounts = accountDaoImpl.selectAllAccounts();
							
							break;
						}
					}
					break;
					
				case "8": case "exit":
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					printBye();
					System.out.println("\n\n|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					System.out.println("|-=-=-=-=-=-= Exiting System =-=-=-=-=-=-|");
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=| \n");
					
					cycle1 = false;
					break;

				}
				
			}
			
			currentEmployee = null;
		}
		
		cycle1 = false;
		
		if (currentUser != null && currentUser.isHasAccount().equals("0")) {
			
			while (cycle2 && currentUser.isHasAccount().equals("0")) {
				
				System.out.print("\nHow may we help you today?");
				System.out.print("\n\n1 = Request Account, \n2 = Exit \n>_");
				
				ans = scan.next().toLowerCase().trim();
				
				
				switch(ans) {
				case "1": case "request account":
					System.out.println("\nAccount Requested\nPlease await approval.");
				
					currentUser.setHasAccount("1");
					petDaoImpl.updatePetNameWhereId(currentUser);
					
					Account newAcc = new Account(currentUser.getPet_id(), 0.01);
					
					accountDaoImpl.insertAccount(newAcc); 
					cycle2 = false;
					break;
				case "2": case "exit":
					
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					printBye();
					System.out.println("\n\n|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					System.out.println("|-=-=-=-=-=-= Exiting System =-=-=-=-=-=-|");
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=| \n");
					
					cycle2 = false;
					break;
					
				}
			}
			
		}
		
		
		//============================================================================
		//=====================   CUSTOMER LOGGED IN  ===================================
		//============================================================================
		//============================================================================
		
		
		cycle1 = true;
		if (currentUser != null) {

			while (cycle1 && (!currentUser.isHasAccount().equals("0") 
					&& currentUser.getAccountApproved().equals("1"))) {
	
				double dubans;
				Account acc;
				Pet chosenAcc = null;
				
				System.out.print("\nHow may we help you today?");
				System.out.print("\n\n1 = View Balance, \n2 = Withdraw, \n3 = Deposit, \n4 = Transfer, \n5 = Exit \n>_");
				
			
				
				ans = scan.next().toLowerCase();
				
				switch(ans) {
				
				case "1": case "view balance":
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("|==================================|");
					System.out.println("|=== Your Balance is: $" +
					seeBalance(currentUser, accounts) + " ===| "
					);
					System.out.println("|==================================|");

					break;
					
				case "2": case "withdraw":
					
					System.out.println("Enter the amount you want to withdraw:");
					dubans = scan.nextDouble();
					
					acc = withdraw(currentUser, accounts, dubans);
					
					accountDaoImpl.updateAccountWhereId(acc);
					break;
					
				case "3": case "deposit":
					System.out.println("Enter the amount you want to deposit:");
					dubans = scan.nextDouble();
					
					acc = deposit(currentUser, accounts, dubans);
					
					accountDaoImpl.updateAccountWhereId(acc);

					break;
					
				case "4": case "transfer":
					System.out.println("Enter the amount you want to Transfer:");
					dubans = scan.nextDouble();
					
					System.out.println("Enter Name of whom you would like to transfer money to:");
					
					ans = scan.next();
					for (Pet p : pets) {
						if (p.getName().equals(ans)) {
							chosenAcc = p;
							break;
						}
					}
					
					if (chosenAcc != null) {
						transfer(currentUser, chosenAcc, accounts, dubans, accountDaoImpl);
					}else {
						System.out.println("|***  That User Does not Exist  ***|");
					}
					
					break;
					
				case "5": case "exit":
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					printBye();
					System.out.println("\n\n|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
					System.out.println("|-=-=-=-=-=-= Exiting System =-=-=-=-=-=-|");
					System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=| \n");
					
					cycle2 = false;
					cycle1 = false;
					break;
					
				default:
					
				}
			}
		
		}
	}
	
	
//	########################################################################################
//	########################### MAIN CLASS METHODS TO PRINT INFO ###########################
//	########################################################################################
	
	public static void printArray(List<Pet> a) {
		System.out.println("| Customer ID |  Password  | hasAccount |   Approved   |    Customer Name    |"
				+ "  \n|------------------------------------------------------------------------");
		for (Pet elem : a) {
			
			System.out.println("| \t" + elem.getPet_id()  + "\t  " + elem.getPassword() 
							+ "\t\t" + elem.isHasAccount()
							+ "\t\t" + elem.getAccountApproved()
							+ "\t " + elem.getName() 
							+ " " + elem.getType()
							);
		}
		System.out.println("|---------------------------------------------------------------------");
	}
	
	

	public static void printArrayAccounts(List<Account> a) {
		System.out.println("| Account ID |  Customer ID  | Balance "
				+ "  \n|------------------------------------------------------------------------");
		for (Account elem : a) {
			
			System.out.println("| \t" + elem.getAcc_id() + "\t  " + elem.getPet_id()
							+ "\t\t" + elem.getBalance());

		}
		System.out.println("|---------------------------------------------------------------------");
	}
	
	public static void printArrayAccountsToApprove(List<Pet> p) {
		System.out.println("| Account ID |  Customer ID  | Balance "
				+ "  \n|------------------------------------------------------------------------");
		for (Pet elem : p) {
			if (elem.isHasAccount().equals("1") && elem.getAccountApproved().equals("0")) {
			System.out.println("| \t" + elem.getName() + "\t  " + elem.getPet_id()
							+ "\t\t" + elem.getPassword() );
			}
		}
		System.out.println("|---------------------------------------------------------------------");
	}
	
	public static void printArrayEmployees(List<Employee> e) {
		System.out.println("| Employee ID |   Password   |    Type     |       Name       | "
				+ "  \n|------------------------------------------------------------------------");
		for (Employee elem : e) {
			
			System.out.println("| \t" + elem.getEmp_id() + "\t  " + elem.getPassword()
							+ "\t\t" + elem.getType() + "\t\t " + elem.getFirstname() 
							+ " " + elem.getLastname());

		}
		System.out.println("|---------------------------------------------------------------------");
	}

	public static void printBye() {
		System.out.println("                                               _\r\n" + 
				"                 ___                          (_)\r\n" + 
				"               _/XXX\\\r\n" + 
				"_             /XXXXXX\\_                                    __\r\n" + 
				"X\\__    __   /X XXXX XX\\                          _       /XX\\__      ___\r\n" + 
				"    \\__/  \\_/__       \\ \\                       _/X\\__   /XX XXX\\____/XXX\\\r\n" + 
				"  \\  ___   \\/  \\_      \\ \\               __   _/      \\_/  _/  -   __  -  \\__/\r\n" + 
				" ___/   \\__/   \\ \\__     \\\\__           /  \\_//  _ _ \\  \\     __  /  \\____//\r\n" + 
				"/  __    \\  /     \\ \\_   _//_\\___     _/    //           \\___/  \\/     __/\r\n" + 
				"__/_______\\________\\__\\_/________\\_ _/_____/_____________/_______\\____/_______\r\n" + 
				"                                  /|\\\r\n" + 
				"                                 / | \\\r\n" + 
				"                                /  |  \\\r\n" + 
				"                               /   |   \\\r\n" + 
				"                              /    |    \\\r\n" + 
				"      We Appreciate Your     /     |     \\\r\n" + 
				"            Money!          /      |      \\\r\n" + 
				"                           /       |       \\\r\n" + 
				"                          /        |        \\\r\n" + 
				"                         /         |         \\");
		logger.info("System Exited");
	}
	
	public static void printWait() {
		System.out.println("          ___   ____\r\n" + 
				"        /' --;^/ ,-_\\     \\ | /\r\n" + 
				"       / / --o\\ o-\\ \\\\   --(_)--\r\n" + 
				"      /-/-/|o|-|\\-\\\\|\\\\   / | \\\r\n" + 
				"       '`  ` |-|   `` '\r\n" + 
				"  We're      |-|\r\n" + 
				"  Working    |-|O\r\n" + 
				"  On It..    |-(\\,__\r\n" + 
				"          ...|-|\\--,\\_....\r\n" + 
				"      ,;;;;;;;;;;;;;;;;;;;;;;;;,.\r\n" + 
				"~~,;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;,~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\r\n" + 
				"~;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;,  ______   ---------   _____     ------");
	}
//	########################################################################################
//	########## MAIN CLASS BUSINESS LOGIC METHODS ###########################################
//	################################## THERE ARE CHECKED WITH JUNIT ########################
	
	
	public static Account withdraw(Pet p, List<Account> l, double dub) {
		double curbal = seeBalance(p,l);
		Account a = null;
		if (dub > 0 && dub <= curbal ) {
			for (Account b : l) {
				if (p.getPet_id() == b.getPet_id()) {
					b.setBalance(curbal - dub);
					System.out.println("New balance = $" + (curbal - dub));
					a = b;
					return a;
				}
			}
		}else {
			System.out.println("Invalid withdraw amount");
		}
		return a;
	}
	
	public static double seeBalance(Pet p, List<Account> l) {
		double dub = 0;
		for (Account a : l) {
			if (p.getPet_id() == a.getPet_id()) {
				dub = a.getBalance();
			}
		}
		return dub;
	}
	
	public static Account deposit(Pet p, List<Account> l, double dub) {
		double curbal = seeBalance(p,l);
		Account a = null;
		if (dub < Double.MAX_VALUE) {
			for (Account b : l) {
				if (p.getPet_id() == b.getPet_id()) {
					b.setBalance(curbal + dub);
					System.out.println("New balance = $" + (curbal + dub));
					a = b;
					return a;
				}
			}
		}else {
			System.out.println("Invalid deposit amount");
		}
		return a;
	}
	
	public static String transfer(Pet p1, Pet p2, List<Account> l, double dub, AccountDaoImpl accountDaoImpl) {
		double curbal1 = seeBalance(p1,l);
		double curbal2 = seeBalance(p2,l);
		Account a1 = null;
		Account a2 = null;
		 
		a1 = withdraw(p1, l, dub);
		a2 = deposit(p2, l, dub);
		
		accountDaoImpl.updateAccountWhereId(a1);
		accountDaoImpl.updateAccountWhereId(a2);
		
		if (a1 != null && a2 != null) {
		return "Success";
		}else {
			return "Failed";
		}
	}
	
	
}
