package com.homework.q01;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
	
		int arraySort[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};	// creates an array
		
		for (int x = 1; x < arraySort.length - 1; x++) {		// counts down the length of the array to the second position
			
			for (int i = 0; i < arraySort.length - x; i++) {	// checks to make sure there is a value to comare
				if(arraySort[i] > arraySort[i +1]) {			// when the first value is less than the second it will start the loop
					int temp = arraySort[i];					// temporarily hold the first value
					arraySort[i] = arraySort[i + 1];			// replaces first value with the second
					arraySort[i + 1] = temp;					// the second value is now replaced by the temporary{was the first value}
				}
			}
		}
		System.out.println(Arrays.toString(arraySort));
	}
}
