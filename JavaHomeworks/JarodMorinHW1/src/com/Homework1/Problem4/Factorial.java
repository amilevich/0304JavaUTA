package com.Homework1.Problem4;

public class Factorial {

	public static int factorial(int x)	{
		
		int result = 1;					// We will initialize our factorial result to 1
		for(int i = 2; i <= x; i++) {	// This loop will count from 2 to x
										// x is the endpoint for x!
			result *= i;				// Every value will be multiplied by the result
										// and stored back into result
		}
		
		return result;		// Value of result is 1 * 2 * ... * x, or x!
	}
	
	public static void main(String[] args) {
			
		for(int i = 1; i < 10; i++) {
			System.out.println(factorial(i));	// print factorials from 1! - 9! 
												// for debugging/demonstration
		}
		
		
	}

}