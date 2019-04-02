/*
 * Program works like this:
 * 
 * You press numbers 1-7 when prompted to do so.
 * You input names, passwords, and money amounts when prompted to do so.
 * 
 * There is one MAIN MENU, from which 3 different submenus branch out:
 * 1) CUSTOMER MENU
 * 2) EMPLOYEE MENU
 * 3) ADMIN MENU
 * 
 * These menus will prompt the user to first REGISTER, and then LOGIN.
 * Nothing can be done before user registers as a CUSTOMER, an EMPLOYEE, or an ADMIN.
 * 
 * Each of the menus has a access to a different submenu:
 * 1) CUSTOMER MENU ---> CUSTOMER SUB MENU
 * 2) EMPLOYEE MENU ---> EMPLOYEE SUB MENU
 * 3) ADMIN MENU ---> ADMIN MENU
 * 
 * Follow instructions to proceed at each step.
 * 
 * Note:
 * Program does NOT support customers/employees/admins having the same username and/or the same password
 * ABSOLUTELY NOBODY CAN HAVE THE SAME USERNAME AND/OR PASSWORD !!!
 * 
 * Also, the TRANSFER method is overall buggy, alongside the CheckCurrentBalanceMethod() associated with it.
 * You can't VIEW candidates whose accounts haven't been approved yet.
 */

package bankingapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<String> usernameArray = new ArrayList<String>(); //this block is for the use of CUSTOMERS ONLY
	static ArrayList<String> passwordArray = new ArrayList<String>();
	static ArrayList<Double> moneyArray = new ArrayList<Double>();
	public static void addToUsernameArray(String newUser) {
		usernameArray.add(newUser);
	}
	public static void addToPasswordArray(String newPassword) {
		passwordArray.add(newPassword);
	}
	public static void addToMoneyArray(double newMoney) {
		moneyArray.add(newMoney);
	}
	
	static ArrayList<String> employeeUsernameArray = new ArrayList<String>(); //this block is for the use of EMPLOYEES only
	static ArrayList<String> employeePasswordArray = new ArrayList<String>();
	static ArrayList<String> approvedUsernameArray = new ArrayList<String>();
	static ArrayList<String> deniedUsernameArray = new ArrayList<String>();
	public static void addToEmployeeUsernameArray(String newUser) {
		employeeUsernameArray.add(newUser);
	}
	public static void addToEmployeePasswordArray(String newPassword) {
		employeePasswordArray.add(newPassword);
	}
	public static void addToApprovedUsernameArray(String newUser) {
		approvedUsernameArray.add(newUser);
	}
	public static void addToDeniedUsernameArray(String newUser) {
		deniedUsernameArray.add(newUser);
	}
	
	static ArrayList<String> adminUsernameArray = new ArrayList<String>(); //this block is for the use of ADMINS only
	static ArrayList<String> adminPasswordArray = new ArrayList<String>();
	static ArrayList<Double> adminMoneyArray = new ArrayList<Double>();
	//static ArrayList<String> approvedUsernameArray = new ArrayList<String>();
	//static ArrayList<String> deniedUsernameArray = new ArrayList<String>();
	public static void addToAdminUsernameArray(String newUser) {
		adminUsernameArray.add(newUser);
	}
	public static void addToAdminPasswordArray(String newPassword) {
		adminPasswordArray.add(newPassword);
	}
	/*
	public static void addToApprovedUsernameArray(String newUser) {
		approvedUsernameArray.add(newUser);
	}
	public static void addToDeniedUsernameArray(String newUser) {
		deniedUsernameArray.add(newUser);
	}
	*/
	
	public static void setUsernameMethod(int cusEmpAdm) { //method prompts user to input a new username
		System.out.println("Enter a username >>>"); //expects user to input a username of their choice
		Scanner input = new Scanner(System.in);
		String userName = input.nextLine();
		
		switch(cusEmpAdm) {
		case 1: addToUsernameArray(userName);
		case 2: addToEmployeeUsernameArray(userName);
		case 3: addToAdminUsernameArray(userName);
		}
	}
	
	public static void setPasswordMethod(int cusEmpAdm) { //method prompts user to input a new username
		System.out.println("Enter a password >>>"); //expects user to input a username of their choice
		Scanner input = new Scanner(System.in);
		String userPassword = input.nextLine();
		
		switch(cusEmpAdm) {
		case 1: addToPasswordArray(userPassword);
		case 2: addToEmployeePasswordArray(userPassword);
		case 3: addToAdminPasswordArray(userPassword);
		}
	}
	
	/*
	public static void setPasswordMethod() { //method prompts user to input a new password
		Scanner input1 = new Scanner(System.in); //Customer password selection
		System.out.println("Enter a password >>> ");
		String userPassword1 = input1.nextLine();

		Scanner input2 = new Scanner(System.in); //Customer password verification (asks user to input the same password)
		System.out.println("Verify password by typing it again >>> ");
		String userPassword2 = input2.nextLine();

		boolean arePasswordsEqual = userPassword1.equals(userPassword2); //verifies if both passwords are equal; returns true if so
		
		String userPassword = new String(); //User's actual password
		if(arePasswordsEqual == true) {
			userPassword = userPassword1;
			
			addToPasswordArray(userPassword1);
			
			System.out.println("Your password is now set to: " + userPassword1);
		}
		else {
			System.out.println("The passwords don't match; please try again: ");
			setPasswordMethod(); //recursion; if passwords don't match, passwordMethod() gets "restarted"
		}
		
	}
	*/
	
	public static void loginAttempt() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your existing username: ");
		String askUsername = input.nextLine();
		
		boolean tempUsername = usernameArray.contains(askUsername);
		int askUsernameIndex = usernameArray.indexOf(askUsername);
		
		if(tempUsername == false) {
			System.out.println("Username does not exist in database.");
			CustomerMenu();
		}
		//after this if block, it is assumed the username DOES exist
		
		Scanner askPasswordInput = new Scanner(System.in);
		System.out.println("Enter your password: ");
		String askPassword = askPasswordInput.nextLine();
		
		boolean tempPassword = passwordArray.contains(askPassword);
		int askPasswordIndex = passwordArray.indexOf(askPassword);
		
		if(tempPassword == false) {
			System.out.println("Wrong password. (1)"); //prints if password does NOT exist in the database; I figured it would be best not to share this info though, for security reasons
			CustomerMenu();
		} else if((tempPassword == true) & (askPasswordIndex != askUsernameIndex)) {
			System.out.println("Wrong password. (2)"); //prints if password DOES exist in the database, but is not a pair of the username; info not shared for security reasons
			CustomerMenu();
		}
		
		if(tempUsername == true & tempPassword == true) { //checks if both username and password exist
			
			if(askUsernameIndex == askPasswordIndex) { //checks whether username and password indexes match
				//at this point both username and password exist, and their indexes match each other
				if(approvedDeniedCheckMethod(askUsername) == 1) {
					System.out.println("Login attempt success.");

					CustomerSubMenu(askUsernameIndex); // sends you to Customer Sub Menu (the "actions" menu)
					//notice you could as well have passed "askPasswordIndex" as an argument instead of "askUsernameIndex"
				} else if(approvedDeniedCheckMethod(askUsername) == 2) {
					System.out.println("Account request was DENIED by either an employee or an admin. Please try again later.");
					CustomerMenu();
				} else if(approvedDeniedCheckMethod(askUsername) == 3) {
					System.out.println("Account has not been approved yet. Wait for an employee or an admin to process your request.");
					CustomerMenu(); //if account hasn't been approved, this sends you back to Customer Menu
				}

				CustomerSubMenu(askUsernameIndex); // sends you to Customer Sub Menu (the "actions" menu)
				//notice you could as well have passed "askPasswordIndex" as an argument instead of "askUsernameIndex"
			}
		}
	}
	
	public static int approvedDeniedCheckMethod(String askUsername) {
		if(approvedUsernameArray.contains(askUsername)) {
			return 1;
		} else if(deniedUsernameArray.contains(askUsername)) {
			return 2;
		}
		else {
			return 3;
		}
		//if APPROVED return "true"
		//if denied return "false"
	}
	
	public static void CustomerSubMenu(int index) { //this method can ONLY be called if usernameIndex == passwordIndex (the only way an account can be successfully accessed)
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
		case 1: withdrawMethod(index);
				CustomerSubMenu(index);
		case 2: depositMethod(index);
				CustomerSubMenu(index);
		case 3: transferMethod(index);
				CustomerSubMenu(index);
		case 4: System.out.println("Your current balance is: $" + checkCurrentBalanceMethod(index));
				CustomerSubMenu(index);
		case 5: CustomerMenu(); //returns you back to the Customer Menu
		default: System.out.println("Invalid input.");
				 CustomerSubMenu(index);
		}
	}
	public static void transferMethod(int index) {
		
		if(usernameArray.isEmpty()) {
			System.out.println("No customer accounts have been created yet.");
			MainMenu(); //sends you back to the main menu if you try to VIEW before a CUSTOMER account is created
		}
		
		if(index >= moneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			moneyArray.add(index, 0.0);
		}
		
		/*
		if(moneyArray.isEmpty()) { //this if statement makes sure the ArrayList index position is not empty; initializes index position to $0.0 if so
			moneyArray.add(index, 0.0);
		}
		*/
		
		System.out.println("Whose account would you like to transfer to?");
		Scanner input = new Scanner(System.in);
		String userTo = input.nextLine(); //username of user you're trying to transfer money to
		
		int userToIndex = usernameArray.indexOf(userTo);
		initializeEmptyArrayListIndex(userToIndex); //initializes an empty ArrayList index position in case someone wants to transfer money to an inexistent account
		/* YOU CAN USE THE SYNTAX OF THE CODE ABOVE INSTEAD OF THE CODE BELOW
		if(index >= moneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			moneyArray.add(index, 0.0);
		*/
	
		
		int indexTo = -1; //index of user you're trying to transfer money to
		boolean userFound = false;
		for(int i = 0; i<usernameArray.size(); i++) {
			indexTo = usernameArray.indexOf(userTo); //indexOf() method returns index of first occurrence of the specified element in that ArrayList, or returns -1 if ArrayList does not contain the element
			if(indexTo != -1) {
				injectMoneyToDifferentAccount(index, indexTo, userTo);
			}
			else {
				System.out.println("Username does not exist in database.");
				CustomerSubMenu(index);
			}
		}
	}
	
	public static void initializeEmptyArrayListIndex(int index) {
		if(index >= moneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			moneyArray.add(index, 0.0);
		}
	}
	
	public static void injectMoneyToDifferentAccount(int indexFrom, int indexTo, String userTo) {//method can ONLY be accessed once the program has made sure there are at least 2 customer accounts open
		System.out.println("Enter amout you would like to transfer:");
		Scanner input = new Scanner(System.in);
		double moneyBeingTransferred = input.nextDouble();
		
		double currentBalanceFrom = moneyArray.get(indexFrom); //variable used to make sure there are enough funds to support transfer of money
		double currentBalanceTo = moneyArray.get(indexTo); //the account receiving the money doesn't care if it's currently at $0.0, as long as the account exists
		
		double newBalanceFrom = currentBalanceFrom - moneyBeingTransferred;
		
		// !!! DELETE THIS BLOCK TO ALLOW USER TO OVERDRAW MONEY (WITHDRAW MORE THAN WHAT'S AVAILABLE)
		if(newBalanceFrom <= 0) {
			System.out.println("You can't tranfer more money than you have.");
			CustomerSubMenu(indexFrom);
		}
		
		double newBalanceTo = currentBalanceTo + moneyBeingTransferred;
		moneyArray.add(indexFrom, newBalanceFrom);
		moneyArray.add(indexTo, newBalanceTo);
		System.out.println("You transferred $" + moneyBeingTransferred + " to " + userTo + "'s account");
		System.out.println("Your current balance is: $" + checkCurrentBalanceMethod(indexFrom)); //prints current balance of person who sent the money
		System.out.println(userTo + "'s current balance is: $" + checkCurrentBalanceMethod(indexTo)); // DELETE THIS AFTER TESTING
		CustomerSubMenu(indexFrom);
	}
	
	public static void withdrawMethod(int index) {
		
		if(usernameArray.isEmpty()) {
			System.out.println("No customer accounts have been created yet.");
			MainMenu(); //sends you back to the main menu if you try to VIEW before a CUSTOMER account is created
		}
		
		if(index >= moneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			moneyArray.add(index, 0.0);
		}
		
		/*
		if(moneyArray.isEmpty()) { //this if statement makes sure the ArrayList index position is not empty; initializes index position to $0.0 if so
			moneyArray.add(index, 0.0);
		}
		*/
		
		double currentBalance = moneyArray.get(index);
		
		// !!! DELETE THIS BLOCK TO ALLOW USER TO OVERDRAW MONEY (WITHDRAW MORE THAN WHAT'S AVAILABLE)
		if(currentBalance == 0.0) {
			System.out.println("Your current balance is: $" + currentBalance + "; You can't withdraw money without funds.");
			CustomerSubMenu(index); //sends you back to Customer Sub Menu if current balance is $0.0
		}
		
		System.out.println("Enter amount you would like to withdraw:");
		Scanner input = new Scanner(System.in);
		double moneyBeingWithdrawn = input.nextDouble();
		
		// !!! DELETE THIS BLOCK TO ALLOW USER TO OVERDRAW MONEY (WITHDRAW MORE THAN WHAT'S AVAILABLE)
		if((currentBalance - moneyBeingWithdrawn) <= 0.0) { //checks if amount to be withdrawn is more than what's available, before proceeding to allow a withdrawal to occur
			System.out.println("Your current balance is: $" + currentBalance + "; You can't withdraw $" + moneyBeingWithdrawn + " because there are not enough funds.");
			CustomerSubMenu(index); //sends you back to Customer Sub Menu if user tried withdrawing more than what's available
		}
		
		System.out.println("Previous balance: $" + currentBalance);
		double newBalance = currentBalance - moneyBeingWithdrawn; //balance after money is added
		moneyArray.add(index, newBalance); //newBalance replaces previous quantity at index location
		System.out.println("You withdrew: $" + moneyBeingWithdrawn);
		System.out.println("Current balance: $" + moneyArray.get(index));
	}
	
	public static void depositMethod(int index) {
		
		if(usernameArray.isEmpty()) {
			System.out.println("No customer accounts have been created yet.");
			MainMenu(); //sends you back to the main menu if you try to VIEW before a CUSTOMER account is created
		}
		
		if(index >= moneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			moneyArray.add(index, 0.0);
		}
		
		/*
		if(moneyArray.isEmpty()) { //this if statement makes sure the ArrayList index position is not empty; initializes index position to $0.0 if so
			moneyArray.add(index, 0.0);
		}
		*/
		
		System.out.println("Enter amount you would like to deposit:");
		Scanner input = new Scanner(System.in);
		double moneyBeingAdded = input.nextDouble();
		
		double currentBalance = moneyArray.get(index); //balance before money is added
		System.out.println("Previous balance: $" + currentBalance);
		double newBalance = currentBalance + moneyBeingAdded; //balance after money is added
		moneyArray.add(index, newBalance); //newBalance replaces previous quantity at index location
		
		//ADMIN BLOCK///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		String approvedUsernameArrayUsername = usernameArray.get(index); //finds the user's actual username; i.e. "John"
		int approvedUsernameArrayIndex = approvedUsernameArray.indexOf(approvedUsernameArrayUsername);
		if(index >= adminMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			adminMoneyArray.add(approvedUsernameArrayIndex, 0.0);
		}
		adminMoneyArray.add(approvedUsernameArrayIndex, newBalance);
		//ADMIN BLOCK///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("You deposited: $" + moneyBeingAdded);
		System.out.println("Current balance: $" + moneyArray.get(index));
		//Notice that the ONLY way for the user to gain access to the depositMethod(index) method is for him to gain access to 
		//the CustomerSubMenu(index) method first, and the latter method can ONLY be accessed if both the inputed username and password have
		//have the same index, meaning that the "index" variable that the withdrawMethod(index), depositMethod(index), and
		//transferMethod(index) take in as an argument HAS to correspond to the right index location where the money will be placed
		//Gaining access to the CustomerSubMenu(index) method means you're already at the right index location to 
		//withdraw/deposit/transfer funds
		
		CustomerSubMenu(index);
	}
	
	public static double checkCurrentBalanceMethod(int index) {
		if(index >= moneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			moneyArray.add(index, 0.0);
		}
		
		/*
		if(moneyArray.isEmpty()) { //this if statement makes sure the ArrayList index position is not empty; initializes index position to $0.0 if so
			moneyArray.add(index, 0.0);
		}
		*/
		
		double currentBalance = moneyArray.get(index); //balance
		//System.out.println("Your current balance is: $" + currentBalance);
		return currentBalance;
	}
	
	public static void MainMenu(){
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
	
	public static void CustomerMenu() {
		
		int cusEmpAdm = 1;
		
		System.out.println("\n** CUSTOMER MENU **");
		System.out.println("Would you like to REGISTER or LOGIN");
		System.out.println("Press 1 to REGISTER");
		System.out.println("Press 2 to LOGIN");
		System.out.println("Press 3 to return to MAIN MENU");
		
		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		
		switch(userInput) {
		case 1: registerMethod(cusEmpAdm);
				CustomerMenu();
		case 2: loginAttempt(); //notice there should be 3 different loginMethod() methods: for CUSTOMER, EMPLOYEE and ADMIN
		case 3: MainMenu(); //sends you back to the Main Menu
		default : System.out.println("Invalid input.");
				  CustomerMenu();
		}
	}
	
	public static void EmployeeMenu() {
		
		int cusEmpAdm = 2;
		
		System.out.println("\n** EMPLOYEE MENU **");
		System.out.println("Would you like to REGISTER or LOGIN");
		System.out.println("Press 1 to REGISTER");
		System.out.println("Press 2 to LOGIN");
		System.out.println("Press 3 to return to MAIN MENU");
		
		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		
		switch(userInput) {
		case 1: registerMethod(cusEmpAdm);
				EmployeeMenu();
		case 2: employeeLoginAttempt(); //notice there should be 3 different loginAttemptMethod() methods: for CUSTOMER, EMPLOYEE and ADMIN; each loginAttemptMethod() gives you access to the CUSTOMER SUBMENU, EMPLOYEE SUBMENU, and ADMIN SUBMENU; that's why there's 3
		case 3: MainMenu(); //sends you back to the Main Menu
		default : System.out.println("Invalid input.");
				  EmployeeMenu();
		}
	}
	
	public static void AdminMenu() {
		
		int cusEmpAdm = 3;
		
		System.out.println("\n** ADMIN MENU **");
		System.out.println("Would you like to REGISTER or LOGIN");
		System.out.println("Press 1 to REGISTER");
		System.out.println("Press 2 to LOGIN");
		System.out.println("Press 3 to return to MAIN MENU");
		
		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		
		switch(userInput) {
		case 1: registerMethod(cusEmpAdm);
				AdminMenu();
		case 2: AdminLoginAttempt(); //notice there should be 3 different loginAttemptMethod() methods: for CUSTOMER, EMPLOYEE and ADMIN; each loginAttemptMethod() gives you access to the CUSTOMER SUBMENU, EMPLOYEE SUBMENU, and ADMIN SUBMENU; that's why there's 3
		case 3: MainMenu(); //sends you back to the Main Menu
		default : System.out.println("Invalid input.");
				  AdminMenu();
		}
	}
	
	public static void AdminLoginAttempt() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your existing username: ");
		String askUsername = input.nextLine();
		
		boolean tempUsername = adminUsernameArray.contains(askUsername);
		int askUsernameIndex = adminUsernameArray.indexOf(askUsername);
		
		if(tempUsername == false) {
			System.out.println("Username does not exist in database.");
			AdminMenu();
		}
		//after this if block, it is assumed the username DOES exist
		
		Scanner askPasswordInput = new Scanner(System.in);
		System.out.println("Enter your password: ");
		String askPassword = askPasswordInput.nextLine();
		
		boolean tempPassword = adminPasswordArray.contains(askPassword);
		int askPasswordIndex = adminPasswordArray.indexOf(askPassword);
		
		if(tempPassword == false) {
			System.out.println("Wrong password. (1)"); //prints if password does NOT exist in the database; I figured it would be best not to share this info though, for security reasons
			AdminMenu();
		} else if((tempPassword == true) & (askPasswordIndex != askUsernameIndex)) {
			System.out.println("Wrong password. (2)"); //prints if password DOES exist in the database, but is not a pair of the username; info not shared for security reasons
			AdminMenu();
		}
		
		if(tempUsername == true & tempPassword == true) { //checks if both username and password exist
			
			if(askUsernameIndex == askPasswordIndex) { //checks whether username and password indexes match
				System.out.println("Login attempt success.");

				AdminSubMenu(askUsernameIndex); // sends you to Customer Sub Menu (the "actions" menu)
				//notice you could as well have passed "askPasswordIndex" as an argument instead of "askUsernameIndex"
			}
		}
	}


	
	public static void EmployeeSubMenu(int index) { //this method can ONLY be called if usernameIndex == passwordIndex (the only way an account can be successfully accessed)
		System.out.println("\n* EMPLOYEE SUBMENU *");
		System.out.println("What would you like to do? APPROVE/DENY accounts, VIEW accounts, LOGOUT");
		System.out.println("Press 1 to APPROVE/DENY");
		System.out.println("Press 2 to VIEW");
		System.out.println("Press 3 to LOGOUT and return to EMPLOYEE MENU");
		
		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		
		switch(userInput) {
		case 1: approveDenyMethod(index);
				EmployeeSubMenu(index);
		case 2: viewMethod(index);
				EmployeeSubMenu(index);
		case 3: EmployeeMenu(); //returns you back to the Customer Menu
		default: System.out.println("Invalid input.");
				 EmployeeSubMenu(index);
		}
	}
	
	public static void AdminSubMenu(int index) { //this method can ONLY be called if usernameIndex == passwordIndex (the only way an account can be successfully accessed)
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
		case 1: approveDenyMethod(index);
				AdminSubMenu(index);
		case 2: viewMethod(index);
				AdminSubMenu(index);
		case 3: specialWithdrawMethod(index);
				AdminSubMenu(index);
		case 4: specialDepositMethod(index);
				AdminSubMenu(index);
		//case 5: transferMethod(index); //ran out of time; didn't implement this functionality
				//AdminSubMenu(index);
		case 6: cancelAccountMethod(index);
				AdminSubMenu(index);
		case 7: AdminMenu(); //returns you back to the Customer Menu
		default: System.out.println("Invalid input.");
				 AdminSubMenu(index);
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void specialWithdrawMethod(int index) {
		
		if(usernameArray.isEmpty()) {
			System.out.println("No customer accounts have been created yet.");
			MainMenu(); //sends you back to the main menu if you try to VIEW before a CUSTOMER account is created
		}
		
		System.out.println("Displaying customers with open accounts:");
		for(int i = 0; i<approvedUsernameArray.size(); i++) {
			System.out.println(i + " ---> " + approvedUsernameArray.get(i)); //prints contents of approvedUsernameArray
		}
		System.out.println("Press the number corresponding to customer whose account you want to WITHDRAW funds from");
		Scanner input = new Scanner(System.in);
		int userIndex = input.nextInt();
		
		if(userIndex >= moneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			moneyArray.add(userIndex, 0.0);
		}
		if(userIndex >= adminMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			adminMoneyArray.add(userIndex, 0.0);
		}
		
		System.out.println("You chose user: " + userIndex + " ---> " + approvedUsernameArray.get(userIndex));
		System.out.println("Enter amount you would like to withdraw:");
		Scanner input2 = new Scanner(System.in);
		double moneyBeingWithdrawn = input2.nextDouble();
		
		double currentBalance = adminMoneyArray.get(userIndex);
		
		// !!! DELETE THIS BLOCK TO ALLOW ADMIN TO OVERDRAW MONEY (WITHDRAW MORE THAN WHAT'S AVAILABLE)
		if(currentBalance == 0.0) {
			System.out.println("Customer's current balance is: $" + currentBalance + "; You can't withdraw money without funds.");
			AdminSubMenu(index); //sends you back to Customer Sub Menu if current balance is $0.0
		}
		
		// !!! DELETE THIS BLOCK TO ALLOW ADMIN TO OVERDRAW MONEY (WITHDRAW MORE THAN WHAT'S AVAILABLE)
		if((currentBalance - moneyBeingWithdrawn) <= 0.0) { //checks if amount to be withdrawn is more than what's available, before proceeding to allow a withdrawal to occur
			System.out.println("Customer's current balance is: $" + currentBalance + "; You can't withdraw $" + moneyBeingWithdrawn + " because there are not enough funds.");
			AdminSubMenu(index); //sends you back to Customer Sub Menu if user tried withdrawing more than what's available
		}
		
		System.out.println("Customer's previous balance: $" + currentBalance);
		double newBalance = currentBalance - moneyBeingWithdrawn; //balance after money is added
		adminMoneyArray.add(index, newBalance); //newBalance replaces previous quantity at index location
		System.out.println("You withdrew: $" + moneyBeingWithdrawn + " from " + approvedUsernameArray.get(userIndex) + "'s account");
		System.out.println("Customer's current balance: $" + adminMoneyArray.get(index));
		
		AdminSubMenu(index);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void specialDepositMethod(int index) {
		if(usernameArray.isEmpty()) {
			System.out.println("No customer accounts have been created yet.");
			MainMenu(); //sends you back to the main menu if you try to VIEW before a CUSTOMER account is created
		}
		
		/*
		if(moneyArray.isEmpty()) { //this if statement makes sure the ArrayList index position is not empty; initializes index position to $0.0 if so
			moneyArray.add(index, 0.0);
		}
		*/
		
		System.out.println("Displaying customers with open accounts:");
		for(int i = 0; i<approvedUsernameArray.size(); i++) {
			System.out.println(i + " ---> " + approvedUsernameArray.get(i)); //prints contents of approvedUsernameArray
		}
		System.out.println("Press the number corresponding to customer whose account you want to DEPOSIT to");
		Scanner input = new Scanner(System.in);
		int userIndex = input.nextInt();
		
			
		if(userIndex >= moneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			moneyArray.add(userIndex, 0.0);
		}
		if(userIndex >= adminMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			adminMoneyArray.add(userIndex, 0.0);
		}
		
		System.out.println("You chose user: " + userIndex + " ---> " + approvedUsernameArray.get(userIndex));
		System.out.println("Enter amount you would like to deposit:");
		Scanner input2 = new Scanner(System.in);
		
		
		double moneyBeingAdded = input2.nextDouble();
		
		double currentBalance = adminMoneyArray.get(userIndex); //balance before money is added
		System.out.println("Previous balance: $" + currentBalance);
		double newBalance = currentBalance + moneyBeingAdded; //balance after money is added
		adminMoneyArray.add(userIndex, newBalance);
		System.out.println("You deposited: $" + moneyBeingAdded + " into " + approvedUsernameArray.get(userIndex) + "'s account.");
		System.out.println("Current account balance: $" + adminMoneyArray.get(userIndex));
		
		AdminSubMenu(index);
	}
	
	public static void cancelAccountMethod(int index) {
		if(usernameArray.isEmpty()) {
			System.out.println("No customer accounts have been created yet.");
			MainMenu(); //sends you back to the main menu if you try to VIEW before a CUSTOMER account is created
		}
		
		System.out.println("Displaying customers with open accounts:");
		for(int i = 0; i<approvedUsernameArray.size(); i++) {
			System.out.println(i + " ---> " + approvedUsernameArray.get(i)); //prints contents of approvedUsernameArray
		}
		
		System.out.println("Press the number corresponding to customer whose account you want to CANCEL");
		Scanner input = new Scanner(System.in);
		int userIndex = input.nextInt();
		
		if(userIndex >= moneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			moneyArray.add(userIndex, 0.0);
		}
		if(userIndex >= adminMoneyArray.size()) { //this if statement makes sure the ArrayList index position exists; initializes index position to $0.0 if not
			adminMoneyArray.add(userIndex, 0.0);
		}
		
		System.out.println("You chose user: " + userIndex + " ---> " + approvedUsernameArray.get(userIndex));
		System.out.println("Are you sure you want to CANCEL this account?");
		System.out.println("Press 1 for YES");
		System.out.println("Press 2 for NO");
		Scanner input2 = new Scanner(System.in);
		int adminChoice = input2.nextInt();
		
		if(adminChoice == 1) {
			approvedUsernameArray.remove(userIndex); //deletes user from database
			adminMoneyArray.remove(userIndex); //deletes user's money (lol)
			
			String tempString = approvedUsernameArray.get(userIndex); //delete's user password from database
			int tempIndex = usernameArray.indexOf(tempString);
			passwordArray.remove(tempIndex);
			usernameArray.remove(tempIndex);
			
			System.out.println("Customer's account has been DELETED");
			AdminSubMenu(index);
		}
		else if(adminChoice == 2) {
			cancelAccountMethod(index);
		}
		else {
			System.out.println("Invalid input.");
			cancelAccountMethod(index);
		}
		
	}
	
	public static void viewMethod(int index) {
		if(usernameArray.isEmpty()) {
			System.out.println("No customer accounts have been created yet.");
			MainMenu(); //sends you back to the main menu if you try to VIEW before a CUSTOMER account is created
		} else {
			int tempVar = usernameArray.size() - approvedUsernameArray.size();
			System.out.println("Candidates currently waiting for approval to open an account: " + tempVar);
			
			if(approvedUsernameArray.isEmpty()) {
				System.out.println("No candidates have an open account yet.");
				MainMenu(); //this is a glitch; I need to sign-out the user here to avoid the creation of a backdoor
			}
			else {
				System.out.println("Displaying candidates with an open account:");
				for(int i = 0; i<usernameArray.size(); i++) {
					System.out.println(i + " = " + usernameArray.get(i));
				}
			}
		} //this block might crash if you create an account as a CUSTOMER, then try to immediately use approveDenyMethod() as an EMPLOYEE or an ADMIN...
		
		System.out.println("Press the number corresponding to the candidate you want to VIEW");
		Scanner input1 = new Scanner(System.in);
		int candidateIndex = input1.nextInt(); //this is the index position of the candidate
		
		if(candidateIndex > approvedUsernameArray.size()) { //notice you can use if blocks to prevent the code below them from running, by sending the user back to a previous menu or method, until a certain condition is no longer met
			System.out.println("Invalid input.");
			viewMethod(index);
		}
		
		System.out.println("\n****************************************"); //this block displays customer's information (name, current balance)
		System.out.println("Name: " + approvedUsernameArray.get(candidateIndex));
		String name = approvedUsernameArray.get(candidateIndex);
		int oldIndex = usernameArray.indexOf(name);
		System.out.println("Current account balance: $" + checkCurrentBalanceMethod(oldIndex));
		System.out.println("****************************************\n");
		
		System.out.println("Would you like to VIEW other candidates?");
		System.out.println("Press 1 if YES");
		System.out.println("Press 2 If NO");
		Scanner input3 = new Scanner(System.in);
		int userInput3 = input3.nextInt();
		
		switch(userInput3) {
			case 1: viewMethod(index);
			case 2: EmployeeSubMenu(index);
			default: System.out.println("Invalid input. Returning to EMPLOYEE SUBMENU");
					 EmployeeSubMenu(index);
		}
	}
	
	public static void approveDenyMethod(int index) {
		
		if(usernameArray.isEmpty()) {
			System.out.println("No customer accounts have been created yet.");
			MainMenu(); //sends you back to the main menu if you try to VIEW before a CUSTOMER account is created
		} else {
			int tempVar = usernameArray.size() - approvedUsernameArray.size();
			System.out.println("Candidates currently waiting for approval to open an account: " + tempVar);
			if(tempVar == 0) {
				System.out.println("No candidates need approval right now.");
				MainMenu(); //this is a glitch; I need to sign-out the user here to avoid the creation of a backdoor
			} else {
				System.out.println("Displaying candidates waiting for approval:");
				for(int i = 0; i<usernameArray.size(); i++) {
					System.out.println(i + " ---> " + usernameArray.get(i));
				}
			}
		} //this block might crash if you create an account as a CUSTOMER, then try to immediately use approveDenyMethod() as an EMPLOYEE or an ADMIN...
		
		System.out.println("Press the number corresponding to the candidate you want to APPROVE/DENY");
		Scanner input1 = new Scanner(System.in);
		int candidateIndex = input1.nextInt(); //this is the index position of the candidate
		
		if(candidateIndex > usernameArray.size()) { //notice you can use if blocks to prevent the code below them from running, by sending the user back to a previous menu or method, until a certain condition is no longer met
			System.out.println("Invalid input.");
			approveDenyMethod(index);
		}
		
		System.out.println("You chose candidate: " + candidateIndex + " = " + usernameArray.get(candidateIndex));
		System.out.println("Press 1 to APPROVE candidate");
		System.out.println("Press 2 to DENY canidate");
		System.out.println("Press 3 to return to EMPLOYEE SUBMENU");
		Scanner input2 = new Scanner(System.in);
		int userInput2 = input2.nextInt();
		
		switch(userInput2) {
			case 1: addToApprovedUsernameArray(usernameArray.get(candidateIndex));
					System.out.println("Candidate APPROVED");
					break;
					//This only works if no one user shares the same username and/or password of another user
			case 2: addToDeniedUsernameArray(usernameArray.get(candidateIndex));
					System.out.println("Candidate DENIED");
					break;
			case 3: EmployeeSubMenu(index);
			default: System.out.println("Invalid input.");
					 approveDenyMethod(index);
		}
		
		System.out.println("Would you like to APPROVE/DENY other candidates?");
		System.out.println("Press 1 if YES");
		System.out.println("Press 2 If NO");
		Scanner input3 = new Scanner(System.in);
		int userInput3 = input3.nextInt();
		
		switch(userInput3) {
			case 1: approveDenyMethod(index);
			case 2: EmployeeSubMenu(index);
			default: System.out.println("Invalid input. Returning to EMPLOYEE SUBMENU");
					 EmployeeSubMenu(index);
		}
	}
	
	public static void employeeLoginAttempt() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your existing username: ");
		String askUsername = input.nextLine();
		
		boolean tempUsername = employeeUsernameArray.contains(askUsername);
		int askUsernameIndex = employeeUsernameArray.indexOf(askUsername);
		
		if(tempUsername == false) {
			System.out.println("Username does not exist in database.");
			EmployeeMenu();
		}
		//after this if block, it is assumed the username DOES exist
		
		Scanner askPasswordInput = new Scanner(System.in);
		System.out.println("Enter your password: ");
		String askPassword = askPasswordInput.nextLine();
		
		boolean tempPassword = employeePasswordArray.contains(askPassword);
		int askPasswordIndex = employeePasswordArray.indexOf(askPassword);
		
		if(tempPassword == false) {
			System.out.println("Wrong password. (1)"); //prints if password does NOT exist in the database; I figured it would be best not to share this info though, for security reasons
			EmployeeMenu();
		} else if((tempPassword == true) & (askPasswordIndex != askUsernameIndex)) {
			System.out.println("Wrong password. (2)"); //prints if password DOES exist in the database, but is not a pair of the username; info not shared for security reasons
			EmployeeMenu();
		}
		
		if(tempUsername == true & tempPassword == true) { //checks if both username and password exist
			
			if(askUsernameIndex == askPasswordIndex) { //checks whether username and password indexes match
				System.out.println("Login attempt success.");

				EmployeeSubMenu(askUsernameIndex); // sends you to Customer Sub Menu (the "actions" menu)
				//notice you could as well have passed "askPasswordIndex" as an argument instead of "askUsernameIndex"
			}
		}
	}
	
	public static void registerMethod(int cusEmpAdm) {
		setUsernameMethod(cusEmpAdm);
		setPasswordMethod(cusEmpAdm);
	}
	
	public static void main(String[] args) {
		MainMenu();
	}

}