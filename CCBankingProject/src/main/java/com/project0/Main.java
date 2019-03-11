package com.project0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		
		String filename = "Account.txt";
		String filename2 = "Employee.txt";
		
		// 
		do{
			System.out.println("what kind of user are you: ");
			System.out.println("C for customer, E for Employee, A for Admin");
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
					
					System.out.println("Enter a Account Type:");
					char aType = scan.next().charAt(0);
					
					// make new account
					Account NewAccount = new Account(User,Pass, Name, aType);
					// acquire list from file
					Storage = (List<Account>) readObject(filename);
					// Store account into list
					Storage.add(NewAccount);
					// Store list into file
					writeObject(filename,Storage);
					
					System.out.println("Thank you for applying for an account with Revature Banking, we will review your account info an get back to you soon.");
					// break loop
					type = 'Z';
					
				}
				else if(type == 'R') {
					
					scan.nextLine();
					// Collect login info
					System.out.println("Enter a Username:");
					String User = scan.nextLine();
					
					System.out.println("Enter a Password:");
					String Pass = scan.nextLine();
					
					// get list stored into file
					Storage = (List<Account>) readObject(filename);
					int F =0;
					// loop for to search for account			
					do{
						
						Account ExAccount = Storage.get(F);
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
									System.out.println("(W)Withdraw, (D)Deposit, (T)Transfer, (L)Leave: ");
									type = scan.next().charAt(0);
									type = Character.toUpperCase(type);
									switch(type) {
									// Allow withdraw
									case 'W':
										// Get amount
										System.out.println("How much?");
										double temp = scan.nextDouble();
										// remove for updating
										Storage.remove(ExAccount);
										// Withdraw from balance
										ExAccount.Withdraw(temp);
										// Add for updating
										Storage.add(ExAccount);
										// Update file
										writeObject(filename,Storage);
										break;
									// allow Deposit
									case 'D':
										// Get amount
										System.out.println("How much?");
										temp = scan.nextDouble();
										// remove for updating
										Storage.remove(ExAccount);
										// Deposit to balance
										ExAccount.Deposit(temp);
										// add for updating
										Storage.add(ExAccount);
										// update file
										writeObject(filename,Storage);
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
						}
						// If you go threw the entire list print
						else if (F == Storage.size()){
							System.out.println("Sorry, could not find that User Name and password combination. Please try again.");
							
						}
						// add for next object in list
						F++;
					}while(F<Storage.size());
					// exit list
					type = 'Z';
					
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
					Employ = (List<Employee>) readObject(filename2);
					Employee ExEmploy = Employ.get(F);
					Storage = (List<Account>) readObject(filename);
					Account ExAccount;
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
								System.out.println(Storage);
								break;
												
							case('S'):
								for(int I=0;I<Storage.size(); I++) {
									ExAccount = Storage.get(I);
									if(ExAccount.getStatus()=='W') {
										System.out.println("Do you want to approve this account?");
										System.out.println(ExAccount);
										char Aws = scan.next().charAt(0);
										Aws = Character.toUpperCase(Aws);
										
										switch(Aws) {
										case 'Y':
											Storage.remove(ExAccount);
											ExAccount.setStatus('A');
											Storage.add(ExAccount);
											writeObject(filename,Storage);
											break;
											
										case 'N':
											Storage.remove(ExAccount);
											writeObject(filename,Storage);
											break;
											
										}
									}
								System.out.println("There are no more waiting account.");
									
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
					// If you go threw the entire list print
					else if (F == Employ.size()){
						System.out.println("Sorry, could not find that User Name and password combination. Please try again.");
						
					}
					// add for next object in list
					F++;
				}while(F<Employ.size());
				type = 'Z';
				break;
			
			// Type A for Admin
			case 'A':
				
				scan.nextLine();
				// Collect login info
				System.out.println("Enter Admin ID:");
				User = scan.nextLine();
				
				System.out.println("Enter a Password:");
				Pass = scan.nextLine();
				F=0;
				
				do{
					Employ = (List<Employee>) readObject(filename2);
					Employee ExEmploy = Employ.get(F);
					Storage = (List<Account>) readObject(filename);
					Account ExAccount;
					// if account is found grant user access to account
					if(User.equals(ExEmploy.getEmployID()) && Pass.equals(ExEmploy.getPassword()) && ExEmploy.getRank() == 'A'){
						// ask for actions
						System.out.println("What would you like to do?");
						// Loop for repeated actions
						do{
							System.out.println("(A)View Accounts, (V)View employees, (N)Add New employees, (S) search for waiting accounts, (E)Erase account, (W)Withdraw from, (D)Deposit to, (T)Transfer, (L)Leave: ");
							type = scan.next().charAt(0);
							type = Character.toUpperCase(type);
							switch(type) {
							case('A'):
								System.out.println(Storage);
								break;
								
							case('V'):
								System.out.println(Employ);
								break;
							
							case('N'):
								scan.nextLine();
								System.out.println("Enter a Username:");
								User = scan.nextLine();
							
								System.out.println("Enter a Password:");
								Pass = scan.nextLine();
							
								System.out.println("Enter a Name:");
								String Name = scan.nextLine();
								
								System.out.println("Enter Rank:");
								char Rank = scan.next().charAt(0);
								Rank = Character.toUpperCase(type);
								
								Employee newHire = new Employee(User, Pass, Name, Rank);
								Employ.add(newHire);
								writeObject(filename2,Employ);
								break;
							
							case('S'):
								for(int I=0;I<Storage.size(); I++) {
									ExAccount = Storage.get(I);
									if(ExAccount.getStatus()=='W') {
										System.out.println("Do you want to approve this account?");
										System.out.println(ExAccount);
										char Aws = scan.next().charAt(0);
										Aws = Character.toUpperCase(Aws);
										
										switch(Aws) {
										case 'Y':
											Storage.remove(ExAccount);
											ExAccount.setStatus('A');
											Storage.add(ExAccount);
											writeObject(filename,Storage);
											break;
											
										case 'N':
											Storage.remove(ExAccount);
											writeObject(filename,Storage);
											break;
											
										}
									}
								System.out.println("There are no more waiting account.");
									
								}
								break;
							
							case('E'):
								scan.nextLine();
								System.out.print("Enter the account ID of the account to be erased:");
								int Del = scan.nextInt();
								for(int I=0;I<Storage.size(); I++) {
									ExAccount = Storage.get(I);
									if(Del == ExAccount.getAccountID()) {
										System.out.println("Are you sure you want to delete this account?");
										System.out.println(ExAccount);
										char Aws = scan.next().charAt(0);
										Aws = Character.toUpperCase(Aws);
									
										switch(Aws) {
										case 'Y':
											Storage.remove(ExAccount);
											writeObject(filename,Storage);
											break;
										
										case 'N':
											break;
										}
									}
								}
								break;
								
							// Allow withdraw
							case 'W':
								scan.nextLine();
								System.out.println("Enter the username of the account you want to withdraw from:");
								String Find = scan.nextLine();
								for(int I=0;I<Storage.size(); I++) {
									ExAccount = Storage.get(I);
									if(Find.equals(ExAccount.getUserName())) {
										System.out.println("How much?");
										double temp = scan.nextDouble();
										Storage.remove(ExAccount);
										ExAccount.Withdraw(temp);
										Storage.add(ExAccount);
										writeObject(filename,Storage);
									}
								}
								break;
							// allow Deposit
							case 'D':
								scan.nextLine();
								System.out.println("Enter the username of the account you want to deposit into:");
								Find = scan.nextLine();
								for(int I=0;I<Storage.size(); I++) {
									ExAccount = Storage.get(I);
									if(Find.equals(ExAccount.getUserName())) {
										System.out.println("How much?");
										double temp = scan.nextDouble();
										Storage.remove(ExAccount);
										ExAccount.Deposit(temp);
										Storage.add(ExAccount);
										writeObject(filename,Storage);
									}
								}
								break;
							case 'T':
								scan.nextLine();
								System.out.println("Enter the username of the account you want transfer from:");
								Find = scan.nextLine();
								for(int I=0;I<Storage.size(); I++) {
									ExAccount = Storage.get(I);
									if(Find.equals(ExAccount.getUserName())) {
										System.out.println("How much?");
										double temp = scan.nextDouble();
										System.out.println("Enter the username of the account you want transfer To:");
										Find = scan.nextLine();
										Account ToAccount = Storage.get(I);
										if(Find.equals(ToAccount.getUserName())) {
											Storage.remove(ToAccount);
											Storage.remove(ExAccount);
											ExAccount.Withdraw(temp);
											ToAccount.Deposit(temp);
											Storage.add(ToAccount);
											Storage.add(ExAccount);
											writeObject(filename,Storage);
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
					// If you go threw the entire list print
					else if (F == Employ.size()){
						System.out.println("Sorry, could not find that User Name and password combination. Please try again.");
						
					}
					// add for next object in list
					F++;
				}while(F<Employ.size());
				type = 'Z';
				break;
			
			// Try again if non of the above were chosen
			default:
				System.out.println("Wrong type please try again:");
				break;
			
			}		
			
		}while( type != 'Z');

		
	}
	
	// Method for Reading object from file
	static Object readObject(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			
			Object obj = ois.readObject();
			return obj;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return filename;
		
	}
	
	// Method for Writing object to file
	static void writeObject(String filename, Object obj) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			
			oos.writeObject(obj);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
