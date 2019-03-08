package com.Homework1.Problem17;

import java.util.Scanner;

public class InterestCalculator {

	public static void main(String[] args) {
		Scanner scanny = new Scanner(System.in); // creating a new scanner object that reads lines from the console

		System.out.print("Please enter the principle amount: ");
		float principle = scanny.nextFloat(); // User enters a number into the console that is stored
												// as a float inside principle
		System.out.print("Please enter the interest rate: "); // **Expects a decimal input, not a percentage**
		float rate = scanny.nextFloat(); // User enters a number into the console that is stored
											// as a float inside rate
		System.out.print("Please enter the number of years: ");
		int time = scanny.nextInt(); // User enters a number into the console that is stored
										// as an int inside time

		System.out.println("Total interest is: $" + principle * rate * time); // product of 3 variables displayed
		scanny.close(); // Closing the scanner
	}

}