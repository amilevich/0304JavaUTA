package com.problem13;

public class Main {
	public static void main (String[] args) {
		printTriangle(4);
	}
	
	public static void printTriangle(int size) {	
		boolean zero = true; // initializing a boolean
		String a = "0"; // initialzing a variable to start with zero
		
		for (int i=0; i<=4; i++) { //rows
			for (int j=0; j<i; j++) { //column
				System.out.print(a); //second for loop will execute completely before going back to the first one. So for example, if we are on the second row we will have two elements added in that column since it keeps going until j<i
				a = zero?"1":"0"; //alternate 0 and 1 based on the boolean
				zero = !zero; //alternate boolean
			}
			System.out.println("");
		}
		
	}
}
