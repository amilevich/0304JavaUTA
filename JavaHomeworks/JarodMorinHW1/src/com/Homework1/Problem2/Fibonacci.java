package com.Homework1.Problem2;

public class Fibonacci {
	
	public static void main(String[] args) {
		
		// Fibonacci sequence relies only on previous two values in sequence
		// I use three integers to store current values as well as two previous
		
		int fibA = 0; 	// Initial values selected so that B+C = A = 0, the first value
						// in the Fibonacci sequence.
		int fibB = -1;	// It is also necessary for C + A = 1 after A is reassigned to
						// 0, in order for B to 'start' at 1 in the following loop.
		int fibC = 1;	// As a result, B = -1 and C = 1. A's value is unnecessary.
		
		for(int i = 0; i < 25; i++) {
			// Loop both calculates next value in sequence and prints it.
			switch(i%3) {	// i is the count to ensure that 25 values are calculated
							// i modulus 3 also functions to determine which of the 
							// three integers is the next to be reassigned to the
							// sum of the other two.
				case 0: fibA = fibB + fibC;
						System.out.println("Term " + (i+1) + ": " + fibA);
						break;
				case 1: fibB = fibC + fibA;
				System.out.println("Term " + (i+1) + ": " + fibB);
						break;
				case 2: fibC = fibA + fibB;
				System.out.println("Term " + (i+1) + ": " + fibC);
						break;
				default: System.out.println(":(");
						break;
				}
		}
	}
		


}
