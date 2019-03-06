package com.example.problem8;

import java.util.ArrayList;

public class PalindromArray {

	public static void main(String[] args) {
		ArrayList<StringBuilder> strings = new ArrayList<StringBuilder>(11);
		ArrayList<StringBuilder> palindromes = new ArrayList<StringBuilder>();
		/*
		 * just adding some of the elements of the list I didn't want to type them all
		 */
		strings.add(new StringBuilder("karan"));
		strings.add(new StringBuilder("madam"));
		strings.add(new StringBuilder("tom"));
		strings.add(new StringBuilder("civic"));
		strings.add(new StringBuilder("radar"));
		strings.add(new StringBuilder("sexes"));
		strings.add(new StringBuilder("jimmy"));
		strings.add(new StringBuilder("kayak"));

		String tmp1;
		String tmp2;

		for (StringBuilder i : strings) {
			
			//the first call to reverse reverses the string
			tmp1 = i.reverse().toString();
			//the second call changes it back to its original form
			tmp2 = i.reverse().toString();

			//was the original string and its reverse equal
			if (tmp1.equals(tmp2)) {
				//then add them to the list
				palindromes.add(i);
			}
		}

		System.out.println(palindromes);
	}

}
