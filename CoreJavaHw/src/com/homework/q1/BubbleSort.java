package com.homework.q1;

public class BubbleSort {
	

	public static void main(String[] args) {
		
		int bubbleSort[]= {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		//swaps the largest number the end of the array
		for(int i = 0; i < bubbleSort.length -1; i++)
			
			//sorts the next largest number, excludes already properly sorted numbers
			for(int j = 0; j < bubbleSort.length - i - 1; j++)
				
			
				if(bubbleSort[j] > bubbleSort[j+1]) {
					
					int temp = bubbleSort[j];
					bubbleSort[j] = bubbleSort[j+1];
					bubbleSort[j+1]= temp;
				}
			
		
		//prints sorted list
		for(int b : bubbleSort) {
			System.out.println(b);
		}
		
	}
}
