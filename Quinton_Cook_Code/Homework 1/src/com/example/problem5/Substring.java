package com.example.problem5;

public class Substring {

	public static void main(String[] args) {
		String text = new String("substring me!");
		int idx = 5;
		
		char[] substring = new char[idx];
		
		for(int i = 0; i < idx; i++) {
			substring[i] = text.charAt(i);
		}
		
		System.out.println(substring);
	}

}
