package com.homework.question19;

import java.util.ArrayList;

public class evenandodd
{
	public static boolean prime(Integer integer)
	{
		for (int j = 2; j < integer; j++) {
			if (integer%j == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) 
	{
		int odds = 0;
		int evens = 0;
		ArrayList<Integer> home = new ArrayList<>();
		for (int i = 0; i <10; i++)
		home.add(i+1);
		
		System.out.println(home);
		
		for(int i = 0; i < 10; i++)
		{
			if (home.get(i) % 2 == 0) 
			{
				evens = home.get(i) + evens;
			}
			else 
			{
				odds = home.get(i) + odds;
			}
		}
		System.out.println(evens);
		System.out.println(odds);
		
		
		for (int i = 0; i < home.size(); i++) 
		{
			if (prime(home.get(i))) {
				//System.out.println(home.get(i));
				home.remove(i);
			}
		}
		System.out.println(home);
	}
}
