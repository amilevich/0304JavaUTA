package com.example.problem19;

import java.util.ArrayList;

public class FunWith10 {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> composites = new ArrayList<Integer>();
		int oddSum = 0;
		int evenSum = 0;

		for (int i = 1; i <= 10; i++) {
			nums.add(i);
		}

		for (int i : nums) {
			if (i % 2 == 0) {
				evenSum += i;
			} else {
				oddSum += i;
			}
		}

		System.out.println("The sum of the even numbers in one through ten is " + evenSum);
		System.out.println("The sum of the odd numbers in one through ten is " + oddSum);

		for (int i : nums) {
			for (int j = 2; j <= 5; j++) {
				if (i % j == 0 && j != i) {
					if(composites.contains(i)) {
						continue;
					}else {
						composites.add(i);
					}
				}
			}
		}
		
		System.out.println(composites);
	}

}
