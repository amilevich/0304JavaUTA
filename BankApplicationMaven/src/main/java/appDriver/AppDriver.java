package appDriver;

import java.util.ArrayList;
import java.util.Scanner;

//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import appDao.AccountDaoImpl;
import appDao.CustomerDaoImple;
import appDao.EmployeeDaoImple;
import appModels.Accounts;
import appModels.Customer;
import appModels.Employee;

public class AppDriver {

	final static Logger Log = Logger.getLogger(AppDriver.class);
	final static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws WithdrawTooLargeException, NoAccountDetectedException, TooManyAccountsException, NotApprovedException {
		
		boolean initialized = CheckForInitialEmp("Mom","Dad","Brother","Sister");
		if(initialized == true) {
		
		Log.info("Initialization complete");
		MainMenu();//call main menu
		}
	}

	//Main Menu Method
	static void MainMenu() throws WithdrawTooLargeException, NoAccountDetectedException, TooManyAccountsException, NotApprovedException 
	{
		int choice = 0;
		System.out.println("Welcome to the bank");
		System.out.println("What do you want to do?");
		System.out.println("Press 1: Register and apply   Press 2: Employee Login   Press 3: Customer Login");
		System.out.println("Press 4: Logout/Leave");
		
		choice = CheckInt(choice,"Pick a Choice: ");
			//reads input to decide program state, did not use enum because I thought of it kind of late
		switch (choice) {
		case 1:{Register(); break;}
		case 2:{EmpLogin(); break;}
		case 3:{CustLogin(); break;}
		case 4:{System.out.println("See You Later"); System.exit(0); break;}//If no case is chose then the main method is called again
		default:{System.out.println("Please choose one of the given options"); MainMenu(); break;}}
		
	}

	static void Register() throws WithdrawTooLargeException, NoAccountDetectedException, TooManyAccountsException, NotApprovedException 
	{
		CustomerDaoImple cdi = new CustomerDaoImple();
		boolean check;
		int choice = 0;
		int creditscore = 0;
		int accountTracker = 0;
		int PassW = 0;
		String UserN;
		System.out.print("Create a UserName: ");
		UserN = scan.nextLine();		

		System.out.println("Wait a minute while we check: " + UserN);
		check = CheckForDuplicateUser(UserN); //(returns bool)checks for duplicate users from master file by comparing userNames
								//did not use comparator because I was to far in but I will switch it

		
		System.out.println(check);
		if (check == true) {//if bool is true, there is a duplicate user, back to main method
			System.out.println("User Already Exist"); 
			MainMenu(); 
			}
		
		else {
		System.out.println("Create a Password");				
		PassW  = CheckInt(PassW,"Create a Password: ");
		
		System.out.println("Enter Credit Score");				
		creditscore  = CheckInt(creditscore,"Enter your creditscore: ");
		
		cdi.insertCustomer(new Customer(UserN, PassW, creditscore, accountTracker));
		System.out.println("Youre in, Login with your new user & password.");
		System.out.println("Username: " + UserN);
		System.out.println("Password: " + PassW);
		System.out.println(" \n\n");
		
		
		System.out.println("\n What type of account do you want to create?");
		System.out.println("Press 1: Apply for a Single Account");
		System.out.println("Press 2: Apply for a Joint Account (2nd person must have a UserName");
		
		choice = CheckInt(choice,"Pick a Choice: ");
		switch (choice) {
		case 1: {CreateAccount(UserN,null,"Normal");break;}
		case 2: {String UserN2 = SecondUserCheck();
			if (UserN2 != null) {
				
				CreateAccount(UserN,UserN2,"Joint");
			}
			else {System.out.println("Cannot create Joint Account, Going to main menu");}
				break;
		}
		default: {System.out.println("Not an option, Proceeding to Main Menu, Login to create an Account");break;}
		}
		MainMenu();}
	}
	
