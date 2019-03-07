package com.corejava.q17;

import java.util.Scanner;

public class SimpleInterest
{

	public static void main(String[] args)
	{

		Scanner scanner = new Scanner(System.in);
		
		double principal = getPrincipal(scanner);
		double interestRate = getInterestRate(scanner);
		int timeInYears = getGrowthTime(scanner);
		
		double finalAmount = doInterestCalc(principal, interestRate, timeInYears);
		
		System.out.println(finalAmount);

	}
	
	static double doInterestCalc(double principal, double rate, int time)
	{
		double amount = principal;
		for (int i = 0; i < time; i++) {
			amount *= 1 + rate;
		}
		return amount;
	}
	
	static double getPrincipal(Scanner scanner)
	{
		double amount = -1;
		String input;
		
		while (amount < 0)
		{
			System.out.print("Please enter the principal amount: ");
			input = scanner.nextLine();
			try
			{
				amount = Double.valueOf(input);
			}
			catch (NumberFormatException e)
			{
				System.out.println("A number is required for the principal amount.");
				continue;
			}
			if (amount < 0)
			{
				System.out.println("A non-negative number is required for the principal amount.");
				continue;
			}
			// Additional checks for memory allocation
		}
		return amount;
	}
	
	static double getInterestRate(Scanner scanner)
	{
		double rate = -1;
		String input;
		
		while (rate < 0)
		{
			System.out.print("Please enter the interest rate: ");
			input = scanner.nextLine();
			try
			{
				rate = Double.valueOf(input);
			}
			catch (NumberFormatException e)
			{
				System.out.println("A number is required for the interest rate.");
				continue;
			}
			if (rate < 0)
			{
				System.out.println("A non-negative number is required for the interest rate.");
				continue;
			}
			// Additional checks for memory allocation
		}
		return rate;
	}
	
	static int getGrowthTime(Scanner scanner)
	{
		int time = -1;
		String input;
		
		while (time < 0)
		{
			System.out.print("Please enter the number of years to apply interest: ");
			input = scanner.nextLine();
			try
			{
				time = Integer.valueOf(input);
			}
			catch (NumberFormatException e)
			{
				System.out.println("A number is required for the interest time.");
				continue;
			}
			if (time < 0)
			{
				System.out.println("A non-negative number is required for the interest time.");
				continue;
			}
			// Additional checks for memory allocation
		}
		return time;
	}
	
}
