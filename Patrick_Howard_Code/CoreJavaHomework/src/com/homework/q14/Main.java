package com.homework.q14;

import java.util.Date;

public class Main {

	public static void main(String[] args) {

		switchExamples(1);
		switchExamples(2);
		switchExamples(3);
	}

	public static void switchExamples(int category) {
		switch (category) {
		case 1:
			double root = 5;
			System.out.println(Math.sqrt(root)); // uses math.sqrt for first case
			break;
		case 2:
			Date today = new Date(); // uses imported date class for case 2
			System.out.println(today);
			break;
		case 3:
			String stringToSplit = "I am learning Core Java"; // uses the split method on the string
			String ss[] = stringToSplit.split(" ");
			for (int i = 0; i < ss.length; i++) { // when each string is split, it prints out each word separately
				System.out.println(ss[i]);
			}
			break;
		}
		return;
	}

}
