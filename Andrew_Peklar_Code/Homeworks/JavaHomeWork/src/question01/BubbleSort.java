package question01;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int[] array = { 6,8,7,9,5,1,3,2,4, -9 };
		recursiveBubbleSort(array, array.length);
		System.out.println(Arrays.toString(array));

	}
	
	public static void recursiveBubbleSort(int[] array, int n) {
		// base case
		if (n == 1)		return;

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
		recursiveBubbleSort(array, n - 1);
	}
}
