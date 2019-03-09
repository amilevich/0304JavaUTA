package com.homework.question2;

public class Fibonnaci {

	public static void main(String[] args) {
		int[] array = new int[25];           //Make a new int array
        array[0] = 0;                        //set initial values of first two integers in the sequence
        array[1] = 1;
//        array[2] = array[0]+array[1];
//        array[3] = array[2]+array[1];
        for(int i = 2; i < 25; i++) {        //set loop to repeat until the 25th number in the sequence
        	array[i] = array[i-1] + array [i-2];
        	
        }
        for(int i = 0; i < 25; i++) {       //print every character one line at a time.
        	System.out.println(array[i]);
        }
	}

}
