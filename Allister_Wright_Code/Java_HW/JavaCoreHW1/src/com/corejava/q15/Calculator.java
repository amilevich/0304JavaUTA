package com.corejava.q15;

public class Calculator implements MathInterface
{
	// use default constructor
	
	@Override
	public double add(double x, double y)
	{
		return x + y;
	}

	@Override
	public double subtract(double x, double y)
	{
		return x - y;
	}

	@Override
	public double multiply(double x, double y)
	{
		return x * y;
	}

	@Override
	public double divide(double x, double y)
	{
		return x / y;
	}

}
