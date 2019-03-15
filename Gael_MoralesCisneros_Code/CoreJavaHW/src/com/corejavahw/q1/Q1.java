package com.corejavahw.q1;

/*
 * Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
 */

public class Q1 {
		
	//bubbleSort swapping method
	void bubbleSort(int arr[]) {
		// set int to length of array
		int c = arr.length;
		//loop for length of array
		for(int i=0; i<c-1; i++) {
			// nest loop for several comparisons
			for(int j=0; j<c-i-1; j++) {
				//comparing values
				if(arr[j] > arr[j+1]) {
					//swap occurs
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
		
	//sysout the sorted array method in a single line
	void print(int arr[]) {
		int c = arr.length;
		for(int i=0; i<c; i++)
			System.out.print(arr[i] + " ");
	}
		
	//program driver
	public static void main(String[] args) {
			
			//instantiate object
			Q1 bubSort = new Q1();
			//set array
			int arr[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
			//sort
			bubSort.bubbleSort(arr);
			//message
			System.out.println("Array has been Bubble Sorted!");
			//print array
			bubSort.print(arr);
			
	}
}

