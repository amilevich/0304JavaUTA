package question15;

public class Interfaces implements BasicMath {

	@Override
	public double add(double a, double b) {
		return a + b;
	}

	@Override
	public double sub(double a, double b) {
		return a - b;
	}

	@Override
	public double div(double a, double b) {
		if(b == 0)	throw new ArithmeticException("Cannot divide by zero!"); 
		return a / b;
	}

	@Override
	public double mlt(double a, double b) {
		return a * b;
	}

}