	static String ModifiedRegister() 
	{
		CustomerDaoImple cdi = new CustomerDaoImple();
		boolean check;
		int creditscore = 0;
		int accountTracker = 0;
		int PassW2 = 0;
		String UserN2;
		System.out.print("Create a Username 2nd Customer: ");
		UserN2 = scan.nextLine();		

		System.out.println("Wait a minute while we check: " + UserN2);
		check = CheckForDuplicateUser(UserN2); //(returns bool)checks for duplicate users from master file by comparing userNames
								//did not use comparator because I was to far in but I will switch it

		
		System.out.println(check);
		if (check == true) {//if bool is true, there is a duplicate user, back to main method
			System.out.println("User Already Exist"); 
			ModifiedRegister();
			}
		
		else {
		System.out.println("Create a Password");				
		PassW2  = CheckInt(PassW2,"Create a Password: ");
		

		System.out.println("Enter Credit Score");				
		creditscore  = CheckInt(creditscore,"Enter your creditscore: ");
				
		//otherwise, create a new customer and add to master list
			cdi.insertCustomer(new Customer(UserN2, PassW2, creditscore, accountTracker));
			System.out.println("Youre in " + UserN2);
			System.out.println("Username: " + UserN2);
			System.out.println("Password: " + PassW2);
			System.out.println(" \n\n");
			}
		
		return UserN2;			
	}
	
	static void CustLogin() throws WithdrawTooLargeException, NoAccountDetectedException, TooManyAccountsException, NotApprovedException {
		
		CustomerDaoImple cdi = new CustomerDaoImple();
		boolean check;
		int PassW = 0;
		String UserN;
		System.out.print("Give a UserName: ");
		UserN = scan.nextLine();	

		System.out.println("Enter your Password");				
		PassW = CheckInt(PassW,"Enter your password");
		System.out.println("Wait a minute while we check...");
		check = CheckForCustomers(UserN,PassW); 	//returns a boolean from CheckForEmployee method
		
		if (check == false) {	//if false, goes back to main menu
			
			Log.info("Customer Login Failed");
			System.out.println("User Doesn't Exist"); 
			MainMenu();
			}
		else {	//if true, grab customer from master list and go to customer menu
			System.out.println("Welcome  " + UserN);
			Log.info("Customer Login Succeeded");
			CustMenu(cdi.getCustomerByUsername(UserN));//Failed right here
			}
	}
	
