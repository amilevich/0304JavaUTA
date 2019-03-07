package Question17;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		//scanner
		Scanner scan = new Scanner(System.in);
		System.out.println("To calculate simple interest first enter the principal amount.");
		
		//the first integer scanned in will be the principal
		int principal = scan.nextInt();
		System.out.println("Please enter the rate");
		
		//the second integer scanned in will be the rate
		double rate = scan.nextDouble();
		System.out.println("Please enter the time");
		
		//the third integer scanned in will be the time
		int time = scan.nextInt();
		
		//the formula to calculate the simple interest
		//although the formula is p * r * t, we do not need to add the variables in
		//a specific order since its only multiplication.
		double interest = principal * rate * time;
		
		//print
		System.out.println("Okay, the simple interest comes out to: " + interest);
		
		
	}

}
