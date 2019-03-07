package com.Homework1.Problem1;

public class BubbleSort {

	public static void bubbleSort(int[] array)
	{
		for(int i = 0; i < array.length -1; i++) {	
			// "Bubble Sort Total Passes" for loop
			// each pass of bubble sort will place the next largest value in the
			// correct position. A total of the array's length-1 passes are needed
			// because the final two elements will be sorted at the same time.
			
			for(int j = 0; j < array.length - 1 - i; j++) {
				// "Bubble Sort Each Pass" for loop
				// Each pass of bubble sort will compare each element to the following
				// element in order. If the the first element is larger than the second,
				// the two will be swapped and the pass continues.
				// array length - 1 used to stay within array bounds (no need to compare
				// final element to anything)
				// -i is included to exclude redundant comparisons in sorted region
				if(array[j] > array[j+1]) {
					// Bubble Sort swap code, uses a temporary variable to swap 
					// contents of two elements
					int tempVal = array[j];
					array[j] = array[j+1];
					array[j+1] = tempVal;
				}
			}
			printArray(array);
		}
		
	}
	
	public static void printArray(int[] array)	// Displays array in readable format
	{
		for(int i = 0; i < array.length; i++) {
			
			if(i<array.length-1)
				System.out.print(array[i] + ",");	// every element followed by a comma...
			else
				System.out.println(array[i]);		// ... except the last, which is instead
													// followed by a new line
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		
		System.out.println("Initial array: ");
		printArray(array);	// display initial array
		
		bubbleSort(array);	// call bubble sort
		
		System.out.println("Sorted array: ");
		printArray(array);	// display sorted array
	}
	
}