	static void CustMenu (Customer cus) throws WithdrawTooLargeException,NoAccountDetectedException,TooManyAccountsException,NotApprovedException
	{ //	logged in customer can perform their function after giving respective inputs
		System.out.println("What do you want to do " + cus.getUsername() + "\n\n");
		System.out.println("Press 1: Apply for a Single Account");
		System.out.println("Press 2: Apply for a Joint Account (2nd person must have a UserName");
		System.out.println("Press 3: View Accounts      Press 4: Transfer with another Customer      Press 5: Deposit");
		System.out.println("Press 6: Withdraw       Press 7: Logout");

		int choice = 0;
		choice = CheckInt(choice,"Choose an option");
		
		switch (choice) { //reads input

		case 1: {
			try {
			if (cus.getAccount_tracker() >= 5) {throw new TooManyAccountsException("You have too many accounts, contact admin to delete one");}
			else {AccountDaoImpl ado = new AccountDaoImpl();
			CustomerDaoImple cdi = new CustomerDaoImple();
			System.out.println("Acount is being created");
			CreateAccount(cus.getUsername(), null, "Normal");
			System.out.println("Wait For Approval");
			int temptracker = cus.getAccount_tracker();
			cus.setAccount_tracker(++temptracker);
			cdi.updateCustomer(cus);
			ado.AutoApproveDeny(cus);
			}}catch(TooManyAccountsException e){e.printStackTrace();CustMenu(cus);}
			CustMenu(cus);
			break;}
	
		case 2: {
			try {
			if (cus.getAccount_tracker() >= 5) {
				throw new TooManyAccountsException("You have too many accounts, contact admin to delete one");
			} else {
				String UserN2 = SecondUserCheck();
				if (UserN2 != null) {
					AccountDaoImpl ado = new AccountDaoImpl();
					CustomerDaoImple cdi = new CustomerDaoImple();
					CreateAccount(cus.getUsername(), UserN2, "Joint");
					int temptracker = cus.getAccount_tracker();
					cus.setAccount_tracker(++temptracker);
					cdi.updateCustomer(cus);
					ado.AutoApproveDeny(cus);					
				} else {
					System.out.println("Cannot create Joint Account, Going to main menu");
				}
			}}catch(TooManyAccountsException e){e.printStackTrace();CustMenu(cus);}
			CustMenu(cus);
			break;
		}

		case 3:{
			try {
			if(cus.getAccount_tracker()>=1) {
			AccountDaoImpl ado = new AccountDaoImpl();
			ArrayList<Accounts> acc = ado.selectCustAccounts(cus.getUsername());
			int i = 0;
			for(Accounts custAcc : acc) {
				System.out.println("" + ++i + ":   " + "Account Num: " + custAcc.getAutoGeneratedNum() + "\tAccount Name:  " + custAcc.getAccount_Name() + "\tAccount Balance:  " + custAcc.getBalance() + "\tAccount Type:  " + custAcc.getAccount_type());

			}
			CustMenu(cus);
			}
			else {
			throw new NoAccountDetectedException("You must make an account to proceed");
				}}catch(NoAccountDetectedException e){e.printStackTrace();CustMenu(cus);}		
			break;}
		
		
		case 4:{
			try { Log.info("Transfer Transaction Attempted");
			if(cus.getAccount_tracker()>=1) {
			AccountDaoImpl ado = new AccountDaoImpl();
			ArrayList<Accounts> acc = ado.selectCustAccounts(cus.getUsername());
			int i = 0;
			for(Accounts custAcc : acc) {
				System.out.println("" + ++i + ":   " + "Account Num: " + custAcc.getAutoGeneratedNum() + "\tAccount Name:  " + custAcc.getAccount_Name() + "\tAccount Balance:  " + custAcc.getBalance() + "\tAccount Type:  " + custAcc.getAccount_type());

			}
				int choices = 0;
			System.out.println("Choose your account");
			choices = CheckInt(choices,"Make a valid choice");
			if (choices >= 1 && choices <=5) {
				if (acc.get(choices - 1).getAccount_State()<1) {throw new NotApprovedException("This account isn't approved or has been denied");}
				else {System.out.println("Enter Second Customer's UserName"); Log.info("Started checking for User 2");
						String UserN2 = scan.nextLine();
						boolean IsUser = CheckForCustomers(UserN2);
						if(IsUser == true) {
							AccountDaoImpl Ado = new AccountDaoImpl();
						ArrayList<Accounts> Acc = Ado.selectCustAccounts(UserN2);
							if (Acc.isEmpty()) {throw new NoAccountDetectedException("User 2 has no accounts");}
						int n = 0;
						for(Accounts CustAcc : Acc) {
							System.out.println("" + ++n + ":   " + "Account Num: " + CustAcc.getAutoGeneratedNum() + "\tAccount Name:  " + CustAcc.getAccount_Name() + "\tAccount Balance:  " + CustAcc.getBalance() + "\tAccount Type:  " + CustAcc.getAccount_type());

						}
							int choy = 0;
						System.out.println("Choose their account");
						choy = CheckInt(choy,"Make a valid choice");
						if (choy >= 1 && choy <=5) {
							if (Acc.get(choy - 1).getAccount_State()<1) {throw new NotApprovedException("This account isn't approved or has been denied");}
							System.out.println("Choose transfer amount");
							int transferAmount = 0; transferAmount =  CheckInt(transferAmount,"Pick only numbers please");
							Ado.Transfer(acc.get(choices-1), Acc.get(choy-1), transferAmount);
							Log.info("Transfer Transaction complete");
							CustMenu(cus);
							
						}else {System.out.println("Not an option");CustMenu(cus);}
					}else {System.out.println("This User doesn't exist, Going back to menu"); CustMenu(cus);}
						}}
			else {
			System.out.println("You need to make a valid choice");
			CustMenu(cus);	
			}
			}	
			else {throw new NoAccountDetectedException("You need to make an account to deposit");
				}}catch(NoAccountDetectedException e){e.printStackTrace();CustMenu(cus);}
					catch(NotApprovedException e) {e.printStackTrace(); CustMenu(cus);}
			break;			
		}
		
		
		
		case 5:{
			try { Log.info("Deposit Transaction Attempted");
			if(cus.getAccount_tracker()>=1) {
			AccountDaoImpl ado = new AccountDaoImpl();
			ArrayList<Accounts> acc = ado.selectCustAccounts(cus.getUsername());
			int i = 0;
			for(Accounts custAcc : acc) {
				System.out.println("" + ++i + ":   " + "Account Num: " + custAcc.getAutoGeneratedNum() + "\tAccount Name:  " + custAcc.getAccount_Name() + "\tAccount Balance:  " + custAcc.getBalance() + "\tAccount Type:  " + custAcc.getAccount_type());

			}
				int choices = 0;
			System.out.println("Choose your account");
			choices = CheckInt(choices,"Make a valid choice");
			if (choices >= 1 && choices <=5) {
				if (acc.get(choices - 1).getAccount_State()<1) {throw new NotApprovedException("This account isn't approved or has been denied");}
				else {System.out.println("How much do you want to add");
					int amount = 0;
					amount = CheckInt(amount,"How do you want to add");
					ado.Deposit(acc.get(choices - 1), amount, cus);
					Log.info("Deposit Transaction Completed");
					System.out.println("Balance has been deposited");
					CustMenu(cus);
					}
												}
			else {
			System.out.println("You need to make a valid choice");
			CustMenu(cus);	
			}
			}	
			else {throw new NoAccountDetectedException("You need to make an account to deposit");
				}}catch(NoAccountDetectedException e){e.printStackTrace();CustMenu(cus);}
					catch(NotApprovedException e) {e.printStackTrace(); CustMenu(cus);}
			break;}
		
		
		
		case 6:{
			try { Log.info("Withdraw Transaction Attempted");
			if(cus.getAccount_tracker()>=1) {
			AccountDaoImpl ado = new AccountDaoImpl();
			ArrayList<Accounts> acc = ado.selectCustAccounts(cus.getUsername());
			int i = 0;
			for(Accounts custAcc : acc) {
				System.out.println("" + ++i + ":   " + "Account Num: " + custAcc.getAutoGeneratedNum() + "\tAccount Name:  " + custAcc.getAccount_Name() + "\tAccount Balance:  " + custAcc.getBalance() + "\tAccount Type:  " + custAcc.getAccount_type());

			}
				int choices = 0;
			System.out.println("Choose your account");
			choices = CheckInt(choices,"Make a valid choice");
			if (choices >= 1 && choices <=5) {
				if (acc.get(choices - 1).getAccount_State()<1) {throw new NotApprovedException("This account isn't approved or has been denied");}
				else {System.out.println("How much do you want to withdraw");
					int amount = 0; int balance = acc.get(choices-1).getBalance();System.out.println(balance);
					amount = CheckInt(amount,"How much do you want to withdraw");
					if ((acc.get(choices-1).getBalance() - amount) < 0) {throw new WithdrawTooLargeException("Save your money, the withdraw was too large");}
					ado.Withdraw(acc.get(choices-1), amount, cus);			
					Log.info("Withdraw Transaction Attempted");
					System.out.println("Withdraw Successful");
					CustMenu(cus);
					}
												}
			else {
			System.out.println("You need to make a valid choice");
			CustMenu(cus);	
			}
			}	
			else {throw new NoAccountDetectedException("You need to make an account to deposit");
				}}catch(NoAccountDetectedException e){e.printStackTrace();CustMenu(cus);}
					catch(WithdrawTooLargeException e){e.printStackTrace();CustMenu(cus);}
					catch(NotApprovedException e) {e.printStackTrace(); CustMenu(cus);}
			break;}
		
		case 7:{
				System.out.println("Thanks for your business, Have a good one"); System.exit(0); break;
		}
		
		default:{System.out.println("Not an Option, going back to menu"); CustMenu(cus); break;}
			}
		
		}
	
