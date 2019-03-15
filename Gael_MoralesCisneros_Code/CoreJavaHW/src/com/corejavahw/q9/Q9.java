package com.corejavahw.q9;

import java.util.ArrayList;

/*
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime 
 * numbers to the console.
 */

public class Q9 {

	// program driver
	public static void main(String[] args) {

		// instantiated ArrayList for numbers
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		// prints message about numbers to be printed later
		System.out.println("Prime numbers in ArrayList:");

		// loop from 1 to 100 inclusive
		for (int i = 1; i <= 100; i++) {
			// add current number to ArrayList
			numbers.add(i);
			// check for prime with false variable f
			boolean f = false;
			//
			for (int j = 2; j <= i / 2; ++j) {
				// condition for non-prime number
				// if the current number modulus 2 is zero, not prime
				if (i % j == 0) {
					f = true;
					break;
				}
			}

			// if flag is false for non-prime condition, print current number
			if (!f)
				System.out.println(i);

		}
	}

}
