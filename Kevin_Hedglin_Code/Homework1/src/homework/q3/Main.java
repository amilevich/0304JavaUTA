package homework.q3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// take in a string from the user
		System.out.println("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		
		//reverse string and print
		String reversed = reverseString(st);
		System.out.println(reversed);
	}
	
	
	public static String reverseString(String reverse)
	{
		//loop through each character of the string, add the first character
		//of the string to the beginning of the character substring that
		//you have already reversed.
		for (int i = 0; i < reverse.length(); i++)
		{
		    reverse = reverse.substring(1, reverse.length() - i)
		    			+ reverse.substring(0, 1)
		    			+ reverse.substring(reverse.length() - i, reverse.length());
		 }
		
		return reverse;
	}

}
