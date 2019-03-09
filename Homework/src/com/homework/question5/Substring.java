package com.homework.question5;

public class Substring {
	public static void main(String[] args) {
		
		String str2 = "Platypus";   
		int idx=6;
		
		System.out.println("Substring is Platypus, idx is "+ substring(str2, idx)); //Prints out the newly generated substring.
		
		

	}
	
	public static String substring(String str, int idx) { 
		char[] x = str.toCharArray(); //changes string into a character array.
		String str1 = new String(); //creates a string.
		for(int i = 0; i<=idx-1; i++) { //Sets loop to begin at 0 in the array.
			str1+=x[i]; //Adds characters to the loop.
		}
		
	return str1; // returns the new string.
		
		
		
	}
}
