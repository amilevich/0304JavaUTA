package com.Homework1.Problem3;

public class Reverse {

	static String reverser(String x)
	{						// Recursive method that reverses a string
		if(x.length() <= 1)
			return x;		// I return strings of length 1 to end the recursive loop
		return reverser(x.substring(1, x.length())) + x.substring(0,1); 
							// Otherwise I separate the first element from the string, call the method
							// on the remaining elements, and append the first element onto the result
							// of the reverser call.
							// Each subsequent call repeats this process until the last element in the 
							// original string is the only remaining character. This element is returned,
							// and the rest of the characters are placed at the end of this string in 
							// reverse order of the function calls, which will result in a reversed string
		
	}
	
	public static void main(String[] args) {
		// Main and test strings
		String stringy = "I'm a stringy!";
		System.out.println(stringy);
		System.out.println(reverser(stringy));
		System.out.println(reverser(reverser(stringy)));	// double reverse returns original string
		String racecar = "racecars";
		System.out.println(reverser(racecar));
		System.out.println(reverser("This is a test123"));
		System.out.println(reverser("B"));
	}
	
}
