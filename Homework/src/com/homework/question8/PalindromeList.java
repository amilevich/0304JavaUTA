package com.homework.question8;

import java.util.ArrayList;

public class PalindromeList {

	public static void main(String[] args) {

		ArrayList<String> NotPalindromesList = new ArrayList<String>(); // Create array called NotPalindromeList

		NotPalindromesList.add("karan");// Add each word to NotPalindromeList
		NotPalindromesList.add("madam");
		NotPalindromesList.add("tom");
		NotPalindromesList.add("civic");
		NotPalindromesList.add("radar");
		NotPalindromesList.add("sexes");
		NotPalindromesList.add("jimmy");
		NotPalindromesList.add("kayak");
		NotPalindromesList.add("john");
		NotPalindromesList.add("refer");
		NotPalindromesList.add("billy");
		NotPalindromesList.add("did");

		ArrayList<String> PalindromeList = new ArrayList<String>();// Create Array called PalindromeList

		for (String reverse : NotPalindromesList) { // Take each word out of NotPalindromeList and call it "reverse."

			String original = reverse; // copy reverse and call it original

			for (int i = 0; i < reverse.length(); i++) { // reverse String currently being called "reverse."
				reverse = reverse.substring(1, reverse.length() - i) + reverse.substring(0, 1)
						+ reverse.substring(reverse.length() - i, reverse.length());

			}
			if (original.equals(reverse)) { // Compare String currently being called Reverse with String currently being
											// called Original.
				PalindromeList.add(original);// If Reverse matches Original add the String to PalindromeList
			}

		}
		System.out.println(PalindromeList); // Print PalindromeList

	}

}
