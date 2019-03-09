package com.corejavahw.q5;

/*
 * Write a substring method that accepts a string str and an integer idx and returns the 
 * substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing 
 * substring methods in the String, StringBuilder, or StringBuffer APIs.
 */

public class Q5 {

	// substring method accepts string str and integer idx
	public static String substring(String str, int idx) {

		// string to char array c
		char[] c = str.toCharArray();
		// instantiate new string to return
		String str1 = new String();

		// loop from 0 to idx-1 inclusive to add current character of char array to
		// string
		for (int i = 0; i <= idx - 1; i++) {
			str1 += c[i];
		}

		// return new string with added chars
		return str1;

	}

	public static void main(String[] args) {
		// set string
		String str2 = "Hello";
		// set index
		int idx = 3;

		// print the substring from the string and index
		System.out.println("substring str: 'Hello', idx: 3 is " + substring(str2, idx));
	}

}
