package com.problem1;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		
		int[] num= {1,5,6,2,3,7,9,8,4};
		int [] sort =bubbleSort(num);
		System.out.println(Arrays.toString(sort));

	}
	
	public static int[] bubbleSort (int[] num) {
		int swap = 0;
		for (int i=0; i<num.length; i++) {
			for (int j=1; j<num.length-i; j++) { //logic: j index will always be one ahead of i so we are comparing two at a time and swapping
				if (num[j-1] > num[j]) {
					swap= num[j-1];
					num[j-1] = num[j];
					num[j] = swap;	
				}
			}
		}
		return num;
	}

}
