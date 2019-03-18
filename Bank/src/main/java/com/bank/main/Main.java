package com.bank.main;

import java.util.Scanner;

//import com.bank.daoimpl.CustomerDaoImpl;
import com.bank.users.Admin;
import com.bank.users.Customer;
import com.bank.utility.Util;

public class Main 
{
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) 
	{
		Admin admin = new Admin();
	
		Util.printMain();
		int choice = Util.scanInt(scan);
		scan.nextLine();
		boolean quit = false;
		while (quit == false)
		{
			
		switch (choice) 
		{
		case 0:
			Util.printMain();
			choice = Util.scanInt(scan);
			scan.nextLine();
			
			break;
		case 1:
			Customer newCust = new Customer();
			Util.printEnter("Username");
			newCust.setUserName(Util.scanString(scan));
			Util.printEnter("Password");
			newCust.setPassWord(Util.scanString(scan));
			admin.addCustomer(newCust);
			break;
		case 2:
			Util.printLogInUsername();
			String username = Util.scanString(scan);
			switch (username) 
			{
			case "admin":
				Util.printLogInPassword();
				String apassword = Util.scanString(scan);
			
				while(!apassword.equals("admin"))
				{
					Util.printWrongPassword();
					Util.printLogInPassword();
					apassword = Util.scanString(scan);
				}
				Util.printAdminOptions();
				int aChoice = Util.scanInt(scan);
				scan.nextLine();
				switch (aChoice)
				{
				case 1:
					Util.printAdminAccountOptions();
					int accOption = Util.scanInt(scan);
					scan.nextLine();
					switch (accOption)
					{
					case 1:
						admin.viewAllAccounts();
						break;
					case 2:
						System.out.println("Enter account id to delete:");
						int beGoneAccount = Util.scanInt(scan);
						scan.nextLine();
						admin.deleteAccount(admin.getAccount(beGoneAccount));
						break;
					case 3:
						for (int i = 0; i < admin.getPendingSize(); i++) 
						{
							admin.getPendingAccount(i).toString();
							System.out.println("1)Approve");
							System.out.println("2)Deny");
							int approve = Util.scanInt(scan);
							scan.nextLine();
							if (approve == 1) 
								admin.Approve(admin.getPendingAccount(i));
							if (approve == 2) 
								admin.Deny(admin.getPendingAccount(i));
						}
						System.out.println("No more accounts pending");
						break;
					default:
						break;
					}
					break;
				case 2:
					Util.printAdminCustomerOptions();
					int cChoice = Util.scanInt(scan);
					scan.nextLine();
					switch (cChoice) 
					{
					case 1:
						admin.viewAllCustomers();
						break;
					case 2:
						System.out.println("Enter customer id number: ");
						int id = Util.scanInt(scan);
						scan.nextLine();
						admin.getCustomer(id).toString();
						break;
					
					default:
						break;
					}
					
					break;
				case 3:
					choice = 0;
					break;
				default:
					choice = 0;
					break;
				}
				break;
			case "employee":
				Util.printLogInPassword();
				String epassword = Util.scanString(scan);
				
				while(!epassword.equals("employee"))
				{
					System.out.println("Password doesn't match");
					Util.printLogInPassword();
					epassword = Util.scanString(scan);
				}
				break;
			default:
				
				break;
			}
			break;
		case 3:
			quit = true;
			break;
		default:
			break;
		}
		}	
	}

}
