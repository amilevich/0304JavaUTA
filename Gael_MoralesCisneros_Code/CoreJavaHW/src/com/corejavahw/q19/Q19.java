package com.corejavahw.q19;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all
 * the even numbers up and display the result. Add all the odd numbers up and display the
 * result. Remove the prime numbers from the ArrayList and print out the remaining
 * ArrayList.
 */

public class Q19 {

	// method to check for a prime number
	public static boolean checkForPrime(int n) {

		// initialize true boolean
		boolean f = true;
		
		// ONE IS NOT A PRIME NUMBER
		if(n == 1) {
			f = false;
			return f;
		} else {
			// iterate to check condition for non-prime number
			for (int i = 2; i <= n / 2; ++i) {
				// if the number modulus the current i through half the number is zero, not
				// prime
				if(n % i == 0) {
					f = false;
					return f;
				}
			}
			return f;
		}
	}

	// program driver
	public static void main(String[] args) {

		// Initialize Integer array list
		ArrayList<Integer> arrList = new ArrayList<>();
		// Initialize sum of even numbers and sum of odd numbers
		int evenSum = 0;
		int oddSum = 0;

		// loop to add values 1-10 to array list
		for (int i = 1; i <= 10; i++)
			arrList.add(i);
		// print out current array list
		System.out.println(arrList);

		// loop to check for even numbers and add them to the even sum, and add the rest
		// to the odd sum
		for (Integer a : arrList) {
			if (a % 2 == 0) {
				evenSum += a;
			} else {
				oddSum += a;
			}
		}
		// print out the even and odd sums
		System.out.println("Sum of even numbers in array list: " + evenSum);
		System.out.println("Sum of odd numbers in array list: " + oddSum);

		// Initialize iterator for array list
		Iterator<Integer> itr = arrList.iterator();
		// loop to iterate through array list
		while (itr.hasNext()) {
			Integer n = itr.next();
			// call the checkForPrime() method and remove the value if true
			if (checkForPrime(n)) {
				itr.remove();
			}
		}
		// print the array list with prime numbers removed
		System.out.println("Array list with prime numbers removed: " + arrList);

	}

}
