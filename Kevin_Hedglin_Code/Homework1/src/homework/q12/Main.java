package homework.q12;

public class Main {

	public static void main(String[] args) {
		
		int[] arr = new int[100];
		
		//fill array with 1 - 100
		for(int i = 0; i < 100; i++)
		{
			arr[i] = i + 1;
		}
		
		//print all even numbers
		for(int i : arr)
		{
			if(i % 2 == 0)
			{
				System.out.println(i);
			}
		}
	}

}
