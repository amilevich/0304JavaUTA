//this program will prompt the user to input an integer in the console; after the user does so, it will output the factorial of that integer

package question4;

import java.util.Scanner; // !!! import this to be able to input things using the keyboard

public class NFactorial {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // !!! define "input" object of the Scanner type
		System.out.print("Enter an integer in the console: ");
		int userInteger = input.nextInt(); // !!! set the user's response into "userInteger" object
		System.out.println("You entered: " + userInteger);

		int factorialNumber = 1; //initialize "factorialNumber" to 1
		for(int i = 1; i <= userInteger; i++) {
			factorialNumber = factorialNumber * i; //"factorialNumber" grows as "i" approaches the value of "userInteger"
		}
		System.out.println("Factorial integer: " + factorialNumber);
	}

}