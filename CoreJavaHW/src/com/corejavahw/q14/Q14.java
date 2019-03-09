package com.corejavahw.q14;

import java.util.Date;

/*
 * Write a program that demonstrates the switch case. Implement the following
 * functionalities in the cases:
 * Case 1: Find the square root of a number using the Math class method.
 * Case 2: Display today’s date.
 * Case 3: Split the following string and store it in a string array.
 * 			“I am learning Core Java”
 */

public class Q14 {

	//program driver
	public static void main(String[] args) {
		// initialize for switch case
		int x = 3;
		
		switch(x) {
			case 1:
				//initialize for Match.sqrt() method
				int y = 25;
				System.out.println(Math.sqrt(y));
				break;
			case 2:
				//instantiate Date object to print
				Date todaysDate = new Date();
				System.out.println(todaysDate);
				break;
			case 3:
				//initialize string to split
				String str = "I am learning Core Java";
				//used split() method to split str and added it to string array str2
				String[] str2 = str.split(" ", 0);
				//enhanced for loop to print every piece of split string in the array
				for (String s: str2)
					System.out.println(s);
				break;
		}
	}
}
