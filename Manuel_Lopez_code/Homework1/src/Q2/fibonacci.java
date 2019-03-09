package Q2;

public class fibonacci {
	
	public static void main(String[] args)
	{
		fibonacci(); //method call to fibonacci sequence which adds previous two integers
	}
	
	static void fibonacci()
	{
		int x=0, y=1;							//set first two integers
		System.out.print(x+", "+y+", ");		//print first two integers
		for(int i=1; i+1<7; i++)
		{
			int sum = x+y;						//add previous two integers and set to sum
			x=y;								//first integer is set to second integer
			y=sum;								//second integer is set to new sum
			System.out.print(sum+", ");			//print out new integer(sum)
		}
	}

}
