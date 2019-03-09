package com.homework.q14;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Q14 {
	
	public static void main(String[] args) {
		
		int choice;
		
		//creates a scanner to receive input from a user 
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Enter your choice\n1 - Find the square root\n2 - Today's date\n3 - Split string put in array");
		
		//takes the users choice and enters the switch to run the correct case number called
		choice = myScanner .nextInt();
		switch(choice) {
		
		case 1: 
			System.out.println("Enter a number");
			int number = myScanner.nextInt();
			
			double squareRoot = Math.sqrt(number);
			System.out.println("The sqaure root of: " + number + " is " + squareRoot);
			break;
			
		case 2: 
			LocalDateTime theDate = LocalDateTime.now();
			System.out.println(theDate.toString());
			break;
			
		case 3: 
			String myString = "I am learning Core Java";
			String[] stringArray = myString.split(" ");
			for(int i = 0; i < stringArray.length; i++) {
				System.out.println(stringArray[i]);
			}
			
		}
		
		
		myScanner.close(); 
	}

	
}
