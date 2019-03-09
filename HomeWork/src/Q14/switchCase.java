package Q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class switchCase {

	public static void main (String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter an Integer between 1-3");
		System.out.println();//white space
		int INT = scan.nextInt();//reads user input		
		switch (INT) 
		{//reads user input to proceed to appropriate case
		case 1: 
		{
			System.out.println("Pick a number");
			float num = scan.nextFloat();
			scan.close();//ask for user input for a number
			float sqnum = (float) Math.sqrt(num);// finds sqrt of user input
			System.out.println("First: " + num  + "  Square Root: " + sqnum);
			break;
		}
		case 2: 
		{
			scan.close();
			getCurrentTimeUsingDate();//imported code
			break;
		}
		case 3: 
		{
			scan.close();
			String str = "I am learning core Java"; //string literal
			String[] strA = str.split(" "); //an array is created with (sub)strings
							//separated by an empty space (between each word)
			for (String s : strA) {System.out.print(" " + s);} break;
			// for each string in the string array, print the string
		}
		default: 
		{//If user doesn't pick a number between 1-3 than default case activated
			scan.close();
			System.out.println("Restart program and enter an Integer between 1-3");
			break;
		}
		}
	}
	
	//imported code --did not know if you want a date hard coded in the switch statement
	public static void getCurrentTimeUsingDate() {
	    Date date = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(date);
	    System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
	}
}
