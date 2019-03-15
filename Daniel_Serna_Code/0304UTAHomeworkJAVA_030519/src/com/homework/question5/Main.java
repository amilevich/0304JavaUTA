package com.homework.question5;

public class Main {

	public static void main(String[] args) {
		// Q5
		// Write a substring method that accepts a string str and an integer idx 
		// and returns the substring contained between 0 and idx-1 inclusive.  Do 
		// NOT use any of the existing substring methods in the String, 
		// StringBuilder, or StringBuffer APIs. 
		
		// user will input both
		String str = "apple"; 
		int idx  = 2; 
		
		System.out.println(findSubString(str, idx)); // call method to find sub string
		
	}

	static String findSubString(String s, int i) 
	{
		char [] c = s.toCharArray(); 
		String b = ""; 
		
		for(int r = 0; r < i; r++)
		{
			b = b + c[r]; 
		}
		return b; 
	}

}
