package BankingApp;

import java.util.Scanner;
import org.apache.log4j.Logger;

public class Main {

	final static Logger log = Logger.getLogger(Main.class);

	static Persistance storage = new Persistance();
	static Activities activity = new Activities();

	public static void main(String[] args) {
		showMainMenu();
	}

	private static void showMainMenu() {
		Scanner sc = new Scanner(System.in);
		int user_choice = 1;

		do {
			// display menu to user
			// ask user for his choice and validate it (make sure it is between 1 and 3)
			System.out.println();
			System.out.println("1) Login to bank");
			System.out.println("2) Register a new user");
			System.out.println("3) Quit");
			System.out.println();
			System.out.print("Enter choice [1-3]: ");
			user_choice = sc.nextInt();
			sc.nextLine(); // throw away the newline character
			switch (user_choice) {
			case 1: {
				System.out.println("Username: ");
				String un = sc.nextLine();
				System.out.println("Password: ");
				String pw = sc.nextLine();
				if (un.equals("admin")) {
					showAdminMenu();
				} else if (un.equals("emp")) {
					showEmployeeMenu();
				} else {
					if (activity.validateUser(un, pw)) {
						showCustomerMenu(un);
					}
				}
				break;
			}
			case 2: {
				System.out.println("Enter a new username: ");
				String un = sc.nextLine();
				System.out.println("Enter a new password: ");
				String pw = sc.nextLine();
				activity.createNewUser(un, pw);
				break;
			}
			}
		} while (user_choice != 3);
		sc.close();
		System.out.println("Logged out, thank you.");
	}

