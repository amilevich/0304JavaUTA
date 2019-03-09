package com.homework.question15;

public class Math implements calculator {

	@Override
	public int addition(int a, int b) {
		return  a+b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a - b;
	}

	@Override
	public int multiplicaton(int a, int b) {
		return a * b;
	}

	@Override
	public int division(int a, int b) {
		return a/b;
	}

}
