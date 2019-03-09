package Q15;

public class mathOperations implements mathOps {
	//driver class with implemented methods

	static int x = 4;
	static int y = 5;
	public static void main(String[] args) {
		//I instantiated this object purely for learning purposes
		//I was confused on how the static keyword affected the methods
		//I understand how static is used now.
		mathOperations MO = new mathOperations();
		MO.addOp(x, y);
		MO.subOp(x, y);
		MO.multOp(x, y);
		MO.divOp(x, y);
	}

	//Overridden interface methods
	
	@Override
	public int addOp(int x, int y) {int z = x+y; 
	System.out.println("Addition: " + z);
	return z;
	}

	@Override
	public int subOp(int x, int y) {int z = x-y; 
	System.out.println("Subtraction: " + z);
	return z;
	}

	@Override
	public int multOp(int x, int y) {int z = x*y; 
	System.out.println("Multiplication: " + z);
	return z;
	}

	@Override
	public int divOp(int x, int y) {int z = x/y; 
	System.out.println("Division: " + z);
	return z;}


}
