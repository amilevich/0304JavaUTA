package com.homework.question16;

public class countstrings {

	public static void main(String[] args) {

		String str = ""; // creating a string.

		for (String s : args) // pass arguments into the string.

			str = s; // puts arguments stored in s into str.

		System.out.println(str.length()); // print out the number of characters in the string.

	}
}
