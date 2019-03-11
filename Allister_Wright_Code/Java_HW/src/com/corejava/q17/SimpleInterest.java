package com.corejava.q17;

import java.util.Scanner;

public class SimpleInterest
{

	public static void main(String[] args)
	{

		// Initialise Scanner for standard input from user
		Scanner scanner = new Scanner(System.in);
		
		// initialise variables for calculation
		double principal = getPrincipal(scanner);
		double interestRate = getInterestRate(scanner);
		int timeInYears = getGrowthTime(scanner);
		
		// Calculate the final amount after interest is applied
		double finalAmount = doInterestCalc(principal, interestRate, timeInYears);
		
		// Display the Result
		System.out.println(finalAmount);

	}
	
	static double doInterestCalc(double principal, double rate, int time)
	{
		// Initialise result as principal amount
		double amount = principal;
		// iteratively apply interest for each year specified
		for (int i = 0; i < time; i++) {
			amount *= 1 + rate;
		}
		// return the final total
		return amount;
	}
	
	static double getPrincipal(Scanner scanner)
	{
		// Initialise user input variables
		double amount = -1;
		String input;
		
		// While user input is not sanitised
		while (amount < 0)
		{
			// Ask the user for Principal amount on stdin
			System.out.print("Please enter the principal amount: ");
			input = scanner.nextLine();
			
			// Attempt to convert the input to a double
			try
			{
				amount = Double.valueOf(input);
			}
			catch (NumberFormatException e)
			{
				// Let the user try again if a number cannot be parsed
				System.out.println("A number is required for the principal amount.");
				continue;
			}
			// Additional checks for memory allocation
			// Make sure principal amount is 0 or more
			//  maximum decimal precision allowed for finely-traded currencies (i.e: values less than 0.01)
			if (amount < 0)
			{
				System.out.println("A non-negative number is required for the principal amount.");
				continue;
			}
		}
		// Principal amount validated, return value
		return amount;
	}
	
	static double getInterestRate(Scanner scanner)
	{
		// Initialise user input variables
		double rate = -1;
		String input;
		
		// While user input is not sanitisd
		while (rate < 0)
		{
			// Ask user for interest rate on stdin
			System.out.print("Please enter the interest rate: ");
			input = scanner.nextLine();
			
			// Attempt to convert input to a double
			try
			{
				rate = Double.valueOf(input);
			}
			catch (NumberFormatException e)
			{
				// Let the user try again if number cannot be parsed
				System.out.println("A number is required for the interest rate.");
				continue;
			}
			// Additional checks for memory allocation			
			// Make sure interest rate is 0 or more (percent as a decimal)
			if (rate < 0)
			{
				System.out.println("A non-negative number is required for the interest rate.");
				continue;
			}
		}
		// interest rate validated, return value
		return rate;
	}
	
	static int getGrowthTime(Scanner scanner)
	{
		// Initialise user input
		int time = -1;
		String input;
		
		// While user input not sanitised
		while (time < 0)
		{
			// Ask user for number of years on stdin
			System.out.print("Please enter the number of years to apply interest: ");
			input = scanner.nextLine();
			
			// attempt to convert input to an integer
			try
			{
				time = Integer.valueOf(input);
			}
			catch (NumberFormatException e)
			{
				// Let user try again if number cannot be parsed
				System.out.println("A number is required for the interest duration.");
				continue;
			}
			// Additional checks for memory allocation
			// Make sure time elapsed is 0 or more years
			if (time < 0)
			{
				System.out.println("A non-negative number is required for the interest duration.");
				continue;
			}
		}
		// Interest duration validated, return value
		return time;
	}
	
}
