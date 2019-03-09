package homework.q9;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//create a list and fill it with 1-100
		ArrayList<Integer> hundred = new ArrayList<Integer>();
		for(int i = 1; i < 101; i++)
		{
			hundred.add(i);
		}
		
		//get primes from the list and print them
		ArrayList<Integer> primes = getPrimes(hundred);
		System.out.println("primes: " + primes);
	}
	
	//iterate through an array list and return a list of primes contained within
	public static ArrayList<Integer> getPrimes(ArrayList<Integer> hundred)
	{
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int num : hundred)
		{
			//1 is not a prime
			if(num == 1)
			{
				continue;
			}
			
			//divide your number by each number > 2  and <= number/2
			// and if there is no remainder for any of those, then the
			//number is a prime
			boolean flag = false;
			int i = 2;
	        while(i <= num/2)
	        {
	            if(num % i == 0)
	            {
	                flag = true;
	                break;
	            }
	            ++i;
	        }
	
	        if (!flag)
	            primes.add(num);
		}
		
		return primes;
	}

}
