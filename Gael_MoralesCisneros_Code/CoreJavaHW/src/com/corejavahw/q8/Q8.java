package com.corejavahw.q8;

import java.util.ArrayList;

/*
 * Write a program that stores the following strings in an ArrayList and saves all the 
 * palindromes in another ArrayList.
 * 
 * “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”, “refer”, 
 * “billy”,“did”
 */

public class Q8 {

	// program driver
	public static void main(String[] args) {

		// instantiated two ArrayLists for strings and palindromes
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		// add strings to strings ArrayList
		strings.add("karan");
		strings.add("madam");
		strings.add("tom");
		strings.add("civic");
		strings.add("radar");
		strings.add("sexes");
		strings.add("jimmy");
		strings.add("kayak");
		strings.add("john");
		strings.add("refer");
		strings.add("billy");
		strings.add("did");
		// print strings ArrayList
		System.out.println("Strings ArrayList: " + strings);

		// enhancedLoop ArrayList to check for palindrome
		for (String str : strings) {
			int l = str.length();
			String reverse = "";

			// reverse string
			for (int i = l - 1; i >= 0; i--) {
				reverse = reverse + str.charAt(i);
			}

			// if string equals reversed string, add to palindrome ArrayList
			if (str.equals(reverse))
				palindromes.add(str);
		}
		// print palindrome ArrayList
		System.out.println("Palindrome ArrayList: " + palindromes);
	}
}
