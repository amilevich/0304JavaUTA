package Q15;

public class Q15 implements Q15Interface {
	
	float a,b;
	
	public Q15(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public float addition() {
	
		return this.a+this.b;
	}
	public float substraction() {
		return this.a-this.b;
	}
	public float multiplication() {
		return this.a*this.b;
	}
	public float division() {
			
		return this.a/this.b;
	}

}
