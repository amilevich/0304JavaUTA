package com.problem.q4;

public class Main {

	public static int factorial(int n) {

		// exit program if negative number used
		// there are better ways to handle this but
		// this is probably fine for homework.
		if (n < 0)
			System.exit(0);

		// this is recursive, the function calls itself
		if (n == 0)
			return 1;
		else
			n = n * factorial(n - 1);

		return n;

	}

	public static void main(String[] args) {

		System.out.println(factorial(5));

	}
}
