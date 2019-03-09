package com.homework.question16;

public class Main {

	// Reference: https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html
	public static void main(String[] args) {

		// Q16. Write a program to display the number of 
		// characters for a string input. The string 
		// should be entered as a command line argument 
		// using (String [ ] args)
		
		int countChars = 0; // var to count characters
		
		// enhanced for loop to iterate through args
		for(String str : args)
		{
			System.out.print(str);
			countChars += str.length(); 
		}
		System.out.println("String length: "+countChars);
	}

}
