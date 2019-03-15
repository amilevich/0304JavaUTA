package com.Homework1.Problem8;

import java.util.ArrayList;

public class Palindrome {

	static String reverser(String x)
	{						// Recursive method that reverses a string, borrowed from my problem3
		if(x.length() <= 1)
			return x;		
		return reverser(x.substring(1, x.length())) + x.substring(0,1); 
	}
	
	static boolean isPalindrome(String x) {
		if(x.equals(reverser(x)))		// determine if string is equal to its reverse
			return true;				// using .equals to ensure we are comparing content, just in case
		return false;
	}
	
	public static void main(String[] args) {
		ArrayList<String> originalList = new ArrayList<String>();	// storing strings into originalList
		originalList.add("karan");
		originalList.add("madam");
		originalList.add("tom");
		originalList.add("civic");
		originalList.add("radar");
		originalList.add("sexes");
		originalList.add("jimmy");
		originalList.add("kayak");
		originalList.add("john");
		originalList.add("refer");
		originalList.add("billy");
		originalList.add("did");

		ArrayList<String> palindromeList = new ArrayList<String>();
		for(String x : originalList) {
			if(isPalindrome(x))				// determining which Strings in originalList are palindromes
				palindromeList.add(x);		// add any Strings which are palindromes to palindromeList
		}
		System.out.println("originalList: " + originalList);
		System.out.println("palindromeList: " + palindromeList);	// display both lists
		
	}

}
