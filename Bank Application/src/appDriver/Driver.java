package appDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.ArrayList;
import java.util.Scanner;

import Users.Admins;
import Users.Employees;
import Users2.Customers;
import accountObjects.AccountObject;
import accountObjects.JointAccount;


public class Driver{

	static Scanner scan = new Scanner(System.in);
	
	JointAccount TempJA;
	AccountObject TempAO;
	int TempAccountTracker;
	static String filename = "./MasterInfoFile.txt";

	private static String[] args;
	
	static MasterInfoFile masterfile;
//	Employees TempEmployee;
//	Customers TempCust;
	
	
	public static void main(String[] args) {
		InitializeEmployees();//Hard Coded Employees
		
		//this line was just commented out, a test line
		//for(Employees EMP : MasterInfoFile.emp) {System.out.println(EMP);}	
		
		
		masterfile = readObject(filename);//Load up master file from .txt file
		MainMenu();//call main menu

	}

	static void MainMenu() 
	{
		
		System.out.println("Welcome to the bank");
		System.out.println("What do you want to do?");
		System.out.println("Press 1: Register   Press 2: Employee Login   Press 3: Customer Login");
		System.out.println("Press 4: Logout");
		
		int choice = scan.nextInt();//reads input to decide program state, did not use enum because I thought of it kind of late
		switch (choice) {
		case 1:{Register(); break;}
		case 2:{EmpLogin(); break;}
		case 3:{CustLogin(); break;}
		case 4:{Logout(); break;}//If no case is chose then the main method is called again
		default:{System.out.println("Please choose one of the given options"); Driver.main(args); break;}
		}
	}
	
	static void Register() 
	{
		boolean check = false;
		String UserN;
		int PassW;//takes user input
		
		System.out.println("Create a UserName");
			UserN = scan.nextLine();
		
		System.out.println("Create a Password");
			PassW = scan.nextInt();	
		
		
		System.out.println("Wait a minute while we check...");
		check = CheckForDuplicateUser(UserN); //(returns bool)checks for duplicate users from master file by comparing userNames
								//did not use comparator because I was to far in but I will switch it

		
		if (check == true) {//if bool is true, there is a duplicate user, back to main method
			System.out.println("User Already Exist"); 
			Driver.main(args); 
			}
		else {//otherwise, create a new customer and add to master list
			Customers customer = new Customers(UserN,PassW);
			MasterInfoFile.cust.add(customer);
			System.out.println("Youre in, Login with your new user & password.");
			for (Customers cus : MasterInfoFile.cust) {System.out.println(cus);}
			Driver.main(args);}
			
	}

	
	static void EmpLogin() {
		boolean check;
		System.out.println("Enter your UserName");
		String UserN = scan.nextLine();
		System.out.println("Enter your Password");
		
		int PassW = scan.nextInt();	//takes user input
		System.out.println("Wait a minute while we check...");
		check = CheckForEmployees(UserN,PassW); //returns a boolean from CheckForEmployee method
		
		if (check == false) {	//if false, goes back to main menu
			System.out.println("User Doesn't Exist"); 
			Driver.main(args); 
			}
		else {	//if true, get that employee from master list and go to employee menu
			System.out.println("Welcome" + UserN);
			EmpMenu(GetEmployee(UserN));
			}
	}
	
	static void CustLogin() {
		boolean check;
		System.out.println("Enter your UserName");
		String UserN = scan.nextLine();
		System.out.println("Enter your Password");
		
		int PassW = scan.nextInt();	//takes user input
		System.out.println("Wait a minute while we check...");
		check = CheckForCustomers(UserN,PassW); 	//returns a boolean from CheckForEmployee method
		
		if (check == false) {	//if false, goes back to main menu
			System.out.println("User Doesn't Exist"); 
			Driver.main(args); 
			}
		else {	//if true, grab customer from master list and go to customer menu
			System.out.println("Welcome" + UserN);
			CustMenu(GetCustomer(UserN));
			}
	}
		
	static void EmpMenu(Employees emp) 
	{	//logged in employee can execute its functions
		System.out.println("What do you want to do" + emp.UserN);
		System.out.println("Press 1: View Customer Accounts    Press 2: Approve or Deny customer account");
		System.out.println("Press 3: Logout");
		
		int choice = scan.nextInt();
		switch (choice) { // reads input for switch case to choose employee function
		case 1:{emp.SeeAccounts(); break;}
		case 2:{emp.changeAcctState(); break;}
		case 3:{emp.Logout(); break;} //If a separate choice is inputed, run employee menu again
		default:{System.out.println("Please choose one of the given options"); EmpMenu(emp); break;}
		}
	}
	
