package com.problem4;

public class Main {

	public static void main(String[] args) {
		factorial(4);
	}
	
	public static int factorial (int x) {
		int factorial = 1;
		for (int i=x; i>1; i--) {
			factorial *= i;
		}
		System.out.println(factorial);
		return factorial;
	}
}
