package Q4;

public class Factorial {

	public static void main(String[] args) {
		int n = 7;
		int fact = nFactorial(n);
		int fast = recursiveFactorial(n);
		System.out.println("Serial output: " + fact + "\nRecurs output: " + fast);
	}
	
	public static int nFactorial (int n) {
	    if(n < 0 || n > 12) throw new IllegalArgumentException("not happening");
		if (n == 0)	return 1;	//special case: 0! = 1
		int ans = 1; 			//var to track answer
		while(n != 0)			//decrementing after captures 1! case
			ans *= n--;			//ans = ans * n and decrements n
		return ans;
	}
	
	public static int recursiveFactorial(int n) {
	    if(n < 0 || n > 12) throw new IllegalArgumentException("not happening");
	    return (n <= 1) ? 1 : n * recursiveFactorial(n - 1);
	}
}
