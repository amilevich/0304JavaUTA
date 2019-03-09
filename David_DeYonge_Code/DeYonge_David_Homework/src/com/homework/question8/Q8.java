

package com.homework.question8;

import java.util.ArrayList;

public class Q8 
{
	public static boolean palindromeCheck(String s)
	{
		for (int i = 0; i < s.length()*.5; i++)
		{		//checks if each char at the 
				//corresponding position in the string is the same
			if (s.charAt(i) != s.charAt((s.length() - 1) - i))
			{
				return false;
			}
		}
		return true;
	}
	public static ArrayList<String> sortPalindrome(ArrayList<String> aList)
	{
		ArrayList<String> palindromeList = new ArrayList<String>();
		//checks the initial arraylist for palindromes
		//if there is a palindrome it adds it to the palindrome list
		for (int i = 0; i < aList.size(); i++) 
		{
			if (palindromeCheck(aList.get(i))) 
			{
				palindromeList.add(aList.get(i));
			}
		}
		return palindromeList;
	}
	public static void main(String[] args)
	{
		ArrayList<String> allStrings = new ArrayList<String>();
		
		allStrings.add("karan");
		allStrings.add("madam");
		allStrings.add("tom");
		allStrings.add("civic");
		allStrings.add("radar");
		allStrings.add("sexes");
		allStrings.add("jimmy");
		allStrings.add("kayak");
		allStrings.add("john");
		allStrings.add("refer");
		allStrings.add("billy");
		allStrings.add("did");
		ArrayList<String> palindromeStrings = new ArrayList<String>();
		
		palindromeStrings = sortPalindrome(allStrings);
		
		for (int i = 0; i < palindromeStrings.size(); i++) 
		{
			System.out.println(palindromeStrings.get(i));
		}
	}

}
