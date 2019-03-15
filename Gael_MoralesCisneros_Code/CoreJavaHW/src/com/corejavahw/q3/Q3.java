package com.corejavahw.q3;

public class Q3 {

	public static void main(String[] args) {

		/*
		 * Reverse a string without using a temporary variable. 
		 * Do NOT use reverse() in theStringBuffer or the StringBuilder APIs.
		 */
		
		String s = "reverse";
		//print original string
		System.out.println("String: " + s);
		
		//loop to reverse using substring
		for (int i = 0; i < s.length(); i++) {
		    s = s.substring(1, s.length() - i) + s.substring(0, 1)+ s.substring(s.length() - i, s.length());
		 }
		
		//print current string
		 System.out.println(s);
	}

}
