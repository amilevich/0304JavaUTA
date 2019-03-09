package com.homework.question1;

public class BubbleSort {
	
	public static void main(String[] args) {          //Defining driver.
		 int[] array = { 1,0,5,6,3,2,3,7,9,8,4 };     //Creating array.
		 for (int j = 0; j < array.length-1; j++) {   //creates loop that repeats the embedded loop if j < array length-1.
		 for(int i = 0; i < array.length-j-1; i++) {  //Creating loop that runs length of
			                                          //array and then increments i by 1.
			 if(array[i] > array[i+1]) {              //comparing position i to position i+1.                        
				 int temporary = array[i];            //creates temporary variable and setting equal to value at i
				 array[i] = array[i+1];               //setting value at i equal to value at i+1.
				 array[i+1] = temporary;              //setting value at i+1 equal to temporary(value at old i).
			 } 
		 }
		 }
		 for(int y = 0; y < array.length; y++) {    // created a new integer that loops through the array.
			 System.out.println(array[y]);          //print array after process is completed.
		 }
		 
	}

}
