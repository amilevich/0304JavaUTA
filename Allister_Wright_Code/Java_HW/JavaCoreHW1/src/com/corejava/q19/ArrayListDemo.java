package com.corejava.q19;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo
{

	public static void main(String[] args)
	{
		
		// Create an ArrayList containing integers 1-10
		ArrayList<Integer> arrList = new ArrayList();
		for (int i = 1; i < 11; i++)
			arrList.add(i);
		
		// Display the arrayList
		System.out.println(arrList);
		
		// Add all even numbers in list
		int evenSum = 0;
		// array starts at 1, first even index @ idx 1
		for (int i = 1; i < arrList.size(); i += 2)
			evenSum += arrList.get(i);
		// And display even sum result
		System.out.println(evenSum);
		
		// Add all odd numbers in list
		int oddSum = 0;
		// array starts at 1;; first odd index @ 0
		for (int i = 0; i < arrList.size(); i+= 2)
			oddSum += arrList.get(i);
		// And display odd sum result
		System.out.println(oddSum);
		
		// Setup Iterator to Remove Primes
		Iterator<Integer> listIter = arrList.iterator();

		// Remove Prime numbers from List
		while(listIter.hasNext())
		{
			if (isPrime(listIter.next()))
				listIter.remove();
		}
		
		// Print the remaining arrayList
		System.out.println(arrList);
	}

	// Method copied from Q9
	public static boolean isPrime(int n)
	{
		// Mark -1, 0, and 1 as non-prime
		if (n < 2 && n > -2)
			return false;
		
		// Iterate over factors which will not exceed target n
		for (int i = 2; i <= Math.sqrt(n); i++)
		{
			// debug: System.out.println(n + "%" + i + " = " + n%i);
			// Exit if a divisor is found
			if (n % i == 0)
				return false;
		}
		// must be prime if no divisors exist
		return true;
	}
}
