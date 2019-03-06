package com.example.problem9;

import java.util.ArrayList;

public class Sieve {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>(100);
		
		//add all the numbers
		for (int i = 2; i <= 100; i++) {
			nums.add(i);
		}

		/*
		 * the sieve of Eratosthenes algorithm runs in square root time (see wikipedia
		 * for proof) that is why i goes to 10
		 */
		for (int i = 2; i <= 10; i++) {
			/*
			 * this will check if all of the remaining indices are multiples of i if they
			 * are, they're removed from nums
			 */
			for (int j = 0; j < nums.size(); j++) {
				if (nums.get(j) % i == 0 && nums.get(j) != i) {
					nums.remove(nums.remove(j));
				}
			}
		}

		System.out.println(nums);
	}

}
