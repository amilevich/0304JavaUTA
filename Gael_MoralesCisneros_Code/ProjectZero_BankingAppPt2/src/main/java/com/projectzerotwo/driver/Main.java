package com.projectzerotwo.driver;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.projectzerotwo.dao.AccountDaoImpl;
import com.projectzerotwo.dao.UserDaoImpl;
import com.projectzerotwo.model.Account;
import com.projectzerotwo.model.User;

public class Main {

	public final static Logger logger = Logger.getLogger(Main.class.getName());
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		logger.info("***Project Zero Banking App Start***");

		boolean b = false;
		do {
			// Welcome screen with options
			System.out.println(
					"Welcome to Project Zero Banking App!" + "\nPress 1: User\nPress 2: Employee\nPress 3: Quit");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				UserLogin();
				break;
			case "2":
				employeeLogin();
				break;
			case "3":
				// escape loop
				b = true;
				break;
			default:
				// If any other key is pressed
				System.out.println("Try again");
				break;
			}
		} while (!b);
		// goodbye message, program end
		System.out.println("Goodbye");
		sc.close();
		quit();
	}

	public static void UserLogin() {
		boolean b = false;

		do {
			// Welcome screen with options
			System.out.println(
					"Welcome to Project Zero Banking App!" + "\nPress 1: Login\nPress 2: Sign up\nPress 3: Exit");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				// Goes to Login class to enter username & password
				appLogin();
				break;
			case "2":
				// Goes to register to input info and make a pending account
				register();
				break;
			case "3":
				// escape loop
				b = true;
				break;
			default:
				// If any other key is pressed
				System.out.println("Try again");
				break;
			}
		} while (!b);
	}

	public static void employeeLogin() {
		boolean b = false;

		do {
			System.out.println("\n***Project Zero Banking App Workspace***" + "\nPress 1: Login\nPress 2: Exit");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				// Goes to Login class to enter username & password
				appLogin();
				break;
			case "2":
				// escape loop
				b = true;
				break;
			default:
				// If any other key is pressed
				System.out.println("Try again");
				break;
			}
		} while (!b);
	}

	public static void register() {
		AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		Account newAccount = new Account();
		User newUser = new User();
		// type of 0 is customer
		newUser.setType(0);
		System.out.println("Enter your First Name: ");
		newUser.setFirstname(sc.nextLine());
		System.out.println("Enter your Last Name: ");
		newUser.setLastname(sc.nextLine());
		System.out.println("Enter new username: ");
		newUser.setUsername(sc.nextLine());
		// loop to check if username is already being used
		while (usernameInUse(newUser.getUsername())) {
			System.out.println("Username already in use\nEnter new username: ");
			newUser.setUsername(sc.nextLine());
		}
		System.out.println("Enter new password: ");
		newUser.setPassword(sc.nextLine());
		// set starting balance of account
		System.out.println("\nTo apply for a bank account enter a starting balance $: ");
		newAccount.setBalance(sc.nextDouble());
		logger.info("set balance");
		// set status of account as 0 for pending
		newAccount.setStatus(0);
		// insert new account and user to db
		logger.info("set account pending");
		accountDaoImpl.insertAccount(newAccount);
		logger.info("inserted new account");

		// do jointAccounts later
		System.out.println("\nDo you want to apply for a new joint bank account with another person? "
				+ "\nYou will need to create a second username and password.\nY/N: ");
		sc.nextLine();
		String n = sc.nextLine();
		if (n.equals("y")) {
			jointUserRegister(newUser);
		}

		// get accNumber for user
		// don't know accNumber, get accNumber_seq.nextval
		newUser.setAccNumber(userDaoImpl.selectAccNumByMax());
		logger.info("select for max accNum");
		userDaoImpl.insertUser(newUser);
		logger.info("inserted newUser");

		waitPage();
	}

	public static void waitPage() {

		System.out.println("\nThanks for registering!\n Please log out and wait for your account to be approved."
				+ "\nYou will be contacted by an employee when your account is ready.");
		System.out.println("To log out press 'Y': ");
		String y = sc.nextLine();
		if (y == "y" || y == "Y")
			quit();
	}

	public static void jointUserRegister(User primUser) {
		UserDaoImpl udi = new UserDaoImpl();
		User newUser = primUser;
		User newJointUser = new User();
		// type of 0 is customer
		newJointUser.setType(0);
		System.out.println("Enter second account holder First Name: ");
		newJointUser.setFirstname(Main.sc.nextLine());
		System.out.println("Enter second account holder Last Name: ");
		newJointUser.setLastname(Main.sc.nextLine());
		System.out.println("Enter second account holder username: ");
		newJointUser.setUsername(Main.sc.nextLine());
		// loop to check if username is already being used
		while (usernameInUse(newJointUser.getUsername())) {
			System.out.println("Username already in use\nEnter new username: ");
			newJointUser.setUsername(sc.nextLine());
		}
		System.out.println("Enter second account holder password: ");
		newJointUser.setPassword(sc.nextLine());

		newUser.setAccNumber(udi.selectAccNumByMax());
		logger.info("select for max accNum");
		udi.insertUser(newUser);
		logger.info("inserted newUser");

		newJointUser.setAccNumber(udi.selectAccNumByMax());
		logger.info("select for max accNum");
		udi.insertUser(newJointUser);
		logger.info("inserted newJointUser");
		waitPage();
	}

	public static boolean usernameInUse(String un) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		for (User u : userDaoImpl.selectAllUsers()) {
			if (u.getUsername().equals(un)) {
				return true;
			}
		}
		return false;
	}

	public static void appLogin() {
		System.out.println("Enter username: ");
		// sc.nextLine();
		String un = sc.nextLine();
		System.out.println("Enter password: ");
		// sc.nextLine();
		String pw = sc.nextLine();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		for (User u : userDaoImpl.selectAllUsers()) {
			if (u.getUsername().equals(un) && u.getPassword().equals(pw)) {
				logger.info(un + " successfull login");
				if (u.getType().equals(0)) {
					AccountDaoImpl adi = new AccountDaoImpl();
					Account userAcc = new Account();
					userAcc = adi.selectAccountByAccNumber(u.getAccNumber());

					// check account status
					if (userAcc.getStatus().equals(1)) {
						// go to banking with successful user's account number
						userBanking(userAcc);
					} else {
						System.out.println(
								"Your account is still pending approval, please login when your account has been approved!");
						quit();
					}
				} else if (u.getType().equals(1)) {
					// go to employee work
					employeeWork();
				} else if (u.getType().equals(2)) {
					// go to admin work
					adminWork();
				}
			}
		}
		logger.info(un + " failed login");
		loginRetry();
	}

	// method to retry appLogin method or quit the program
	public static void loginRetry() {
		System.out.println("To retry press 'Y'\tTo quit press 'N'");
		String s = sc.nextLine();
		switch (s) {
		case "y":
			appLogin();
			break;
		default:
			sc.close();
			quit();
			break;
		}
	}

	public static void userBanking(Account uA) {
		// lookup account by accNum
		Account userAcc = new Account();
		userAcc = uA;
		double amount;
		boolean b = false;
		do {
			System.out.println("\nYour account balance is \n$ " + userAcc.getBalance() + "\nWhat would you like to do?:"
					+ "\n 1: Withdraw\n 2: Deposit\n 3: Transfer\n 4: Quit");
			switch (sc.nextInt()) {
			case 1:
				System.out.print("Withdraw amount: \n$ ");
				amount = sc.nextDouble();

				if (amount > 0) {
					try {
						withdraw(userAcc, amount);
					} catch (WithdrawTooBigException e) {
						e.printStackTrace();
					}
					// log transaction
					System.out.println("Withdraw of $ " + amount + " success!");
				} else {
					System.out.println("Can't withdraw less than zero...");
				}
				break;

			case 2:
				System.out.print("Deposit amount: \n$ ");
				amount = sc.nextDouble();
				if (amount > 0) {
					deposit(userAcc, amount);
					// log transaction
					System.out.println("Deposit of $ " + amount + " success!");
				} else {
					System.out.println("Can't deposit less than zero...");
				}
				break;

			case 3:
				System.out.print("Account number to transfer to: ");
				int to = Integer.parseInt(sc.next());

				System.out.print("Transfer amount: \n$ ");
				amount = sc.nextDouble();

				if (amount > 0) {
					try {
						transfer(userAcc, amount, to);
					} catch (WithdrawTooBigException e) {
						e.printStackTrace();
					}
					// log transaction
					System.out.println("Transfer of $ " + amount + " to account " + to + " success!");
				} else {
					System.out.println("Can't transfer less than zero...");
				}
				break;
			case 4:
				b = false;
				quit();
				break;
			default:
				System.out.println("Try again!");
				break;
			}
		} while (!b);
	}

	public static int withdraw(Account from, double amt) throws WithdrawTooBigException {
		AccountDaoImpl adi = new AccountDaoImpl();
		if (amt > from.getBalance())
			throw new WithdrawTooBigException(amt + " exceeds the max withdraw limit of : " + from.getBalance());

		double balance = from.getBalance() - amt;
		from.setBalance(balance);
		adi.updateAccount(from);
		logger.info("Amount $ " + amt + "was withdrawn from account " + from.getAccNumber());
		return 0;
	}

	public static int deposit(Account from, double amt) {
		AccountDaoImpl adi = new AccountDaoImpl();
		double balance = from.getBalance() + amt;
		from.setBalance(balance);

		adi.updateAccount(from);
		logger.info("Amount $ " + amt + "was deposited to account " + from.getAccNumber());
		return 0;
	}

	public static int transfer(Account from, double amt, int to) throws WithdrawTooBigException {
		AccountDaoImpl adi = new AccountDaoImpl();
		Account toAccount = adi.selectAccountByAccNumber(to);
		if (amt > from.getBalance())
			throw new WithdrawTooBigException(amt + " exceeds the max withdraw limit of : " + from.getBalance());

		double balance = from.getBalance() - amt;
		from.setBalance(balance);
		balance = toAccount.getBalance() + amt;
		toAccount.setBalance(balance);

		adi.updateAccount(from);
		adi.updateAccount(toAccount);
		logger.info("Amount $ " + amt + "was transfered from account " + from.getAccNumber() + " to account "
				+ toAccount.getAccNumber());
		return 0;
	}

	public static void employeeWork() {
		// menu options
		boolean b = false;
		do {
			System.out.println("\\n***Project Zero Banking App Workspace***\" +\nWelcome Project Zero Employee!"
					+ "\nPress 1: View UserInfo" + "\nPress 2: View Accounts\nPress 3: Quit\n");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("***List of customers***");
				// method to view user info with type 0
				viewUserInfo();

				System.out.println("Approve an account? Y/N:");
				String s = sc.next();
				if (s.equals("y")) {
					System.out.println("Enter account number to approve: ");
					Integer accNumA = sc.nextInt();
					approveAccount(accNumA);
				} else if (s.equals("n")) {
					// do nothing
				}
				break;
			case 2:
				System.out.println("***List of accounts***");
				viewAccountInfo();
				break;
			case 3:
				// method to close program
				quit();
				break;
			default:
				// if any other key is pressed, restart menu
				System.out.println("Try again!");
				break;
			}
		} while (!b);
	}

	public static void adminWork() {
		// menu options
		boolean b = false;
		do {
			System.out.println("\\n***Project Zero Banking App Workspace***\" +\nWelcome Project Zero Admin!"
					+ "\nPress 1: View UserInfo for user info edit or to w/d/t"
					+ "\nPress 2: View Accounts for balance info or cancel account\nPress 3: Quit\n");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("***List of users***");
				// method to view user info of any type
				viewUserInfoAdmin();

				System.out.println("Make changes to user account? Y/N");
				String y = sc.next();
				if (y.equals("y") || y.equals("Y")) {

					System.out.println("1: Edit user info\n2: withdraw from user account"
							+ "\n3: deposit to user account" + "\n4: transfer from user account\n");
					switch (sc.nextInt()) {
					case 1:
						// display all users
						viewUserInfoAdmin();
						System.out.println("Enter customer username to edit info: ");
						String nm = sc.next();
						System.out.println("1: Edit username\n2: Edit password\n3: Edit first name\n4: Edit last name");
						Integer c = sc.nextInt();
						editUserInfo(nm,c);
						break;
					case 2:
						System.out.println("Enter customer account number to withdraw from: ");
						Integer accNum = sc.nextInt();
						AccountDaoImpl adi = new AccountDaoImpl();
						Account custAcc = new Account();
						custAcc = adi.selectAccountByAccNumber(accNum);

						System.out.println("Enter amount to withdraw: $ ");
						Double amt = sc.nextDouble();
						try {
							withdraw(custAcc, amt);
						} catch (WithdrawTooBigException e) {
							e.printStackTrace();
						}
						break;
					case 3:
						System.out.println("Enter customer account number to deposit to: ");
						Integer accNum2 = sc.nextInt();
						AccountDaoImpl adi2 = new AccountDaoImpl();
						Account custAcc2 = new Account();
						custAcc2 = adi2.selectAccountByAccNumber(accNum2);

						System.out.println("Enter amount to deposit: $ ");
						Double amt2 = sc.nextDouble();
						deposit(custAcc2, amt2);
						break;
					case 4:
						System.out.println("Enter customer account number to transfer from: ");
						Integer accNumF = sc.nextInt();
						AccountDaoImpl adi3 = new AccountDaoImpl();
						Account custAccF = new Account();
						custAccF = adi3.selectAccountByAccNumber(accNumF);

						System.out.println("Enter customer account number to transfer to: ");
						Integer accNumt = sc.nextInt();

						System.out.println("Enter amount to transfer: $ ");
						Double amt3 = sc.nextDouble();
						try {
							transfer(custAccF, amt3, accNumt);
						} catch (WithdrawTooBigException e) {
							e.printStackTrace();
						}
						break;
					default:
						System.out.println("Try again!");
						break;
					}
				}
				break;
			case 2:
				System.out.println("***List of accounts***");
				viewAccountInfo();
				System.out.println("1: Approve an account\n2: Cancel an account\n3: Quit");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter account number to approve: ");
					Integer accNumA = sc.nextInt();
					approveAccount(accNumA);
					break;
				case 2:
					System.out.println("Enter account number to cancel: ");
					Integer accNumC = sc.nextInt();
					cancelAccount(accNumC);
					break;
				case 3:
					quit();
					break;
				default:
					System.out.println("Try again!");
					b = true;
					break;
				}
				break;
			case 3:
				quit();
				break;
			default:
				// if any other key is pressed, restart menu
				System.out.println("Try again!");
				break;
			}
		} while (!b);
	}

	public static void viewUserInfo() {

		UserDaoImpl udi = new UserDaoImpl();
		for (User u : udi.selectAllUsers()) {
			if (u.getType().equals(0)) {
				System.out.println(u);
			}
		}
	}

	public static void viewUserInfoAdmin() {

		UserDaoImpl udi = new UserDaoImpl();
		for (User u : udi.selectAllUsers()) {
			System.out.println(u);
		}
	}

	public static void editUserInfo(String nm,Integer c) {
		UserDaoImpl udi = new UserDaoImpl();
		User u = udi.selectUserByUsername(nm);
		switch (c) {
		case 1:
			System.out.println("Enter new username: ");
			u.setUsername(sc.next());
			udi.updateUser(u);
			logger.info("Changed username "+ nm +" to " + u.getUsername());
			break;
		case 2:
			System.out.println("Enter new password: ");
			u.setPassword(sc.next());
			udi.updateUser(u);
			logger.info("Changed password of"+ nm +" to " + u.getPassword());
			break;
		case 3:
			System.out.println("Enter new first name: ");
			u.setFirstname(sc.next());
			udi.updateUser(u);
			logger.info("Changed firstname of "+nm+" to "+ u.getFirstname());
			break;
		case 4:
			System.out.println("Enter new last name: ");
			u.setLastname(sc.next());
			udi.updateUser(u);
			logger.info("Changed lastname of "+nm+" to " + u.getLastname());
			break;
		default:
			System.out.println("Try again!");
			break;

		}
	}

	public static void viewAccountInfo() {
		AccountDaoImpl adi = new AccountDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		User u = new User();
		for (Account a : adi.selectAllAccounts()) {
			u = udi.selectUserByAccountNum(a.getAccNumber());
			System.out.println(u.getFirstname() + "'s account\n" + a);
		}
	}

	public static void approveAccount(Integer accNumA) {
		AccountDaoImpl adi = new AccountDaoImpl();
		Account accA = adi.selectAccountByAccNumber(accNumA);
		accA.setStatus(1);
		adi.updateAccount(accA);
		logger.info("Account " + accA.getAccNumber() + " was approved");
	}

	public static void cancelAccount(Integer accNumC) {
		AccountDaoImpl adi = new AccountDaoImpl();
		Account accC = adi.selectAccountByAccNumber(accNumC);
		adi.deleteAccount(accC);
		logger.info("Account " + accC.getAccNumber() + " was cancelled by admin");
	}

	public static void quit() {
		logger.info("***Project Zero Banking App Closing***");
		System.exit(0);
	}
}
