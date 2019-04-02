//Program prompts the user to input either 1, 2 or 3;
package question14;

import java.text.DateFormat; //import this to display today's date
import java.text.SimpleDateFormat; //import this to display today's date
import java.util.Date; //import this to display today's date
import java.util.Scanner; //import this so user can input stuff

public class SwitchCase {
	
	public static void main(String[] args) {
		
		Scanner input1 = new Scanner(System.in);
		System.out.print("Enter either '1', '2', or '3': ");
		int userInt = input1.nextInt();
		switch(userInt) {
			case 1: Scanner input2 = new Scanner(System.in); //define "input" object of the Scanner type
					System.out.print("Enter a number: ");
					double userDouble = input2.nextDouble(); //set the user's response into "userDouble" object; use .nextDouble() here
					double squareRootOfUserDouble = Math.sqrt(userDouble);
					System.out.println("The square root of: " + userDouble + " is " + squareRootOfUserDouble);
					break;
			case 2: DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); //sets the date display format
					Date todaysDate = new Date();
					System.out.println("Today's date is: " + dateFormat.format(todaysDate));
					break;
			case 3: String learningCoreJava = new String();
					learningCoreJava = "I am learning Core Java";
					System.out.println("Original String: " + learningCoreJava);
					String[] splitStringArray = learningCoreJava.split(" "); //String.split(" ") splits the String every time it finds a space (" ")
					System.out.println(splitStringArray[0]); //notice we never specified the size of splitStringArray; its size is dynamic (?)
					System.out.println(splitStringArray[1]);
					System.out.println(splitStringArray[2]);
					System.out.println(splitStringArray[3]);
					System.out.println(splitStringArray[4]);
					break;
		}

	}

}