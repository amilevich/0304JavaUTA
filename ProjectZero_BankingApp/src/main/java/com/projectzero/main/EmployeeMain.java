package com.projectzero.main;

import com.projectzero.users.Employee;
import com.projectzero.users.User;

public class EmployeeMain {

	EmployeeMain() {

	}

	public static void employeeLogin() {
		
		System.out.println("Enter username: ");
		String un = Main.sc.nextLine();
		System.out.println("Enter password: ");
		String pw = Main.sc.nextLine();

		Employee employee = Employee.authenticateEmp(un, pw);
		
		if(employee instanceof Employee) {
			//success logged
		Main.logger.info(un + " successfull login");
		employeeWork(employee);
		}
	}
	
	//method for employee to work from
	public static void employeeWork(Employee employee) {
			
		//menu options
		System.out.println("\nWelcome Project Zero Employee!\n 1: View Accounts\n 2: View Applications\n 3: Quit\n");
		switch (Main.sc.nextInt()) {
		case 1:
			//CAN'T FIGURE OUT HOW TO DISPLAY ALL ACCOUNTS
				//THOUGHT- master txt file containing all accounts and associated usernames 
			System.out.println("//Display all accounts");
			//method to view certain account info
			Employee.viewAccountInfo(null);
			break;
		case 2:
			//SIMILAR PROBLEM TO ABOVE
			System.out.println("//Display all applications");
			 Employee.approveAccount(null);
			break;
		case 3:
			//method to close program
			Main.Quit();
			break;
		default:
			//if any other key is pressed, restart menu
			System.out.println("Try again!");
			employeeWork(employee);
			break;
		}
	}



}
