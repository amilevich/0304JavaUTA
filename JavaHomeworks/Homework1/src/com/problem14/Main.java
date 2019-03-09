package com.problem14;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		int x = 3; // this can be changed to test other cases
		int number = 49;
		String str= "I am learning Core Java"; 
		String [] stringArray; 
		switch(x) {
		case 1: 
			Math.sqrt(number); // square root the number from the Math class
			break;
		
		case 2: 
			Date today = new Date();
			System.out.println(today); //displays today's date
			break;
		
		case 3: 
			String string= "I am learning Core Java";
			String[] arr = string.split("\\s+"); //splitting it on the spaces and storing it to an initialized array
			System.out.println(Arrays.toString(arr));
			break;
		}

	}
	

}
