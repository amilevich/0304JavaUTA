package homework.q2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fibNums = getFibonacciNumbers();
		//print fibonacci numbers
		for(int i = 0; i < fibNums.length; i++)
		{
			System.out.print(fibNums[i] + " ");
		}
	}
	
	public static int[] getFibonacciNumbers()
	{
		int[] fibNums = new int[25];
		
		//start with 0 and 1
		fibNums[0] = 0;
		fibNums[1] = 1;
		
		//generate fibonacci numbers
		for(int i = 2; i < 25; i++)
		{
			fibNums[i] = fibNums[i -1] + fibNums[i - 2];
		}
		return fibNums;
	}
}
