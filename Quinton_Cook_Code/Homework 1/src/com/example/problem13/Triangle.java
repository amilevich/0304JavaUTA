package com.example.problem13;

public class Triangle {

	public static void main(String[] args) {
		int max = 10;
		/*
		 * the pattern to the triangle oscillate between zero and one switcher will
		 * have the correct parity so that the output matches the instructions.
		 */
		int switcher = 0;

		for (int i = 1; i <= max; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(switcher % 2);
				switcher++;
			}

			System.out.println("");
		}
	}

}
