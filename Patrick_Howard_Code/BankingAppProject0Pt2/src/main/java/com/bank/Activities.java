package com.bank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import org.apache.log4j.Logger;

import com.bank.daoAccount.DaoAccountImpl;
import com.bank.daoJunctionTable.DaoJunctionImpl;
import com.bank.daoUser.DaoUserImpl;
import com.bank.model.Account;
import com.bank.model.Junction;
import com.bank.model.User;
import com.bank.model.UserAccount;

public class Activities {

	final static Logger log = Logger.getLogger(Activities.class);
	// private List<User> users = new ArrayList<>();
	// private List<Account> accounts = new ArrayList<>();
	DaoUserImpl daoUserImpl = new DaoUserImpl();
	DaoAccountImpl daoAccountImpl = new DaoAccountImpl();
	DaoJunctionImpl daoJunctionImpl = new DaoJunctionImpl();
	private DecimalFormat df = new DecimalFormat("$###,###.00");

	public Activities() {
		// load data from files
		// users = storage.retrieveUsers();
		// accounts = storage.retrieveAccounts();
	}

	// User methods
	public boolean createNewUser(String userName, String password) {
		if (daoUserImpl.getUserByName(userName) != null) {
			log.warn(userName);
			System.out.println("Username already exists. Please try again.");
			return false;
		}
		// add a new user
		daoUserImpl.insertUser(new User(userName, password, "Customer"));
		return true;
	}

	// public boolean doesUserExist(String userName) {
	// for (User user : users) {
	// if (userName.equals(user.getUsername())) {
	// return true;
	// }
	// }
	// return false;
	// }

	public int getUserIdByName(String un) {
		return daoUserImpl.getUserByName(un).getUserId();

	}

	public String validateUser(String userName, String password) {
		if (daoUserImpl.getUserByName(userName) == null) {
			log.warn(userName);
			System.out.println("User doesn't exist! ");
			return "";
		} else {
			User user = daoUserImpl.getUserByName(userName);
			if (password.equals(user.getPassword())) {
				return user.getType();
			} else {
				System.out.println("Invalid Password");
				return "";
			}
		}
	}

	// Account methods
	public boolean createNewAccount(int userId, String accountName) {
		// add a new account
		int accountId = 0;
		Account tmpAcct = new Account();
		tmpAcct.setAccountName(accountName);
		tmpAcct.setBalance(0.0);
		tmpAcct.setIsActive(1);
		tmpAcct.setIsApproved(0);

		accountId = daoAccountImpl.insertAccount(tmpAcct);

		Junction tmpJnct = new Junction();
		tmpJnct.setUserId(userId);
		tmpJnct.setAccountId(accountId);
		tmpJnct.setIsJointAccount(0);

		daoJunctionImpl.insertJunction(tmpJnct);
		return true;
	}

	// public boolean createNewJointAccount(String userName, String secondaryUser,
	// String accountName) {
	// // add an account (applied for)
	// accounts.add(new Account(userName, secondaryUser, accountName));
	// storage.storeAccounts(accounts);
	// return true;
	// }
	//
	// public boolean validateAccount(int userId, String accountName) {
	// if (accountName.equals(daoAccountImpl.getAccountByName(userId,
	// accountName).getaccountName())) {
	// return true;
	// } else {
	// log.warn("Account already exist! " + accountName);
	// System.out.println("Account already exists. Please try again.");
	// return false;
	// }
	// return false;
	// }

	public int displayAccountsByUser(int userId) {
		User user = daoUserImpl.getUser(userId);
		System.out.println("Account listing for user: " + user.getUsername());
		List<Account> accountList = daoAccountImpl.selectAllAccounts();
		System.out.println();
		int i = 0;

		Formatter fmt = new Formatter();
		fmt.format("----------------------------------------------------------------------------------\n");
		fmt.format("%1$-5s %2$-20s %3$10s %4$6s %5$6s\n", "No", "Account Name", "Balance", "Active", "Approved");
		fmt.format("----------------------------------------------------------------------------------\n");
		for (Account account : accountList) {
			++i;
			String activeWord = "NO";
			String approvedWord = "NO";
			if (account.getIsActive() == 1) {
				activeWord = "YES";
			}
			if (account.getIsApproved() == 1) {
				approvedWord = "YES";
			}
			fmt.format("%1$-5s:%2$-20s %3$10s %4$6s %5$6s\n", account.getAccountId(), account.getAccountName(),
					df.format(account.getBalance()), activeWord, approvedWord);
		}
		System.out.println(fmt);
		if (i == 0) {
			// no accounts
			System.out.println("There are no accounts.");
		}
		fmt.close();
		return i;
	}

