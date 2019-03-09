package com.homework.question2;

public class Q2
{
	public static void printSequence(int n,int currNum)
	{
		//prints out the sequence
		int sum;
		int prevNum = 0;
		for (int i = 0; i < n ; i++) 
		{
			//adds the current number and the previous number
			sum = prevNum + currNum;
			prevNum = currNum;
			currNum = sum;
			System.out.println(currNum);
			if(currNum == 0)
			{
				//Increments so it doesn't continuously add zeros
				currNum++;
				System.out.println(currNum);
			}
		}	
	}
	public static void main(String[] args)
	{
		int n = 25;
		int startSequence = 0;
		printSequence(n,startSequence);
	}

}
