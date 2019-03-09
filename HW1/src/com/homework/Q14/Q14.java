package com.homework.Q14;
/* Christopher Collins
 * Switch statement
 */


import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Q14 {

	public static void main(String[] args) {
		
		// Create Scanner
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter 1, 2, or 3:");
		
		// Get input 1,2, or 3
		String Temp = myObj.nextLine();
		int Gamma = Integer.parseInt(Temp);
		
		// Switch statement
		switch(Gamma) {
		// Case 1 Square root 81
		case 1: System.out.println("Square root of 81 is " + Math.sqrt(81.0));
				break;
		
		// Case 2 Display Date and time
		case 2: Date today = Calendar.getInstance().getTime();
				System.out.println("Today is " + today);
				break;
		
		// Case 3 Store String into an array
		case 3: String IDK = "I am learning core Java";
				String[] Split = IDK.split(" ");
				List<String> store = Arrays.asList(Split);
				System.out.println(store);
				break;
		
		}

	}

}
