package com.project0.main;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main 
{
	enum programState 
	{
		ADMIN,
		EMPLOYEE,
		CUSTOMER,
		LOGGEDOUT,
		EXIT,
	}
	enum adminChoice
	{
		APPROVE,
		DENY,
		CANCEL,
		WITHDRAW,
		DEPOSIT,
		TRANSFER,
		VIEWACCOUNTS,
		LOGOUT
	}
	enum employeeChoice
	{
		VIEWACCOUNT,
		VIEWCUSTOMER,
		LOGOUT
	}
	enum customerChoice
	{
		REGISTER,
		APPLYACCOUNT,
		WITHDRAW,
		DEPOSIT,
		TRANSFER,
		VIEWACCOUNTS,
		LOGOUT
	}

	public static int  scanInt(Scanner s) 
	{
		try
		{return s.nextInt();}
		
		catch (InputMismatchException e) 
		{
			
			System.out.println("Please enter an integer");
			return 0;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return 0;
		}
	}
	public static float scanFloat(Scanner s) 
	{
		try
		{return s.nextFloat();}
		
		catch (InputMismatchException e) 
		{
			System.out.println("Please enter a value with a decimal");
			return 0;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return 0;
		}
	}
	public static String scanString(Scanner s) 
	{
		try
		{return s.nextLine();}
		
		catch (NoSuchElementException e) 
		{
			
			System.out.println("No element found");
			return "";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "";
		}
	}
	public static void enterChoice() {System.out.println("What would you like to do: ");}
	public static void enterUsername(){System.out.println("Enter username: ");}
	public static void enterPassword(){System.out.println("Enter password: ");}
	public static void main(String[] args)
	{
		int quit = 0;
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		String currUsername = null;
		programState state = programState.LOGGEDOUT;
		while (quit != -1)
		{
			
			switch (state)
			{
			case ADMIN:
				
				break;

			case EMPLOYEE:
				
				break;
				
			case CUSTOMER:
	
	
				break;
				
			case LOGGEDOUT:
				System.out.println("To register enter 1");
				System.out.println("To login enter 2");
				choice = scanInt(scanner);
//				while(choice != 1 & choice != 2) 
//				{
//					scanner.reset()
//					System.out.println("To register enter 1");
//					System.out.println("To login enter 2");
//					choice = scanInt(scanner);
//				}
				if (choice == 1)
				{
					
				}
				if (choice == 2)
				{
					
				enterUsername();
				currUsername = scanner.nextLine();
				//read in file currUsername if exists
				
				//switch between
				enterPassword();
				
		
				}
				break;
			case EXIT:
				scanner.close();
				quit = -1;
				break;
			default:
				break;
			}
		}

	}

}
