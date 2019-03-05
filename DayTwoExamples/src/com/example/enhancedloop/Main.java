package com.example.enhancedloop;

import java.util.ArrayList;

public class Main {

	// what is an arraylist?
	// similar to an array but the size is not fixed
	// ArrayList can not contain primitive data types
	// it can only contains objects
	
	public static void main(String[] args) {
	
	ArrayList<String> names = new ArrayList<String>();
	
	names.add("Yousef");
	names.add("Jarod");
	names.add("Patrick");
	names.add("Andrew");
	names.add("David");
	
	for(String nm : names)		// "in"
		System.out.println(nm);
		
	}
	
	// enhanced for loops can be used on any
	// data structure in the Collection API
}
