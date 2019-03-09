package com.homework.q4;

public class Factorial {
	
	public static void main(String[] args) {
		
		int fact = 1;
		int number = 7;
		
		
		//loops through and multiplies 1*2*3*4*5*6*7 
		for(int i = 1; i <= number; i++) {
			fact *= i;
		}
		
		System.out.println("The Factorial of " + number + " is: " + fact);
	}
	
	

}
