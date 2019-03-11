package com.project.startupscreen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	// single scanner for simplicity
	static Scanner userInput = new Scanner(System.in);
	
	// public static ArrayList<UserRegistration> customersArrayList = new ArrayList<UserRegistration>(); 
	

	public static void main(String[] args) {

		int userChoice = 0; 
		
		// main menu 
		while(true)
		{
			// user selects options from main menu
			// Scanner mainMenu = new Scanner(System.in);
			
			System.out.println("\n\nBanking Application\n");
			
			System.out.println("Select one of the following options");;
			System.out.println("1. Log-In");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			
			// user selects from start up screen
			userChoice = userInput.nextInt(); 
			
			// check user decision
			// userChoice = checkUserChoice(userChoice); 
			
			switch(userChoice)
			{
				// call the Log-In method(s)
			case 1: 
				
				// get login credentials
				UserLogin userCredentials = (UserLogin) insertCredentials(); 
				
				// confirm credentials in users text file
				userCredentials = checkUserCredentials(userCredentials); 
				
				// login customer/employee/admin
				switch(userCredentials.getPriv())
				{
				case 0:
					// call admin menu
					adminMenu(); 
					break; 
				case 1:
					// call employee menu
					employeeMenu(); 
					break; 
				case 2:
					// call customer menu
					customerMenu(); 
					break; 
				default: 
					; // never reaches here
					break; 
				}
				
				
				// exits main switch statement for MAIN MENU
				break; 
				// call the Register method(s)
			case 2: 
				
				// call the user registration function
				UserRegistration regUser = (UserRegistration) provideUserInfo(); 
				System.out.println(regUser.getSsn()+" "+regUser.getFn()+" "+regUser.getLn()+" "+regUser.getUn()+" "+regUser.getPw()+" "+regUser.getAb()+" "+regUser.getJoint()+" "+regUser.getAccountApp());
				
				// check customers textfile if user is already registered
				boolean checkUserRegistration = searchCustomersFile(regUser);
				
				// if true == register new user
				if(checkUserRegistration == true)
				{
					try {
						addNewCustomer(regUser);
					} catch (IOException e) {
						e.printStackTrace();
					} 
					System.out.println("\nReturning to Banking Application Main Menu");
				}
				else // start over and log in
				{
					System.out.println("\nReturning to Banking Application Main Menu");
				}
				
				
				// serialize registered user into customers.ser
				// serialize(regUser); 
				
				// then return to main menu
				
				break;
			case 3:
				System.out.println("\n\nClosing Banking Application");
				System.exit(0);
				
			default:
				break;
			} 
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// REGISTER STUFF
	
	// user provides first name, last name password, re-enter password, ssn, joint account, application status
		static Object provideUserInfo() {
			
			String accountApplicationStatus = "open"; // open, ongoing, rejected, closed
			
			String jointAccount = "none"; // none or shared
			
			userInput.nextLine(); 
			
			System.out.println("Register now.");
			
			System.out.println("Enter your first name: ");
			String firstName = userInput.nextLine();
			firstName.toLowerCase(); 
			// System.out.print("Firstname: "+firstName);
			
			System.out.println("Enter your last name: ");
			String lastName = userInput.nextLine();
			lastName.toLowerCase(); 
			// System.out.println("Lastname: "+lastName);
			
			System.out.println("Enter a User Name: ");
			String userName = userInput.nextLine(); 
			
			System.out.println("Enter a password: ");
			String password = userInput.nextLine();
			
			int ssnLength = 0; // need to check if in correct format (XXX_XX_XXXX)
			int ssn = 0; 
			
			// check ssn length
			while(true)
			{
				// ask for integers after Strings
				System.out.println("Enter your Social Security Number: ");
				ssn = userInput.nextInt(); 
				// System.out.println(ssn);
				
				// find length of ssn
				// Reference: https://www.baeldung.com/java-number-of-digits-in-int
				ssnLength = String.valueOf(ssn).length(); 
				
				if(ssnLength == 9)
				{
					break; 
				}
				else
				{
					System.out.println("Social Security Number incorrect format");
				}
			}
			
			UserRegistration userReg = new UserRegistration(ssn, firstName, lastName, userName, password, 0, jointAccount, accountApplicationStatus); 
			
			// userInput.close(); 
			
			System.out.println("User Registration complete");
			
			return userReg;
			
		}
		
		// search if customer already exists
		public static boolean searchCustomersFile(UserRegistration regUser) {
			String filename = "./customerstest.txt";
			
			try {
				
				// convert ssn to string to use with sub string method
				String ssnTemp = Integer.toString(regUser.getSsn());
				
				// scanner for customers file
				Scanner checkCustomersFile = new Scanner(new File(filename));
				
				// loop through file while there is a line
				while(checkCustomersFile.hasNextLine())
				{
					// holds each line within the text file
					String textFileLine = checkCustomersFile.nextLine(); 
					
					// substring must be 0 through 9 to account for proper substring
					if(textFileLine.substring(0,  9).equals(ssnTemp))
					{
						System.out.println("Username: "+regUser.getUn()+" already exists. Please Log-In");
						return false; 
					}
//					// store username 
//					String tempUsername = regUser.getUn();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			checkFile.close(); 999887777:Jake:Farm:JFarm:pass:20:none:ongoing
			
			return true;
		}

	// insert new user into customers text file
	public static void addNewCustomer(UserRegistration regUser) throws IOException {
		
		
		String filename = "./customerstest.txt"; // write customer data to this file
		
		String usersFile = "./userstest.txt"; // send username and password this way
		
		
		// THIS SECTION TO WRITE TO CUSTOMERS
		FileWriter writeToCustomerFileFW = new FileWriter(filename, true); // set to true or else file will be overridden
		
		BufferedWriter writeToCustomerFileBW = new BufferedWriter(writeToCustomerFileFW);
		writeToCustomerFileBW.newLine(); // do this to write to the next blank line
		
		writeToCustomerFileBW.write(regUser.getSsn()+":"+
									regUser.getFn()+":"+
									regUser.getLn()+":"+
									regUser.getUn()+":"+
									regUser.getPw()+":"+
									regUser.getAb()+":"+
									regUser.getJoint()+":"+
									regUser.getAccountApp());
		
		writeToCustomerFileBW.close();
		writeToCustomerFileFW.close(); 
		
		
		// THIS SECTION TO ADD TO USERS 
		FileWriter writeToUsersFileFW = new FileWriter(usersFile, true); 
		
		BufferedWriter writeToUsersFileBW = new BufferedWriter(writeToUsersFileFW);
		writeToUsersFileBW.newLine(); 
		
		writeToUsersFileBW.write(
				regUser.getUn()+":"+
				regUser.getPw()+":"+
				"2");
		
		writeToUsersFileBW.close(); 
		writeToUsersFileFW.close(); 
		
	}

//	public static void serialize(Object obj)
//	{
//		try 
//		{
//			FileOutputStream fos = new FileOutputStream("./customers.ser");
//			ObjectOutputStream os = new ObjectOutputStream(fos); 
//			os.writeObject(obj); 
//			os.close(); 
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
//	
//	public static Object deserialize()
//	{
//		try
//		{
//			Object obj; 
//			FileInputStream fis = new FileInputStream("./customers.ser");
//			ObjectInputStream ois = new ObjectInputStream(fis); 
//			obj = (Object) ois.readObject(); 
//			ois.close();
//			return obj;
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		return null; 
//	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//LOG IN STUFF
	
	// grab user credentials
	public static Object insertCredentials() {

		// String combineUsername = ""; 
		userInput.nextLine(); 
		
		// ask for username, password
		System.out.println("Username: ");
		String username = userInput.nextLine(); 
		
		System.out.println("Password: ");
		String password = userInput.nextLine();

		UserLogin userLog = new UserLogin(username, password, -1); // don't need to know priviledge level at this point
		
		return userLog;
	}
	
	// confirm that username and password exists
	public static UserLogin checkUserCredentials(UserLogin userCredentials) {
		// System.out.println(userCredentials.getPw()+" "+userCredentials.getUn());
		
		String filename = "./userstest.txt";
		
//		String tempUsername = userCredentials.getUn();
//		String tempPassword = userCredentials.getPw();
//		int tempPriv = userCredentials.getPriv(); 
		
		// flags needed
		boolean checkUsername; // = false; 
		boolean checkPassword; // = false; 
		int checkPriviledges; // initialize variable 
		
		try
		{
			// scanner to search through users text file
			Scanner checkUsersFile = new Scanner(new File(filename)); 
			
			// loop through file while these is a line
			while(checkUsersFile.hasNextLine())
			{
				// reset booleans 
				checkUsername = false; 
				checkPassword = false; 
				checkPriviledges = -1; 
				
				// store each line from users text file
				String textFileLine = checkUsersFile.nextLine();
				
				// String array used for storing fields (username, password, priviledges)
				String [] parseTextFileLine = textFileLine.split(":");
				
				for(int i = 0; i < 3; i++)
				{
					// check username
					if(i == 0)
					{
						if(parseTextFileLine[i].equals(userCredentials.getUn()) == true)
						{
							checkUsername = true; 
						}
					}
					
					// check password
					if(i == 1)
					{
						if(parseTextFileLine[i].equals(userCredentials.getPw()) == true)
						{
							checkPassword = true; 
						}
					}
					
					// if username and password match run this statement
					if(i == 2 && checkUsername == true && checkPassword == true) 
					{
						checkPriviledges = Integer.parseInt(parseTextFileLine[i]); 
						userCredentials.setPriv(checkPriviledges);
						break; 
					}
					
				}
				
				// need statement here to break from while loop	
				if(checkUsername == true && checkPassword == true)
				{
					// confirmed user
					System.out.println("Welcome: "+userCredentials.getUn());
					break; // break out of for loop
				}
				
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace(); 
		}
		
		// System.out.println("Before Return Statement Priviledges: "+userCredentials.getPriv());
		return userCredentials;	
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MENU STUFF
	
	private static void customerMenu() {
		System.out.println("Customer Menu");	
		
	}

	private static void employeeMenu() {
		System.out.println("Employee Menu");
	}

	private static void adminMenu() {
		System.out.println("Admin Menu");
	}

}
