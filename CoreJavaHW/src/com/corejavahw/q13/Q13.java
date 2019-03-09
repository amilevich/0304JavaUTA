package com.corejavahw.q13;

/*
 * Display the triangle on the console as follows using any type of loop. Do NOT use 
 * a simple group of print statements to accomplish this.
 * 0
 * 1 0
 * 1 0 1
 * 0 1 0 1
 */

public class Q13 {

	//program driver
	public static void main(String[] args) {
		
		int x, y;
		
		//loop for rows
		for(int i=0; i<5; i++) {
			//set condition for first two rows
			if(i<3) {
				//check for even or odd to alternate 0 and 1
				if(i%2 == 0) 
				{x=0;y=1;}
				else {x=1;y=0;}
			} 
			//set condition to flip for rest of rows
			else {
				//check for even or odd to alternate 0 and 1
				if(i%2 == 0) 
				{x=1;y=0;}
				else {x=0;y=1;}
			}
			//nested loop for columns
			for(int j=0; j<i; j++) 
				//check for even or odd to alternate 0 and 1 in the same row
				if(j%2 == 1)
					System.out.print(x);
				else 
					System.out.print(y);
			//print line to start next row
			System.out.println();
		}
	}

}
