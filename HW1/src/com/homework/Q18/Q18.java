package com.homework.Q18;
/* Christopher Collins
 * Check for uppercase, Converter string to all uppercase, Convert string to int
 */

public class Q18 {

	public static void main(String[] args) {
		
		// Create Instance
		Q18CL Beta = new Q18CL();
		
		// Call Uppercase checker
		// Print result, should be true
		System.out.println(Beta.CheckUpper("peterpiperpickedapeckofpickledPepper"));
		
		// Call Uppercase converter
		//Print result, every letter should be uppercase
		System.out.println(Beta.ConvertUpper("I will not be stopped!"));
		
		// Call Converter to int
		// Print result, should print 13
		System.out.println(Beta.ConvertInt("3"));
		
		
		
	}

}
