package Q19;

import java.util.ArrayList;

public class EvenNprime {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(); //ArrayList for all numbers
		
		for (int i = 1; i <= 10; i++) 
		{//adding element to list
			list.add(i);
		}
		
		System.out.print(list);
		
		//initializing variables, one to store sum of all even numbers, one to store sum of all odd numbers
		int even = 0;
		int odd = 0;
		
		for(Integer in : list) 
		{// for each integer in list add to respective variable if element is even or odd
			if (in%2==0) {even = even + in;}
			if (in%2!=0) {odd = odd + in;}
		}
		
		System.out.println("\n");
		System.out.println("Sum of Even Numbers: " + even);
		System.out.println("Sum of Odd Numbers: " + odd);
		System.out.println();
		
		ArrayList<Integer> plist = IP(list); //an Arraylist<Integer> of prime numbers created from IP method returned ArrayList<Integer>

		for (Integer ints : plist) //for each element in prime number array 
		{int j = list.size(); //get size of all numbers arrayList (list index changes as you remove elements) and run nested loop
			for (int i = 0; i< j-1; i++ ) //for each element in array list containing all numbers
			{
				if (ints == list.get(i)) //if integer in prime number arrray equals element in all numbers array
				{
					list.remove(i);//remove that number from all numbers arraylist list
				}
			}
		}
		
		System.out.println();
		System.out.println("New List: " + list);
		
		//System.out.println(nlist);
	}
	
	public static ArrayList<Integer> IP (ArrayList<Integer> AL) //takes in an Arraylist AL
	{	ArrayList<Integer> Prime = new ArrayList<Integer>(); //creates new arrayList
		boolean IP; //creates a boolean that keeps tab on if each element in AL is prime or not.
		for (int in : AL)// for each element in AL
		{
			IP = isPrime(in);//check if it is prime by calling isPrime method and push to bool IP
			if (in == 1) {continue;}// 1 is not a prime number
			if (IP == true) {Prime.add(in);}; //if IP is true, add element to ArrayList isPrime 
		}
		System.out.println();
		System.out.print("Second Array "+ Prime);
		return Prime; 
	}
	
	public static boolean isPrime(int n) {
	    int i;
	    for (i = 2; i < n; i++) {//given a integer n, check from 2 to n-1
	        if (n % i == 0) {//if no remainder, return false
	            return false;
	        }
	    }
	    return true; //otherwise return true
	}

}
