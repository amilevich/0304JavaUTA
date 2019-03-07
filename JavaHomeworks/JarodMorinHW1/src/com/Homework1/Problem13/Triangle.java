package com.Homework1.Problem13;

public class Triangle {

	public static void main(String[] args) {
		int nextVal = 0;			// The pattern flip-flops from 0 to 1 to 0 to 1 ...
									// This integer will keep track of which value will be printed next
		
		for(int i = 1; i<5; i++) {	// Four rows
			for(int j = 1; j<=i; j++) {	// # of columns in each row is the # of the row
										// as a result, j(column#) will only increment until it is equal to i(row#)
				if(j!=i)			// Only want println if j == i, otherwise just use print to stay on same line
					System.out.print(nextVal);
				else
					System.out.println(nextVal);
				nextVal = nextVal *-1 + 1;	// Flip-flip expression. nextVal becomes 0 if 1, and becomes 1 if 0.
			}
				
				
		}

	}

}
