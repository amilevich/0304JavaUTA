package com.Homework1.Problem10;

public class Minimum {

	static int minimum(int x, int y) {
		
		return (x < y)?  x:  y;			// Ternary operator here, evaluates ( x < y), returns x if true (x minimum)
										// returns y otherwise (y minimum, or both are equal and minimum)
	}
	
	static void printMin(int x, int y) {
		// Print function for clarity
		System.out.println("The minimum of " + x + " and " + y + " is: " + minimum(x,y));
	}
	
	public static void main(String[] args) {
		// Test cases
		printMin(1,2);
		printMin(11,2);
		printMin(1,12);
		printMin(2,2);
		printMin(12,21);
		printMin(11,22);
		printMin(-1,-2);

	}

}
