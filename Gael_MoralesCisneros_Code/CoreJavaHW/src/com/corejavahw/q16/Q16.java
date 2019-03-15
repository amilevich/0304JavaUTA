package com.corejavahw.q16;

/*
 * Write a program to display the number of characters for a string input. The string
 * should be entered as a command line argument using (String [ ] args).
 */

public class Q16 {

	//program driver
	public static void main(String[] args) {
		
		//Initialize String to put args into
		String str="";
		//enhanced loop to put args array into String str
		for(String s: args) 
			str+=s;
		
		//print number of characters in String str with length() method
		System.out.println("The number of characters for the string input is: " + str.length());
			
		
	}
}
