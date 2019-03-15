package com.corejavahw.q4;

/*
 * Write a program to compute N factorial.
 */

public class Q4 {
	
	//factorial method
	static int factorial(int n) {
		
		//if accepted number is zero, returns 1
		if (n == 0) 
			return 1;
		//recursive method to multiply the number by each of its smaller values
		return n*factorial(n-1);
		
	}

	//program driver
	public static void main(String[] args) {

		//initialize for factorial method
		int num =6;
		//print number and its factorial
		System.out.println("N factorial of "+ num + " is: " + factorial(num));
	}

}
