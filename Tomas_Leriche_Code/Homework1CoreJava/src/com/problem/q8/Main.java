package com.problem.q8;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		String[] b = { "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy",
				"did" };

		isPalindrome(arrayPalin(b));
	}

	// here we put the array of strings into an ArrayList
	public static ArrayList<String> arrayPalin(String[] s) {
		ArrayList<String> alist = new ArrayList<String>();

		for (String string : s) {
			alist.add(string);
		}
		return alist;
	}

	// put the palindromes in another array ArrString2.
	public static void isPalindrome(ArrayList<String> ArrStrings) {

		ArrayList<String> ArrString2 = new ArrayList<String>();

		for (String string : ArrStrings) {

			int len = string.length();
			String rev = "";

			// if the reverse string matches the original
			// its palindromic.
			for (int i = len - 1; i >= 0; i--)
				rev += string.charAt(i);

			if (string.equals(rev)) {

				ArrString2.add(string);
			}
		}
		System.out.println("The Strings that are Palindromic: " + ArrString2);
	}

}
