// UPON FIRST USE: First, open sqldeveloper, then open the file "IronBank.sql"
//                 Second, create both tables "CustomerTable" and "MoneyTable"
//				   Third, run this program and follow the prompts
//				   Both the SQL will be updated with the information inputed here in Java
//				   A text file called "RegisteredCustomers" will become available inside the IronBankJDBC folder (workspace-sts-3.9.4.RELEASE)
// This program will work so long as users are APPROVED by an employee or an admin in the same order they registered
// Make sure ALL accounts are APPROVED by an employee or an admin before proceeding
// Customers should ALWAYS have a positive balance in their accounts after the first deposit to prevent the JDBC from creating duplicate records in the SQL MoneyTable 
// Remember customers can only gain access to an account after they've been APPROVED by an employee/admin, so there's no need for an "approvedCustomerMoneyArray"
// The SQL database only keeps track of customers who get APPROVED to open an account, not those who merely register

// inputedUsername
// usernameIndex

package bankingapp;

import java.util.ArrayList;
import java.util.Scanner;

import bankingapp.CustomerPetDaoImpl;
import bankingapp.CustomerPet;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class IronUpdatedMain {
	
	//CustomerTableDaoImpl customerDataAccessObject = new CustomerTableDaoImpl(); // 같� CUSTOMER DAO 같�
	//CustomerTable customerTableRecord = new CustomerTable(); //I might not need this
	
	static ArrayList<String> customerUsernameArray = new ArrayList<String>(); // 같� CUSTOMER BLOCK 같�
	static ArrayList<String> customerPasswordArray = new ArrayList<String>();
	static ArrayList<Double> customerMoneyArray = new ArrayList<Double>();
	
	static ArrayList<String> employeeUsernameArray = new ArrayList<String>(); // ### EMPLOYEE BLOCK ###
	static ArrayList<String> employeePasswordArray = new ArrayList<String>();
	static ArrayList<String> approvedCustomerUsernameArray = new ArrayList<String>();
	static ArrayList<String> approvedCustomerPasswordArray = new ArrayList<String>();
	//static ArrayList<Double> approvedCustomerMoneyArray = new ArrayList<Double>(); //The "customerMoneyArray" array can only be accessed through customerLoginMethod() after user has been approved; there's no need for this other array
	static ArrayList<String> deniedCustomerUsernameArray = new ArrayList<String>();
	static ArrayList<String> deniedCustomerPasswordArray = new ArrayList<String>();
	//static ArrayList<Double> deniedCustomerMoneyArray = new ArrayList<Double>();
	
	static ArrayList<String> adminUsernameArray = new ArrayList<String>(); // %%% ADMIN BLOCK %%%
	static ArrayList<String> adminPasswordArray = new ArrayList<String>();
	
	/// MENUS ///
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void MainMenu() throws IOException {
		System.out.println("\n*** MAIN MENU ***");
		System.out.println("Are you a CUSTOMER, EMPLOYEE or ADMIN?");
		System.out.println("Press 1 for CUSTOMER");
		System.out.println("Press 2 for EMPLOYEE");
		System.out.println("Press 3 for ADMIN");
		
		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		
		switch(userInput) {
		case 1: CustomerMenu();
		case 2: EmployeeMenu();
		case 3: AdminMenu();
		default: System.out.println("Invalid input.");
				 MainMenu();
		}
	}
	
	public static void CustomerMenu() throws IOException {
		
		int cusEmpAdm = 1;
		
		System.out.println("\n** CUSTOMER MENU **");
		System.out.println("Would you like to REGISTER or LOGIN");
		System.out.println("Press 1 to REGISTER");
		System.out.println("Press 2 to LOGIN");
		System.out.println("Press 3 to return to MAIN MENU");
		
		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		
		switch(userInput) {
		case 1: customerRegisterMethod();
		case 2: customerLoginMethod(); //notice there should be 3 different loginMethod() methods: for CUSTOMER, EMPLOYEE and ADMIN
		case 3: MainMenu(); //sends you back to the Main Menu
		default : System.out.println("Invalid input.");
				  CustomerMenu();
		}
	}
	
	public static void CustomerSubMenu(String inputedUsername, int usernameIndex) throws IOException { //this method can ONLY be called if usernameIndex == passwordIndex (the only way an account can be successfully accessed)
		System.out.println("\n* CUSTOMER SUBMENU *");
		System.out.println("What would you like to do? WITHDRAW, DEPOSIT or TRANSFER, CHECK CURRENT BALANCE, LOGOUT");
		System.out.println("Press 1 to WITHDRAW");
		System.out.println("Press 2 to DEPOSIT");
		System.out.println("Press 3 to TRANSFER");
		System.out.println("Press 4 to CHECK CURRENT BALANCE");
		System.out.println("Press 5 to LOGOUT and return to CUSTOMER MENU");
		
		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		
		switch(userInput) {
		case 1: withdrawMethod(inputedUsername, usernameIndex);
				CustomerSubMenu(inputedUsername, usernameIndex);
		case 2: depositMethod(inputedUsername, usernameIndex);
				CustomerSubMenu(inputedUsername, usernameIndex);
		case 3: transferMethod(inputedUsername, usernameIndex);
		case 4: checkCurrentBalanceMethod(inputedUsername, usernameIndex);
		case 5: CustomerMenu(); //returns you back to the Customer Menu
		default: System.out.println("Invalid input.");
				 CustomerSubMenu(inputedUsername, usernameIndex);
		}
	}
	
	public static void EmployeeMenu() throws IOException {
		
		System.out.println("\n** EMPLOYEE MENU **");
		System.out.println("Would you like to REGISTER or LOGIN");
		System.out.println("Press 1 to REGISTER");
		System.out.println("Press 2 to LOGIN");
		System.out.println("Press 3 to return to MAIN MENU");
		
		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		
		switch(userInput) {
		case 1: employeeRegisterMethod();
		case 2: employeeLoginMethod(); //notice there should be 3 different loginAttemptMethod() methods: for CUSTOMER, EMPLOYEE and ADMIN; each loginAttemptMethod() gives you access to the CUSTOMER SUBMENU, EMPLOYEE SUBMENU, and ADMIN SUBMENU; that's why there's 3
		case 3: MainMenu(); //sends you back to the Main Menu
		default : System.out.println("Invalid input.");
				  EmployeeMenu();
		}
	}
	
	public static void EmployeeSubMenu() throws IOException { //this method can ONLY be called if usernameIndex == passwordIndex (the only way an account can be successfully accessed)
		System.out.println("\n* EMPLOYEE SUBMENU *");
		System.out.println("What would you like to do? APPROVE/DENY accounts, VIEW accounts, LOGOUT");
		System.out.println("Press 1 to APPROVE/DENY");
		System.out.println("Press 2 to VIEW");
		System.out.println("Press 3 to LOGOUT and return to EMPLOYEE MENU");
		
		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		
		switch(userInput) {
		case 1: approveDenyMethod();
		case 2: viewMethod();
		case 3: EmployeeMenu(); //returns you back to the Customer Menu
		default: System.out.println("Invalid input.");
				 EmployeeSubMenu();
		}
	}
	
	public static void AdminMenu() throws IOException {
		
		System.out.println("\n** ADMIN MENU **");
		System.out.println("Would you like to REGISTER or LOGIN");
		System.out.println("Press 1 to REGISTER");
		System.out.println("Press 2 to LOGIN");
		System.out.println("Press 3 to return to MAIN MENU");
		
		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		
		switch(userInput) {
		case 1: adminRegisterMethod();
		case 2: adminLoginMethod(); //notice there should be 3 different loginAttemptMethod() methods: for CUSTOMER, EMPLOYEE and ADMIN; each loginAttemptMethod() gives you access to the CUSTOMER SUBMENU, EMPLOYEE SUBMENU, and ADMIN SUBMENU; that's why there's 3
		case 3: MainMenu(); //sends you back to the Main Menu
		default : System.out.println("Invalid input.");
				  AdminMenu();
		}
	}
	
	public static void AdminSubMenu() throws IOException { //this method can ONLY be called if usernameIndex == passwordIndex (the only way an account can be successfully accessed)
		System.out.println("\n* ADMIN SUBMENU *");
		System.out.println("What would you like to do? APPROVE/DENY accounts, VIEW accounts, WITHDRAW, DEPOSIT, TRANSFER, CANCEL accounts, LOGOUT");
		System.out.println("Press 1 to APPROVE/DENY");
		System.out.println("Press 2 to VIEW");
		System.out.println("Press 3 to WITHDRAW from customer account");
		System.out.println("Press 4 to DEPOSIT to customer account");
		System.out.println("Press 5 to TRANSFER from customer account");
		System.out.println("Press 6 to CANCEL customer account");
		System.out.println("Press 7 to LOGOUT and return to ADMIN MENU");
		
		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		
		switch(userInput) {
		case 1: specialApproveDenyMethod(); //this method is the same as "approveDenyMethod()", but it sends you back to the AdminSubMenu() at the end, instead of to the EmployeeSubMenu(); that's the only "special" thing about it
		case 2: specialViewMethod();
		case 3: specialWithdrawMethod();
		case 4: specialDepositMethod();
		case 5: specialTransferMethod();
		case 6: cancelAccountMethod();
		case 7: AdminMenu(); //returns you back to the Customer Menu
		default: System.out.println("Invalid input.");
				 AdminSubMenu();
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//같� CUSTOMER FUNCTIONALITY 같�
	//같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같
	public static void customerRegisterMethod() throws IOException {
		System.out.println("Enter a new username");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		
		customerUsernameArray.add(userInput);
		
		System.out.println("Enter a new password");
		Scanner input2 = new Scanner(System.in);
		String userInput2 = input.nextLine();
		
		customerPasswordArray.add(userInput2);
		
		/* I might not need this block at all
		int customerIndex = customerUsernameArray.indexOf(userInput);
		//JDBC
		CustomerTable customerTableRecord = new CustomerTable(customerIndex ,userInput, userInput2);
		CustomerTableDaoImpl customerDataAccessObject = new CustomerTableDaoImpl();
		customerDataAccessObject.insertCustomerTable(customerTableRecord);
		//end of JDBC
		*/
		
		CustomerMenu(); //change this to EmployeeMenu() or AdminMenu(); you might need 3 different registerMethod()s
	}
	
	public static void customerLoginMethod() throws IOException {
		if(customerUsernameArray.isEmpty()) {
			System.out.println("No customers have registered yet.");
			CustomerMenu();
		}
		
		System.out.println("Enter your username");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		String inputedUsername = userInput;
		int usernameIndex = customerUsernameArray.indexOf(inputedUsername); //becomes the index of the name contained in customerUsernameArray
		
		System.out.println("Enter your password");
		Scanner input2 = new Scanner(System.in);
		String userInput2 = input2.nextLine();
		String inputedPassword = userInput2;
		int passwordIndex = customerPasswordArray.indexOf(inputedPassword);
		
		if(approvedCustomerUsernameArray.contains(inputedUsername) & approvedCustomerPasswordArray.contains(inputedPassword) & usernameIndex == passwordIndex) { //this is the key for either successfully logging in or not
			System.out.println("Login successful.");
			CustomerSubMenu(inputedUsername, usernameIndex);
		} else if(customerUsernameArray.contains(inputedUsername) & customerPasswordArray.contains(inputedPassword) & usernameIndex == passwordIndex) {
			System.out.println("Account has not been approved by an employee or an admin yet.");
			CustomerMenu();
		} else {
			System.out.println("Login failed. Wrong username/password combination.");
			CustomerMenu();
		}
	}
	
	public static void withdrawMethod(String inputedUsername, int usernameIndex) throws IOException {
		if(usernameIndex >= customerMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			customerMoneyArray.add(usernameIndex, 0.0); //customerMoneyArray.get(usernameIndex) returns 0.0 at this point in the code
		}
		
		System.out.println("Enter amount you want to WITHDRAW");
		Scanner input = new Scanner(System.in);
		double userInput = input.nextDouble();
		
		if(userInput > customerMoneyArray.get(usernameIndex)) { //DELETE THIS BLOCK TO ALLOW CUSTOMER TO OVERDRAW MONEY FROM ACCOUNT
			System.out.println("Your current balance is $" + customerMoneyArray.get(usernameIndex));
			System.out.println("You can't withdraw more money than you have.");
			CustomerSubMenu(inputedUsername, usernameIndex);
		}
		
		double currentBalance = customerMoneyArray.get(usernameIndex);
		double newBalance = currentBalance - userInput;
		
		//JDBC
		//Note: To avoid the same user being added multiple times to the SQL table, try to keep his balance positive at all times after the first deposit
		MoneyTable moneyTableRecord = new MoneyTable(usernameIndex, inputedUsername, newBalance);
		MoneyTableDaoImpl moneyDataAccessObject = new MoneyTableDaoImpl();
		moneyDataAccessObject.updateMoneyTable(moneyTableRecord);
		//end of JDBC
		
		customerMoneyArray.set(usernameIndex, newBalance); // !!! use .set here; do NOT use .add
		
		System.out.println("You withdrew $" + userInput);
		System.out.println("Your current balance is $" + newBalance);
		//System.out.println("Withdraw index: " + usernameIndex); // !!! Delete this after testing
		CustomerSubMenu(inputedUsername, usernameIndex);
	}
	
	public static void depositMethod(String inputedUsername, int usernameIndex) throws IOException {
		if(usernameIndex >= customerMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			customerMoneyArray.add(usernameIndex, 0.0);
		}
		
		System.out.println("Enter amount you want to DEPOSIT");
		Scanner input = new Scanner(System.in);
		double userInput = input.nextDouble();
		
		if(userInput < 0) { //DELETE THIS BLOCK TO ALLOW CUSTOMER TO DEPOSIT NEGATIVE AMOUNTS
			System.out.println("Please enter a positive amount.");
			depositMethod(inputedUsername, usernameIndex);
		}
		
		double currentBalance = customerMoneyArray.get(usernameIndex);
		double newBalance = currentBalance + userInput;
		
		
		//JDBC
		//Note: To avoid the same user being added multiple times to the SQL table, try to keep his balance positive at all times after the first deposit
		MoneyTable moneyTableRecord = new MoneyTable(usernameIndex, inputedUsername, newBalance);
		MoneyTableDaoImpl moneyDataAccessObject = new MoneyTableDaoImpl();
		if(customerMoneyArray.get(usernameIndex) == 0.0)
		{
			moneyDataAccessObject.insertMoneyTable(moneyTableRecord); //this should only run once per customer
		} else {
			moneyDataAccessObject.updateMoneyTable(moneyTableRecord);
		}
		//end of JDBC
		
		customerMoneyArray.set(usernameIndex, newBalance); // !!! use .set here; do NOT use .add
		
		System.out.println("You deposited $" + userInput);
		System.out.println("Your current balance is $" + newBalance);
		
		CustomerSubMenu(inputedUsername, usernameIndex);
	}
	
	public static void transferMethod(String inputedUsername, int usernameIndex) throws IOException {
		if(usernameIndex >= customerMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			customerMoneyArray.add(usernameIndex, 0.0);
		}
		
		System.out.println("Whose account would you like to TRANSFER to?");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		if(customerUsernameArray.contains(userInput)) {
			
			int indexFrom = usernameIndex;
			int indexTo = customerUsernameArray.indexOf(userInput);
			if(indexTo >= customerMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
				customerMoneyArray.add(indexTo, 0.0);
			}
			
			System.out.println("Enter amount you would like to TRANSFER to this account");
			Scanner input2 = new Scanner(System.in);
			double moneyBeingTransferred = input.nextDouble();
			
			double currentBalanceFrom = customerMoneyArray.get(indexFrom); //remember indexFrom == usernameIndex
			double currentBalanceTo = customerMoneyArray.get(indexTo); //this is equal to 0.0 if account didn't exist prior to TRANSFER operation
			double newBalanceFrom = currentBalanceFrom - moneyBeingTransferred;
			double newBalanceTo = currentBalanceTo + moneyBeingTransferred;
			
			//JDBC
			//Note: To avoid the same user being added multiple times to the SQL table, try to keep his balance positive at all times after the first deposit
			MoneyTable moneyTableRecord = new MoneyTable(indexFrom, inputedUsername, newBalanceFrom);
			MoneyTableDaoImpl moneyDataAccessObject = new MoneyTableDaoImpl();
			moneyDataAccessObject.updateMoneyTable(moneyTableRecord);
			//end of JDBC
			
			//JDBC
			//Note: To avoid the same user being added multiple times to the SQL table, try to keep his balance positive at all times after the first deposit
			MoneyTable moneyTableRecord2 = new MoneyTable(indexTo, inputedUsername, newBalanceTo);
			MoneyTableDaoImpl moneyDataAccessObject2 = new MoneyTableDaoImpl();
			moneyDataAccessObject.updateMoneyTable(moneyTableRecord);
			//end of JDBC
			
			customerMoneyArray.set(indexFrom, newBalanceFrom);
			customerMoneyArray.set(indexTo, newBalanceTo);
			
			System.out.println("You transferred $" + moneyBeingTransferred + " to " + customerUsernameArray.get(indexTo) + "'s account.");
			System.out.println("Your current balance is $" + customerMoneyArray.get(indexFrom));
			CustomerSubMenu(inputedUsername, usernameIndex);
		} else {
			System.out.println("Account does not exist.");
			CustomerSubMenu(inputedUsername, usernameIndex);
		}
	}
	
	public static void checkCurrentBalanceMethod(String inputedUsername, int usernameIndex) throws IOException {
		System.out.println("Your current balance is $" + customerMoneyArray.get(usernameIndex));
		CustomerSubMenu(inputedUsername, usernameIndex);
	}
	//같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같같
	
	//### EMPLOYEE FUNCITONALITY ###
	//##########################################################################################################################################
	public static void employeeRegisterMethod() throws IOException {
		System.out.println("Enter a new username");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		
		employeeUsernameArray.add(userInput);
		
		System.out.println("Enter a new password");
		Scanner input2 = new Scanner(System.in);
		String userInput2 = input.nextLine();
		
		employeePasswordArray.add(userInput2);
		
		/*
		int employeeIndex = employeeUsernameArray.indexOf(userInput);
		//JDBC
		EmployeeTable employeeTableRecord = new EmployeeTable(employeeIndex, userInput, userInput2);
		EmployeeTableDaoImpl employeeDataAccessObject = new EmployeeTableDaoImpl();
		employeeDataAccessObject.insertEmployeeTable(employeeTableRecord);
		//end of JDBC
		*/
		
		EmployeeMenu(); //change this to EmployeeMenu() or AdminMenu(); you might need 3 different registerMethod()s
	}
	
	public static void employeeLoginMethod() throws IOException {
		if(employeeUsernameArray.isEmpty()) {
			System.out.println("No employees have registered yet.");
			EmployeeMenu();
		}
		
		System.out.println("Enter your username");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		String inputedUsername = userInput;
		int usernameIndex = employeeUsernameArray.indexOf(inputedUsername); //becomes the index of the name contained in customerUsernameArray
	
		System.out.println("Enter your password");
		Scanner input2 = new Scanner(System.in);
		String userInput2 = input2.nextLine();
		String inputedPassword = userInput2;
		int passwordIndex = employeePasswordArray.indexOf(inputedPassword);
		
		if(employeeUsernameArray.contains(inputedUsername) & employeePasswordArray.contains(inputedPassword) & usernameIndex == passwordIndex) {
			System.out.println("Login successful.");
			EmployeeSubMenu();
		} else {
			System.out.println("Login failed. Wrong username/password combination.");
			EmployeeMenu();
		}
	}
	
	public static void approveDenyMethod() throws IOException {
		if(customerUsernameArray.isEmpty()) {
			System.out.println("No customers have registered yet.");
			EmployeeSubMenu();
		}
		if(approvedCustomerUsernameArray.containsAll(customerUsernameArray)) {
			System.out.println("No customers need approval right now.");
			EmployeeSubMenu();
		}
		
		System.out.println("Displaying registered customers wishing to open an account:");
		for(int i = 0; i<customerUsernameArray.size(); i++) {
			if(approvedCustomerUsernameArray.contains(customerUsernameArray.get(i))){ //if usernamename in "customerUsernameArray" array already exists in "approvedCustomerUsernameArray" array,
				continue; //skips this iteration of the for loop to prevent customer's usernames to be printed once their accounts have been approved
			} else {
				System.out.println(i + " ---> " + customerUsernameArray.get(i)); //notice the index i coincides with the index where the String within customerUsernameArray is located
			}
		}
		
		System.out.println("Enter the number corresponding to the customer you want to APPROVE/DENY");
		Scanner input = new Scanner(System.in);
		int usernameIndex = input.nextInt(); //I called the employee's input here "usernameIndex" here because it serves the same purpose
		if(usernameIndex > customerUsernameArray.size()) { //if the employee inputs an invalid index, this block sents him back to EmployeeSubMenu 
			System.out.println("Invalid input.");
			EmployeeSubMenu();
		}
		
		int candidateIndex = customerUsernameArray.indexOf(customerUsernameArray.get(usernameIndex)); //"Candidates" are customers wishing to open an account
		String candidateUsername = customerUsernameArray.get(usernameIndex);
		
		System.out.println("You chose candidate: " + candidateIndex + " ---> " + candidateUsername);
		System.out.println("Press 1 to APPROVE candidate");
		System.out.println("Press 2 to DENY canidate");
		System.out.println("Press 3 to return to EMPLOYEE SUBMENU");
		Scanner input2 = new Scanner(System.in);
		int userInput2 = input2.nextInt();
		
		switch(userInput2) { //Note: Customers can be approved in any order thanks to the "INITIALIZE ARRAY IF EMPTY" if blocks
		case 1: if(approvedCustomerUsernameArray.isEmpty()) { //APPROVED
				approvedCustomerUsernameArray.add(candidateIndex, candidateUsername);
				}
				if(usernameIndex >= approvedCustomerUsernameArray.size()) { //INITIALIZE ARRAY IF EMPTY
					approvedCustomerUsernameArray.add(usernameIndex, "");
				}
				String candidatePassword = customerPasswordArray.get(usernameIndex);
				if(approvedCustomerPasswordArray.isEmpty()) {
					approvedCustomerPasswordArray.add(candidateIndex, candidatePassword);
				}
				if(usernameIndex >= approvedCustomerPasswordArray.size()) {
					approvedCustomerPasswordArray.add(usernameIndex, "");
				}
				
				approvedCustomerUsernameArray.set(candidateIndex, candidateUsername); //copies contents of customerUsernameArray with the same index
				approvedCustomerPasswordArray.set(candidateIndex, candidatePassword); //copies contents of cutomerPasswordArray with the same index
				System.out.println("Candidate APPROVED");
				
				
				int customerIndex = customerUsernameArray.indexOf(candidateUsername);
				//JDBC
				CustomerTable customerTableRecord = new CustomerTable(customerIndex, candidateUsername, candidatePassword);
				CustomerTableDaoImpl customerDataAccessObject = new CustomerTableDaoImpl();
				customerDataAccessObject.insertCustomerTable(customerTableRecord);
				//end of JDBC
				
				//FileWriter
				FileWriter myWriter = new FileWriter("RegisteredCustomers.txt", true); //import PrintWriter class to
				try(FileReader myReader = new FileReader("RegisteredCustomers.txt")){
					myWriter.write("Customer ID: " + customerIndex);
					myWriter.write(System.lineSeparator());
					myWriter.write("Customer Name: " + candidateUsername);
					myWriter.write(System.lineSeparator());
					myWriter.write("Customer Password: " + candidatePassword);
					myWriter.write(System.lineSeparator());
					myWriter.write(System.lineSeparator());
					myWriter.close();
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				}
				//end FileWriter
				
				EmployeeSubMenu();
				
		case 2: if(deniedCustomerUsernameArray.isEmpty()) { //DENIED //Note: When customers are denied, their names are still displayed under prompt "Displaying registered customers wishing to open an account:"
					deniedCustomerUsernameArray.add(candidateIndex, candidateUsername);
				}
				String candidatePassword2 = customerPasswordArray.get(usernameIndex);
				if(deniedCustomerPasswordArray.isEmpty()) {
					deniedCustomerPasswordArray.add(candidateIndex, candidateUsername);
				}
				if(usernameIndex >= deniedCustomerUsernameArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
					deniedCustomerUsernameArray.add(usernameIndex, "");
				}
				if(usernameIndex >= deniedCustomerPasswordArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
					deniedCustomerPasswordArray.add(usernameIndex, "");
				}
				
				deniedCustomerUsernameArray.set(candidateIndex, candidateUsername); //copies contents of customerUsernameArray with the same index
				deniedCustomerPasswordArray.set(candidateIndex, candidatePassword2); //copies contents of cutomerPasswordArray with the same index
				System.out.println("Candidate DENIED");
				
				/* Create a new table in SQL called "DeniedCustomerTable" and implement the 4 required files for the code below to work
				int customerIndex = customerUsernameArray.indexOf(candidateUsername);
				//JDBC
				DeniedCustomerTable deniedCustomerTableRecord = new DeniedCustomerTable(customerIndex, candidateUsername, candidatePassword);
				DeniedCustomerTableDaoImpl deniedCustomerDataAccessObject = new DeniedCustomerTableDaoImpl();
				DeniedCustomerDataAccessObject.insertDeniedCustomerTable(deniedCustomerTableRecord);
				//end of JDBC
				*/
				
				EmployeeSubMenu();
				
		case 3: EmployeeSubMenu();
		
		default: System.out.println("Invalid input.");
				 approveDenyMethod();
		}
	}
	
	public static void viewMethod() throws IOException {
		if(customerUsernameArray.isEmpty()) {
			System.out.println("No customers have registered yet.");
			EmployeeSubMenu();
		}
		if(approvedCustomerUsernameArray.isEmpty()) {
			System.out.println("No customers have been approved/denied to open an account yet.");
			EmployeeSubMenu();
		}
		
		System.out.println("Displaying customers with an open account:");
		for(int i = 0; i<approvedCustomerUsernameArray.size(); i++) {
			System.out.println(i + " ---> " + approvedCustomerUsernameArray.get(i)); //notice the index i coincides with the index where the String within customerUsernameArray is located
		}
		System.out.println("Enter the number corresponding to the customer you want to VIEW");
		Scanner input = new Scanner(System.in);
		int usernameIndex = input.nextInt(); //I called the employee's input here "usernameIndex" here because it serves the same purpose
		if(usernameIndex > approvedCustomerUsernameArray.size()) { //if the employee inputs an invalid index, this block sents him back to EmployeeSubMenu 
			System.out.println("Invalid input.");
			EmployeeSubMenu();
		}
		
		int customerIndex = approvedCustomerUsernameArray.indexOf(customerUsernameArray.get(usernameIndex)); //stores customer's index in "customerIndex"
		String customerUsername = approvedCustomerUsernameArray.get(usernameIndex); //stores customer's username in "customerUsername"
		
		if(customerMoneyArray.isEmpty()) { // !!!These two if statements MUST come in pairs!
			customerMoneyArray.add(0, 0.0); //you might want to replace the first 0 with "usernameIndex"
		}
		if(usernameIndex >= customerMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			customerMoneyArray.add(usernameIndex, 0.0);
		}
		double customerCurrentBalance = customerMoneyArray.get(customerIndex); //stores customer's money in "customerCurrentBalance"
		
		System.out.println("**************************************************");
		System.out.println("Name: " + customerUsername);
		System.out.println("Current account balance: " + customerCurrentBalance);
		System.out.println("**************************************************");
		
		EmployeeSubMenu();
		
	}
	//##########################################################################################################################################
	
	//%%% ADMIN FUNCTIONALITY %%%
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	public static void adminRegisterMethod() throws IOException {
		System.out.println("Enter a new username");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		
		adminUsernameArray.add(userInput);
		
		System.out.println("Enter a new password");
		Scanner input2 = new Scanner(System.in);
		String userInput2 = input.nextLine();
		
		adminPasswordArray.add(userInput2);
		
		/*
		int adminIndex = adminUsernameArray.indexOf(userInput);
		//JDBC
		AdminTable adminTableRecord = new AdminTable(adminIndex, userInput, userInput2);
		AdminTableDaoImpl adminDataAccessObject = new AdminTableDaoImpl();
		adminDataAccessObject.insertAdminTable(adminTableRecord);
		//end of JDBC
		*/
		
		AdminMenu(); //change this to EmployeeMenu() or AdminMenu(); you might need 3 different registerMethod()s
	}
	
	public static void adminLoginMethod() throws IOException {
		if(adminUsernameArray.isEmpty()) {
			System.out.println("No admins have registered yet.");
			AdminMenu();
		}
		
		System.out.println("Enter your username");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		String inputedUsername = userInput;
		int usernameIndex = adminUsernameArray.indexOf(inputedUsername); //becomes the index of the name contained in adminUsernameArray
	
		System.out.println("Enter your password");
		Scanner input2 = new Scanner(System.in);
		String userInput2 = input2.nextLine();
		String inputedPassword = userInput2;
		int passwordIndex = adminPasswordArray.indexOf(inputedPassword);
		
		if(adminUsernameArray.contains(inputedUsername) & adminPasswordArray.contains(inputedPassword) & usernameIndex == passwordIndex) {
			System.out.println("Login successful.");
			AdminSubMenu();
		} else {
			System.out.println("Login failed. Wrong username/password combination.");
			AdminMenu();
		}
	}
	
	public static void specialApproveDenyMethod() throws IOException {
		if(customerUsernameArray.isEmpty()) {
			System.out.println("No customers have registered yet.");
			AdminSubMenu();
		}
		if(approvedCustomerUsernameArray.containsAll(customerUsernameArray)) {
			System.out.println("No customers need approval right now.");
			AdminSubMenu();
		}
		
		System.out.println("Displaying registered customers wishing to open an account:");
		for(int i = 0; i<customerUsernameArray.size(); i++) {
			if(approvedCustomerUsernameArray.contains(customerUsernameArray.get(i))){ //if usernamename in "customerUsernameArray" array already exists in "approvedCustomerUsernameArray" array,
				continue; //skips this iteration of the for loop to prevent customer's usernames to be printed once their accounts have been approved
			} else {
				System.out.println(i + " ---> " + customerUsernameArray.get(i)); //notice the index i coincides with the index where the String within customerUsernameArray is located
			}
		}
		
		System.out.println("Enter the number corresponding to the customer you want to APPROVE/DENY");
		Scanner input = new Scanner(System.in);
		int usernameIndex = input.nextInt(); //I called the employee's input here "usernameIndex" here because it serves the same purpose
		if(usernameIndex > customerUsernameArray.size()) { //if the employee inputs an invalid index, this block sents him back to EmployeeSubMenu 
			System.out.println("Invalid input.");
			AdminSubMenu();
		}
		
		int candidateIndex = customerUsernameArray.indexOf(customerUsernameArray.get(usernameIndex)); //"Candidates" are customers wishing to open an account
		String candidateUsername = customerUsernameArray.get(usernameIndex);
		
		System.out.println("You chose candidate: " + candidateIndex + " ---> " + candidateUsername);
		System.out.println("Press 1 to APPROVE candidate");
		System.out.println("Press 2 to DENY canidate");
		System.out.println("Press 3 to return to EMPLOYEE SUBMENU");
		Scanner input2 = new Scanner(System.in);
		int userInput2 = input2.nextInt();
		
		switch(userInput2) { // TESTING first if statement
		case 1: if(approvedCustomerUsernameArray.isEmpty()) { //APPROVED
					approvedCustomerUsernameArray.add(candidateIndex, candidateUsername);
				}
				if(usernameIndex >= approvedCustomerUsernameArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
					approvedCustomerUsernameArray.add(usernameIndex, "");
				}
				String candidatePassword = customerPasswordArray.get(usernameIndex);
				if(approvedCustomerPasswordArray.isEmpty()) {
					approvedCustomerPasswordArray.add(candidateIndex, candidatePassword);
				}
				if(usernameIndex >= approvedCustomerPasswordArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
					approvedCustomerPasswordArray.add(usernameIndex, "");
				}
				
				approvedCustomerUsernameArray.set(candidateIndex, candidateUsername); //copies contents of customerUsernameArray with the same index
				approvedCustomerPasswordArray.set(candidateIndex, candidatePassword); //copies contents of cutomerPasswordArray with the same index
				
				
				int customerIndex = customerUsernameArray.indexOf(candidateUsername);
				//JDBC
				CustomerTable customerTableRecord = new CustomerTable(customerIndex, candidateUsername, candidatePassword);
				CustomerTableDaoImpl customerDataAccessObject = new CustomerTableDaoImpl();
				customerDataAccessObject.insertCustomerTable(customerTableRecord);
				//end of JDBC
				
				System.out.println("Candidate APPROVED");
				AdminSubMenu();
				
		case 2: if(deniedCustomerUsernameArray.isEmpty()) { //DENIED
					deniedCustomerUsernameArray.add(candidateIndex, candidateUsername);
				}
				String candidatePassword2 = customerPasswordArray.get(usernameIndex);
				if(deniedCustomerPasswordArray.isEmpty()) {
					deniedCustomerPasswordArray.add(candidateIndex, candidateUsername);
				}
				
				/*
				if(usernameIndex >= deniedCustomerUsernameArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
					deniedCustomerUsernameArray.add(usernameIndex, "");
				}
				if(usernameIndex >= deniedCustomerPasswordArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
					deniedCustomerPasswordArray.add(usernameIndex, "");
				}
				*/
				
				deniedCustomerUsernameArray.set(candidateIndex, candidateUsername); //copies contents of customerUsernameArray with the same index
				deniedCustomerPasswordArray.set(candidateIndex, candidatePassword2); //copies contents of cutomerPasswordArray with the same index
				
				
				/* Create a new table in SQL called "DeniedCustomerTable" and implement the 4 required files for the code below to work
				int customerIndex = customerUsernameArray.indexOf(candidateUsername);
				//JDBC
				DeniedCustomerTable deniedCustomerTableRecord = new DeniedCustomerTable(customerIndex, candidateUsername, candidatePassword);
				DeniedCustomerTableDaoImpl deniedCustomerDataAccessObject = new DeniedCustomerTableDaoImpl();
				DeniedCustomerDataAccessObject.insertDeniedCustomerTable(deniedCustomerTableRecord);
				//end of JDBC
				*/
				
				System.out.println("Candidate DENIED");
				AdminSubMenu();
				
		case 3: AdminSubMenu();
		
		default: System.out.println("Invalid input.");
				 specialApproveDenyMethod();
		}
	}
	
	public static void specialViewMethod() throws IOException {
		if(customerUsernameArray.isEmpty()) {
			System.out.println("No customers have registered yet.");
			AdminSubMenu();
		}
		if(approvedCustomerUsernameArray.isEmpty()) {
			System.out.println("No customers have been approved/denied to open an account yet.");
			AdminSubMenu();
		}
		
		System.out.println("Displaying customers with an open account:");
		for(int i = 0; i<approvedCustomerUsernameArray.size(); i++) {
			System.out.println(i + " ---> " + approvedCustomerUsernameArray.get(i)); //notice the index i coincides with the index where the String within customerUsernameArray is located
		}
		System.out.println("Enter the number corresponding to the customer you want to VIEW");
		Scanner input = new Scanner(System.in);
		int usernameIndex = input.nextInt(); //I called the employee's input here "usernameIndex" here because it serves the same purpose
		if(usernameIndex > approvedCustomerUsernameArray.size()) { //if the employee inputs an invalid index, this block sents him back to EmployeeSubMenu 
			System.out.println("Invalid input.");
			AdminSubMenu();
		}
		
		int customerIndex = approvedCustomerUsernameArray.indexOf(customerUsernameArray.get(usernameIndex)); //stores customer's index in "customerIndex"
		String customerUsername = approvedCustomerUsernameArray.get(usernameIndex); //stores customer's username in "customerUsername"
		
		if(customerMoneyArray.isEmpty()) { // !!!These two if statements MUST come in pairs!
			customerMoneyArray.add(usernameIndex, 0.0);
		}
		if(usernameIndex >= customerMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			customerMoneyArray.add(usernameIndex, 0.0);
		}
		double customerCurrentBalance = customerMoneyArray.get(customerIndex); //stores customer's money in "customerCurrentBalance"
		
		System.out.println("**************************************************");
		System.out.println("Name: " + customerUsername);
		System.out.println("Current account balance: " + customerCurrentBalance);
		System.out.println("**************************************************");
		AdminSubMenu();
	}
	public static void specialWithdrawMethod() throws IOException {
		if(customerUsernameArray.isEmpty()) {
			System.out.println("No customers have registered yet.");
			AdminSubMenu();
		}
		if(approvedCustomerUsernameArray.isEmpty()) {
			System.out.println("No customers have been approved/denied to open an account yet.");
			AdminSubMenu();
		}
		
		System.out.println("Displaying customers with an open account:");
		for(int i = 0; i<approvedCustomerUsernameArray.size(); i++) {
			System.out.println(i + " ---> " + approvedCustomerUsernameArray.get(i)); //notice the index i coincides with the index where the String within customerUsernameArray is located
		}
		System.out.println("Enter the number corresponding to the customer you want to WITHDRAW funds from");
		Scanner input = new Scanner(System.in);
		int usernameIndex = input.nextInt();
		if(usernameIndex >= approvedCustomerUsernameArray.size()) { //if the admin inputs an invalid index, this block sents him back to EmployeeSubMenu 
			System.out.println("Invalid input.");
			AdminSubMenu();
		}
		
		int customerIndex = approvedCustomerUsernameArray.indexOf(customerUsernameArray.get(usernameIndex)); //stores customer's index in "customerIndex"
		String customerUsername = approvedCustomerUsernameArray.get(usernameIndex); //stores customer's username in "customerUsername"
		
		if(customerMoneyArray.isEmpty()) { // !!!These two if statements MUST come in pairs!
			customerMoneyArray.add(usernameIndex, 0.0);
		}
		if(usernameIndex >= customerMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			customerMoneyArray.add(usernameIndex, 0.0);
		}
		double customerCurrentBalance = customerMoneyArray.get(customerIndex); //stores customer's money in "customerCurrentBalance"
		
		///UP TO THIS POINT, METHOD IS IDENTICAL TO specialViewMethod();
		
		System.out.println("Enter amount you want to WITHDRAW from customer's account");
		Scanner input2 = new Scanner(System.in);
		double userInput = input2.nextDouble();
		
		if(userInput > customerMoneyArray.get(usernameIndex)) { //DELETE THIS BLOCK TO ALLOW CUSTOMER TO OVERDRAW MONEY FROM ACCOUNT
			System.out.println("Customer's current balance is $" + customerMoneyArray.get(usernameIndex));
			System.out.println("You can't withdraw more money than the customer has.");
			AdminSubMenu();
		}
		
		double currentBalance = customerMoneyArray.get(usernameIndex);
		double newBalance = currentBalance - userInput;
		
		
		//JDBC
		//Note: To avoid the same user being added multiple times to the SQL table, try to keep his balance positive at all times after the first deposit
		MoneyTable moneyTableRecord = new MoneyTable(usernameIndex, customerUsername, newBalance);
		MoneyTableDaoImpl moneyDataAccessObject = new MoneyTableDaoImpl();
		moneyDataAccessObject.updateMoneyTable(moneyTableRecord);
		//end of JDBC
		
		customerMoneyArray.set(usernameIndex, newBalance); // !!! use .set here; do NOT use .add
		
		System.out.println("You withdrew $" + userInput + " from " + customerUsername + "'s account.");
		System.out.println("Customer's current balance is $" + newBalance);
		
		AdminSubMenu();
		
	}
	public static void specialDepositMethod() throws IOException {
		if(customerUsernameArray.isEmpty()) {
			System.out.println("No customers have registered yet.");
			AdminSubMenu();
		}
		if(approvedCustomerUsernameArray.isEmpty()) {
			System.out.println("No customers have been approved/denied to open an account yet.");
			AdminSubMenu();
		}
		
		System.out.println("Displaying customers with an open account:");
		for(int i = 0; i<approvedCustomerUsernameArray.size(); i++) {
				System.out.println(i + " ---> " + approvedCustomerUsernameArray.get(i)); //notice the index i coincides with the index where the String within customerUsernameArray is located
			}
		
		System.out.println("Enter the number corresponding to the customer you want to DEPOSIT funds to");
		Scanner input = new Scanner(System.in);
		int usernameIndex = input.nextInt();
		if(usernameIndex >= approvedCustomerUsernameArray.size()) { //if the admin inputs an invalid index, this block sents him back to EmployeeSubMenu 
			System.out.println("Invalid input.");
			AdminSubMenu();
		}
		
		int customerIndex = approvedCustomerUsernameArray.indexOf(customerUsernameArray.get(usernameIndex)); //stores customer's index in "customerIndex"
		String customerUsername = approvedCustomerUsernameArray.get(usernameIndex); //stores customer's username in "customerUsername"
		
		if(customerMoneyArray.isEmpty()) { // !!!These two if statements MUST come in pairs!
			customerMoneyArray.add(usernameIndex, 0.0);
		}
		if(usernameIndex >= customerMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			customerMoneyArray.add(usernameIndex, 0.0);
		}
		double customerCurrentBalance = customerMoneyArray.get(customerIndex); //stores customer's money in "customerCurrentBalance"
		
		///UP TO THIS POINT, METHOD IS IDENTICAL TO specialViewMethod();
		
		System.out.println("Enter amount you want to DEPOSIT to " + customerUsername + "'s account");
		Scanner input2 = new Scanner(System.in);
		double userInput = input2.nextDouble();
		
		if(userInput < 0) { //DELETE THIS BLOCK TO ALLOW CUSTOMER TO DEPOSIT NEGATIVE AMOUNTS
			System.out.println("Please enter a positive amount.");
			AdminSubMenu();
		}
		
		double currentBalance = customerMoneyArray.get(usernameIndex);
		double newBalance = currentBalance + userInput;
		
		
		//JDBC
		//Note: To avoid the same user being added multiple times to the SQL table, try to keep his balance positive at all times after the first deposit
		MoneyTable moneyTableRecord = new MoneyTable(usernameIndex, customerUsername, newBalance);
		MoneyTableDaoImpl moneyDataAccessObject = new MoneyTableDaoImpl();
		if(customerMoneyArray.get(usernameIndex) == 0.0)
		{
			moneyDataAccessObject.insertMoneyTable(moneyTableRecord); //this should only run once per customer
		} else {
			moneyDataAccessObject.updateMoneyTable(moneyTableRecord);
		}
		//end of JDBC
		
		customerMoneyArray.set(usernameIndex, newBalance); // !!! use .set here; do NOT use .add
		
		System.out.println("You deposited $" + userInput + " to " + customerUsername + "'s account.");
		System.out.println("Customer's current balance is $" + newBalance);
		
		AdminSubMenu();
	}
	public static void specialTransferMethod() throws IOException { //Note: Admins can over-transfer money between accounts regardless of how much money customers have
		if(customerUsernameArray.isEmpty()) {
			System.out.println("No customers have registered yet.");
			AdminSubMenu();
		}
		if(approvedCustomerUsernameArray.isEmpty()) {
			System.out.println("No customers have been approved/denied to open an account yet.");
			AdminSubMenu();
		}
		
		System.out.println("Displaying customers with an open account:");
		for(int i = 0; i<approvedCustomerUsernameArray.size(); i++) {
			System.out.println(i + " ---> " + approvedCustomerUsernameArray.get(i)); //notice the index i coincides with the index where the String within customerUsernameArray is located
		}
		
		System.out.println("Enter the number corresponding to the customer you want to TRANSFER funds from"); //TRANSFER FROM
		Scanner input = new Scanner(System.in);
		int usernameIndexFrom = input.nextInt();
		if(usernameIndexFrom >= approvedCustomerUsernameArray.size()) { //if the admin inputs an invalid index, this block sents him back to EmployeeSubMenu 
			System.out.println("Invalid input.");
			AdminSubMenu();
		}
		
		int customerIndexFrom = approvedCustomerUsernameArray.indexOf(customerUsernameArray.get(usernameIndexFrom)); //stores customer's index in "customerIndex"
		String customerUsernameFrom = approvedCustomerUsernameArray.get(usernameIndexFrom); //stores customer's username in "customerUsername"
		
		if(customerMoneyArray.isEmpty()) { // !!!These two if statements MUST come in pairs!
			customerMoneyArray.add(usernameIndexFrom, 0.0);
		}
		if(usernameIndexFrom >= customerMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			customerMoneyArray.add(usernameIndexFrom, 0.0);
		}
		double customerCurrentBalanceFrom = customerMoneyArray.get(customerIndexFrom); //stores customer's money in "customerCurrentBalance"
		
		///UP TO THIS POINT, METHOD IS IDENTICAL TO specialViewMethod();
		
		System.out.println("Displaying customers with an open account:");
		for(int i = 0; i<approvedCustomerUsernameArray.size(); i++) {
			System.out.println(i + " ---> " + approvedCustomerUsernameArray.get(i)); //notice the index i coincides with the index where the String within customerUsernameArray is located
		}
		
		System.out.println("Enter the number corresponding to the customer you want to TRANSFER funds to"); //TRANSFER TO
		Scanner input2 = new Scanner(System.in);
		int usernameIndexTo = input2.nextInt();
		if(usernameIndexTo >= approvedCustomerUsernameArray.size()) { //if the admin inputs an invalid index, this block sents him back to EmployeeSubMenu 
			System.out.println("Invalid input.");
			AdminSubMenu();
		}
		
		if(customerMoneyArray.isEmpty()) { // !!!These two if statements MUST come in pairs!
			customerMoneyArray.add(usernameIndexTo, 0.0);
		}
		if(usernameIndexTo >= customerMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			customerMoneyArray.add(usernameIndexTo, 0.0);
		}
		
		int customerIndexTo = approvedCustomerUsernameArray.indexOf(customerUsernameArray.get(usernameIndexTo)); //stores customer's index in "customerIndex"
		String customerUsernameTo = approvedCustomerUsernameArray.get(usernameIndexTo); //stores customer's username in "customerUsername"
		double customerCurrentBalanceTo = customerMoneyArray.get(customerIndexTo); //stores customer's money in "customerCurrentBalance"
		
		if(approvedCustomerUsernameArray.contains(customerUsernameTo)) { // TESTING TESTING
			int indexFrom = customerIndexFrom;
			int indexTo = customerIndexTo;
			if(indexTo >= customerMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
				customerMoneyArray.add(indexTo, 0.0);
			}
			
			System.out.println("Enter amount you would like to TRANSFER to this account");
			Scanner input3 = new Scanner(System.in);
			double moneyBeingTransferred = input3.nextDouble();
			
			double currentBalanceFrom = customerMoneyArray.get(indexFrom); //remember indexFrom == usernameIndex
			double currentBalanceTo = customerMoneyArray.get(indexTo); //this is equal to 0.0 if account didn't exist prior to TRANSFER operation
			double newBalanceFrom = currentBalanceFrom - moneyBeingTransferred;
			double newBalanceTo = currentBalanceTo + moneyBeingTransferred;
			
			//JDBC
			//Note: To avoid the same user being added multiple times to the SQL table, try to keep his balance positive at all times after the first deposit
			MoneyTable moneyTableRecord = new MoneyTable(indexFrom, customerUsernameFrom, newBalanceFrom);
			MoneyTableDaoImpl moneyDataAccessObject = new MoneyTableDaoImpl();
			moneyDataAccessObject.updateMoneyTable(moneyTableRecord);
			//end of JDBC
			
			//JDBC
			//Note: To avoid the same user being added multiple times to the SQL table, try to keep his balance positive at all times after the first deposit
			MoneyTable moneyTableRecord2 = new MoneyTable(indexTo, customerUsernameTo, newBalanceTo);
			MoneyTableDaoImpl moneyDataAccessObject2 = new MoneyTableDaoImpl();
			moneyDataAccessObject2.updateMoneyTable(moneyTableRecord2);
			//end of JDBC
			
			customerMoneyArray.set(indexFrom, newBalanceFrom);
			customerMoneyArray.set(indexTo, newBalanceTo);
			
			System.out.println("You transferred $" + moneyBeingTransferred + " from " + customerUsernameFrom + "'s account to " + customerUsernameTo + "'s account.");
			System.out.println(customerUsernameFrom + "'s balance is $" + customerMoneyArray.get(indexFrom));
			System.out.println(customerUsernameTo + "'s balance is $" + customerMoneyArray.get(indexTo));
			
			AdminSubMenu();
		} else {
			System.out.println("Account does not exist.");
			AdminSubMenu();
		}
		
	}
	public static void cancelAccountMethod() throws IOException { //To delete accounts you'll make use of customerIndex, customerUsername, customerPassword, customerCurrentBalance
		if(customerUsernameArray.isEmpty()) {
			System.out.println("No customers have registered yet.");
			AdminSubMenu();
		}
		if(approvedCustomerUsernameArray.isEmpty()) {
			System.out.println("No customers have been approved/denied to open an account yet.");
			AdminSubMenu();
		}
		
		System.out.println("Displaying customers with an open account:");
		for(int i = 0; i<approvedCustomerUsernameArray.size(); i++) {
			System.out.println(i + " ---> " + approvedCustomerUsernameArray.get(i)); //notice the index i coincides with the index where the String within customerUsernameArray is located
		}
		
		System.out.println("Enter the number corresponding to the customer whose account you want to CANCEL"); //TRANSFER FROM
		Scanner input = new Scanner(System.in);
		int usernameIndex = input.nextInt();
		if(usernameIndex >= approvedCustomerUsernameArray.size()) { //if the admin inputs an invalid index, this block sents him back to EmployeeSubMenu 
			System.out.println("Invalid input.");
			AdminSubMenu();
		}
		
		// TESTING TESTING
		int customerIndex = approvedCustomerUsernameArray.indexOf(customerUsernameArray.get(usernameIndex)); //stores customer's index in "customerIndex"
		String customerUsername = approvedCustomerUsernameArray.get(usernameIndex); //stores customer's username in "customerUsername"
		String customerPassword = approvedCustomerPasswordArray.get(usernameIndex); //stores customer's password in "customerPassword"
		
		if(customerMoneyArray.isEmpty()) { // !!!These two if statements MUST come in pairs!
			customerMoneyArray.add(usernameIndex, 0.0);
		}
		if(usernameIndex >= customerMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			customerMoneyArray.add(usernameIndex, 0.0);
		}
		double customerCurrentBalance = customerMoneyArray.get(customerIndex); //stores customer's money in "customerCurrentBalance"
		
		//hmm
		
		System.out.println("You chose customer: " + customerIndex + " ---> " + customerUsername);
		System.out.println("Are you sure you want to CANCEL this account?");
		System.out.println("Press 1 for YES");
		System.out.println("Press 2 for NO");
		Scanner input2 = new Scanner(System.in);
		int adminChoice = input2.nextInt();
		
		if(adminChoice == 1) {
			int oldCustomerIndex = customerUsernameArray.indexOf(approvedCustomerUsernameArray.get(customerIndex)); //index used to delete username and password from "customerUsernameArray" and "customerPasswordArray"
			
			
			//int customerIndex = customerUsernameArray.indexOf(candidateUsername);
			//JDBC
			CustomerTableDaoImpl customerDataAccessObject = new CustomerTableDaoImpl();
			CustomerTable findCustomerTableRecord = customerDataAccessObject.selectCustomerTableByName(customerUsername);
			customerDataAccessObject.deleteCustomerTable(findCustomerTableRecord);
			
			/*
			CustomerTable customerTableRecord = new CustomerTable(customerIndex, customerUsername, customerPassword);
			CustomerTableDaoImpl customerDataAccessObject = new CustomerTableDaoImpl();
			customerDataAccessObject.deleteCustomerTable(customerTableRecord);
			*/
			//end of JDBC
			
			customerUsernameArray.remove(oldCustomerIndex);
			customerPasswordArray.remove(oldCustomerIndex);
			approvedCustomerUsernameArray.remove(customerIndex);
			approvedCustomerPasswordArray.remove(customerIndex);
			customerMoneyArray.remove(customerIndex);
			
			System.out.println("Customer's account has been DELETED");
			AdminSubMenu();
		}
		else if(adminChoice == 2) {
			AdminSubMenu();
		}
		else {
			System.out.println("Invalid input.");
			AdminSubMenu();
		}
	}
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	
	public static void main(String[] args) throws IOException {
		MainMenu();
	}

}
