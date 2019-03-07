package com.example.controlflow;

public class Main {

	//control flow
	// break up the flow of execution by 
	// employing decision making and loops,
	// enabling the program to conditionally execute
	// particular blocks of code
	
	/*
	 * if -> runs block of code if true,
	 * 		"else if" is used to write mutually
	 * 				 exclusive blocks of code
	 * 		"else" will execute if nothing else did
	 * 		(if no condition is met AllisterTM)
	 */
	
	/*
	 * while -> typically used when you do not know
	 * 			how long you want to loop, but have
	 * 			a condition that needs to be satisfied
	 */
	
	/*
	 * do while -> same as while, but will definitely
	 * 				run at least once
	 */
	
	/*
	 * switch -> useful when you are checking a variable
	 * 			against a lot of values
	 */
	
	/*
	 * for -> typically used when you know how long
	 * 			you want to loop
	 */
	
	// "break" -> end loop, can be only used in loops
				// and switch statement 
	
	// "continue" -> go to end of loop and starts the
					// next iteration
					// only in loops
	
	public static void main(String[] args) {
		
		int tempWhile = 0;
		
//		while(tempWhile<7) {
//			tempWhile++;
//			System.out.println(tempWhile);
//		}
		
		int arrayOne[] = {27, 1997, 4, 5, 7};
		
		for(int i=0; i<arrayOne.length; i++) {
			System.out.println(++arrayOne[i]);
		}
		
		// & - and
		// && - short circuit and
		// | - or
		// || - short circuit or
		
		
		// short circuit - only checks the first condition
		// meaning they don't evaluate the right hand
		// side (if the left hand side satisfies the
		// condition TomaTM)
		
		// the & and | -> when used as logical operators,
		// evaluate both sides always
		
		// false && -> it is not necessary to know what
		// the right hand side is, the result must
		// be false
		
//		while(boolOne && boolTwo) {
//			// will only go into the block if the initial
//			// condition is true
//			// if the condition is false, it will go
//			// past the loop
//			// if the condition is still true,
//			// it will execute again
//		}
	}
}
