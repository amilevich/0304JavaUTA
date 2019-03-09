package com.problem15;

public class OperationsClass implements OperationsInterface {

	@Override
	public int addition(int x, int y) {
		return x+y;
	}

	@Override
	public int subtraction(int x, int y) {
		return x-y;
	}

	@Override
	public int division(int x, int y) {
		return x/y;
	}

	@Override
	public int multiplication(int x, int y) {
		return x*y;
	}

}
