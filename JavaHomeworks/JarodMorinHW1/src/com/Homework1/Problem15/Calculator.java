package com.Homework1.Problem15;

public class Calculator implements CanDoMath {

	
	@Override
	public int add(int x, int y) {			// addition method overrides that of CanDoMath
		return x + y;
	}

	@Override
	public int subtract(int x, int y) {		// subtraction method overrides that of CanDoMath
		return x - y;
	}

	@Override
	public int multiply(int x, int y) {		// overriding multiply in CanDoMath
		return x * y;
	}

	@Override
	public int divide(int x, int y) {		// overriding divide in CanDoMath
		return x / y;
	}

}
