import java.util.Scanner;

import org.apache.log4j.Logger;


public class Main {
	

	final static Logger logger = Logger.getLogger(Main.class);
	static Scanner myScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean theLoop = true;
		
		logger.info("APP has started");
		BankAccount.writeObject();
		do {
			System.out.println("Welcome, please select an option to continue.");
			System.out.println("1 to Login");
			System.out.println("2 to Make an Account");
			System.out.println("3 to Quit");
			
			switch(myScanner.nextInt()) {
			case 1:
				logger.info("log in screen");
				login();
				break; 
				
			case 2:
				logger.info("starting to make an account");
				makeAnAccount();
				break;
				
			case 3:
				theLoop = false;
				break;
				
			default:
				System.out.println("Option not available");
				break; 
			}
			
		}while(theLoop);
		
		myScanner.close();
		BankAccount.readObject(); 
		}
	
	public static void makeAnAccount() {
		
		String userName;
		
		myScanner.nextLine();
		
		System.out.println("What is your first name?");
		String fName = myScanner.nextLine();
		
		System.out.println("What is yout last name?");
		String lName = myScanner.nextLine();
		
		System.out.println("Please enter a username for your account: ");
		userName = myScanner.nextLine();
		
		while(Customer.userNameNotUnique(userName));
		
		System.out.println("Please enter a password for your account");
		String password = myScanner.nextLine();
		
		System.out.println("Would you like to add a joint account holder?");
		System.out.println("If yes enter their first name and last name in the style of first:last ");
		System.out.println("If no enter NONE");
			String jointHolder = myScanner.nextLine();
			
		BankAccount newAccount = new BankAccount(fName,lName, userName, password, 0, jointHolder);
		
		if(BankAccount.setUpAccount(newAccount)) {
			System.out.println("Account was created");
		}else {
			System.out.println("Account could not be created");
		}
	}
	
	
	public static void login() {
		
		System.out.println("Enter Username: ");
		String userName = myScanner.next();
		
		System.out.println("\n Enter Password: ");
		String password = myScanner.next();
		
		Customer customer = Customer.logIn(userName, password);
		
		if(customer instanceof BankAccount) {
			transactionScreen((BankAccount) customer);
		}else {
			System.out.println("invalid username or password");
		}
		
	}
	
	public static void transactionScreen(BankAccount customer) {
		
		boolean anotherLoop = true;
		double amount;
		
		logger.info("Now in the transaction screen");
		do {
			
			System.out.println("Select your banking option: ");
			System.out.println("1 to deposit");
			System.out.println("2 to withdraw");
			System.out.println("3 to transfer");
			System.out.println("4 to quit");
			
			switch(myScanner.nextInt()) {
			
			case 1:
				System.out.println("Enter amount to be deposited: ");
				amount = myScanner.nextDouble();
				
				if(customer.deposit(amount)) {
					System.out.println("deposit of " + amount + " was successfu1");
				}else {
					System.out.println("deposit of " + amount + " was unsuccessful");
				}
				break;
				
			case 2:
				System.out.println("Enter amount to be withdrawn: ");
				amount = myScanner.nextDouble();
				
				if(customer.withdraw(amount)) {
					System.out.println("withdraw of " + amount + " was successful");
				}else {
					System.out.println("withdraw of " + amount + " was unsuccessful");
				}
				break;
				
			case 3: 
				System.out.println("Enter the account you are transfering to: ");
				String to = myScanner.next();
				
				System.out.println("Enter the amount to  be transfered: ");
				amount = myScanner.nextDouble();
				
				if(customer.transferTo(to, amount)) {
					System.out.println("Transfer of " + amount + "to " + to + " successful");
				}else {
					System.out.println("Transfer of " + amount + "to " + to + " unsuccessful");
				}
				
				break;
				
			case 4: 
				anotherLoop = false;
				break;
			
			default:
				System.out.println("Option not available");
				break;
					
			}
		}while(anotherLoop);
		
	}
	}


