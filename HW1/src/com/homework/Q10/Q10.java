package com.homework.Q10;
/*
 * Christopher Collins
 * ternary use
 */

import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
			    
		// Set up scanner
		Scanner myObj = new Scanner(System.in);
		
		// Get First number
		System.out.println("Enter first #");
		String Temp = myObj.nextLine();
		int Alpha = Integer.parseInt(Temp);  
		
		// Get Second number
		System.out.println("Enter second #");
		Temp = myObj.nextLine();
		int Omega = Integer.parseInt(Temp);
		
		// Compare using Ternary operators
		int Zeta = (Alpha < Omega) ? Alpha : Omega;
		
		// Print lower number
		System.out.println(Zeta + " is the smaller number.");

	}

}
