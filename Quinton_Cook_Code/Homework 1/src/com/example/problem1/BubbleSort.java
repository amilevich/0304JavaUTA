package com.example.problem1;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int temp = 0;

		/*
		 * this will bubble the largest elements to the top of the array
		 */
		for (int i = 0; i < array.length - 1; i++) {

			/*
			 * in this loop the last i elements have been sorted. The inner loop will find
			 * the next largest number in the remaining length-i elements and add it to the
			 * sorted portion of the array
			 */
			for (int j = 0; j < array.length - i - 1; j++) {

				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}

		}

		for (int i : array) {
			System.out.print(" " + i);
		}
	}

}
