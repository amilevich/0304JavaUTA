package com.homework.Q17;

import java.util.Scanner;
/* Christopher Collins
 * Interest Calculator
 */

public class Q17 {

	public static void main(String[] args) {
		
		// Establish Variables
		double interest;
		double principal;
		double rate;
		double time;
		
		// Create instance of scanner
		Scanner myObj = new Scanner(System.in);
		
		// Receive Principal
		System.out.println("Enter Principal: ");
		String Temp = myObj.nextLine();
		principal = Double.parseDouble(Temp);
		
		// Receive Rate
		System.out.println("Enter % Rate: ");
		Temp = myObj.nextLine();
		rate = Double.parseDouble(Temp);
		rate = rate/100;
		
		// Receive Time
		System.out.println("Enter Length: ");
		Temp = myObj.nextLine();
		time = Double.parseDouble(Temp);
		
		// Calculate Interest
		interest = principal * rate * time;
		
		// Print result
		System.out.println("Your total intrest is $" + interest);
		
		

	}

}
