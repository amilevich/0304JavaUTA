package com.corejavahw.q10;

/*
 * Find the minimum of two numbers using ternary operators.
 */

public class Q10 {

	//program driver
	public static void main(String[] args) {
		//initialize two integers
		int a = 3;
		int b = 7;
		//ternary operator compares two integers
		int minVal = (a < b) ? a : b;
		//print minimum value
		System.out.println(minVal);
	}

}
