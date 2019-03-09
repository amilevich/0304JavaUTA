package Q1;

public class BubbleSort {

	static int[] Q1array = new int[] {1,0,5,6,3,2,3,7,9,8,4}; //creates array
	
	public static void main(String[] args) 
	{
		Sort(Q1array); //Calls array sort
		
		//start of print
		System.out.print("Q1array: " + " [");
		
		for (int i = 0;i < Q1array.length; i++) 
		{
			System.out.print(Q1array[i]);			
		}
		
		System.out.print("]");
		//end of print
	}

	public static void Sort (int [] array) //Sort function takes in an array as parameter
	{
		for (int i = 0; i < (array.length -1); i++) 
		{	//for first element through the second to last element execute nested loop
			for (int j = 0; j < (array.length - i - 1); j++) 
			{	//for first element to second to last (minus the number parent loop iterations), perform nested loop
				if (array[j] > array[++j]) 
					{	//if current array element is greater than element on the right, swap places
						int holder = array[j]; // holder variable for current element
						array[j] = array[++j]; //next element overwrites current element
						array[++j] = holder; //next element is overwritten with holder variable
					}
			}
		}

	}
}
