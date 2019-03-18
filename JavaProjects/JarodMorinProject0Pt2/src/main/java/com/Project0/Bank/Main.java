package com.Project0.Bank;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Bank banky = new Bank();
		
		banky.initializeBank();
		
		
		homeMenu(banky);
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;

		try {
			fileOut = new FileOutputStream("banky.txt");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(banky);
			fileOut.close();
			objOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void homeMenu(Bank banky) { // this method displays the options available to the user at the 'home' menu of
										// the program. The user can log in to an existing user account, create a new
										// user account, or exit the program. Exiting the program serializes the
										// current state of the Bank object, which stores all user and bank account
										// data, before terminating the program
		Scanner scanner = new Scanner(System.in);
		boolean dontExitYet = true;
		while (true) {
			int input = 0;
			try {
				System.out.println("\n\n\n\n\n\n\n\n\n\nWelcome to Banky the Bank!\n");
				System.out.println("Would you like to: ");
				System.out.print(
						"1. Log in\n2. Create a new user\n3. Close Program\nPlease enter the number of your selection: ");
				String strIn = null;
				strIn = scanner.nextLine();
				try {
					input = Integer.parseInt(strIn);
				} catch (NumberFormatException e) {
					System.out.println("\nInvalid input. Please enter a number.");
					pauseScreen(scanner);
					continue;
				}
			} catch (NoSuchElementException e) {
				System.out.println("Input not found. Please try again.");
				pauseScreen(scanner);
				continue;
			}

			switch (input) {
			case 1:
				banky.userLogin(banky, scanner);
				continue;
			case 2:
				banky.createUser(scanner);
				break;
			case 3:
				System.out.println("\nClosing program.\n\nGoodbye!");
				dontExitYet = false;
				break;
			default:
				System.out.println("\nInvalid selection. Plese input a number from the menu.");
				break;
			}
			if (dontExitYet)
				pauseScreen(scanner);
			else
				break;
		}
		scanner.close();

	}

	static void pauseScreen(Scanner pauser) { // Used to allow user to read screen before advancing.
		// I use a lot of console outputs to display options/instructions
		// that will flood the window unless I use pauses to space them out.
		System.out.println("Enter any key to continue...");
		pauser.nextLine();
	}

}
