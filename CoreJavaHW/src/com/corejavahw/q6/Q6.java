package com.corejavahw.q6;

/*
 * Write a program to determine if an integer is even without using the modulus 
 * operator (%)
 */

public class Q6 {

	// method to determine if integer is even
	static boolean isEven(int n) {
		// returns false if integer returns float
		return ((n / 2) * 2 == n);
	}

	// program driver
	public static void main(String[] args) {
		// set integer to be tested
		int n = 53;
		// if condition not false is even, else not even
		if (isEven(n) != false)
			System.out.print("Integer " + n + " is Even");
		else
			System.out.print("Integer " + n + " is not Even");
	}

}
