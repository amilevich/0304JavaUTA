package question12;

import java.util.ArrayList; //import this package in order to use ArrayList

public class EnhancedForLoop {
	public static void main(String[] args) {
		int[] hundredArray = new int[100]; //declaring, instantiating and initializing array
		for(int i = 0; i<hundredArray.length; i++) {
			hundredArray[i] = i + 1; //populating array with numbers 1-100
		}
		
		ArrayList<Integer> evenArray = new ArrayList<Integer>(); //we use an ArrayList because we don't know how long array will be
		for(int i = 0; i<hundredArray.length; i++) {
			if(Math.floorMod(hundredArray[i], 2) == 0) { //checking for even numbers
				evenArray.add(hundredArray[i]);
			}
		}
		
		/*
		for(int i = 0; i<evenArray.size(); i++) { //verifying "evenArray" indeed contains even numbers only
			System.out.println(evenArray.get(i));
		}
		*/
		
		for(int j : evenArray) {
			System.out.println(j); //enhanced for loop prints out  contents "evenArray"
		}
	}
}