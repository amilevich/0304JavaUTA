package com.projectzero.main;

import java.util.InputMismatchException;

import com.projectzero.users.Admin;
import com.projectzero.users.User;

public class AdminMain extends EmployeeMain {

	public AdminMain() {

	}
	
	public static void adminLogin() {
		
		System.out.println("Enter username: ");
		String un = Main.sc.nextLine();
		System.out.println("Enter password: ");
		String pw = Main.sc.nextLine();
		
		Admin admin = authenticateAd(un, pw);
	}

	public static void adminWork(User admin) {
		// method to go to EmployeeMain class and approve/deny applications and view
		// account info/balance
		employeeWork(admin);

		System.out.println(
				"\nWhat would you like to do?:" + "\n 1: Withdraw\n 2: Deposit\n 3: Transfer\n 4: Cancel\n 5: Quit");
		switch (Main.sc.nextInt()) {
		case 1:
			System.out.print("Withdraw amount: \n$ ");
			amount = Main.sc.nextFloat();

			if (amount > 0) {
				holder.withdraw(amount);
				printTransaction("Withdrawal", "success", amount);
			} else {
				printTransaction("Withdrawal", "failure", amount);
			}
			break;

		case 2:
			System.out.print("Deposit amount: \n$ ");
			amount = Main.sc.nextFloat();
			if (amount > 0) {
				holder.deposit(amount);
				printTransaction("Deposit", "success", amount);
			} else {
				printTransaction("Deposit","failure", amount);
			}
			break;

		case 3:
			System.out.print("Username of account to transfer to: ");
			String to;
			to = Main.sc.next();

			System.out.print("Transfer amount: \n$ ");
			amount = Main.sc.nextFloat();

			if (amount > 0) {
				holder.transfer(amount, to);
				printTransaction(to, amount, "success");
			} else {
				printTransaction(to, amount, "failure");
			}
			break;

		case 4:
			b = false;
			Main.Quit();
			break;

		default:
			System.out.println("Try again!");
			adminWork(admin);
			break;
		}

	}

}
