package com.example.problem15;

public class FourFunction implements Arithmetic {

	@Override
	public double add(double arg1, double arg2) {
		return arg1 + arg2;
	}

	/*
	 * this multiplies argument two by negative one then passes the result to add
	 * 
	 */
	@Override
	public double subtract(double arg1, double arg2) {
		return add(arg1, (-1) * arg2);
	}

	@Override
	public double multiply(double arg1, double arg2) {
		return arg1 * arg2;
	}

	/*
	 * this takes the repicrocal of argument two and the passes the two numbers to
	 * multiply
	 * 
	 */
	@Override
	public double divide(double arg1, double arg2) {
		return multiply(arg1, Math.pow(arg2, -1));
	}

}
