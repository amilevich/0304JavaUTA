
package com.homework.question3;

public class Main {

	// Reference: https://www.quora.com/How-do-I-reverse-a-String-in-Java-without-using-any-loop-or-inbuilt-methods
	public static void main(String[] args) {
		// Q3. Reverse a string without using a temporary 
		// variable.  Do NOT use reverse() in the 
		// StringBuffer or the StringBuilder APIs
		
		String a = "apple"; 
		String b = ""; // temporary variable?
		
		// reverse for loop to start at end of string
		for(int i = a.length() - 1; i >= 0; i--)
		{
			b = b + a.charAt(i); // append to the end of string b
		}
		
		System.out.println(b);
	}

	

}
