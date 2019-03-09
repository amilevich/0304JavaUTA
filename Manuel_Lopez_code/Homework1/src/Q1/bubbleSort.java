package Q1;

import java.util.Arrays;

public class bubbleSort {
	
	public static float x =13.0f;
	public static float y=9.0f;
	
	public static void main(String[] args) {
		int[] list = {1,0,5,6,3,2,3,7,9,8,4};		//array to sort
		bubbleSort(list);
	}
	
	static void bubbleSort(int[] list){
		System.out.println("Array before bubble sort: "+ Arrays.toString(list)); // view of array before bubbleSort
		
		int x = list.length;													//
		for(int i=0; i<x-1; i++)												//
			for(int j=0; j<x-i-1; j++)											//
				if(list[j] > list[j+1])											//<--
				{																//<--BubbleSort Algorithm
					int temp = list[j];											//<--
					list[j] = list[j+1];										//
					list[j+1] = temp;											//
				}																//
		
		System.out.println("Array after bubble sort: "+Arrays.toString(list)); //view of array after bubbleSort
	}

}
