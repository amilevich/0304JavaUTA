package com.problem5;

public class Main {

	public static void main(String[] args) {
	substring("Hello",2);		
	}
	
	public static String substring(String str, int x) {
		String newString = "";
		for (int i=0; i<x; i++) {		//looped through each character (starting from index 0 and stopping at the index provided minus one) 
			newString += str.charAt(i); // appended the characters to a new string
		}
		System.out.println(newString);
		return newString; //return new string
	}
}
