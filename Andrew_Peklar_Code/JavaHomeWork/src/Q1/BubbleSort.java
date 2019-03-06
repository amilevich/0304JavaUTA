package Q1;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int[] array = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		BubbleSort(array, array.length);
		System.out.println(Arrays.toString(array));

	}

	public static void BubbleSort(int[] array, int n) {
		// base case
		if (n == 1)
			return;

		// one pass of bubble sort
		// largest element moved to end
		for (int i = 0; i < n - 1; i++)
			// if neighbor is larger
			// swap the array elements
			if (array[i] > array[i + 1]) {
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
		// recursion call
		// decrement list length until == 1
		BubbleSort(array, n - 1);
	}
}
