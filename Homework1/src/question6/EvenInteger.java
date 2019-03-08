//this program asks the user to input an integer, and then outputs whether the inputed integer is even or not.

package question6;

import java.util.Scanner; //import this so user can input stuff

public class EvenInteger {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //define "input" object of the Scanner type
		System.out.print("Enter an integer in the console: ");
		int arbitraryNumber = input.nextInt(); //set the user's response into "arbitraryNumber" object
		System.out.println("You entered: " + arbitraryNumber);
		
		if(Math.floorMod(arbitraryNumber, 2) == 0) //Math.floorMod(x,y) grabs x and divides it by y, and it returns the remainder of the division
		{                                          //if number is even, the remainder of Math.floodMod(x,y) will be 0
			System.out.println("Number is even.");
		}
		else {
			System.out.println("Number is NOT even.");
		}
		
	}

}
