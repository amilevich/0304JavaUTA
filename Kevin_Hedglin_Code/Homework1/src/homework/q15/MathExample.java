package homework.q15;

public class MathExample implements MathInterface {

	public MathExample() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float addition(float a, float b) {
		return a+b;
	}

	@Override
	public float subtraction(float a, float b) {
		return a - b;
	}

	@Override
	public float multiplication(float a, float b) {
		return a * b;
		
	}

	@Override
	public float division(float a, float b) {
		return a / b;
	}

}
