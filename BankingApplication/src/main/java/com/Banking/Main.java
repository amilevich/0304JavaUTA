package com.Banking;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	private static String bankEmployeeFile = "bankEmployee.txt";
	private static String bankCustomersFile = "bankCustomers.txt";
	
	public static void main(String[] args) {
		/*Employee Frank = new Employee("FrankSmith", "frankSmith", "122333");
		Employee Alberto = new Employee("AlbertoJones", "aJones", "455666");
		Employee.bankEmployee.put(Frank.getUserName(), Frank);
		Employee.bankEmployee.put(Alberto.getUserName(), Alberto);
		System.out.println(Frank);
		//writing
		System.out.println("writing");
	    Employee.writeObject(bankEmployeeFile, Frank);
	    Employee.writeObject(bankEmployeeFile, Alberto);
	    System.out.println("Reading");
	    System.out.println(Employee.readObject(bankEmployeeFile, Frank));
	    System.out.println(Employee.readObject(bankEmployeeFile, Alberto));
	    System.out.println("Hi");*/
	    Admin Alberto = new Admin();
	    Alberto.setName("Alberto");
	    Alberto.setUserName("albertoJ");
		Alberto.setPassWord("123");
	    
		Employee Frank = new Employee();
		Frank.setName("Frank");
		Frank.setUserName("frankS");
		Frank.setPassWord("456");
		
		Customer Jeff = new Customer();
		Jeff.setName("Jeff");
		Jeff.setUserName("jeffP");
		Jeff.setPassWord("789");
		Customer.writeObject(bankCustomersFile, Jeff);
		
		Customer.readObject(bankCustomersFile);
		System.out.println(Customer.bankCustomers);
		System.out.println("wrote");
		System.out.println("Welcome to the Bank");
		System.out.println("Press A to log in.");
		System.out.println("Press B to register and apply for an account.");
		String a = scan.next();
		
		do {
		
		//if employee/customer, someone with username and password
		if(a.equals("A")) {	
			userLogin();
			
		//if want to apply
		}else if(a.equals("B")) {
			System.out.println("Creating a new account");
			createAccount();
			break;
			
		//inputs we do not want
		}else {
			System.out.println("Invalid input, please try again.");
		}
		}while(!a.equals("A") || !a.equals("B"));
		
	}
	
	public static void createAccount() {
		System.out.println("Okay, to apply for an account, please enter your Name");
		String name = scan.next();
		System.out.println("Please input your Username");
		String userName = scan.next();
		System.out.println("Please input your Password");
		String passWord = scan.next();
		System.out.println("Please input your Social Security Number");
		String ssn = scan.next();
		
		Customer anotherCustomer = new Customer();
		anotherCustomer.setName(name);
		anotherCustomer.setUserName(userName);
		anotherCustomer.setPassWord(passWord);
		Customer.writeObject(bankCustomersFile, anotherCustomer);
		anotherCustomer.applyAccount(anotherCustomer);
		//Account account = new Account(name, userName, passWord, 0, ssn);
		//account.addUsers(userName, anotherCustomer);
		//System.out.println(account.getBalance());
		System.out.println(anotherCustomer.toString());
	}
	
	//login
	public static void userLogin() {
		System.out.println("***Login Menu ***");
		System.out.println("Are you a Customer(A), Employee(B) or an Admin(C)?");
		String loginType = scan.next();
		//System.out.println("Please input your Name");
		//String name = scan.next();
		System.out.println("Please input your Username");
		String userName = scan.next();			
		System.out.println("Please input your Password");
		String passWord = scan.next();
		//Account account = new Account();
		Customer login = Customer.bankCustomers.get(userName);
		
		do {
			if(loginType.equals("A")) {
				
				//correct password?
				if(Customer.bankLogin(userName, passWord) != null) {
					//do account and customer already exist
					//Account.readObject(bankAccountsFile, account);
					//go to specific menus
					customerMenu(login);
				}
			}else if(loginType.equals("B")) {
				employeeMenu();
				
				//future reference
				/*Employee emp = new Employee();
				emp.setName(name);
				emp.setUserName(userName);
				emp.setPassWord(passWord);
				if(emp.bankLogin(userName, passWord)) {
					//do account and customer already exist
					//go to specific menus
					
				}*/
			}else if(loginType.equals("C")) {
				adminMenu();
				
				//future reference
				/*Admin admin = new Admin(name, userName, passWord);
				if(admin.bankLogin(userName, passWord)) {
					//do account and customer already exist
					//go to specific menus
					adminMenu();
				}*/
			}else {
				System.out.println("Invalid input, please try again.");
			}
		}while(!loginType.equals("A") || !loginType.equals("B") || !loginType.equals("C"));	
		
	}
	
	public static void customerMenu(Customer login) {
		System.out.println("***Customer Menu***");
		System.out.println("Hello " + login.getName() + " how can we help you today?");
		System.out.println("Withdraw(A), Deposit(B), Transfer(C), or Exit(E)");
		String choice = scan.next();
		
		do {
			if(choice.equals("A")) {
				System.out.println("How much money would you like to withdraw? Your balance is " + login.getBalance() + ".");
				double money = scan.nextDouble();
				login.withdrawMoney(money);
			}else if(choice.equals("B")) {
				System.out.println("How much money would you like to deposit? Your balance is " + login.getBalance() + ".");
				double money = scan.nextDouble();
				login.depositMoney(money);
			}else if(choice.equals("C")) {
				System.out.println("What is the user name for the account you would like to transfer to?");
				String transferAccount = scan.next();
				System.out.println("How much money would you like to transfer? Your balance is " + login.getBalance() + ".");
				double money = scan.nextDouble();
				login.transferMoney(money, Customer.getBankCustomers().get(transferAccount));
			}else if(choice.equals("E")) {
				System.out.println("Thank you, have a nice day.");
				break;
			}else {
				System.out.println("Invalid input, please try again.");
			}
		}while(!choice.equals("A") || !choice.equals("B") || !choice.equals("C") || !choice.equals("E"));
	}
	
	public static void employeeMenu() {
			System.out.println("***Employee Portal***");
			System.out.println("What functions would you like to perform");
			System.out.println("View: Account Balance(A), Account Info(B), Approve(C), or Deny an applicaton(D)");
			String choice = scan.next();
			System.out.println("Please input the account's userName");
			String customerAccount = scan.next();
			
			if(Customer.bankCustomers.containsKey(customerAccount)) {
				Customer account = Customer.bankCustomers.get(customerAccount);
				
				do {
					if(choice.equals("A")) {
						account.getBalance();
					}else if(choice.equals("B")) {
						account.toString();
					}else if(choice.equals("C")) {
						Employee.approveAccount(account);
					}else if(choice.equals("D")) {
						Employee.denyAccount(account);
					}else {
						System.out.println("Invalid input, please try again.");
					}
				}while(!choice.equals("A") || !choice.equals("B") || !choice.equals("C") || !choice.equals("D"));
			}else {
				System.out.println("Account invalid");
			}
	}
	
	public static void adminMenu() {
		System.out.println("***Admin Portal***");
		System.out.println("What functions would you like to perform");
		System.out.println("Withdraw(A), Deposit(B), Transfer(C), Cancel(D) View Account Info(E), or Edit Account Info(F)");
		String choice = scan.next();
		System.out.println("Please input the account's userName");
		String customerAccount = scan.next();
		
		if(Customer.bankCustomers.containsKey(customerAccount)) {
			Customer account = Customer.bankCustomers.get(customerAccount);
			
			do {
				if(choice.equals("A")) {
					System.out.println("How much money would you like to withdraw? Account's balance is " + account.getBalance() + ".");
					double money = scan.nextDouble();
					account.withdrawMoney(money);
				}else if(choice.equals("B")) {
					System.out.println("How much money would you like to deposit? Account's balance is " + account.getBalance() + ".");
					double money = scan.nextDouble();
					account.depositMoney(money);
				}else if(choice.equals("C")) {
					System.out.println("What is the user name for the account you would like to transfer to?");
					String transferAccount = scan.next();
					System.out.println("How much money would you like to transfer? Account's balance is " + account.getBalance() + ".");
					double money = scan.nextDouble();
					account.transferMoney(money, Customer.getBankCustomers().get(transferAccount));
				}else if(choice.equals("D")) {
					Admin.cancelAccount(account);
				}else if(choice.equals("E")) {
					account.toString();
				}else if(choice.equals("F")) {
					Admin.editAccountInfo(account, account.getUserName(), account.getName(), account.getPassWord());
				}else {
					System.out.println("Invalid input, please try again.");
				}
			}while(!choice.equals("A") || !choice.equals("B") || !choice.equals("C") || !choice.equals("D") || !choice.equals("E") || !choice.equals("F"));
		}else {
			System.out.println("Account invalid");
		}
	}
	
}


