package com.problem12;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		makeArray(100);	
		
	}
	public static int[] makeArray (int x) {
		int[] intArray = new int[x+1];
		for (int i=0; i< x; i++) {
			intArray[i] = i+1; 
		}
		for(int y: intArray) {   
			if (y % 2 == 0) {
				System.out.println(y);
			}
		}
		System.out.println(Arrays.toString(intArray));
		return intArray; 
	}
	
}
