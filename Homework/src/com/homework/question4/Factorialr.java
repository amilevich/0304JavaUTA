package com.homework.question4;

public class Factorialr {

	public static void main(String[] args) {
		int n = 0; // number being factored.
		int fact = 1;// initial number to be multiplied.
		if (n == 0)
			System.out.println(1);
		else {
			for (int i = 1; i <= n; i++) { // loop which runs to the number being factored and then stops.
				fact = fact * i; 
				System.out.println(fact);
			}

		}

	}

}
