package com.homework.q05;

public class Main {

	public static void main(String[] args) {

		System.out.println(SubString("Hello,World!", 3));		//Substring 
	}

	public static String SubString(String str, int idx) {	
		String outString = "";									//Creates space before string outputs
		for (int i = 0; i <= idx - 1; i++) {					//Calculates first character in string until the index minus 1
			outString += str.charAt(i);
		}
		return outString;
	}
}