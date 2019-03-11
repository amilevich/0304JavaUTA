package com.projectzero.main;

import com.projectzero.accounts.Account;
import com.projectzero.accounts.Application;
import com.projectzero.accounts.JointApplication;
import com.projectzero.users.Employee;
import com.projectzero.users.User;

public class Register {

	public Register() {
	}

	//Registration process to make an application to be approved by Employee
	public static void makeProfile() {
		
		String username;
		String password;
		String fN;
		String lN;
		String ssn;
		String accountBalance = "0";
		String jointHolder = "null";
		System.out.println("Enter your First Name: ");
		fN = Main.sc.nextLine();
		System.out.println("Enter your Last Name: ");
		lN = Main.sc.nextLine();
		System.out.println("Enter your SSN: ");
		ssn = Main.sc.nextLine();
		System.out.println("Enter new username: ");
		username = Main.sc.nextLine();
		//loop to check if username is already being used
		while (User.userNameAlreadyUsed(username)) {
			System.out.println("Username already in use\nEnter new username: ");
			username = Main.sc.nextLine();
		}
		System.out.println("Enter new password: ");
		password = Main.sc.nextLine();
		//set starting balance of account
		System.out.println("To apply for a bank account enter a starting balance $: ");
		accountBalance = Main.sc.nextLine();
		
		//Switch to make a regular or joint account application 
		System.out.println("Do you want to apply for a joint bank account with another person? Y/N: ");
		String n = Main.sc.nextLine();
		switch (n) {
		case "n":
			//automatically create account, CAN'T LOGIN WITH EMPLOYEE!!! =(
			Account newAccount = new Account(fN, lN, username,password, ssn, Float.parseFloat(accountBalance));
			
			//Instantiate and initialize application
			Application newApplication = new Application(Float.parseFloat(accountBalance), newAccount);
			//Goes to Application class to Serialize 
			Application.accountApply(newApplication);

			if (Employee.approveAccount(newAccount)) {
				System.out.println("Account created successfully");
				Account.close(newAccount);
			} else {
				System.out.println("Account creation failure");
			}
			break;
		case "y":
			System.out.println("Enter the joint account holder's first and last name: ");
			jointHolder = Main.sc.nextLine();
			
			//automatically create account, CAN'T LOGIN WITH EMPLOYEE!!! =(
			Account newJointAccount = new Account(fN, lN, username,password, ssn, Float.parseFloat(accountBalance), jointHolder);
			//Instantiate and initialize joint account application
			JointApplication newJointApplication = new JointApplication(Float.parseFloat(accountBalance), jointHolder,
					newJointAccount);
			//Goes to Joint Application class to Serialize
			JointApplication.accountApply(newJointApplication);

			if (Employee.approveAccount(newJointAccount)) {
				System.out.println("Account created successfully");
			} else {
				System.out.println("Account creation failure");
			}
			break;
		default:
			//calls quit method to close program
			Main.Quit();
			break;
		}

	}

	public static void waitPage() {

		System.out.println(
				"\nThanks for registering!\n Please log out and wait for your account application to be approved."
						+ "\nYou will be contacted by an employee when your account is ready.");
		System.out.println("To log out press 'Y': ");
		String y = Main.sc.nextLine();
		if (y == "y" || y == "Y")
			System.exit(0);
	}
}
