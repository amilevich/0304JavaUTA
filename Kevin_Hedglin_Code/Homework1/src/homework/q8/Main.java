package homework.q8;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		//create and print the list of strings
		ArrayList<String> all = new ArrayList<String>( 
	            Arrays.asList("karan", "madam", "tom", "civic", 
	            		"radar", "sexes", "jimmy", "kayak", "john", 
	            		"refer", "billy", "did")); 
		String allStr = String.join(", ", all);
		System.out.println("all: " + allStr);
		
		
		//check each string in the list for palindrome and add if so,
		//add to a new list
		ArrayList<String> palindromes = new ArrayList<String>();
		for(String s: all)
		{
			if(isPalindrome(s))
			{
				palindromes.add(s);
			}
		}
		
		//print result
		String palindromesStr = String.join(", ", palindromes);
		System.out.println("palindromes: " + palindromesStr);
	}

	//Iterate through the string to check for palindrome
	public static boolean isPalindrome(String s)
	{
		char[] chars = s.toCharArray();
		int i1 = 0;
	    int i2 = chars.length - 1;
	    while (i2 > i1) {
	        if (chars[i1] != chars[i2]) {
	            return false;
	        }
	        i1++;
	        i2--;
	    }
	    return true;
	}
}
