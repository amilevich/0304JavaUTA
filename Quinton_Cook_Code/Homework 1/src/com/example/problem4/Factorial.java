package com.example.problem4;

public class Factorial {

	public static void main(String[] args) {
		int n = 10;
		int prod = 1;

		for (int i = 1; i <= n; i++) {
			prod *= i;
		}

		System.out.println(prod);
	}

}
