package com.homework.q8;

import java.util.ArrayList;

public class Palindromes {
	
	
	//method to check if a string is a palindrome by reversing the string and seeing
		//and seeing if the strings are equal 
	public static boolean isPalindromes(String s) {
		
		String reverse = "";
		
		for(int i = s.length()-1; i>=0; i--) {
			reverse += s.charAt(i);
		}

		return s.equals(reverse);
		
	}
	
	public static void main(String[] args) {
		
		
		//create an ArrayList to store names
	ArrayList<String> words = new ArrayList<String>();
	
	
	//adding names to the ArrayList
	words.add("karan");
	words.add("madam");
	words.add("tom");
	words.add("civic");
	words.add("radar");
	words.add("sexes");
	words.add("jimmy");
	words.add("kayak");
	words.add("john");
	words.add("refer");
	words.add("billy");
	words.add("did");
	
	
	//creating an ArrayList to hold all palindromes 
	ArrayList<String> palarr = new ArrayList<String>();
	
	//loops through our array and checks if it is a palindrome and adds
		//to the palindrome array if true
	for(int i = 0; i < words.size(); i++) {
		if(isPalindromes((String) words.get(i))) {
			palarr.add((String) words.get(i));
		}
		
	}
	System.out.println(palarr);
	
	}
}
