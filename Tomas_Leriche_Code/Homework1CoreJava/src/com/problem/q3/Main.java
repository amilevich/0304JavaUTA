package com.problem.q3;

public class Main {

	public static void rev(String s) {

		// goes from end of string to beginning appending
		for (int x = s.length() - 1; x >= 0; x--) {

			// here I append the reversed characters to the same
			// string that is input.
			s += s.charAt(x);
		}

		// then I print out only the second half of my string
		// which is the reversed string.
		System.out.println(s.substring(s.length() / 2, s.length()));

	}

	public static void main(String[] args) {

		rev("Hellooo!");
		rev("THis string is reversed!");
	}

}
