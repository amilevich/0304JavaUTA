package com.homework.Q9;
/* Christopher Collins
 * Output prime numbers
 */

import java.util.ArrayList;

public class Q9 {
	
	public static void main(String[] args) {
		
		// Create Array list
		ArrayList<Integer> Num = new ArrayList<>();
		
		// Loop up to 100
		for(int N = 1 ; N<=100; N++) {
			
			// Add number to array
			Num.add(N);
			
			// Key for Prime confirming
			char Key = 'P';
			
			int P=N;
			
			// Loop to confirm if prime
			do {
				
				P--;
				// check for 1 or 2
				if(N==1 || N==2) {
					System.out.println(N + " is Prime");
				}
				// If P Decreases to 1  without the key changing the number is prime
				else if(Key == 'P' && P == 1){
					System.out.println(N + " is Prime");
				}
				
				// If P goes in to N evenly the # is not prime
				else if(N%P==0) {
					P = 0;
					Key = 'N';
				}
				
				
			}while(P>1);
			
		}
	}

}
