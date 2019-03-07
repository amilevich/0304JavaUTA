package Question15;

public class Main {

	public static void main(String[] args) {
		
		//starting variables
		int i = 10;
		int j = 5;
		
		//Creating object of type ImplementArithmetic so we can use the math functions created
		ImplementArithmetic numbers = new ImplementArithmetic();
		
		//Implementing atleast two of the methods
		//numbers.sum(i, j);
		numbers.subtract(i, j);
		//numbers.multiply(i, j);
		numbers.divide(i, j);
	}

}