	private static void showCustomerMenu(String userName) {
		Scanner sc = new Scanner(System.in);

		int user_choice;
		int noOfAccounts = 0;
		do {
			// display menu to user
			// ask user for his choice and validate it (make sure it is between 1 and 6)
			System.out.println();
			System.out.println("1) View all customer information");
			System.out.println("2) Open a new bank account");
			System.out.println("3) Open a new joint bank account");
			System.out.println("4) Deposit to a bank account");
			System.out.println("5) Withdraw to bank account");
			System.out.println("6) Transfer funds");
			System.out.println("7) Quit");
			System.out.println();
			System.out.print("Enter choice [1-7]: ");
			user_choice = sc.nextInt();
			sc.nextLine(); // throw away the newline character
			switch (user_choice) {
			case 1:
				activity.displayAccountsByUser(userName);
				break;
			case 2: {
				System.out.println("Enter a name for your account: ");
				String an = sc.nextLine();

				if (!activity.doesAccountExist(userName, an)) {
					activity.createNewAccount(userName, an);
				}
				break;
			}
			case 3: {
				System.out.println("Enter a name for joint bank account: ");
				String an = sc.nextLine();
				System.out.println("Enter secondary UserName for joint access: ");
				String su = sc.nextLine();
				if (activity.doesUserExist(su)) {
					if (!activity.doesAccountExist(userName, an)) {
						activity.createNewJointAccount(userName, su, an);
					}
				} else {
					System.out.println("Secondary user does not exist. Please Register as a User.");
				}

				break;
			}
			case 4:
				noOfAccounts = activity.displayAccountsByUser(userName);
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number");
					int an = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (an > 0 && an <= noOfAccounts) {
						System.out.println("Enter a deposit amount");
						double amt = sc.nextDouble();
						sc.nextLine(); // throw away the newline character
						activity.deposit(activity.getAccountByNumber(userName, an), amt);
					} else {
						System.out.println("not a valid account");
					}
				}
				break;
			case 5:
				noOfAccounts = activity.displayAccountsByUser(userName);
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number");
					int an = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (an > 0 && an <= noOfAccounts) {
						System.out.println("Enter a withdrawl amount");
						double amt = sc.nextDouble();
						sc.nextLine(); // throw away the newline character
						activity.withdraw(activity.getAccountByNumber(userName, an), amt);
					} else {
						System.out.println("not a valid account");
					}
				}
				break;
			case 6:
				noOfAccounts = activity.displayAccountsByUser(userName);
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number you would like to transfer from");
					int anfrom = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					System.out.println("Enter a account number you would like to transfer to");
					int anto = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (anfrom > 0 && anfrom <= noOfAccounts && anto > 0 && anto <= noOfAccounts) {
						System.out.println("Enter how much you would like to transfer");
						double amt = sc.nextDouble();
						sc.nextLine(); // throw away the newline character
						activity.transfer(activity.getAccountByNumber(userName, anfrom),
								activity.getAccountByNumber(userName, anto), amt);
					} else {
						System.out.println("not a valid account");
					}
				}
				break;
			}
		} while (user_choice != 7);
		System.out.println("Logged out, thank you.");
	}

	private static void showEmployeeMenu() {
		Scanner sc = new Scanner(System.in);
		// Bank myBank = new Bank();

		int user_choice = 1;
		int noOfAccounts = 0;
		do {
			// display menu to user
			// ask user for his choice and validate it (make sure it is between 1 and 6)
			System.out.println();
			System.out.println("1) View all customer information");
			System.out.println("2) Approve Account Application");
			System.out.println("3) Deny Account Application");
			System.out.println("4) Deposit to a bank account");
			System.out.println("5) Withdraw to bank account");
			System.out.println("6) Transfer funds");
			System.out.println("7) Quit");
			System.out.println();
			System.out.print("Enter choice [1-7]: ");
			user_choice = sc.nextInt();
			sc.nextLine(); // throw away the newline character
			switch (user_choice) {
			case 1: {
				activity.displayAllAccounts();
				break;
			}
			case 2:
				noOfAccounts = activity.displayAllAccounts();
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number to Approve");
					int an = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (an > 0 && an <= noOfAccounts) {
						activity.changeAccountApprovalStatus(activity.getAccountByNumber(an), true);
						System.out.println("Account Approved!");
					}
				}
				break;
			case 3:
				noOfAccounts = activity.displayAllAccounts();
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number to Deny");
					int an = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (an > 0 && an <= noOfAccounts) {
						activity.changeAccountApprovalStatus(activity.getAccountByNumber(an), false);
						System.out.println("Account Denied!");
					}
				}
				break;
			case 4:
				noOfAccounts = activity.displayAllAccounts();
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number");
					int an = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (an > 0 && an <= noOfAccounts) {
						System.out.println("Enter a deposit amount");
						double amt = sc.nextDouble();
						sc.nextLine(); // throw away the newline character
						activity.deposit(activity.getAccountByNumber(an), amt);
					} else {
						System.out.println("not a valid account");
					}
				}
				break;
			case 5:
				noOfAccounts = activity.displayAllAccounts();
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number");
					int an = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (an > 0 && an <= noOfAccounts) {
						System.out.println("Enter a withdrawl amount");
						double amt = sc.nextDouble();
						sc.nextLine(); // throw away the newline character
						activity.withdraw(activity.getAccountByNumber(an), amt);
					} else {
						System.out.println("not a valid account");
					}
				}
				break;
			case 6:
				noOfAccounts = activity.displayAllAccounts();
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number you would like to transfer from");
					int anfrom = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					System.out.println("Enter a account number you would like to transfer to");
					int anto = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (anfrom > 0 && anfrom <= noOfAccounts && anto > 0 && anto <= noOfAccounts) {
						System.out.println("Enter how much you would like to transfer");
						double amt = sc.nextDouble();
						sc.nextLine(); // throw away the newline character
						activity.transfer(activity.getAccountByNumber(anfrom), activity.getAccountByNumber(anto), amt);
					} else {
						System.out.println("not a valid account");
					}
				}
				break;
			// case 5: ... break;
			}
		} while (user_choice != 7);
		System.out.println("Logged out, thank you.");
	}

	private static void showAdminMenu() {
		Scanner sc = new Scanner(System.in);
		// Bank myBank = new Bank();

		int user_choice;
		int noOfAccounts = 0;
		do {
			// display menu to user
			// ask user for his choice and validate it
			System.out.println();
			System.out.println("1) View all customer information");
			System.out.println("2) Approve Account Application");
			System.out.println("3) Deny Account Application");
			System.out.println("4) Deposit to a bank account");
			System.out.println("5) Withdraw to bank account");
			System.out.println("6) Transfer funds");
			System.out.println("7) Cancel Account");
			System.out.println("8) Quit");
			System.out.println();
			System.out.print("Enter choice [1-8]: ");
			user_choice = sc.nextInt();
			sc.nextLine(); // throw away the newline character
			switch (user_choice) {
			case 1: {
				activity.displayAllAccounts();
				break;
			}
			case 2:
				noOfAccounts = activity.displayAllAccounts();
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number to Approve");
					int an = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (an > 0 && an <= noOfAccounts) {
						activity.changeAccountApprovalStatus(activity.getAccountByNumber(an), true);
						System.out.println("Account Approved!");
					}
				}
				break;
			case 3:
				noOfAccounts = activity.displayAllAccounts();
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number to Deny");
					int an = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (an > 0 && an <= noOfAccounts) {
						activity.changeAccountApprovalStatus(activity.getAccountByNumber(an), false);
						System.out.println("Account Denied!");
					}
				}
				break;
			case 4:
				noOfAccounts = activity.displayAllAccounts();
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number");
					int an = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (an > 0 && an <= noOfAccounts) {
						System.out.println("Enter a deposit amount");
						double amt = sc.nextDouble();
						sc.nextLine(); // throw away the newline character
						activity.deposit(activity.getAccountByNumber(an), amt);
					} else {
						System.out.println("not a valid account");
					}
				}
				break;
			case 5:
				noOfAccounts = activity.displayAllAccounts();
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number");
					int an = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (an > 0 && an <= noOfAccounts) {
						System.out.println("Enter a withdrawl amount");
						double amt = sc.nextDouble();
						sc.nextLine(); // throw away the newline character
						activity.withdraw(activity.getAccountByNumber(an), amt);
					} else {
						System.out.println("not a valid account");
					}
				}
				break;
			case 6:
				noOfAccounts = activity.displayAllAccounts();
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number you would like to transfer from");
					int anfrom = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					System.out.println("Enter a account number you would like to transfer to");
					int anto = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (anfrom > 0 && anfrom <= noOfAccounts && anto > 0 && anto <= noOfAccounts) {
						System.out.println("Enter how much you would like to transfer");
						double amt = sc.nextDouble();
						sc.nextLine(); // throw away the newline character
						activity.transfer(activity.getAccountByNumber(anfrom), activity.getAccountByNumber(anto), amt);
					} else {
						System.out.println("not a valid account");
					}
				}
				break;
			case 7:
				noOfAccounts = activity.displayAllAccounts();
				if (noOfAccounts > 0) {
					System.out.println("Enter a account number to cancel");
					int an = sc.nextInt();
					sc.nextLine(); // throw away the newline character
					if (an > 0 && an <= noOfAccounts) {
						activity.changeAccountActiveStatus(activity.getAccountByNumber(an), false);
						System.out.println("Account Canceled!");
					}
				}
				break;
			}

		} while (user_choice != 8);
		System.out.println("Logged out, thank you.");
	}

}
