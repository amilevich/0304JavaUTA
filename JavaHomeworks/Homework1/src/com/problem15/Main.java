package com.problem15;

public class Main {

	public static void main(String[] args) {
		OperationsInterface test1 = new OperationsClass();
		System.out.println(test1.addition(2, 4));
		System.out.println(test1.multiplication(2, 4));
	}

}
