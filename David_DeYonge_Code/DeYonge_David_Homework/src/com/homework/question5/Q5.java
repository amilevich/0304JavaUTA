package com.homework.question5;

public class Q5 
{
	public static String returnSubstring(String s,int index)
	{
		if (index > s.length())
		{
			//Makes sure that the index isn't larger than the string size
			System.out.println("Index is larger than string");
			return "";
		}
		//Empty return string
		String ret="";
		//add each character of the string to the empty string until the index is reached
		for (int i = 0; i < index; i++) 
		{
			ret += s.charAt(i);
		}
		return ret;
	}
	public static void main(String[] args) 
	{
		String s = "HelloWorld";
		
		System.out.println(returnSubstring(s,(int)(s.length()*.5f)));
	}

}
