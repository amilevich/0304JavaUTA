package com.homework.Q6;
/* Christopher Collins
 * Is the # Even or Odd
 */

public class Q6 {
	
	public static void main(String[] args) {
		
		// Loop to 100
		for(int T = 0; T<100; T++) {
			
			// Stored half of number. Because of the nature of integers if # is odd it will drop the decimal
			int O = T/2;
			
			
			// If the halved # is the same when double again its even. Otherwise its odd.
			// If # is 0 output its neither
			if(T == 0) {
				System.out.println("Number is 0");
			}
			
			// Check if # number is Even
			else if(O*2 == T) {
				System.out.println(T + " is Even");
			}
			
			// If # is not even it is odd
			else {
				
			}
		}
	}
}
