package com.homework.Q13;
/* Christopher Collins
 * Display triangle
 */

public class Q13 {

	public static void main(String[] args) {
		
		// Loop 4 times
		for(int N = 1; N<5; N++) {
			// Set T = N
			int T = N;
			// Loop till T equals 0
			do {
				// If even print
				if(T%2==0) {
					// If N above 2 swap print
					if(N>2) {
						System.out.print(0);
					}
						
					else {
						System.out.print(1);
					}

				}
				// If odd print opposite
				else if(T%2==1) {
					// If N above 2 swap print
					if(N>2) {
						System.out.print(1);
					}
					else {
						System.out.print(0);
					}
				}
				// Subtract from T
				T--;
			}while(T>0);
			
			// Moving down the ladder
			System.out.println("");
		}

	}

}
