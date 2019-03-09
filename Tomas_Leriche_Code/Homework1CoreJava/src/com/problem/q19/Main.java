package com.problem.q19;

import java.util.ArrayList;

public class Main {

	public static void printPrime(ArrayList<Integer> aL) {
		ArrayList<Integer> returnedArr = new ArrayList<Integer>();

		for (int num : aL) {
			if (num == 1)
				continue;
			int count = 2;
			boolean isNotPrime = false;

			// only need to count from 2 to half of the integer since
			// doubling those numbers would mean they were divisible by 2.
			while (count <= num / 2) {
				if (num % count == 0) {
					isNotPrime = true;
					break;
				}
				count++;
			}
			if (isNotPrime) {
				returnedArr.add(num);
			} else {

			}
		}
		returnedArr.add(0, 1);
		System.out.println("The ArrayList with Primes removed: " + returnedArr);
	}

	public static void main(String[] args) {

		int evenAdd = 0;
		int oddAdd = 0;

		// arraylists for each array of numbers.
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> evens = new ArrayList<Integer>();
		ArrayList<Integer> odds = new ArrayList<Integer>();

		// add the numbers to nums array, 1-10
		for (int x = 0; x < 10; x++) {

			nums.add(x + 1);

		}
		// print the 1-10
		for (int num : nums) {
			System.out.print(num + " ");

		}
		// add odds evens and primes to their own arraylists
		for (int x = 0; x < nums.size(); x++) {
			if (nums.get(x) % 2 == 0) {
				evens.add(nums.get(x));
			} else {
				odds.add(nums.get(x));
			}
			// removing the primes as asked
		}

		System.out.println("\nThe even numbers: ");
		for (int num : evens) {
			System.out.print(num + " ");
			evenAdd += num;
		}
		System.out.println("\nThe odd numbers: ");
		for (int num : odds) {
			System.out.print(num + " ");
			oddAdd += num;
		}

		System.out.println("\nAll evens added up: " + evenAdd);
		System.out.println("\nAll odds added up: " + oddAdd);

		System.out.println();

		// This removes the primes and returns the new array.
		printPrime(nums);
	}
}
