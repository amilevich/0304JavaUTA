package com.corejava.q8;

import java.util.ArrayList;

public class Palindrome {

	public static void main(String[] args) {
		String[] initial_dict = {"karan", "madam", "tom", 
				"civic", "radar", "sexes", "jimmy", "kayak", 
				"john", "refer", "billy", "did"};

		// Initialise Target ArrayLists
		ArrayList<String> fullList = new ArrayList<String>();
		ArrayList<String> palindromeList = new ArrayList<String>();
		
		// Add to appropriate lists
		for (String s : initial_dict)
		{
			fullList.add(s);
			if (isPalindrome(s)) 
				palindromeList.add(s);
		}
		
		// Output Results
		System.out.println(fullList);
		System.out.println(palindromeList);
	}

	public static boolean isPalindrome(String s)
	{
		// compare input string to reverse copy
		return s.contentEquals((new StringBuilder(s)).reverse());
	}
}
