package com.Homework1.Problem14;

import java.util.Date;

public class SwitchCase {

	public static void main(String[] args) {

		for (int i = 0; i < 4; i++) // Counting from 0 to 4 to show different cases, case 1 repeated
									// This will produce 2 different square roots because i changes
		{
			switch (i % 3 + 1) { // i % 3 + 1 will ensure result is within 1-3 range
			case 1:
				System.out.println("Sqrt of " + i + " is " + Math.sqrt((double) (i)) + "\n");
				break; // case 1 simply prints i and its square root
			case 2:
				Date newDate = new Date();
				System.out.println("Current date is: " + newDate + "\n");
				break; // case 2 creates a new date object and displays it using toString
			case 3:
				String stringy = "I am learning Core Java";
				String[] arrList = stringy.split(" ");
				for (String str : arrList)
					System.out.print(str + ", ");
				System.out.println("\n");
				break; // case 3 splits the string into pieces every time a space " " character
						// is found this results in a different string for each word
						// I display the results separated by commas to differentiate from the
						// original sentence, as each word is a separate string in the
						// string array arrList
			default:
				System.out.println("Failure :("); // break statements are used to prevent falling through cases
			}

		}

	}

}
