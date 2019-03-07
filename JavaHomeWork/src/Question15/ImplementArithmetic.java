package Question15;

public class ImplementArithmetic implements BasicArithmetic {

	//Methods that are implemented using basic arithmetic
	@Override
	public void sum(int i, int j) {
		System.out.println(i + j);
	}

	@Override
	public void subtract(int i, int j) {
		System.out.println(i - j);		
	}

	@Override
	public void multiply(int i, int j) {
		System.out.println(i * j);		
	}

	@Override
	public void divide(double i, double j) {
		System.out.println(i / j);		
	}

}
