package question15;

public class Main {

	public static void main(String[] args) {
		
		//values to test
		double a = 9.0, b = 3.0;

		//create object
		Interfaces inYourFaces = new Interfaces();
		
		//test outputs
		System.out.println("Division:\t" + a +  " / " + b + " = " + inYourFaces.div(a, b));
		System.out.println("Addition:\t" + a +  " + " + b + " = " + inYourFaces.add(a, b));
		System.out.println("Subtraction:\t" + a +  " - " + b + " = " + inYourFaces.sub(a, b));
		System.out.println("Multiplication:\t" + a +  " * " + b + " = " + inYourFaces.mlt(a, b));
	}

}
