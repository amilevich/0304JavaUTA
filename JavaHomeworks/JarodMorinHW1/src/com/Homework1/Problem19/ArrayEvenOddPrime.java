package com.Homework1.Problem19;

import java.util.ArrayList;

public class ArrayEvenOddPrime {

	static boolean isPrime(int val) { // isPrime method borrowed from my problem9 that returns true
										// if a value up to 100 is prime

		if (val == 1) {
			return false;
		}
		for (int i = 2; (i < val && i < 10); i++) {
			if (val % i == 0)
				return false;
		}
		return true;
	}

	static boolean isEven(int x) {
		if (x < 0) // isEven method borrowed from my problem6 that returns true if a given int is
					// even
			x = Math.abs(x);

		if (x / 2 == (x + 1) / 2) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ArrayList<Integer> evenOddPrimeList = new ArrayList<Integer>();

		for (int i = 1; i <= 10; i++) // 10 elements to add to the ArrayList
		{
			evenOddPrimeList.add(i); // Placing numbers 1 through 10 into ArrayList by adding them to the end
		}

		System.out.println("Displaying list: " + evenOddPrimeList); // Displaying original list

		int result = 0; // initializing the sum (result) to 0
		for (int x : evenOddPrimeList) {
			if (isEven(x)) // add any values that are even to the sum
				result += x;
		}

		System.out.println("Sum of evens is: " + result); // display sum of evens

		result = 0; // reset result to 0

		for (int x : evenOddPrimeList) {
			if (!isEven(x)) // add any values that are NOT even to the sum
				result += x;
		}
		System.out.println("Sum of odds is: " + result); // display sum of odds

		for (int i = 0; i < evenOddPrimeList.size(); i++) {
			if (isPrime(evenOddPrimeList.get(i))) // Check for primeness, remove from list if prime
				evenOddPrimeList.remove(i--); // Removal shifts elements in an ArrayList, so the counter i must
												// be decremented whenever a removal occurs to prevent
												// any unintended skipping
		}

		System.out.println("Displaying list without primes: " + evenOddPrimeList); // display list without primes
	}

}
