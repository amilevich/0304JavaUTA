package com.problem.q9;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();

		// get the 1-100
		for (int x = 1; x <= 100; x++) {
			arrList.add(x);
		}

		System.out.println("ArrayList with 1 through 100: " + arrList);

		printPrime(arrList);

	}

	public static void printPrime(ArrayList<Integer> aL) {
		ArrayList<Integer> returnedArr = new ArrayList<Integer>();

		for (int num : aL) {
			if (num == 1)
				continue;
			int count = 2;
			boolean isNotPrime = false;

			// only need to count from 2 to sqrt of integer
			// because of math.
			while (count <= Math.sqrt(num)) {
				if (num % count == 0) {
					isNotPrime = true;
					break;
				}
				count++;
			}
			if (isNotPrime) {
			} else {
				returnedArr.add(num);
			}
		}
		System.out.println("The prime numbers of those 100 integers: " + returnedArr);
	}

}
