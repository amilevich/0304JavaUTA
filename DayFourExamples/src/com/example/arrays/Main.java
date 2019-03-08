package com.example.arrays;

public class Main {
	
	public static void main(String[] args) {
		//array - collection of elements (primitives) of the same type and a fixed size
		
		int tempOne[] = {1, 2, 3, 4}; //array has a size of 4
		tempOne[1] = 50;
		System.out.println(tempOne[1]); //prints out 50
		//to print out all the members of an array you must use a loop, usually a for loop
		
		int tempTwo[] = new int[9004]; //array has a size of 9004; elements are 0's as of now

		//arrays are initialized as 0 for default
		//float -> 0.0f
		//boolean -> false
		//char -< '/u0000/' unicode null character
		
		tempTwo[3] = 60;
		Boolean tempThree[] = new Boolean[3000]; //use Boolean keyword to create Boolean array
		
		int tempFour[][] = {{9,10,11},{4,2,7},{6,6,5}};
		System.out.println(tempFour[1][2]); //prints out 7
		
		int tempFive[][][][][]; //five dimensional array
		
		int tempSix[][] = new int[10][12]; //[rows][columns]
		tempSix[5][8] = 80; //sets 80 to the fifth row, eight column
		
		int tempSeven[] = new int[100];
		//tempSeven[101] = 90; // ArrayIndexOutOfBounds
		tempSeven[90] = 1;
		
		tempSix[5] = tempSeven; //puts all 100 integers in tempSeven into the fifth row of tempSix
		
		System.out.println(tempTwo.length); //prints size of array; use length
		
	}

}
