package com.corejava.q9;

import java.util.ArrayList;

public class Primes {

	public static void main(String[] args) {

		ArrayList<Integer> numList = new ArrayList<Integer>();
		
		// Iterate over test cases
		for (int i = 1; i <= 100; i++)
		{
			// Log tests
			numList.add(new Integer(i));
			// Print Primes
			if (isPrime(i))
				System.out.println(i);
		}

	}

	public static boolean isPrime(int n)
	{
		// Mark -1, 0, and 1 as non-prime
		if (n < 2 && n > -2)
			return false;
		
		// Iterate over factors which will not exceed target n
		for (int i = 2; i <= Math.sqrt(n); i++)
		{
			//System.out.println(n + "%" + i + " = " + n%i);
			// Exit if a divisor is found
			if (n % i == 0)
				return false;
		}
		// must be prime if no divisors exist
		return true;
	}
}
