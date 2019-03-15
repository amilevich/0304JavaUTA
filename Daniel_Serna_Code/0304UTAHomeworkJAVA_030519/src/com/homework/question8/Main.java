package com.homework.question8;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Q8
		// Write a program that stores the following strings in 
		// an ArrayList and saves all the palindromes in another
		// ArrayList. 
		// 
		// 
		
		// create an empty arrayList and palindrome list
		ArrayList<String> arrL = new ArrayList<String>(12); 
		 
		// array of strings
		String [] strings = { "karan", "madam", "tom",
				"civic", "radar", "sexes", 
				"jimmy", "kayak", "john", 
				"refer", "billy", "john" };
		
		// enhanced for loop to insert into ArrayList arrL
		for(String s : strings )
		{
			arrL.add(s); 
		}
		
		// System.out.println(arrL);
		
		// save strings to separate ArrayList reversed
		ArrayList<String> reverseArrL = new ArrayList<String>(); 
	
		int length = 0; // temp to hold length of string
		String reverseCopy = ""; // will hold copy of string reversed
		
		// enhanced for loop to store reversed string in reverseArrL
		for(String move : arrL)
		{
			length = move.length(); 
			
			// inner for loop to appen chars to reverseCopy
			for(int i = length - 1; i >= 0; i--)
			{
				reverseCopy += move.charAt(i); 
			}
			
			// condition check to add palindrome
			if(reverseCopy.equals(move))
			{
				reverseArrL.add(reverseCopy);
			}
			
			length = 0; // reset length
			reverseCopy = ""; // reset temp str
		}
		
		System.out.println(reverseArrL);
	}

	

}
