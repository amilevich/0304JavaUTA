package com.corejavahw.q18;

public class Test {

	//program driver
	public static void main(String[] args) {

		//Instantiate extending class
		Super s = new Q18();
		//Initialize strings for testing
		String str = "Hello World";
		String str2 = "29";
		
		//print testing methods and actual values by calling methods from the exending class
		System.out.println("Testing method upperCaseCheck() with String 'Hello World'" 
				+ "\nupperCaseCheck: "+ s.upperCaseCheck(str));
		System.out.println("Testing method lowToUp() with String 'Hello World'"
			+ "\nloToUp: "+ s.lowToUp(str));
		System.out.println("Testing method stringToInt() with String '29' + 10"
			+ "\nstringToInt: " + s.stringToInt(str2));
	}

}
