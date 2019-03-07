package Question4;

public class Factorial {

	public static void main(String[] args) {
		int N = 12;		//Set N which we will apply the factorial to
		int factorial = 1;	//factorial value we will multiply to
		for(int i = N; i >= 1; i--) {	//Loop that starts at N and moves in descending order from N to 1
			factorial *= i;			//Multiplication fact variable with itself times i
		}
		
		System.out.println(factorial);		//Print
		
	}

}
