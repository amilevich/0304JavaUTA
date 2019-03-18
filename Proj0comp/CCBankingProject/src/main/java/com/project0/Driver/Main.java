package com.project0.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project0.Build.Account;
import com.project0.Build.Employee;
import com.project0.Data.AccountDaolmpl;
import com.project0.Data.EmployeeDaolmpl;

public class Main {

	public static void main(String[] args) {
		
		// char for navigation
		char type ='\n';
		// Create instance for scanner
		Scanner scan = new Scanner(System.in);
		// Create Storage for Info
		List<Account> Storage = new ArrayList<Account>();
		// Create list for employee and admin info
		List<Employee> Employ = new ArrayList<Employee>();
		// Instantiate Doa class
		AccountDaolmpl Omega = new AccountDaolmpl();
		EmployeeDaolmpl Zeta = new EmployeeDaolmpl();
		
		// 
		do{
			System.out.println("what kind of user are you: ");
			System.out.println("C for customer, E for Employee, A for Admin, Z to END");
			// Get Type of user
			type = scan.next().charAt(0);
			type = Character.toUpperCase(type);
			
			switch (type)
			{
			// Type C for customer
			case 'C':
				// get New or Returning client
				System.out.println("Are you a new(N) or returning(R) User: ");
				type = scan.next().charAt(0);
				type = Character.toUpperCase(type);
				// if new allow registration
				if(type == 'N') {
					
					// get info needed for registration
					System.out.println("Please enter your registration information: ");
					scan.nextLine();
					
					System.out.println("Enter a Username:");
					String User = scan.nextLine();
					
					System.out.println("Enter a Password:");
					String Pass = scan.nextLine();
					
					System.out.println("Enter a Name:");
					String Name = scan.nextLine();
					
					// make new account
					Account NewAccount = new Account(User,Pass, Name);
					
					// New Dao class
					AccountDaolmpl newAcc = new AccountDaolmpl();
					
					// Insert into database
					newAcc.insertAccount(NewAccount);
					
					System.out.println("Thank you for applying for an account with Flash Banking, we will review your account info an get back to you soon.");
					
				}
				else if(type == 'R') {
					
					scan.nextLine();
					// Collect login info
					System.out.println("Enter a Username:");
					String User = scan.nextLine();
					
					System.out.println("Enter a Password:");
					String Pass = scan.nextLine();
					
					Account ExAccount = Omega.selectAccount(User, Pass);
					// if account is found grant user access to account
					if(User.equals(ExAccount.getUserName()) && Pass.equals(ExAccount.getPassword())){
						System.out.println("Welcome");
						// If account hasn't been approve yet end loop
						if(ExAccount.getStatus() != 'A'){
							System.out.println("Sorry, your account has not been approved yet");
							
						}
						// otherwise continue process
						else {
							// ask for actions
							System.out.println("What would you like to do?");
							// Loop for repeated actions
							do{
								System.out.println("(W)Withdraw, (D)Deposit, (L)Leave: ");
								type = scan.next().charAt(0);
								type = Character.toUpperCase(type);
								switch(type) {
								// Allow withdraw
								case 'W':
									// Get amount
									System.out.println("How much?");
									double temp = scan.nextDouble();
									// Withdraw from balance
									ExAccount.Withdraw(temp);
									// Update
									Omega.updateAccount(ExAccount);
									break;
								// allow Deposit
								case 'D':
									// Get amount
									System.out.println("How much?");
									temp = scan.nextDouble();
									// Deposit to balance
									ExAccount.Deposit(temp);
									// Update
									Omega.updateAccount(ExAccount);
									break;
									
								// Leave
								case 'L':
									System.out.println("Thank you. Come again.");
									type = 'L';
									break;
								// otherwise loop back around	
								default:
									System.out.println("Sorry, try again.");
									break;
										
								}
										
							}while(type != 'L');
						}
						// add for next object in list
					}
					
				}
				
				break;
				
			// Type E for employee
			case 'E':
				scan.nextLine();
				// Collect login info
				System.out.println("Enter Employee ID:");
				String User = scan.nextLine();
				
				System.out.println("Enter a Password:");
				String Pass = scan.nextLine();
				int F=0;
				
				do{
					// Get login from database
					Employee ExEmploy = Zeta.findEmployee(User, Pass);
					Account ExAccount;
					System.out.println("Welcome " + ExEmploy.getName());
					// if account is found grant user access to account
					if(User.equals(ExEmploy.getEmployID()) && Pass.equals(ExEmploy.getPassword())){
						// ask for actions
						System.out.println("What would you like to do?");
						// Loop for repeated actions
						do{
							System.out.println("(A)View Accounts, (S) search for waiting accounts, (L)Leave: ");
							type = scan.next().charAt(0);
							type = Character.toUpperCase(type);
							switch(type) {
							case('A'):
								Omega.displayAccounts();
								break;
												
							case('S'):
								Storage = Omega.FindPending();
								for(int I=0;I<Storage.size(); I++) {
									ExAccount = Storage.get(I);
									if(ExAccount.getStatus()=='W') {
										System.out.println("Do you want to approve this account?");
										System.out.println(ExAccount);
										char Aws = scan.next().charAt(0);
										Aws = Character.toUpperCase(Aws);
									
										switch(Aws) {
										case 'Y':
											ExAccount.setStatus('A');
											Omega.updateStatus(ExAccount);
											break;
										
										case 'N':
											Omega.deleteAccount(ExAccount.getAccountID());
											break;
										
										}
									}
								}
								System.out.println("There are no more waiting account.");
								break;
							// Leave
							case 'L':
								System.out.println("Leaving");
								type = 'L';
								break;
							// otherwise loop back around	
							default:
								System.out.println("Sorry, try again.");
								break;
								
							}
								
						}while(type != 'L');
					}
					// If you go threw the entire list print
					else if (F == Employ.size()){
						System.out.println("Sorry, could not find that User Name and password combination. Please try again.");
						
					}
					// add for next object in list
					F++;
				}while(F<Employ.size());
				break;
			
			// Type A for Admin
			case 'A':
				
				scan.nextLine();
				// Collect login info
				System.out.println("Enter Admin ID:");
				User = scan.nextLine();
				
				System.out.println("Enter a Password:");
				Pass = scan.nextLine();
				
				Employee ExEmploy = Zeta.findEmployee(User, Pass);
				Account ExAccount;
				// if account is found grant user access to account
				if(User.equals(ExEmploy.getEmployID()) && Pass.equals(ExEmploy.getPassword()) && ExEmploy.getRank() == 'A'){
					// ask for actions
					System.out.println("What would you like to do?");
					// Loop for repeated actions
					do{
						System.out.println("(A)View Accounts, (S) search for waiting accounts, (E)Erase account, (W)Withdraw from, (D)Deposit to, (T)Transfer, (L)Leave: ");
						type = scan.next().charAt(0);
						type = Character.toUpperCase(type);
						switch(type) {
						case('A'):
							Omega.displayAccounts();
							break;							
						case('S'):
							Storage = Omega.FindPending();
							for(int I=0;I<Storage.size(); I++) {
								ExAccount = Storage.get(I);
								if(ExAccount.getStatus()=='W') {
									System.out.println("Do you want to approve this account?");
									System.out.println(ExAccount);
									char Aws = scan.next().charAt(0);
									Aws = Character.toUpperCase(Aws);
									
									switch(Aws) {
									case 'Y':
										ExAccount.setStatus('A');
										Omega.updateStatus(ExAccount);
										break;
										
									case 'N':
										Omega.deleteAccount(ExAccount.getAccountID());
										break;
										
									}
								}							
							}
							System.out.println("There are no more waiting account.");
							break;
						
						case('E'):
							scan.nextLine();
							System.out.print("Enter the account ID of the account to be erased:");
							int Del = scan.nextInt();
							ExAccount = Omega.FindByID(Del);
							if(Del == ExAccount.getAccountID()) {
								System.out.println("Are you sure you want to delete this account?");
								System.out.println(ExAccount);
								char Aws = scan.next().charAt(0);
								Aws = Character.toUpperCase(Aws);
							
								switch(Aws) {
								case 'Y':
									Omega.deleteAccount(Del);
									break;
								
								case 'N':
									break;
								}
							}
							
							break;
								
						// Allow withdraw
						case 'W':
							scan.nextLine();
							System.out.println("Enter the username of the account you want to withdraw from:");
							String Find = scan.nextLine();
							ExAccount = Omega.FindByUser(Find);
							if(Find.equals(ExAccount.getUserName())) {
								System.out.println("How much?");
								double temp = scan.nextDouble();
								ExAccount.Withdraw(temp);
								Omega.updateAccount(ExAccount);
							}
							break;
						// allow Deposit
						case 'D':
							scan.nextLine();
							System.out.println("Enter the username of the account you want to deposit into:");
							Find = scan.nextLine();
							ExAccount = Omega.FindByUser(Find);
							if(Find.equals(ExAccount.getUserName())) {
								System.out.println("How much?");
								double temp = scan.nextDouble();
								ExAccount.Deposit(temp);
								Omega.updateAccount(ExAccount);
							}
							break;
						case 'T':
							scan.nextLine();
							System.out.println("Enter the username of the account you want transfer from:");
							Find = scan.nextLine();
							ExAccount = Omega.FindByUser(Find);
							if(Find.equals(ExAccount.getUserName())) {
								System.out.println("How much?");
								double temp = scan.nextDouble();
								System.out.println("Enter the username of the account you want transfer To:");
								scan.nextLine();
								Find = scan.nextLine();
								Account ToAccount = Omega.FindByUser(Find);
								if(Find.equals(ToAccount.getUserName())) {
									if (temp > ExAccount.getFunds()) {
										System.out.println(ExAccount.getUserName() + " does not have enough.");
									}
									else{
										ExAccount.Withdraw(temp);
										ToAccount.Deposit(temp);
										Omega.updateAccount(ExAccount);
										Omega.updateAccount(ToAccount);
									}
								}
							}
							break;
						// Leave
						case 'L':
							System.out.println("Leaving");
							type = 'L';
							break;
						// otherwise loop back around	
						default:
							System.out.println("Sorry, try again.");
							break;
								
						}
							
					}while(type != 'L');
				}
				break;
			case 'Z':
				// Break the loop
				type = 'Z';
				break;
			// Try again if non of the above were chosen
			default:
				System.out.println("Wrong type please try again:");
				break;
			
			}		
			
		}while( type != 'Z');
		System.out.println("Goodbye");
		
	}
}
