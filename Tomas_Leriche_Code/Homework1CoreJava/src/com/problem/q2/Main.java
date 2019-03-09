package com.problem.q2;

public class Main {

	public static void Fiby(int n) {

		// first two numbers are 0 and 1
		int num1 = 0;
		int num2 = 1;

		// this controls for inputs less than 1.
		if (n < 1) {
			return;
		}

		System.out.println(num1 + " ");
		for (int i = 1; i < n; i++) {
			System.out.println(num2 + " ");
			// fibonacci progresses by adding last 2 numbers.
			int nextNum = num1 + num2;
			num1 = num2;
			num2 = nextNum;
		}

	}

	public static void main(String[] args) {

		// specify the number of numbers returned.
		Fiby(25);

	}

}
