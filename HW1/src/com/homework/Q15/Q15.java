package com.homework.Q15;
/* Christopher Collins
 * Implementing an interface
 */

public class Q15 {

	public static void main(String[] args) {
		
		// Create object
		Q15Implem Test = new Q15Implem();
		
		// Declare integers
		int X = 15;
		int Y = 3;
		
		// Check if Implemented class works
		System.out.println( X + " + " + Y + " = " + Test.Addition(X,Y));
		System.out.println( X + " - " + Y + " = " + Test.Subtraction(X,Y));
		System.out.println( X + " * " + Y + " = " + Test.Multiplication(X,Y));
		System.out.println( X + " / " + Y + " = " + Test.Division(X,Y));

	}

}
