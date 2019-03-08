package com.Homework1.Problem5;

public class Substring {

	static String subString(String str, int idx) {		// subString method that accepts String str and int idx args
		String res = null;				// setting the result to null initially, for use when input is invalid
		
		if(idx <= 0 || idx > str.length())	// if length of 0 or less, or greater than original string length is 
			return res;						// chosen, return res which is still null
		res = "";							// otherwise set res to an empty string
		
		for(int i = 0; i < idx; i++)		// populate newly cleared res with characters from str, one-
			res = res + str.charAt(i);		// at-a-time and in sequence. Continue as long as i < idx
		
		return res;							// return the result string
	}
	
	
	public static void main(String[] args) {
		
		String newStr = "0123456789";
		String otherStr = "HelloIAmJustAString";
		
		System.out.println(subString(newStr,5));		// printing out from 0 until index 5-1, or "01234"
		System.out.println(subString(newStr,10));		// printing out from 0 until index 10-1, 
														// or "0123456789"
		System.out.println(subString(otherStr,7)); 		// printing "HelloIA", first 7 characters
	}

}
