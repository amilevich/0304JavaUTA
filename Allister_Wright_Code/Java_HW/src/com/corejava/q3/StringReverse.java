package com.corejava.q3;

public class StringReverse {

	public static void main(String[] args) {
		
		String string = "TestString"; 		// Test case
		String outString = new String(); 	// Output Buffer
		
		// iterate backwards over string
		for (int i = string.length()-1; i >= 0; i--)
		{
			// append current character to output Buffer
			outString += string.charAt(i);
		}
		
		// print result
		System.out.println(outString);
	}
}
