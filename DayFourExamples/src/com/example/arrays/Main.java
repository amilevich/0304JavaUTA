package com.example.arrays;

public class Main {

	// array - collection of elements (primitives) of the
	// same type and a fixed size
	
	public static void main(String[] args) {

		int tempOne[] = { 1, 2, 3, 4}; 
		
		tempOne[1] = 50;
		
		//System.out.println(tempOne[1]);
		
		int tempTwo[] = new int[9004];
		// an array of size 9004
		// int arrays are initialized as 0 for default
		
		// float -> 0.0f
		// boolean -> false
		// char -> '/u0000'/ unicode null character
		
		tempTwo[3] = 60;
		
		Boolean tempThree[] = new Boolean[3000];
		
		int tempFour[][] = { {9,10,11}, {4,2,7}, {6,6,5} };
		
		System.out.println(tempFour[1][2]); //7
		
		int tempFive[][][][][]; //totally possible
		
		int tempSix[][] = new int[10][12];
		tempSix[5][8]=80;
		int tempSeven[] = new int[100];
		tempSeven[90]= 90; //if index > 100, ArrayIndexOutOfBounds Exception
		
		tempSix[5] = tempSeven; //totally possible
		
		System.out.println(tempTwo.length);
		// the size/length of array
		
	}

}
