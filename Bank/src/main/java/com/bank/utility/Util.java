package com.bank.utility;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.bank.account.Account;
import com.bank.users.Customer;

public class Util
{
	public final static String url = "jdbc:oracle:thin:@deyongedavid-db.chvpwsm7hk6v.us-east-2.rds.amazonaws.com:1521:ORCL";
	public final static String username = "bankerboii";
	public final static String password = "bankpassword";
	
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
	public static void printWrongPassword() {System.out.println("Password doesn't match");}
	public static double withdraw(Customer user,Account account,double amount)
	{
		if(amount <= account.getBalance())
		account.setBalance(account.getBalance()-amount);
		
		else
			System.out.println("Insufficient funds");
		
		return account.getBalance();
	}
	public static double deposit(Customer user,Account account,double amount)
	{
		account.setBalance(account.getBalance()+amount);
		return account.getBalance();
	}
	
	public static void printMain()
	{
		System.out.println("What would you like to do:");
		System.out.println("1)Register");
		System.out.println("2)Log In");
		System.out.println("3)Exit");
	}
	public static void printEnter(String variable)
	{
		System.out.println("Enter a "+variable);
	}
	public static void printLogInUsername()
	{
		System.out.println("Enter username: ");
	}
	public static void printLogInPassword()
	{
		System.out.println("Enter username: ");
	}
	public static void printAdminOptions()
	{
		System.out.println("What would you like to do:");
		System.out.println("1)Manage accounts");
		System.out.println("2)Manage customers");
		System.out.println("3)Main Menu");
	}
	public static void printAdminAccountOptions()
	{
		System.out.println("What would you like to do:");
		System.out.println("1)View Accounts");
		System.out.println("2)Delete Accounts");
		System.out.println("3)Approve/Deny Accounts");
		
		System.out.println("4)Exit");
	}
	public static void printAdminCustomerOptions()
	{
		System.out.println("What would you like to do:");
		System.out.println("1)View Customer");
		System.out.println("2)Insert/Delete Customer");
		System.out.println("3)Exit");
	}
	public static void printAdminViewCustomerOptions()
	{
		System.out.println("What would you like to do:");
		System.out.println("1)View All Customers");
		System.out.println("2)Pick Customer");
		System.out.println("3)Exit");
	}

	public static void printCustomerOptions()
	{
		System.out.println("What would you like to do:");
		System.out.println("1)Manage accounts");
		System.out.println("2)View Personal Info");
		System.out.println("3)Apply for New account");
		System.out.println("4)Exit");
	}
	public static void printCustomerAccountOptions()
	{
		System.out.println("What would you like to do:");
		System.out.println("1)View Accounts");
		System.out.println("2)Withdraw");
		System.out.println("3)Deposit");
		System.out.println("4)Exit");
	}
	
	
}
