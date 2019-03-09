package com.homework.Q5;
/* Christopher Collins
 * Generate substring
 */

public class Q5 {
	
	public static void main(String[] args) {
		
		// Print out substring
		System.out.println(SS("USE THUNDERBOLT",11));
	}
	
	static String SS(String A, int B) {
		
		// Create temp Var
		String temp = " ";
		
		// loop Adding in characters until reach desired destination
		for(int P = 0; P < B; P++ ) {
			temp = temp  + A.charAt(P);
		}
		
		// return substring
		return temp;
	}
	
	
}
