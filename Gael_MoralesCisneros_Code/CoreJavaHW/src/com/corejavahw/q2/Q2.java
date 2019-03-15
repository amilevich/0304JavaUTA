package com.corejavahw.q2;

/*
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */

public class Q2 {

	public static void main(String[] args) {

		// set length of Fibonacci sequence, set first two numbers
		int n = 25, x1 = 0, x2 = 1; 
		// loop for length of numbers
		for(int i=0; i<n; i++) {
			
			//print sequence in a single line
			System.out.print(x1 + " ");
			
			//set sum of two numbers
			int sum = x1+x2;
			//set first equal to second
			x1=x2;
			//set second equal to sum
			x2=sum;
		}
	}

}