	static void EmpLogin() throws WithdrawTooLargeException, NoAccountDetectedException, TooManyAccountsException, NotApprovedException {
		EmployeeDaoImple Edi = new EmployeeDaoImple();
		boolean check;
		int PassW = 0;
		String UserN;
		System.out.print("Give a UserName: ");
		UserN = scan.nextLine();		

		System.out.println("Enter your Password");		
		
		PassW = CheckInt(PassW,"Enter your Password: ");
		System.out.println("Wait a minute while we check...");
		check = CheckForEmployees(UserN, PassW);
		
		if (check == false) {	//if false, goes back to main menu
			System.out.println("User Doesn't Exist");
			MainMenu();
			}
		else {	//if true, get that employee from master list and go to employee menu
			Log.info("Employee Login Successful");
			System.out.println("Welcome  " + UserN);
			//TempEmployee = GetEmployee(UserN);
			//System.out.println(TempEmployee.UserN);
			EmpMenu(Edi.getEmployeeByUsername(UserN));
			return;
			}
	}	
	
	static void EmpMenu(Employee emp) 
	{	//logged in employee can execute its functions
		//System.out.println("What do you want to do" + emp.getUsername());
		System.out.println("Press 1: View Customer Accounts    Press 2: Approve or Deny customer account");
		System.out.println("Press 3: Edit Customer Accounts    Press 4: Logout");
		
		int choice = 0; choice = CheckInt(choice,"Choose a menu option");
		switch (choice) { // reads input for switch case to choose employee function

		case 1: {
			AccountDaoImpl ADI = new AccountDaoImpl();// CustomerDaoImple CDI = new CustomerDaoImple();
			ArrayList<Accounts> masterlist = ADI.selectAllAccounts();
			int i = 0;
			if (masterlist.isEmpty()) {
				System.out.println("No one loves our bank, going back to menu");
				EmpMenu(emp);
			}
			for (Accounts account : masterlist) {
				System.out.println(" " + ++i + "\tAccNumber: " + account.getAutoGeneratedNum() + "\tAccUser: "
						+ account.getUsername1() + "\tAccUser2: " + account.getUsername2() + "\tAccBalance: "
						+ account.getBalance() + "\tAccState: " + account.getAccount_State());
			}
			EmpMenu(emp);
			break;
		}
		
		

		case 2: {
			AccountDaoImpl ADI = new AccountDaoImpl(); ArrayList<Accounts> accounts = ADI.selectAllAccounts();
			int i = 0;
			for (Accounts A : accounts) { System.out.println(" " + ++i + "\tAccNumber: " + A.getAutoGeneratedNum() + "\tAccUser: "
					+ A.getUsername1() + "\tAccUser2: " + A.getUsername2() + "\tAccBalance: "
					+ A.getBalance() + "\tAccState: " + A.getAccount_State());}
			System.out.println("Which account do you want to Approve or Deny"); int c = 0;
			c = CheckInt(c,"Which account do you choose?");
			while(c>accounts.size()) {c = CheckInt(c,"Which account do you choose?");}
			System.out.println("Press    1)Approve    or     2)Deny");
			int d = 0; d = CheckInt(d,"Choose an above option");
			switch(d) {
			case 1:{accounts.get(c-1).setAccount_State(1);ADI.updateAccount(accounts.get(c-1)); Log.info("Account updated");EmpMenu(emp);break;}
			case 2:{accounts.get(c-1).setAccount_State(-1);ADI.updateAccount(accounts.get(c-1)); Log.info("Account updated");EmpMenu(emp);break;}
			default:{System.out.println("Choose a better option, returning to menu");EmpMenu(emp);break;}
			}
			
			
			break;
		}
		
		
		

		case 3: {
			try {
				if (emp.getAdmin_privileges() < 1) {
					throw new NotApprovedException("You do not have access to this function");
				} else {
					AccountDaoImpl ADI = new AccountDaoImpl();// CustomerDaoImple CDI = new CustomerDaoImple();
					ArrayList<Accounts> masterlist = ADI.selectAllAccounts();
					int i = 0;
					if (masterlist.isEmpty()) {
						System.out.println("No one loves our bank, going back to menu");
						EmpMenu(emp);
					}
					for (Accounts account : masterlist) {
						System.out.println(" " + ++i + "\tAccNumber: " + account.getAutoGeneratedNum() + "\tAccUser: "
								+ account.getUsername1() + "\tAccUser2: " + account.getUsername2() + "\tAccBalance: "
								+ account.getBalance() + "\tAccState: " + account.getAccount_State());
					}
					System.out.println("Choose an account to alter");
					int decide = 0;
					decide = CheckInt(decide, "Choose a valid option");
					while (decide > masterlist.size()) {
						System.out.println("Choose again");
						decide = CheckInt(decide, "Choose an account");
					}
					System.out.println("You want to  1)Withdraw From      2)Deposit To      3)Delete this Account?");
					int option = 0;
					option = CheckInt(option, "What do you want to do to this account?");
					switch (option) {
					case 1: {
						Log.info("Account Withdrawal Attempted");
						System.out.println("How much do you want to withdraw");
						int amount = 0;
						int balance = masterlist.get(decide - 1).getBalance();
						System.out.println(balance);
						amount = CheckInt(amount, "How much do you want to withdraw");
						if ((masterlist.get(decide - 1).getBalance() - amount) < 0) {
							throw new WithdrawTooLargeException("They have no money, the withdraw was too large");
						}
						ADI.Withdraw(masterlist.get(decide - 1), amount, masterlist.get(decide - 1).getUsername1());
						Log.info("Withdraw Transaction Successful");
						System.out.println("Withdraw Successful");
						EmpMenu(emp);
						break;
					}
					case 2: {
						Log.info("Account deposit attempted");
						System.out.println("How much do you want to add");
						int amount = 0;
						amount = CheckInt(amount, "How do you want to add");
						ADI.Deposit(masterlist.get(decide - 1), amount, masterlist.get(decide - 1).getUsername1());
						Log.info("Deposit Transaction Completed");
						System.out.println("Balance has been deposited");
						EmpMenu(emp);
						break;
					}
					case 3: {
						Log.info("Account will be deleted");
						ADI.deleteAccount(masterlist.get(decide - 1), emp);
						Log.info("Account deleted");
						EmpMenu(emp);
						break;
					}
					default: {
						System.out.println("Choose a better option");
						EmpMenu(emp);
						break;
					}
					}
				}
			} catch (WithdrawTooLargeException e) {
				e.printStackTrace();
				EmpMenu(emp);
			} catch (NotApprovedException e) {
				e.printStackTrace();
				EmpMenu(emp);
			}
			break;
		}

		case 4: {
			System.out.println("Good Work, Goodbye");
			System.exit(0);
			break;
		} // If a separate choice is inputed, run employee menu again

		default: {
			System.out.println("Please choose one of the given options");
			EmpMenu(emp);
			break;
		}
		}
	}
	
	
	
	
	
		
		//SECURITY CHECKS
		//Register and Login Methods
	static boolean CheckForDuplicateUser(String UserN) 
	{	Log.debug("Customer Attempted to Register");
		CustomerDaoImple cdi = new CustomerDaoImple();
		ArrayList<Customer> cust = cdi.CustomerArchive();
		boolean check = false;int i;
		for(Customer cus : cust) {
			i = cus.getUsername().compareTo(UserN);
			if(i == 0) {check = true;System.out.println("Entered if loop");Log.debug("Register Attempted");Log.info("Register Attempted");}
		}
	return check;
	}
		
	
	static boolean CheckForInitialEmp(String UserN,String UserN1, String UserN2, String UserN3) 
	{	Log.info("Checking Database For Employees");
		boolean initialized;
		String [] Strings = {UserN,UserN1,UserN2,UserN3};
		EmployeeDaoImple edi = new EmployeeDaoImple();
		ArrayList<Employee> Empl = edi.EmployeeArchive();
		if(Empl.isEmpty()) {
		initialized = false;int j;
			for (j = 0; j < Strings.length; j++) {
				String temp = Strings[j];int i = 1;
				if(j>=2) {
					i = 0;
				}
				edi.insertEmployee(new Employee(temp,654321,i));
					}
				}

		initialized = true;
		return initialized;
	}
	
