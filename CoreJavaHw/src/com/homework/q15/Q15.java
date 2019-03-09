package com.homework.q15;

public class Q15 implements MathInterface{


	//implementing the abstract methods from MathInterface
	
	//method for subtracting two numbers & printing the result
	@Override
	public void subtract(int x, int y) {
		
		int q = x - y;
		System.out.println(q);
		
	}

	//method for adding two numbers & printing the result
	@Override
	public void add(int x, int y) {
	
		int q = x + y;
		System.out.println(q);
	}

	//method for multiplying two numbers & printing the result
	@Override
	public void multiply(int x, int y) {
	
		int q = x * y;
		System.out.println(q);
	}

	//method for dividing two numbers & printing the results 
	@Override
	public void divide(int x, int y) {
		
		int q = x / y;
		System.out.println(q);
	}
	
	public static void main(String[] args) {
		
		int x = 4;
		int y = 6;
		
		//creating a new object 
		Q15 obj = new Q15(); 
		
	
		obj.add(x, y);
		obj.subtract(x, y);
		obj.multiply(x, y);
		obj.divide(x, y);
		
	
	}
}
