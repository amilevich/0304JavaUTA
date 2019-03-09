package com.homework.q02;

public class Main {

	public static void main(String[] args) {
		
		int n = 24; 				// number of sequences
		int x = 0;					// First number of sequence (given)
		int y = 1;					// Second number of sequence (given)
		System.out.println(y); 		// Show the first  number in sequence
		
		for(int i = 0; i < n; i++) { // creates a for loop that counts up to n
			int z = x + y;			 // creates new variable add the first 2 terms (sum)
			x = y;					 // sets the first term to the next one
			y = z;					 // sets the second term to the sum
			System.out.println(z);	 // prints the sum

		}
		
	}
}
