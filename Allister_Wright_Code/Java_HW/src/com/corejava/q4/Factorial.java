package com.corejava.q4;

public class Factorial {

	public static void main(String[] args) {

		// Iterate over Test cases
		for (int i = 0; i < 10; i++)
			System.out.println(i + "! = " + lowMemFactorial(i));
	}

	private static int lowMemFactorial(int n)
	{
		// return 0! to avoid loop range issues
		if (n == 0)
			return 1;
		
		// multiply all integers from N to 1
		int product = 1;
		for (int i = n; i >= 1; i--)
			product *= i;
		return product;
	}
}
