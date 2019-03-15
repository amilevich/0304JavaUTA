package com.homework.question15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Q15. Write a program that defines an interface having the 
		// following methods: addition, subtraction, multiplication, 
		// and division.  Create a class that implements this 
		// interface and provides appropriate functionality to carry 
		// out the required operations. Hard code two operands in a 
		// test class having a main method that calls the implementing 
		// class
		
		// make our variables
//		int a = 0; 
//		int b = 0; 
//		
//		Scanner s = new Scanner(System.in); // create instance of scanner for user input
//		
//		// Ask user to insert numbers
//		System.out.println("Enter a number: ");
//		a = s.nextInt(); 
//		
//		while(true) // cannot divide by zero, so use loop to prevent action
//		{
//			System.out.println("Enter another number: ");
//			b = s.nextInt(); 
//			
//			// check for a zero
//			if(b == 0)
//			{
//				System.out.println("Number cannot be zero! Changed to 1.");
//				b = 1; 
//				break; 
//			}
//			else
//			{
//				break; 
//			}
//		}
		
		CalculationsInterface ci = new UseCalculations(); 
		
		ci.addition(10, 2);
		ci.subtraction(10, 2);
		ci.division(10, 2);
		ci.multiplication(10, 2);		
	}

}
