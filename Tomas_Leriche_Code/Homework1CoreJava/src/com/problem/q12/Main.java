package com.problem.q12;

public class Main {

	public static void main(String[] args) {
		hundredEven();
	}

	public static void hundredEven() {

		int[] list = new int[100];

		for (int x = 0; x < 100; x++) {
			list[x] = x + 1;
		}

		// here is the enhanced for loop
		for (int num : list) {
			if (num % 2 == 0) {
				System.out.println(num);
			} else
				continue;
		}

	}

}
