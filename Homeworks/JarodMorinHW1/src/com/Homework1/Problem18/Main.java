package com.Homework1.Problem18;


public class Main {

	static void doEverything(String str, Abstracto abby) {				// this method displays original string, calls all above functions 
												// and displays results
		System.out.println("Original String is: " + str);
		System.out.println("Result of anyUppersHere is: " + abby.anyUppersHere(str));
		System.out.println("Result of noLowersAllowed is: " + abby.noLowersAllowed(str));
		System.out.println("Result of strToIntPlusTen is: " + abby.strToIntPlusTen(str) + "\n"); 
		
	}
	
	public static void main(String[] args) {
		Abstracto abby = new Concreteo();
		String str1 = "ALLCAPSRAAR";
		String str2 = "nocapsshh";
		String str3 = "m1x3dCaP5AnDnUm5";
		String str4 = "12";			// test cases
				
		doEverything(str1,abby);	// strToIntPlusTen generates -1 for any strings 1-3 because they 
		doEverything(str2,abby);	// include non-numerical characters which results in a NumberFormatException
		doEverything(str3,abby);	// This is handled by returning a -1
		doEverything(str4,abby);	// Only str4 returns a valid result for strToIntPlusTen because
									// it is the only value for which parseInt generates an integer.
	}

}
