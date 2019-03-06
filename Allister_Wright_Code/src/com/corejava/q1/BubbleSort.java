package com.corejava.q1;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		int[] numList = {1,0,5,6,3,2,3,7,9,8,4};
		
		int[] outList = bubbleSort(numList);
		System.out.println(Arrays.toString(outList));
	}

	// Encapsulated method to sort array of integers
	private static int[] bubbleSort(int[] inList)
	{
		// Marking off Sorted Elements from highest to lowest
		for (int sortedIndex = inList.length -1; sortedIndex >= 0; sortedIndex--)
		{
			// Check each index (ascending) up to sorted elements
			for (int indexToSort = 0; indexToSort < sortedIndex; indexToSort++)
			{
				// Check if the current index needs to be swapped
				if (inList[indexToSort] > inList[indexToSort + 1])
				{
					// swap values in array
					int tmp = inList[indexToSort + 1];
					inList[indexToSort + 1] = inList[indexToSort];
					inList[indexToSort] = tmp;
				}
			}
		}
		// return the list, sorted in place
		return inList; 
	}
}
