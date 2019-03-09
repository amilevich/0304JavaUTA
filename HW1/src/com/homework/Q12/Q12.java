package com.homework.Q12;
/* Christopher Collins
 * Enhanced for loop, output even up to 100
 */

import java.util.ArrayList;

public class Q12 {
	public static void main(String[] args) {
		// Create Array
		ArrayList<Integer> Proton = new ArrayList<Integer>();
		
		// Store numbers 1-100 into the array
		for(int N=1; N<=100;N++){
			Proton.add(N);
		}
		
		for(Integer Elec : Proton) {
			// if numbers are divisible by 2 they are even, Print even #'s
			if( Elec%2 == 0)
				System.out.println(Elec);
		}
	}

}
