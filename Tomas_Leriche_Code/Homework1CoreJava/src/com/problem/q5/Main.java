package com.problem.q5;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		String str = "This String is substringged";
		String subStr = subString(str, 10);
		System.out.println(subStr);
	}

	public static String subString(String strg, int n) {
		String out = "";
		String[] split = strg.split("");

		// I split the string and add it to an ArrayList
		ArrayList<String> alist = new ArrayList<String>();
		for (String string : split) {
			alist.add(string);
		}
		// from 0 to index create the output string
		for (int x = 0; x < n; x++) {
			out += alist.get(x);
		}

		return out;

	}
}
