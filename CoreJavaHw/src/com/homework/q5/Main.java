package com.homework.q5;

public class Main {
	
	//a method that will return the subString of a string
	static String subString(String myString, int index) {
		
		
		String subString = "";
		
		//gets the char at the position asked and creates the subString
		for(int i = 0; i < index; i++) {
			
			subString += myString.charAt(i);
			
		}
		return subString; 
	}
	
	public static void main(String[] args) {
		
		
		String theString="Welcome to Java";
		
		//uses the subString method above to print desired part the string
		System.out.println(subString(theString,7));
		System.out.println(subString(theString,5));
	}

}
