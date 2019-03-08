//Program prompts user to input two integers, then outputs whether the integers are equal or not

package question10;

import java.util.Scanner;// !!! import this to be able to input things using the keyboard

public class TernaryOperator {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // !!! define "input" object of the Scanner type
		System.out.print("Enter an integer: ");
		int userInteger1 = input.nextInt(); //!!! set the user's response into "userInteger" object
		System.out.print("Enter another integer: ");
		int userInteger2 = input.nextInt();
		
		if(userInteger1 == userInteger2) {
			System.out.println("Numbers are equal. Please enter unequal numbers.");
		}
		else {
			int minimumOfTwoNumbers = (userInteger1 < userInteger2) ? userInteger1 : userInteger2; //ternary operator
			System.out.println("The smaller number is: " + minimumOfTwoNumbers); //only prints if numbers are not equal
		}
		
	}

}

//Ternary operator syntax:
//result = testStatement ? value1 : value2;
//If testStatement is true then value1 is assigned to result variable else value2 is assigned to result variable
