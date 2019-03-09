package com.problem11package1;

import com.problem11package2.AccessTheseVars;

public class Main {

	public static void main(String[] args) {
		AccessTheseVars test1 = new AccessTheseVars(); //creates new class with the variables to be accessed
		System.out.println(test1.num1);  //prints num1
		System.out.println(test1.num2); //prints num2
	}

}
