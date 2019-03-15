package com.projectzero.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.projectzero.accounts.Account;
import com.projectzero.accounts.WithdrawTooBigException;
import com.projectzero.users.Admin;
import com.projectzero.users.Employee;
import com.projectzero.users.User;

public class Main {
	//start logger and scanner
	final static Logger logger = Logger.getLogger(Main.class.getName());
	static Scanner sc = new Scanner(System.in);
	static String userName;

	//program driver
	public static void main(String[] args) throws WithdrawTooBigException {

		//populate so users can login
		makeProfiles();
		boolean b = false;

		logger.info("**project zero banking app start**");
		//Deserialized account to work with
		Account.InsertUserObject();
		
		//Can't figure out how to authenticate employee or admin
//		Admin.InsertAdminAccount();
//		Employee.InsertEmployeeAccount();
		

		do {
			//Welcome screen with options
			System.out.println("Welcome to Project Zero Banking App!"
					+ "\nPress 1: User\nPress 2: Employee\nPress 3: Admin\nPress 4: Quit");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				Login.UserLogin();
				break;
			case "2":
				EmployeeMain.EmployeeLogin();
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
		sc.close();
	}

	//method to Quit program with goodbye message
	public static void Quit() {
		System.out.println("Goodbye");
		System.exit(0);
	}

	//writes txt files and creates to be deserialized and checked at login
	public static void makeProfiles() {
		String empFilename = "./Employee.txt";
		String adFilename = "./Admin.txt";
		
		//Instantiation and initializing objects
		Admin ad = new Admin(1, "admin", "drowssap321", "Rick", "J19Zeta7");
		Account cust = new Account("user", "pass", "Jerry", "Smith", "123456789", 100.0f);
		Employee emp = new Employee();
		
		//Serialization
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(empFilename));
			oos.writeObject(emp);
			oos.close();
			ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(adFilename));
			oos2.writeObject(ad);
			oos2.close();
			ObjectOutputStream oos3 = new ObjectOutputStream(
					new FileOutputStream(System.getProperty("user.dir") + "\\" + User.filename + ".txt"));
			oos3.writeObject(cust);
			oos3.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
