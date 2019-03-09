package question17;

import java.util.Scanner;

public class InterestRate {
	
	private static int time;
	private static double interest, principle, rate, balance;

	public static void main(String[] args) {
		calculateInterest();
		printInterest();
	}
	
	private static void calculateInterest() {
		// create scanner and get input
		//double principle, rate, time;
		Scanner userInput = new Scanner(System.in);
		
		//write these explicitly b/c unique prompts
		System.out.print("Enter the principle amount (USD):\t$");
		principle = userInput.nextDouble();

		
		System.out.print("Enter annual interest rate (%):\t\t");
		// percent(%) val -> decimal
		rate = userInput.nextDouble() / 100; 
		
		System.out.print("Enter amount of time (years):\t\t");
		time = userInput.nextInt();

		
		//close resource leak
		userInput.close();
		
		//interest and balance calculations
		interest = rate*principle*time;
		balance = principle + interest;
	}
	
	// printf used to round niceley for dollar amount
	private static void printInterest() {
		System.out.printf("Your investment will be $%.2f in %d years "
				+ "(accruing $%.2f in interest).", balance, time, interest);
	}

}
