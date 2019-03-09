package com.problem8;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String[]strArray = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		// created an array to loop through and append to the arrayList for efficiency
		
		ArrayList<String> listofNames = new ArrayList <> ();
		ArrayList<String> palindromes = new ArrayList <> ();
		
		for (String str: strArray) { //looped through the array and added to the arrayList
			listofNames.add(str);
		}
		
		for (String str: listofNames) {
			StringBuilder x = new StringBuilder(str);
			StringBuilder y = x; //need to build a copy of x because reverse method changes the type
			if(y.toString().equals( x.reverse().toString())) { //note: == didn't work but .equals did
				palindromes.add(str);
			}
		}
		
		System.out.println(listofNames);
		System.out.println(palindromes);
		

	}
		

}