	static boolean CheckForCustomers(String UserN, int password) 
	{	Log.info("Customer Login Attempted");
		//for each customer login attempt, the Username and Password is checked against Database
		CustomerDaoImple cdi = new CustomerDaoImple();
		boolean check = false; int i;int j;int k = Integer.valueOf(password);
		//boolean to be returned
		//int i to return compareTo function output (compares string input to customer username records
		//int j = customer records password
		//int k = the integer value of input password
		ArrayList<Customer> customers = cdi.CustomerArchive();
				for (Customer cus : customers) 
				{
					i = cus.getUsername().compareTo(UserN); j = cus.getPassword();	
					
					if((i == 0) & (j == k)) 
					{
						return true; 
					}
				}	
				return check;//else return false
	}
	
	static boolean CheckForCustomers(String UserN) 
	{	Log.info("Customer Check");
		//for each customer login attempt, the Username and Password is checked against Database
		CustomerDaoImple cdi = new CustomerDaoImple();
		boolean check = false; int i;
		//boolean to be returned
		//int i to return compareTo function output (compares string input to customer username records
		ArrayList<Customer> customers = cdi.CustomerArchive();
				for (Customer cus : customers) 
				{
					i = cus.getUsername().compareTo(UserN);	
					
					if(i == 0)  
					{
						return true; 
					}
				}	
				return check;//else return false
	}
	
	
	static boolean CheckForEmployees(String UserN, int password) 
	{	Log.info("Employee Login Attempted");
		//for each customer login attempt, the Username and Password is checked against Database
		EmployeeDaoImple edi = new EmployeeDaoImple();
		boolean check = false; int i;int j;int k = Integer.valueOf(password);
		//boolean to be returned
		//int i to return compareTo function output (compares string input to customer username records
		//int j = customer records password
		//int k = the integer value of input password
		ArrayList<Employee> Employees = edi.EmployeeArchive();
				for (Employee emp : Employees) 
				{
					i = emp.getUsername().compareTo(UserN); j = emp.getPassword();	
					
					if((i == 0) & (j == k)) 
					{
						return true; 
					}
				}	
				return check;//else return false
	}
	
