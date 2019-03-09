package com.homework.q12;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();

		for (int i = 1; i <= 100; i++) {			//Created array list that counts to 100
			numbers.add(i);
		}
		for (int item : numbers) { 					// enhanced for loop
			if (item % 2 == 0)
				System.out.println(item);
		}
	}

}
