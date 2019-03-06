package com.example.problem12;


public class Evens {

	public static void main(String[] args) {
		int[] nums = new int[100];

		/*
		 * one is added to i because the indices of an array start at zero that way the
		 * variable i can be reused
		 */
		for (int i = 0; i < 100; i++) {
			nums[i] = i + 1;
		}

		for (int i : nums) {
			if (i % 2 == 0) {
				System.out.print(i + ", ");
			}
		}
	}
}
