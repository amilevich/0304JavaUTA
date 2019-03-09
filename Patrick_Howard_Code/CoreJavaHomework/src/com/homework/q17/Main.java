package com.homework.q17;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

															// principal, rate of interest, number of years
		Scanner interest = new Scanner(System.in);			//creates the scanner object

		System.out.println("Enter amount of principal: ");		// asks for the input of each variable double
		double principal = interest.nextDouble();
		System.out.println("Enter the rate of interest(%): ");
		double rateOfInterestPercent = interest.nextDouble();
		System.out.println("Enter the number of years: ");
		int numOfYears = interest.nextInt();
		
		double rateOfInterest = rateOfInterestPercent*.01;		//converts percent rate

		System.out.println("The amount of interest is: " + (principal*rateOfInterest*numOfYears) + "$" );	//calculates total interest
	}

}
