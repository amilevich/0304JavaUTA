package homework.q5;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Take in the string from the user
		System.out.println("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		
		//take in the idx integer from the user
		System.out.println("Enter the idx integer: ");
		int idx = sc.nextInt();
		
		//get and print the substring
		String substr = getSubString(st, idx);
		System.out.println(substr);
	}

	public static String getSubString(String st, int idx) 
	{
		String subStr = "";
		CharacterIterator it = new StringCharacterIterator(st);
		
		//iterate through the substring for the length of the idx building
		//the substring from the characters
		char c = it.first();
		while(it.getIndex() < idx)
		{
			subStr += c;
			c = it.next();
		}
		return subStr;
	}
}
