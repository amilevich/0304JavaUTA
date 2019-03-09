package Q9;

import java.util.ArrayList;

public class primeNum {

	public static void main(String[] args) 
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 1; i<= 100; i++) {al.add(i);}	
		System.out.print("First Array "+ al);
		IP(al);
	}

	public static void IP (ArrayList<Integer> AL) 
	{	ArrayList<Integer> Prime = new ArrayList<Integer>();
		boolean IP;
		for (int in : AL)
		{
			IP = isPrime(in);
			if (in == 1) {continue;}
			if (IP == true) {Prime.add(in);};
		}
		System.out.println();
		System.out.print("Second Array "+ Prime);
	}
	
	public static boolean isPrime(int n) {
	    int i;
	    for (i = 2; i < n; i++) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
}	