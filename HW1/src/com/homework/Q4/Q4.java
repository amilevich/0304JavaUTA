package com.homework.Q4;
/* Christopher Collins
 * Compute N Factorial
 */


public class Q4 {
	
	public static void main(String[] args) {
		
		// Get #
		int G=10;
		// assign number 1 lower to W
		int W=G-1;

		// Compute Factorial
		// Loop till W hits 0
		while(W>0) {
			
			//multiply total by W
			G = W * G;
			// Decrease W by 1
			W--;
		}
		
		//Print Result
		System.out.println(G);
				
	}

}
