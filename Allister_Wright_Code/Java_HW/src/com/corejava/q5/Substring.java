package com.corejava.q5;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Substring {

	public static void main(String[] args) {

		String string = "TestString";

		System.out.println(getSubstring(string, 7));
	}

	private static String getSubstring(String inString, int idx)
	{
		String outString = ""; 	// output buffer
				
		// setup Iterator using StringCharacterIterator()
		CharacterIterator ci = new StringCharacterIterator(inString);
		
		// Loop over iterator while:
		// current index is in range and Character Iterator has character(s)
		for(int i = 0 ;
				i < idx 	&& 	ci.current() != CharacterIterator.DONE;
				i++, ci.next())
		{
			// append each character to the output
			outString += ci.current();
		}
		// return substring
		return outString;
	}
}