	public int displayAccountsByUserName(String userName) {
		User user = daoUserImpl.getUserByName(userName);
		System.out.println("Account listing for user: " + user.getUsername());
		List<UserAccount> useraccountList = daoJunctionImpl.getUserAccountsByUserName(userName);
		System.out.println();
		int i = 0;

		Formatter fmt = new Formatter();
		fmt.format("----------------------------------------------------------------------------------\n");
		fmt.format("%1$-5s %2$-20s %3$10s %4$6s %5$6s\n", "No", "Account Name", "Balance", "Active", "Approved");
		fmt.format("----------------------------------------------------------------------------------\n");
		for (UserAccount useraccount : useraccountList) {
			++i;
			String activeWord = "NO";
			String approvedWord = "NO";
			if (useraccount.getIsActive() == 1) {
				activeWord = "YES";
			}
			if (useraccount.getIsApproved() == 1) {
				approvedWord = "YES";
			}
			fmt.format("%1$-5s:%2$-20s %3$10s %4$6s %5$6s\n", useraccount.getAccountId(), useraccount.getAccountName(),
					df.format(useraccount.getBalance()), activeWord, approvedWord);

		}
		System.out.println(fmt);
		if (i == 0) {
			// no accounts
			System.out.println("There are no accounts.");
		}
		fmt.close();
		return i;
	}

	public int displayAllAccounts() {
		List<UserAccount> useraccountList = daoJunctionImpl.getAllUserAccounts();
		System.out.println();
		int i = 0;

		Formatter fmt = new Formatter();
		fmt.format("----------------------------------------------------------------------------------\n");
		fmt.format("%1$-5s %2$-20s %3$-20s %4$10s %5$6s %6$6s\n", "No", "Primary User", "Account Name", "Balance",
				"Active", "Approved");
		fmt.format("----------------------------------------------------------------------------------\n");
		for (UserAccount useraccount : useraccountList) {
			++i;
			String activeWord = "NO";
			String approvedWord = "NO";
			if (useraccount.getIsActive() == 1) {
				activeWord = "YES";
			}
			if (useraccount.getIsApproved() == 1) {
				approvedWord = "YES";
			}
			fmt.format("%1$-5s:%2$-20s %3$-20s %4$10s %5$6s %6$6s\n", useraccount.getAccountId(),
					useraccount.getUsername(), useraccount.getAccountName(), df.format(useraccount.getBalance()),
					activeWord, approvedWord);

		}
		System.out.println(fmt);
		if (i == 0) {
			// no accounts
			System.out.println("There are no accounts.");
		}
		fmt.close();
		return i;
	}

	// public Account getAccountByNumber(String userName, int number) {
	// int i = 0;
	// for (Account account : accounts) {
	// if (userName.equals(account.getUserName())) {
	// if (++i == number) {
	// return account;
	// }
	// }
	// if (userName.equals(account.getSecondaryUser())) {
	// if (++i == number) {
	// return account;
	// }
	// }
	// }
	// return null;
	// }
	//
	// // Method overloading
	// public Account getAccountByNumber(int number) {
	// int i = 0;
	// for (Account account : accounts) {
	// if (++i == number) {
	// return account;
	// }
	// }
	// return null;
	// }

	public boolean changeAccountApprovalStatus(int accountid, boolean status) {
		Account account = daoAccountImpl.getAccount(accountid);
		if (status) {
			account.setIsApproved(1);
		} else {
			account.setIsApproved(0);
		}
		daoAccountImpl.updateAccount(account);
		return true;
	}

	public boolean changeAccountActiveStatus(int accountid, boolean status) {
		Account account = daoAccountImpl.getAccount(accountid);
		if (status) {
			account.setIsActive(1);
		} else {
			account.setIsActive(0);
		}
		daoAccountImpl.updateAccount(account);
		return true;
	}

	// // Transaction methods
	public void deposit(int accountid, Double value) {
		Account account = daoAccountImpl.getAccount(accountid);
		if ((int) account.getIsActive() == 1) {
			if ((int) account.getIsApproved() == 1) {
				if (value > 0.0) {
					System.out.println("Depositing " + value.toString() + " to balance.");
					Double balance = account.getBalance();
					account.setBalance(balance + value);
					daoAccountImpl.updateAccount(account);
					log.info("deposited " + Double.toString(value));
					System.out.println("Deposit successful.");
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

	public boolean withdraw(int accountid, Double value) {
		Account account = daoAccountImpl.getAccount(accountid);
		if ((int) account.getIsActive() == 1) {
			if ((int) account.getIsApproved() == 1) {
				if (value > 0.0) {
					System.out.println("Withdrawing " + value.toString() + " from balance.");
					Double balance = account.getBalance();
					if (balance - value < 0) {
						System.out.println("Insufficient funds.");
						return false;
					}
					account.setBalance(balance - value);
					daoAccountImpl.updateAccount(account);
					log.info("withdrawl " + Double.toString(value));
					System.out.println("Withdrawl successful.");
				} else {
					System.out.println("You cannot withdraw a negative amount");
				}
			} else {
				System.out.println("Sorry account is not approved.");
			}
		} else {
			System.out.println("Sorry account is not active.");
		}
		return true;
	}

	public void transfer(int fromAccountId, int toAccountId, Double value) {
		Account fromAccount = daoAccountImpl.getAccount(fromAccountId);
		Account toAccount = daoAccountImpl.getAccount(toAccountId);
		if ((int) fromAccount.getIsActive() == 1 && toAccount.getIsActive() == 1) {
			if ((int) fromAccount.getIsApproved() == 1 && toAccount.getIsApproved() == 1) {
				if (withdraw(fromAccountId, value)) {
					deposit(toAccountId, value);
					log.info("transfered " + Double.toString(value));
					System.out.println("Transfer successful.");
				}
			} else {
				System.out.println("Sorry account is not approved.");
			}
		} else {
			System.out.println("Sorry account is not active.");
		}
	}
}
