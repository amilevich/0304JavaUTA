package com.banking;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		System.out.println("Welcome to the Comrade Cassion Credit Union App");
		ArrayList<User> users = new ArrayList<>();
		ArrayList<Account> accounts = new ArrayList<>();

		String input = "";
		boolean loggedIn = false;
		User currentUser = null;

		while (!loggedIn)
		{
			input = getUserInput("Please select an option (Login/Register/Exit): ").toUpperCase();
			if (input.equals("QUIT") || input.equals("EXIT"))
				System.exit(0);

			if (input.equals("R") || input.equals("REGISTER"))
			{
				boolean isAvailable;
				do
				{
					input = getUserInput("Please enter a new username: ");
					isAvailable = true;
					for (User u : users)
					{
						if (u.getUsername().equals(input))
							isAvailable = false;
					}
				} while (!isAvailable);
				
				boolean isValidated = false;
				do
				{
					input = getUserInput("Please enter a new password: ");
					String pwCheck = getUserInput("Please confirm your password: ");
					isValidated = input.equals(pwCheck);
				} while (!isValidated);
				
				// Username available and password validated
				// Finish collecting personal information
				
			}

		}

	}

	public static String getUserInput(String message)
	{
		Scanner stdin = new Scanner(System.in);
		System.out.print(message);
		return stdin.nextLine();
	}
}
