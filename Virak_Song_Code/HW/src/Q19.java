import java.util.ArrayList;

public class Q19 
{
	public static boolean checkPrime(Integer i)
	{
		if (i == 2)
			return true;
		
		
		for (int j = 2; j < i; j++)
		{
			//checks if i is divisible by anything up to itself 
			if (i%j == 0)
				return false;
		}
		
		
		return true;
	}
	public static void main(String[] args)
	{
		ArrayList<Integer> intList = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) 
		{
			intList.add(i);
		}
		System.out.println(intList);
		int evenSum = 0;
		int oddSum = 0;
		for (int i = 0; i < intList.size(); i++)
		{
			if (intList.get(i)%2 == 0)
			evenSum += intList.get(i);
		}
		System.out.println("Sum of even numbers: "+evenSum);
		for (int i = 0; i < intList.size(); i++)
		{
			if (intList.get(i)%2 != 0)
			oddSum += intList.get(i);
		}
		System.out.println("Sum of odd numbers: "+oddSum);
		
		
		for (int i = 0; i < intList.size(); i++)
		{
			if (checkPrime(intList.get(i)))
			{
				intList.remove(i);
				i = -1;
			}
		}
		//intList.remove(0);
		System.out.println(intList);		
	}

}

