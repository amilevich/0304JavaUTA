package com.homework.q2;

public class Fibonacci {
	
	public static void main(String[] args) {
		
		 
		int numOne = 0;
		int numTwo = 1;
		
		int i = 0;
		//loop to display the first 25 fibonacci numbers
		while(i < 25) {
			
			System.out.println(numOne + " ");
			int sumOfNumbers = numOne + numTwo;
			numOne = numTwo;
			numTwo = sumOfNumbers;
			
			i++; 
			
			
		}
		
	}
	

}
