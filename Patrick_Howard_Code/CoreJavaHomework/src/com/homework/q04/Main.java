package com.homework.q04;

public class Main {
	
	public static void main(String[] args) {
		
		int i = 5;
		int n = 1;
		int factorial = 1;
		for(n = 1; n <= i; n++) {			// counts until reaches input number
			factorial = factorial * n;		// multiplies the counter for every iteration
		}
			System.out.println(factorial);
		}
	}

