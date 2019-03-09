package com.homework.question3;

public class Q3
{
	
	static String reverseString(String s)
	{
		for (int i = s.length()-1; i >= 0; i--) 
		{		//adds string backwards to current string
				s += s.charAt(i); 
		}
		//sets string to the backwards half of the string
		s = s.substring((s.length())/2, s.length());
		
		return s;
	}
	
	
	
	public static void main(String[] args)
	{
		String s = "this is a string";
		System.out.println("Regular string: " + s);
		s = reverseString(s);
		System.out.println("Reverse string: " + s);
		
	}
	
	
}
