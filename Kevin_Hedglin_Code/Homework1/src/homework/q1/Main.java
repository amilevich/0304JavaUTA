package homework.q1;

public class Main {

	public static void main(String[] args) {
		int[] arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int[] sorted = bubbleSort(arr);
		
		for(int i =0; i < sorted.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
	
	//bubble sort an integer array
	public static int[] bubbleSort(int[] arr)
	{
		int l = arr.length;
		for(int i = 0; i < l-1; i++)
		{
			for(int j = 0; j < l-i-1; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}

}
