package com.homework.Q11;
/* Christopher Collins
 * Accessing a separate package
 */

// import package
import com.homework.Q11E.*;

public class Q11 {
	
	public static void main(String[] args) {
		
		// Create class from new class
		Q11E Test = new Q11E();
		
		// Print out float values
		System.out.println(Test.getAL());
		System.out.println(Test.getOM());
		
	}
	
}
