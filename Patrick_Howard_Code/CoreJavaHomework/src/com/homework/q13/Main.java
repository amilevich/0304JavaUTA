package com.homework.q13;

public class Main {

	public static void main(String[] args) {

		boolean toggle = false;

		for (int i = 1; i < 5; i++) {			//counts from 1 to 4	
			for (int j = 1; j <= i; j++) {		// iterates each number 1 through 4
				if (toggle) {					// every other number goes through if statement		
					System.out.print("1 ");
				} else {						// the other numbers go through the else
					System.out.print("0 ");
				}
				toggle = !toggle;
			}
			System.out.println("");				// creates new line after every loop up to 4
		}

	}

}