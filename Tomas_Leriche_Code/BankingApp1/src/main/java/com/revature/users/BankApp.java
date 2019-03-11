package com.revature.users;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BankApp implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1714305117848502349L;
	ArrayList<Employee> employees;
	public ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Account> accounts = new ArrayList<Account>();
	ArrayList<BankAdmin> bankAdmins;
	
	
	
	public BankApp(){
		Account acc1 = new Account(500.50);
		Account acc2 = new Account(659.93);
		accounts.add(acc1);
		accounts.add(acc2);
		
		//Customer(String f, String l, String userID, String userName, Account account, String pw)
		Customer cust1 = new Customer("Babbb", "Jones", "44LLD", "BJones", acc1, "password");
		Customer cust2 = new Customer("Jackbb", "Borrego", "77HRD", "JBorrego", acc2, "pass");
		Customer cust3 = new Customer("Tombb", "Leriche", "98UYT", "TLeriche", acc2, "passw");
		customers.add(cust1);
		customers.add(cust2);
		customers.add(cust3);
		

	}

	public static void main(String[] args) throws Exception{
		
		// for initializing db with a few entries to start
//		BankApp bankapp = new BankApp();
//		serialize(bankapp);
				
		System.out.println("Main Method\n\n\n\n\n\n");
		
		BankApp bankapp = (BankApp) deserialize();
		Customer currentCust = null;
		
		System.out.println("Current Customers:" + bankapp.customers.size());
		for (Customer cust : bankapp.customers) {
			System.out.println("\t\t" + cust.getFirstName() + " " + cust.getLastname() 
							+ " " + cust.getUserName() + " " + cust.getPassword() 
							+ " " + cust.getAccount());
			
			
			
			/*===========================================================================
			 * End of Main Method
			 * =========================================================================
			 */
		}
		
		Scanner scan = new Scanner(System.in);
		boolean cycle = true;
		boolean loggedin = false;
		System.out.println("|+++++++++++++++++++++++++++++++++++++++++|");
		System.out.println("|++ Welcome to the Banking Application: ++|");
		System.out.println("|+++++++++++++++++++++++++++++++++++++++++|");
		System.out.print("\nGreetings Application User! of " + bankapp.customers.size());
		
		while (cycle && !loggedin) {
			
			System.out.print("\nChoose your recourse: 1 = Login, 2 = Register, 3 = Exit \n>_");
		
			String ans = scan.next().toLowerCase();
			switch(ans) {
			
			case "1": case "login":
				
				System.out.println("Logging In: ");
				System.out.println("Enter your Username: ");
				String uname = scan.next();
				System.out.println("Enter your Password: ");
				String pword = scan.next();
				System.out.println(uname +" "+ pword);
				
				// returns the customer object that logs in successfully
				currentCust = login(uname, pword);
				
				if (currentCust != null) {
					loggedin = true;
					break;
				}
				
				break;
				
			case "2": case "register":
				
				System.out.print("Registering: \nEnter First Name: ");
				ans = scan.next();
				System.out.print("\nEnter Last Name: ");
				String ans2 = scan.next();
				Customer customer = register(ans, ans2);
				bankapp.customers.add(customer);
				serialize(bankapp);
				break;
				
			case "3": case "exit":
				
				System.out.println("\n\n|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
				System.out.println("|-=-=-=-=-=-= Exiting System =-=-=-=-=-=-|");
				System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|  Have a good day!");
				cycle = false;
				
			default:
					break;
			}
			//System.out.println(ans);
		}
		cycle = true;
		
		while (currentCust != null && cycle) {
			
			bankapp = (BankApp) deserialize();
			
			// can only enter when person logging in has an account.
			while (currentCust.getAccount() != null && cycle) {
				
				/*===========================================================================
				 * Customer with Account 
				 * =========================================================================
				 */
				
				System.out.println("Please choose an action:");
				System.out.print("1 = View Balance, 2 = Withdraw, 3 = Deposit, 4 = Transfer, 5 = Exit \n>_");
				String ans = scan.next().toLowerCase();
				
				switch(ans) {
				case "1": case "view balance":
					
					if (currentCust.getAccount() != null) {
						System.out.println("\n|++++++++++++++++++++++++++|");
						System.out.println("|=== Your balance = $" + currentCust.getAccount().getBalance());
						System.out.println("|++++++++++++++++++++++++++|");
					}else {
						System.out.println("Please request an account first.");
					}
					
					break;
					
				case "2": case "withdraw":
					
					System.out.println("Enter withdraw amount: ");
					double amt = scan.nextDouble();
					
					// nice trick to iterate and remove object you are iterating over.
					for (Iterator<Customer> iterator = bankapp.customers.iterator(); iterator.hasNext();) {
					    Customer cust = iterator.next();
					    if (cust.getFirstName().equals(currentCust.getFirstName())) {
					        // Remove the current element from the iterator and the list.
					        iterator.remove();
					    }
					}
					currentCust.getAccount().withdraw(amt);
					bankapp.getCustomers().add(currentCust);
					break;
					
				case "3": case "deposit":
					
					System.out.println("Enter deposit amount: ");
					amt = scan.nextDouble();
					
					for (Iterator<Customer> iterator = bankapp.customers.iterator(); iterator.hasNext();) {
					    Customer cust = iterator.next();
					    if (cust.getFirstName().equals(currentCust.getFirstName())) {
					        // Remove the current element from the iterator and the list.
					        iterator.remove();
					    }
					}
					currentCust.getAccount().deposit(amt);
					bankapp.getCustomers().add(currentCust);
					break;
					
				case "4": case "transfer":
					
					Customer chosenCust = null;
					System.out.println("Enter amount to transfer: ");
					amt = scan.nextDouble();
					
					System.out.println("Enter name of recipient: ");
					String name = scan.next();
					
					for (Customer cust : bankapp.customers) {
						if (cust.getFirstName().equals(name)) {
							chosenCust = cust;
						}
					}
					
					currentCust.getAccount().transfer(chosenCust, amt);
					
					for (Iterator<Customer> iterator = bankapp.customers.iterator(); iterator.hasNext();) {
					    Customer cust = iterator.next();
					    if (cust.getFirstName().equals(currentCust.getFirstName())) {
					        // Remove the current element from the iterator and the list.
					        iterator.remove();
					    }
					}
					
					for (Iterator<Customer> iterator = bankapp.customers.iterator(); iterator.hasNext();) {
					    Customer cust = iterator.next();
					    if (cust.getFirstName().equals(chosenCust.getFirstName())) {
					        // Remove the current element from the iterator and the list.
					        iterator.remove();
					    }
					}
					
					bankapp.getCustomers().add(currentCust);
					bankapp.getCustomers().add(chosenCust);
					break;
					
				case "5": case "exit":
					
					
					cycle = false;
					
				}
			}
			
			/*===========================================================================
			 * No Account User
			 * =========================================================================
			 */
			
			// This is the outer while loop now and if 
			// cycle was put false we need to break out
			if (cycle == false) {
				break;
			}
			
			System.out.println("You dont have an Account with Us! ");
			System.out.print("1 = Request Account, 2 = Exit\n>_");
			String ans1 = scan.next().toLowerCase();
			
			switch(ans1) {
			case "1": case "request account":
				System.out.println("Account request sent..");
				
				Account newAcc = new Account(100.0);
				currentCust.setAccount(newAcc);
				
				for (Iterator<Customer> iterator = bankapp.customers.iterator(); iterator.hasNext();) {
				    Customer cust = iterator.next();
				    if (cust.getFirstName().equals(currentCust.getFirstName())) {
				        // Remove the current element from the iterator and the list.
				        iterator.remove();
				    }
				    
				}
				
				bankapp.customers.add(currentCust);
				
				
				cycle = false;
				
			case "2": case "exit":
				System.out.println("\nExiting... Have a nice day!");
				cycle = false;
			}
			
			
			

		}
		System.out.println("Saving changes...");
		
		serialize(bankapp);
		
	}
	
	

	/*===========================================================================
	 * Serialize and Deserialize Methods
	 * =========================================================================
	 */

	public static void serialize(Object obj) {

		try {
			FileOutputStream fos = new FileOutputStream("./bankapp.ser");
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(obj);
			os.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object deserialize() {
		try {
			Object obj;
			FileInputStream fis = new FileInputStream("./bankapp.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			obj = (Object) ois.readObject();
			ois.close();
			return obj;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*===========================================================================
	 * Register and Login Methods
	 * =========================================================================
	 */
	
	public static Customer register(String s1, String s2) {
				
		BankApp bankapp1 = (BankApp) deserialize();
		System.out.println(bankapp1.getCustomers().size());
		Scanner scan = new Scanner(System.in);
		
		for (Customer cust : bankapp1.customers) {
			if (cust.getFirstName().equals(s1) && cust.getLastname().equals(s2)) {
				System.out.println("\n\n|++++++++++++++++++++++++++++++++++++++++++++|");
				System.out.println("|==== That User Already Exists Try Again ====|");
				System.out.println("|++++++++++++++++++++++++++++++++++++++++++++|");
				break;
			}else {
				
				System.out.println("Registration Commencing...");
				System.out.println("Enter a Username: ");
				String uname = scan.next();
				
				System.out.println("Enter a Password: ");
				String pword = scan.next();

				
				Customer cust1 = new Customer(s1, s2, uname, pword, null, pword);
				bankapp1.getCustomers().add(cust1);
				return cust1;
			}
		}
		serialize(bankapp1);
		scan.close();
		return null;
	}
	
	
	public static Customer login(String s1, String s2) {
		
		BankApp bankapp2 = (BankApp) deserialize();
		System.out.println(bankapp2.customers.size());
		for (Customer cust : bankapp2.customers) {
			//System.out.println(cust.getFirstName());
			if (cust.getUserName().equals(s1)) {
				System.out.println("\nWelcome " + cust.getFirstName() + " " 
						+ cust.getLastname() + "!");
				
				// we grab the current customer
				Customer thisCust = cust;
				
				//remove the customer because we will change it.
//				bankapp2.getCustomers().remove(cust);
//				serialize(bankapp2);
				return thisCust;
			}else {
				
				continue;
			}
			
			
		}
		System.out.println("\nUser not found, try again.");
		return null;
		
	}
	
	
	/*===========================================================================
	 * Getters and Setters
	 * =========================================================================
	 */
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public ArrayList<BankAdmin> getBankAdmins() {
		return bankAdmins;
	}

	public void setBankAdmins(ArrayList<BankAdmin> bankAdmins) {
		this.bankAdmins = bankAdmins;
	}
	
	

}