	static void CustMenu(Customers cus) 
	{ //	logged in customer can perform their function after giving respective inputs
		System.out.println("What do you want to do" + cus.Custname);
		System.out.println("Press 1: Apply for a Single Account");
		System.out.println("Press 2: Apply for a Joint Account (2nd person must have a UserName");
		System.out.println("Press 3: Withdraw      Press 4: Transfer      Press 5: View Accounts");
		System.out.println("Press 6: Logout");
		
		int choice = scan.nextInt();
		switch (choice) { //reads input

		case 1: {
			System.out.println("Enter Your Information");
			System.out.println("Enter First Name");
			String FN = scan.nextLine();
			System.out.println("Enter Last Name");
			String LN = scan.nextLine();
			System.out.println("Social Security");
			int SSN = scan.nextInt();
			System.out.println("Enter Account Name");
			String AN = scan.nextLine();
			AccountObject AO = cus.AccountCreate(FN, LN, SSN, cus.Custname, AN);
								// Normal Account is created and added to the queue of normal account approvals
			cus.PushToQue(AO);
			System.out.println("Joint Account created, wait for approval"); CustMenu(cus);
			break;
		}
		
		case 2: {
			System.out.println("Enter UserName of 2nd Customer");
			String UserN2 = scan.nextLine();
			Customers cust = GetCustomer(UserN2);
			if (cust == null) {
				System.out.println("2nd person must be a customer to apply for a joint account");
				CustMenu(cus);
			} else {
				System.out.println("Enter UserName of First Customer");
				String UserN1 = scan.nextLine();
				System.out.println("Enter Your First Name");
				String FN1 = scan.nextLine();
				System.out.println("Enter Your 2nd First Name");
				String FN2 = scan.nextLine();
				System.out.println("Enter Your Last Name");
				String LN1 = scan.nextLine();
				System.out.println("Enter Your 2nd Last Name");
				String LN2 = scan.nextLine();
				System.out.println("Social Security of First Customer");
				int SSN1 = scan.nextInt();
				System.out.println("Social Security of Second Customer");
				int SSN2 = scan.nextInt();
				System.out.println("Enter Account Name");
				String AN = scan.nextLine();
				JointAccount JAO = cus.JAccountCreate(FN1, FN2, LN1, LN2, SSN1, SSN2, UserN1, UserN2, AN);
									// Joint Account is created and added to the queue of joint account approvals
				cus.PushToQue(JAO);
				System.out.println("Joint Account created, wait for approval"); CustMenu(cus);
			}
			break;
		}
		
		case 3:{if(cus.acctTRKR == 0) {System.out.println("You need an account to proceed"); 
		CustMenu(cus);} else {}	//if customer account tracker variable is 0, user must create an account first
		break;}					//else customer can pick account and perform withdraw function		
		case 4:{cus.Logout(); break;}
		case 5:{cus.Logout(); break;}
		case 6:{cus.Logout(); break;}
		default:{System.out.println("Please choose one of the given options"); CustMenu(cus); break;}
		}
	}
	
	static void Logout() 
	{
		writeObject(filename);//writes master to text file after each logout
		System.out.println("See you later");
		Driver.main(args); //Call Main method
	}
	
	
	
	public static Employees GetEmployee(String UserName) {
		for(Employees employee : MasterInfoFile.emp) 
		{
			if (UserName == employee.UserN) {return employee;}
		}
		return null;
	}
	
	public static Customers GetCustomer(String UserName) {
		for(Customers customer : MasterInfoFile.cust) 
		{
			if (UserName == customer.Custname) {return customer;}
		}
		return null;
	}
	
	
	
	
	
	//Register and Login Methods
	static boolean CheckForDuplicateUser(String UserN) 
	{	
		for (Customers cus : MasterInfoFile.cust) 
		{//for each customer cus in customer ArrayList
			if(UserN == cus.Custname) 
			{//if Username matches the customer username return true
				return true;
			}
		}	
		return false;//otherwise return false
	}

	static boolean CheckForEmployees(String UserN, int password) 
	{	
		for (Employees emps : MasterInfoFile.emp) 
		{//for each employee login attempt, the Username and Password is checked against Master Employee ArrayList
			if(emps.UserN == UserN & emps.password == password) 
			{//if there is a match return true
				return true;
			}
		}	
		return false;//else return false
	}
	
	static boolean CheckForCustomers(String UserN, int password) 
	{	
		for (Customers custs : MasterInfoFile.cust) 
		{//for each customer login attempt, the Username and Password is checked against Master customer ArrayList
			if(custs.Custname == UserN & custs.password == password) 
			{//if there is a match return true
				return true;
			}
		}	
		return false;//else return false
	}
	
	
	
	
	
	
	//initial and final methods
	
	static void InitializeEmployees() 
	{// hard coded employees
		Employees Alex = new Admins("AlexM",123456);
		Employees Cameron = new Employees("CamC", 234567);
		Employees Gael = new Employees("GaelM", 345678);
		Employees Chris = new Admins ("Chris",456789);
		
		//added to master list
		MasterInfoFile.emp.add(Alex);
		MasterInfoFile.emp.add(Cameron);
		MasterInfoFile.emp.add(Gael);
		MasterInfoFile.emp.add(Chris);
	}
		
	static MasterInfoFile readObject(String filename) {//file object reader
		FileInputStream FIS = null;			//reads master file data from textfile
		ObjectInputStream OIS = null;		//returns master file
		MasterInfoFile masterF = null;
		try{
			FIS = new FileInputStream(filename);
			OIS = new ObjectInputStream(FIS);
			masterF = (MasterInfoFile) OIS.readObject();			
			OIS.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return masterF;
	}

	static void writeObject(String filename) {
		ObjectOutputStream OOS = null;
		FileOutputStream FOS = null;
		try { FOS = new FileOutputStream(filename);
			OOS = new ObjectOutputStream(FOS);	 
			MasterInfoFile masterFile = new MasterInfoFile();
			OOS.writeObject(masterFile);
			OOS.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
