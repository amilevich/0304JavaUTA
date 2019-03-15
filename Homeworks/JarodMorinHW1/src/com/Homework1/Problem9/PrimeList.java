package com.Homework1.Problem9;

import java.util.ArrayList;

public class PrimeList {

	static boolean isPrime(int val) {
		
		if (val == 1) {
			return false;
		}
		for(int i = 2; (i < val && i < 10); i++) {		
											// For a list up to 100, only factors up to 10 are necessary to check
			if(val % i == 0)				// for primes. Additionally, only values less than val are checked
				return false;				// A modulus result of 0 indicates that i is a factor of val,
											// indicating that val is not prime
		}
		return true;						// if none of the i values are factors that return a false, then 
											// val is prime and true is returned
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> maybePrimeList = new ArrayList<Integer>();
		
		for(int i = 1; i <= 100; i++)	// 100 elements to add to the ArrayList
		{
			maybePrimeList.add(i);		// Placing numbers 1 through 100 into ArrayList by adding them to the end
		}

		for(int x : maybePrimeList) {
			if(isPrime(x))				// Check for primeness, print if prime
				System.out.println(x);	
		}
	}

}
