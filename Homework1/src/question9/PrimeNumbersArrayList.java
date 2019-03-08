package question9;

import java.util.ArrayList; //import this package in order to use ArrayList

public class PrimeNumbersArrayList {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> hundredArray = new ArrayList<Integer>(); //use ArrayList<Integer> so that whatever is added to ArrayList takes the form of an Integer, as opposed to an Object 
		for(int i = 0; i<100; i++) { //fill the new ArrayList "hundredArray" with numbers 1 through 100
			hundredArray.add(i+1); //don't forget the i+1 so that hundredArray.get(0)=1, instead of =0
			System.out.println("Printing all numbers in the ArrayList: " + hundredArray.get(i));
		}
		System.out.println(" "); //new line added for clarity
		for(int i = 0; i<100; i++) {
			if(Math.floorMod(hundredArray.get(i), 2) == 0) { //notice hundred.get(i) returns an Integer and NOT an Object because we used ArrayList<Integer>
				System.out.println("Printing even numbers only: " + hundredArray.get(i));
			}
			else {
			}
		}
		
	}

}
