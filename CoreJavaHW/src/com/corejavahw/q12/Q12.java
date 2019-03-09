package com.corejavahw.q12;

import java.util.ArrayList;

/*
 * Write a program to store numbers from 1 to 100 in an array. Print out all the even 
 * numbers from the array. Use the enhanced FOR loop for printing out the numbers.
 */

public class Q12 {
	
	//checks if number is even
	static boolean isEven(int n) {  
		//returns false if integer returns float
	    return ((n/2)*2 == n); 
	} 

	//program driver
	public static void main(String[] args) {

		//instantiated ArrayList for numbers
		ArrayList<Integer> numbers = new ArrayList<Integer>();
				
		//prints message about numbers to be printed later
		System.out.println("Even numbers in ArrayList:");
				
		//loop from 1 to 100 inclusive
		for (int i=1; i<=100; i++) {
			// add current number to ArrayList
			numbers.add(i);	
		}
				
		//enhanced loop to check and print even numbers
		for(Integer nm: numbers) {
			//if even, returns true
			if(isEven(nm) != false)
				System.out.println(nm);
		}
	}
}