	static int CheckInt(int number, String message) 
	{
		number = 0;
		String Intcheck = null;
		while (Intcheck == null) {
			Intcheck = scan.nextLine();
			try {
				number = Integer.valueOf(Intcheck);break;
			}catch(NumberFormatException e){
				System.out.println("No letters, only numbers please");
				Intcheck = null;
				System.out.print(message);
				}
			}
		return number;
	}
	
	static void CreateAccount (String UserName1, String UserName2,String AccountType) {
		AccountDaoImpl adi = new AccountDaoImpl(); CustomerDaoImple CDI = new CustomerDaoImple();
		
		System.out.println("Enter An Account Name\n");
		String AccountName = scan.nextLine();
		Log.info("Account Being Created");
		adi.insertAccount(new Accounts(AccountName, UserName1, UserName2, AccountType, 0, 0));
		Customer Tempcust = CDI.getCustomerByUsername(UserName1);
		int at = Tempcust.getAccount_tracker(); at++; Tempcust.setAccount_tracker(at);
		CDI.updateCustomer(Tempcust);
		System.out.println("Account Was Created");
	}
	
	static String SecondUserCheck() {
		int choice = 0;
		String UserN2 = null;
		System.out.println("Is this Second Person a customer?");
		System.out.println("Press 1: Yes     Press 2: No");
		choice = CheckInt(choice, "Are they a customer");
		switch (choice) {
		case 1: {
			System.out.println("Enter their username");
			UserN2 = scan.nextLine();
			boolean check = CheckForCustomers(UserN2);
			if (check == false) {
				System.out.println("Second person is not a customer");
				System.out.println("Would they like to Register Now?");
				System.out.println("Press 1: Yes            Press 2: No");
				int choices = 0;
				//int a = 1;
				int b = 2;
					
				do {choices = CheckInt(choice, "Pick a valid choice, Are they a customer"); Log.info("Loop Entered");}
				while(choice > b );

				switch (choices) {
				case 1: {
					UserN2 = ModifiedRegister();
					break;
				}
				case 2: {
					System.out.println("Joint Account cannot be created");
					UserN2 = null;
					break;
				}
				}
				break;
			} else {
				break;
			}
		}
		case 2: {
			System.out.println("Would they like to Register Now?");
			System.out.println("Press 1: Yes            Press 2: No");
			int choices = 0;
			//int a = 1;
			int b = 2;
			do {
				choices = CheckInt(choice, "Are they a customer");
			} while (choices > b);
			switch (choices) {
			case 1: {
				UserN2 = ModifiedRegister();
				break;
			}
			case 2: {
				System.out.println("Joint Account cannot be created");
				UserN2 = null;
				break;
			}
			}
			break;
		}
		default: {
			System.out.println("Choose a valid option please");
			SecondUserCheck();
			break;
		}
		}
		return UserN2;
	}
	
	
}
