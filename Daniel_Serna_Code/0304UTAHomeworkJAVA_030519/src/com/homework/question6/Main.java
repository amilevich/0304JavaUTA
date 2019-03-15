package com.homework.question6;

import java.util.Scanner; 
import java.lang.*; 

public class Main {

	public static void main(String[] args) {
		// Q6
		// Write a program to determine if an integer is 
		// even without using the modulus operator (%)
		
		Scanner myInput = new Scanner(System.in); // create an instance of the Scanner class
		int num = 0; // variable to hold user input
		
		System.out.print("Enter a number: "); 
		num = myInput.nextInt(); // get user input number num
		
		checkIfEven(num); // run function to check if even
		
	}

	private static void checkIfEven(int num) {

		// check the rightest most bit if 1 then odd
		num = Integer.lowestOneBit(num);
		
		if(num == 1)
		{
			System.out.println("Number is odd");
		}
		else
		{
			System.out.println("Number is even");
		}
	}

}
