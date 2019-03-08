package question2;

public class FibonacciNumbers {
	
	public static void main(String[] args) {
		int[] fibArray = new int[25];
		
		fibArray[0] = 0;
		fibArray[1] = 1;
		
		System.out.println("First 25 Fibonacci numbers:");
		for(int i = 1; i<fibArray.length-1; i++) {
			fibArray[i+1] = fibArray[i] + fibArray[i-1];
		}
		for(int i = 0; i<fibArray.length-1; i++) {
			System.out.println(fibArray[i]);
		}
	}

}
