package com.Homework1.Problem15;

public class Test {

	Calculator calcy = new Calculator(); // creating an object to utilize methods of calculator

	int x, y;

	Test(int x, int y) {
		this.x = x; // Test will accept two int arguments upon instantiation
		this.y = y; // these arguments are stored and used for its tests
	}

	void testAll() {				// Function tests all operations and displays result of test.
		if (this.testAddition())		
			System.out.println("Addition test passed.");
		else
			System.out.println("Addition test failed.");
						
		if (this.testSubtraction())
			System.out.println("Subtraction test passed.");
		else
			System.out.println("Subtraction test failed.");

		if (this.testMultiplication())
			System.out.println("Multiplication test passed.");
		else
			System.out.println("Multiplication test failed.");

		if (this.testDivision())
			System.out.println("Division test passed.");
		else
			System.out.println("Division test failed.");

	}

	boolean testAddition() {
		if (calcy.add(x, y) == x + y) // compare result of add function with expected result
			return true;				// operands are x and y of test object
		return false;
	}

	boolean testSubtraction() {
		if (calcy.subtract(x, y) == x - y) // compare result of subtract function with expected result
			return true;					// operands are x and y of test object
		return false;
	}

	boolean testMultiplication() {
		if (calcy.multiply(x, y) == x * y) // compare result of multiply function with expected result
			return true;					// operands are x and y of test object
		return false;
	}

	boolean testDivision() {
		if (calcy.divide(x, y) == x / y) // compare result of divide function with expected result
			return true;					// operands are x and y of test object
		return false;
	}

}
