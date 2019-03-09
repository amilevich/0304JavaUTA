package com.homework.question9;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// Q9. Create an ArrayList which stores numbers from 1 
		// to 100 and prints out all the prime numbers to the 
		// console
		
		// create empyt array list
		ArrayList<Integer> arrL = new ArrayList<Integer>(100); 
		
		// boolean to check prime
		boolean primeBool = false; 
		
		// add 1 to 100 to ArrayList arrL
		for(int i = 1; i <= 100; i++)
		{
				arrL.add(i); 
		}
		
		for(int i = 0; i < arrL.size(); i++) 
		{
			primeBool = isPrime(arrL.get(i)); 
			
			if(primeBool == true)
				System.out.println(arrL.get(i));
		}
		
	}

	// check and display prime numbers in ArrayList arrL
	static boolean isPrime(Integer checkPrime) 
	{
		for(int i = 2; i < checkPrime; i++) {
			
			if(checkPrime % i == 0)
			{
				return false; 
			}
		}
		return true; 		
	}

}
