package com.homework.q09;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();

		for (int i = 1; i <= 100; i++) { // Array list counting to 100
			numbers.add(i);
		}
		for (int j = 1; j < numbers.size(); j++) {
			int temp = numbers.get(j); // puts each element in a temporary
			boolean notPrime = false;
			for (int k = 2; k <= temp / 2; ++k) {
				if (temp % k == 0) { // finds if the temp is divisible by itself with no remainder
					notPrime = true; // to find is not prime
					break;
				}
			}

			if (!notPrime)
				System.out.println(temp + " is a prime number."); // if prime print
		}
	}
}