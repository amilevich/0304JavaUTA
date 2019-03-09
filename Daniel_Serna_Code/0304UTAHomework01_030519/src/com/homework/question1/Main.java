// Daniel Serna
// Purpose: Java homework practice (20 questions)
// Due date: 03/09/19 (Saturday) at 5pm
package com.homework.question1;

public class Main {

	public static void main(String[] args) {

		// Q1. Perform a bubble sort on the 
		// following integer array:  1,0,5,6,3,2,3,7,9,8,4
		
		int arr[] = { 1,0,5,6,3,2,3,7,9,8,4 }; 
		// unsorted array
		
		int temp = 0; 
		// create a temporary variable
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		
		// iterate through array
		for(int r = 0; r < arr.length - 1; r++)
		{
			for(int c = 0; c < arr.length - 1; c++)
			{
				if(arr[c] > arr[c+1])
				{
					temp = arr[c]; 
					arr[c] = arr[c+1]; 
					arr[c+1] = temp; 
				}
			}
		}
		
		System.out.println();
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		
	}

}
