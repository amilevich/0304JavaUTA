//program prompts the user to enter a string, then outputs number of characters in string

package question16;

//import java.util.ArrayList; //import this package in order to use ArrayList
import java.util.Scanner; //import this so user can input stuff

public class NumberOfChar {
	
	public static void main(String[] args) {
		
		Scanner inputString = new Scanner(System.in); //initializing "inputString" object
		System.out.print("Enter a string: ");
		String userString = inputString.nextLine(); //use .nextLine() to store whatever user inputs inside "userString" object
		System.out.println("You entered string: " + userString );
		//ArrayList myArray = new ArrayList();
		String[] splitStringArray = userString.split(""); // .split() method makes String[] behave like ArrayList; array size is dynamic
		
		int splitStringArrayLength = splitStringArray.length;
		System.out.println("Number of characters: " + splitStringArrayLength);
	}

}
