package com.problem.q1;

public class Main {

	public static void bubble2(int[] array) {
		int length = array.length;
		
		// looping over the length of the array -1
		for (int y = 0; y < length-1; y++) {
			//this second loop gets smaller in size since each 
			// iteration of the first loop ensures that the largest number
			// goes to the far right of the array.
			for (int x = 0; x < length-y-1; x++) {
				if (array[x] > array[x+1]) {
					
					//swapping the element with adjacent element
					int temp =  array[x];
					array[x] = array[x+1];
					array[x+1] = temp;
				}
			}

		}

	}
	
	public static void main(String[] args) {
		
		int[] numbers = {1,0,5,6,3,2,3,7,9,8,4};
		
		bubble2(numbers);
		
		for(int num : numbers)
			System.out.print(num + ", ");
	}
	
}
