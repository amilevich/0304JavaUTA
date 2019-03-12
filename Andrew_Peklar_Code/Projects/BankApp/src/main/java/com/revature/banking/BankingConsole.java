package com.revature.banking;

import java.io.File;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BankingConsole {

	protected static String fileName = "serialize/data.ser";
	protected static File file = new File(fileName); // TODO

	protected static Scanner scan;
	protected static BankDatabase database;
	protected static User currentUser = new User("", "");

	public static void startup() {

		// create database instance
		database = new BankDatabase();

		ObjectOutputStream out;

		if (!file.exists() || file.length() == 0) {
			addDefaulUsers();
			try {
				out = new ObjectOutputStream(new FileOutputStream(fileName));
				out.writeObject(database);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// create streams for handling serialization of data
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream(fileName));
			database = (BankDatabase) in.readObject();
		} catch (IOException | ClassNotFoundException i) {
			i.printStackTrace();
		}

		// create instance of scanner
		scan = new Scanner(System.in);

		// call mainMenu
		// database.getUser().stream().forEach(System.out::println);
		// database.getAccount().forEach(System.out::println);
		mainMenu();
	}

	public static void mainMenu() {
		// header
		System.out.println("\r\n" + "\t                                    __            \r\n"
				+ "\t|  | _| _ _  _  _  |_ _   |_|_  _  |__) _  _ |   \r\n"
				+ "\t|/\\|(-|(_(_)|||(-  |_(_)  |_| )(-  |__)(_|| )|(  \r");
		// user prompt
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Please select an option matching a value: \r" + "\n\t 1. Login to account"
				+ "\n\t 2. Register for an account" + "\n\t 3. Perform a safe Shut Down\n");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("Option: \t");

		// loop through inputs until valid

		String menuInputs = menuInput(3, scan.next());

		clearConsole();
		// route from selection
		switch (menuInputs) {
		case "1":
			login();
			break;
		case "2":
			register();
			break;
		case "3":
			System.out.println("~~~~~~~~~~~~ Farewell! ~~~~~~~~~~~~");
			scan.close();
			break;
		default: // should be impossible to reach here
			System.out.println("invalid input at main menu");
			break;
		}
	}

	private static void login() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\tLOGIN SCREEN");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("To go back, simply enter \"b\"");

		System.out.print("\nPlease enter your Username: \t");
		String username = scan.next();
		if (username.equals("b"))
			mainMenu();

		System.out.print("\nPlease enter your Password: \t");
		String password = scan.next();
		if (password.equals("b"))
			mainMenu();
		boolean pass = database.getUserLoginMap().containsKey(username)
				&& database.getUserLoginMap().get(username).equals(password);

		if (pass) {
			int index = -1;
			while (!database.getUser().get(++index).getUsername().equals(username))
				;
			currentUser = database.getUser().get(index);

			if (currentUser instanceof Employee)
				employeeMenu();
			if (currentUser instanceof Customer)
				customerMenu();
			if (currentUser instanceof Administrator)
				administratorMenu();
		} else {
			System.out.print("\nInvalid Username or password! Please try again...");
			login();
		}
	}

	public static void register() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\tREGISTRATION SCREEN");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("To go back, simply enter \"b\"");
		System.out.println("Please choose a username and a password");

		System.out.print("\nUsername: \t");
		String username = scan.next();
		if (username.equals("b"))
			mainMenu();

		if (database.getUserLoginMap().containsKey(username)) {
			System.out.println("Name already taken. Please try again...");
			register();
		} else {
			System.out.print("\nPassword: \t");
			String password = scan.next();
			if (password.equals("b"))
				mainMenu();

			Customer newCustomer = new Customer(username, password);
			database.getUser().add(newCustomer);
			database.getUserLoginMap().put(username, password);

			System.out.println("Thank you for registering! You may now login from the main menu");
			System.out.println("Redirecting to main....");
			mainMenu();
		}
	}

	private static void customerMenu() {
		int input = -1;
		clearConsole();
		System.out.println("Hello " + currentUser.getUsername());
		System.out.println("Please select an option: ");
		System.out.print("\n\t 1. Apply for Account" + "\n\t 2. Withdraw funds" + "\n\t 3. Deposit Funds"
				+ "\n\t 4. Transfer Funds" + "\n\t 5. View Accounts" + "\n\t 6. Logout");
		System.out.print("\nOption: \t");

		if (scan.hasNextInt())
			input = scan.nextInt();
		else
			customerMenu();

		switch (input) {
		case 1:
			customerApplication();
			break;
		case 2:
			withdrawFromCustomer();
			break;
		case 3:
			depositToCustomer();
			break;
		case 4:
			transferFromCustomer();
			break;
		case 5:
			viewCustomerAccounts();
		default:
			scan.close();
			System.out.println("~~~~~~~~~~ Goodbye! ~~~~~~~~~~");
		}
	}

	private static void viewCustomerAccounts() {
		// TODO Auto-generated method stub
		((Customer) currentUser).getTheirAccounts().forEach(System.out::println);
		customerMenu();
	}

	private static void customerApplication() {
		int input = -1;
		System.out.println("Select account type you wish to create: ");
		System.out.print("\n\t 1. Individual Account" + "\n\t 2. Joint Account");
		System.out.print("\nOption: \t");

		if (scan.hasNextInt())
			input = scan.nextInt();
		else
			customerApplication();

		if (input == 1) {
			Application app = new Application(currentUser.getUsername());
			database.getApplication().add(app);
			System.out.println("Thank you for applying!\n Now returning to customer menu...");
			System.out.println(database.getAccount().size());
			customerMenu();
		}
		// add rest
	}

	private static void employeeMenu() {
		// TODO Auto-generated method stub

	}

	private static void administratorMenu() {
		// TODO Auto-generated method stub
		int input = -1;
		System.out.println("Hello " + currentUser.getUsername());
		System.out.println("Please select an option: ");
		System.out.print("\t 1. View User Account" + "\n\t 2. View Applications" + "\n\t 3. Withdraw Funds"
				+ "\n\t 4. Deposit Funds" + "\n\t 5. Transfer funds" + "\n\t 6. Delete Accounts"
				+ "\n\t 7. List All Customers" + "\n\t 8. List all Accounts on file" + "\n\t 9. Logout");
		System.out.print("\nOptions: :\t");

		if (scan.hasNextInt())
			input = scan.nextInt();
		else
			administratorMenu();

		switch (input) {
		case 1:
			viewUserAccount();
			break;
		case 2:
			viewApplications();
			break;
		case 3:
			withdrawFromCustomer();
			break;
		case 4:
			depositToCustomer();
			break;
		case 5:
			transferFromCustomer();
			break;
		case 6:
			deleteAccount();
			break;
		case 7:
			listCustomerAccounts();
			break;
		case 8:
			listAllAcounts();
			break;
		case 9:
			logout();
			break;
		default:
			System.out.println("Something went horribly wrong!");
			scan.close();
		}
	}

	private static void logout() {
		mainMenu();
	}

	private static void listAllAcounts() {
		// TODO Auto-generated method stub
		database.getAccount().forEach(Account::printAccountInfo);
	}

	private static void viewUserAccount() {
		int index = -1;
		while (!database.getUser().get(++index).getUsername().equals("andrew"))
			;
		User tmp = database.getUser().get(index);
		((Customer) tmp).printInfo();
	}

	private static void deleteAccount() {
		// TODO Auto-generated method stub

	}

	private static void transferFromCustomer() {
		// TODO Auto-generated method stub

	}

	private static void depositToCustomer() {
		// TODO Auto-generated method stub

	}

	private static void withdrawFromCustomer() {
		// TODO Auto-generated method stub

	}

	private static void viewApplications() {
		database.getApplication().forEach(Application::getUsers);
	}

	private static void listCustomerAccounts() {
		// TODO Auto-generated method stub

		// int index = -1;
		// while(!(database.getAccount().get(++index).getaID() == accountID));
		System.out.println("---------------------------------------------------------------");
		System.out.println("Account ID\tOwners \t\t\tBalances ");
		System.out.println("---------------------------------------------------------------");
		database.getAccount().forEach(Account::printAccountInfo);
		System.out.println("---------------------------------------------------------------");
	}

	// ------------------------------------------UTIL METHODS
	// -----------------------------------------

	// adds the default users
	public static void addDefaulUsers() {

		// create a default admin
		Administrator defaultAdmin = new Administrator("a", "a");
		database.getUserLoginMap().putIfAbsent("a", "a");
		database.getUser().add(defaultAdmin);

		// create a default employee
		Employee defaultEmployee = new Employee("e", "e");
		database.getUserLoginMap().putIfAbsent("e", "e");
		database.getUser().add(defaultEmployee);

		Customer custom = new Customer("andrew", "c");
		database.getUserLoginMap().putIfAbsent("andrew", "c");
		database.getUser().add(custom);
		List<String> f = Arrays.asList(custom.getUsername());

		Account account = new Account(1000, f);
		custom.getTheirAccounts().add(1000);
		database.getAccount().add(account);

		account = new Account(2000, f);
		custom.getTheirAccounts().add(2000);
		database.getAccount().add(account);

		custom = new Customer("Anna", "d");
		database.getUserLoginMap().putIfAbsent("anna", "c");
		database.getUser().add(custom);
		f = Arrays.asList("andrew", "anna");

		account = new Account(3000, f);
		custom.getTheirAccounts().add(3000);
		database.getAccount().add(account);
		database.getUser().stream().forEach(System.out::println);
		database.getAccount().forEach(System.out::println);

		// Log issue and output to file
	}

	public static String menuInput(int maxVal, String userInput) {
		while (true) {
			if (userInput.length() != 1) {
				System.out.print("\nInvalid input! please try again. \nOption: \t");
				userInput = scan.next();
			} else if (!userInput.matches("\\d+")) {
				System.out.print("\nInvalid input! please try again. \nOption: \t");
				userInput = scan.next();
			} else if (Integer.parseInt(userInput) > maxVal) {
				System.out.print("\nInvalid input! please try again. \nOption: \t");
				userInput = scan.next();
			} else
				break;
		}
		return userInput;
	}

	// method to try and handle the annoying console
	public static void clearConsole() {
		// System.out.print("\033[H\033[2J");
		// System.out.println(new String(new char[50]).replace("\0", "\r\n"));
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
		System.out.flush();
	}
}