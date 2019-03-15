package com.projectzero.main;

import com.projectzero.accounts.Account;
import com.projectzero.accounts.WithdrawTooBigException;
import com.projectzero.users.Admin;
import com.projectzero.users.Employee;
import com.projectzero.users.User;

public class Login {

	public Login() {
	}
	
	public static void UserLogin()	{
		boolean b = false;
		
		do {
			//Welcome screen with options
			System.out.println("Welcome to Project Zero Banking App!"
					+ "\nPress 1: Login\nPress 2: Sign up\nPress 3: Exit");
			String choice = Main.sc.nextLine();
			switch (choice) {
			case "1":
				//Goes to Login class to enter username & password
				try {
					appLogin();
				} catch (WithdrawTooBigException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "2":
				//Goes to Register class to input info and make an application for an account
				Register.makeProfile();
				break;
			case "3":
				//escape loop
				b = true;
				break;
			default:
				//If any other key is pressed
				System.out.println("Try again");
				break;
			}
		} while (!b);
		//goodbye message, program end
		System.out.println("Goodbye");
	}

	//method to attempt login 
	public static boolean appLogin() throws WithdrawTooBigException {
		System.out.println("Enter username: ");
		String un = Main.sc.nextLine();
		System.out.println("Enter password: ");
		String pw = Main.sc.nextLine();

		//*********************************************PROBLEM*********************************************//
		//Figure out how to properly authenticate employee and admin
		User customer = User.authenticate(un, pw);
		
		
		
		//if user is authenticated as an Account, go to Banking class for transactions
		if (customer instanceof Account) {
			//success logged
			Main.logger.info(un + " successfull login");
			Banking.banking((Account)customer);
		
			
		}else 
			//SHOULD go to AdminMain class for application approval, view account info, edit accounts, ISN'T
			
		}else {
			//failed login message logged
			Main.logger.info(un + " failed login");
			//fail message printed, goes to retry method
			System.out.println("Invalid username or password");
			loginRetry();
		}
		return true;
	}

	//method to retry appLogin method or quit the program
	public static void loginRetry() throws WithdrawTooBigException {
		System.out.println("To retry press 'Y'\tTo quit press 'N'");
		String s = Main.sc.nextLine();
		switch (s) {
		case "y":
			appLogin();
			break;
		default:
			Main.sc.close();
			System.exit(0);
			break;
		}
	}

}
