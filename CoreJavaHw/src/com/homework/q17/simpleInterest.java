package com.homework.q17;

import java.util.Scanner;

public class simpleInterest {

	public static void main(String[] args) {
		
		//creating a scanner object
		Scanner myScanner = new Scanner(System.in);
		
		
		//asks user for input and putting it in a variable 
		System.out.println("Enter the Principle:");
		double principle = myScanner.nextDouble();
		
		System.out.println("Enter the Rate of Interest:");
		double rate = myScanner.nextDouble();	
		
		System.out.println("Enter the Time period");
		double time = myScanner.nextDouble();
		
		
		//equation to calculate the simpleInterest 
		double simpleInterest = (principle * rate * time)/100;
		System.out.println("the simple interest is: " + simpleInterest);
		
		myScanner.close(); 

	}

}
