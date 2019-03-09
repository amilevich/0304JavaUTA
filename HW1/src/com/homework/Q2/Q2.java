package com.homework.Q2;
/* Christopher Collins
 * Fibonacci
 */


public class Q2 {
	
	public static void main(String[] args) {
		
		// Establish starting numbers
		int Chu=1;
		int TStone;
		int RChu=0;
		
		for (int D = 1; D<26; D++) {
			
			// Print out next number in sequence
			System.out.println(RChu);
			
			// Add Numbers Together
			TStone = Chu;
			Chu = RChu;
			RChu = Chu + TStone;
			
			
		}
		
		
	}
}
