package com.homework.Q1;
/* Christopher Collins
 * bubble sort
 */


public class Q1 {
	
	public static void main(String[] args) {
		
		// Define array
		int A[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		// Print array
		for(int i = 0; i<11; i++) {
			System.out.println(A[i]);
		}
		
		//Begin Sort
		
		// Made key for exiting loop using char
		char K = 'E';
		
		//Establish loop
		for(int s=0; s<10; s++) {
			
			// If bigger # is before the Smaller #, Swap and change key
			if(A[s]> A[s+1]) {
				int temp = A[s];
				A[s] = A[s+1];
				A[s+1] = temp;
				K = 'S';
			}
			
			// If Key is S then restart loop
			if(K=='S'){
				s = -1;
				K = 'E';
			}	
		}
		
		
		// Print Sorted Array
		System.out.println("Sorted");
		for(int i = 0; i<11; i++) {
			System.out.println(A[i]);
		}
		
	}

}
