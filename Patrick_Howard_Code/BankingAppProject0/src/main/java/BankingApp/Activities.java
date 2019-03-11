package BankingApp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import org.apache.log4j.Logger;

public class Activities {

	final static Logger log = Logger.getLogger(Activities.class);
	private static Persistance storage = new Persistance();
	private List<User> users = new ArrayList<>();
	private List<Account> accounts = new ArrayList<>();

	private DecimalFormat df = new DecimalFormat("$###,###.00");

	public Activities() {
		// load data from files
		users = storage.retrieveUsers();
		accounts = storage.retrieveAccounts();
	}

	// User methods
	public boolean createNewUser(String userName, String password) {
		for (User user : users) {
			if (userName.equals(user.getUsername())) {
				log.warn(userName);
				System.out.println("Username already exists. Please try again.");
				return false;
			}
		}
		// add a new user
		users.add(new User(userName, password));
		storage.storeUsers(users);
		return true;
	}

	public boolean doesUserExist(String userName) {
		for (User user : users) {
			if (userName.equals(user.getUsername())) {
				return true;
			}
		}
		return false;
	}

	public boolean validateUser(String userName, String password) {
		for (User user : users) {
			if (userName.equals(user.getUsername())) {
				if (password.equals(user.getPassword())) {
					return true;
				} else {
					System.out.println("Invalid Password");
					return false;
				}
			}
		}
		System.out.println("User doesn't exist! ");
		return false;
	}

	// Account methods
	public boolean createNewAccount(String userName, String accountName) {
		// add an account (applied for)
		accounts.add(new Account(userName, accountName));
		storage.storeAccounts(accounts);
		return true;
	}

	public boolean createNewJointAccount(String userName, String secondaryUser, String accountName) {
		// add an account (applied for)
		accounts.add(new Account(userName, secondaryUser, accountName));
		storage.storeAccounts(accounts);
		return true;
	}

	public boolean doesAccountExist(String userName, String accountName) {
		for (Account account : accounts) {
			if (accountName.equals(account.getAccountName())) {
				log.warn("Account already exist! " + accountName);
				System.out.println("Account already exists. Please try again.");
				return true;
			}
		}
		return false;
	}

	public int displayAccountsByUser(String userName) {
		System.out.println("Account listing for user: " + userName);
		Formatter fmt = new Formatter();
		fmt.format("%1$2s %2$-20s %3$-20s %4$10s %5$6s %6$6s\n", "No", "Primary User", "Account Name", "Balance",
				"Active", "Approved");
		fmt.format("-----------------------------------------------------------------------------\n");
		int i = 0;
		for (Account account : accounts) {
			if (userName.equals(account.getUserName())) {
				++i;
				fmt.format("%1$-2s:%2$-20s %3$-20s %4$10s %5$6s %6$6s\n", Integer.toString(i), account.getUserName(),
						account.getAccountName(), df.format(account.getBalance()), Boolean.toString(account.isActive()),
						Boolean.toString(account.isApproved()));
			}
			if (userName.equals(account.getSecondaryUser())) {
				++i;
				fmt.format("%1$-2s:%2$-20s %3$-20s %4$10s %5$6s %6$6s\n", Integer.toString(i), account.getUserName(),
						account.getAccountName(), df.format(account.getBalance()), Boolean.toString(account.isActive()),
						Boolean.toString(account.isApproved()));
			}
		}
		System.out.println(fmt);
		if (i == 0) {
			// no accounts
			System.out.println("There are no accounts for this user.");
		}
		fmt.close();
		return i;
	}

	public int displayAllAccounts() {
		System.out.println();
		// System.out.println("No User\tAccount Name\t\tBalance\tActive\tApproved");
		// System.out.println("--------------------------------------------------------------");
		int i = 0;

		Formatter fmt = new Formatter();
		fmt.format("%1$2s %2$-20s %3$-20s %4$10s %5$6s %6$6s\n", "No", "Primary User", "Account Name", "Balance",
				"Active", "Approved");
		fmt.format("-----------------------------------------------------------------------------\n");
		for (Account account : accounts) {
			/// System.out.println(++i + ": " + account.getUserName() +"\t" +
			/// account.getAccountName() + "\t\t" + df.format(account.getBalance()) + "\t" +
			/// account.isActive() + "\t" + account.isApproved());
			++i;
			fmt.format("%1$-2s:%2$-20s %3$-20s %4$10s %5$6s %6$6s\n", Integer.toString(i), account.getUserName(),
					account.getAccountName(), df.format(account.getBalance()), Boolean.toString(account.isActive()),
					Boolean.toString(account.isApproved()));
		}
		System.out.println(fmt);
		if (i == 0) {
			// no accounts
			System.out.println("There are no accounts.");
		}
		fmt.close();
		return i;
	}

	public Account getAccountByNumber(String userName, int number) {
		int i = 0;
		for (Account account : accounts) {
			if (userName.equals(account.getUserName())) {
				if (++i == number) {
					return account;
				}
			}
			if (userName.equals(account.getSecondaryUser())) {
				if (++i == number) {
					return account;
				}
			}
		}
		return null;
	}

	// Method overloading
	public Account getAccountByNumber(int number) {
		int i = 0;
		for (Account account : accounts) {
			if (++i == number) {
				return account;
			}
		}
		return null;
	}

	public boolean changeAccountApprovalStatus(Account account, boolean status) {
		account.setApproved(status);
		storage.storeAccounts(accounts);
		return true;
	}

	public boolean changeAccountActiveStatus(Account account, boolean status) {
		account.setActive(status);
		storage.storeAccounts(accounts);
		return true;
	}

	// Transaction methods
	public void deposit(Account account, Double value) {
		if (account.isActive()) {
			if (account.isApproved()) {
				if (value > 0.0) {
					System.out.println("Depositing " + value.toString() + " to balance.");
					Double balance = account.getBalance();
					account.setBalance(balance + value);
					log.info(account.getUserName() + " - " + "deposited " + Double.toString(value));
					System.out.println("Deposit successful.");
					storage.storeAccounts(accounts);
				} else {
					System.out.println("You cannot deposit a negative amount");
				}
			} else {
				System.out.println("Sorry account is not approved.");
			}
		} else {
			System.out.println("Sorry account is not active.");
		}
	}

	public boolean withdraw(Account account, Double value) {
		if (account.isActive()) {
			if (account.isApproved()) {
				if (value > 0.0) {
					Double balance = account.getBalance();
					if (balance - value < 0) {
						System.out.println("Insufficient funds.");
						return false;

					} else {
						account.setBalance(balance - value);
						System.out.println("Withdrawing " + value.toString() + " of balance.");
						log.info(account.getUserName() + " - " + "withdrawl " + Double.toString(value));
						System.out.println("Withdraw successful.");
						storage.storeAccounts(accounts);
						return true;
					}
				} else {
					System.out.println("You cannot deposit a negative amount");
				}

			} else {
				System.out.println("Sorry account is not approved.");
			}
		} else {
			System.out.println("Sorry account is not active.");
		}
		return false;
	}

	public void transfer(Account fromAccount, Account toAccount, Double value) {
		if (fromAccount.isActive() && toAccount.isActive()) {
			if (fromAccount.isApproved() && toAccount.isActive()) {
				if (withdraw(fromAccount, value)) {
					deposit(toAccount, value);
					log.info(fromAccount.getUserName() + " - " + "transfered " + Double.toString(value));
					System.out.println("Transfer successful.");
					storage.storeAccounts(accounts);
				}
			} else {
				System.out.println("Sorry account is not approved.");
			}
		} else {
			System.out.println("Sorry account is not active.");
		}
	}
}
