package com.homework.question14;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner; 


// Reference: http://javadevnotes.com/java-split-string-into-array-of-integers-example
public class Main {
	public static void main(String[] args)
	{
		// Q14. Write a program that demonstrates the switch 
		// case. Implement the following functionalities in the 
		// cases: 
			// Case 1: Find the square root of a number using the Math class method.  
			// Case 2: Display today’s date. 
			// Case 3: Split the following string and store it in a sting array.  
		    // “I am learning Core Java” 
		
		// get user input for switch statement
		int user = 0;
		
		// string that holds time
		// Reference: https://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd").format(Calendar.getInstance().getTime());
		
		String myString = "I am learning Core Java"; // store string to be split
		String [] myStrArray; // = new String[5]; // empty string array for split string above
		
		Scanner s = new Scanner(System.in); // create a new scanner
		
		while(true) // loop to check user input
		{
			System.out.println("Enter a number (1, 2, 3): ");
			user = s.nextInt(); 
			if(user == 1 || user == 2 || user == 3)
			{
				break; // leave loop if correct input
			}
			else
			{
				System.out.println("Incorrect value!");
			}
		}
		
		switch(user)
		{
		case 1: 
			int squareRoot = 0; // initialize temp num to be square rooted
			System.out.println("Enter a number to find it's square root: ");
			squareRoot = s.nextInt(); 
			System.out.println("Square root of "+squareRoot+" is: "+Math.sqrt(squareRoot)); // print out reseult of user input number
			break; 			
		case 2: 
			System.out.println(timeStamp); // print out the data using variable timeStamp
			break; 
		case 3: 
			myStrArray = myString.split(" "); // split string using deleminater "white space"
			System.out.println("myStrArray: "); 
			
			// print out string array with for loop
			for(int i = 0; i < myStrArray.length; i++)
			{
				System.out.println(myStrArray[i]);
			}
			break; 
		default:
			; 	// instruction provided no default 
		}
		s.close(); 
		
		
	}
}
