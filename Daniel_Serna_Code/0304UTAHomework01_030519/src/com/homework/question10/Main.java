package com.homework.question10;

import java.util.Scanner; 

public class Main {
	public static void main(String [] args)
	{
		// Q10. Find the minimum of two numbers using ternary 
		// operators.
		
		// create a temp variable to hold the answer
		int temp = 0;
		int a, b; // two numbers being compared
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		a = s.nextInt(); 
		System.out.print("Enter another number: ");
		b = s.nextInt(); 
		s.close();
		 
	    temp = a < b ? a:b; 
	    
	    System.out.print("Minimum number: "+temp);
	}
	
}
