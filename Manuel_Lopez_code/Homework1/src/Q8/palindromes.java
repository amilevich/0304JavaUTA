package Q8;

import java.util.Arrays;
import java.lang.*;
import java.util.*;

public class palindromes {
	
	static String[] list = {"karan", "madam", "tom","civic", "radar","sexes","jimmy", "kayak", "john", "refer", "billy", "did"};
	static String[] palindromeList = new String[10];
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(list));
		System.out.println(Arrays.toString(palindromeList));
		palindrome();
		System.out.println(Arrays.toString(list));
		System.out.println(Arrays.toString(palindromeList));
		
		/*String pal = "madam";
		//String pal1 = "madam";
		StringBuilder x = new StringBuilder();
		StringBuilder y = new StringBuilder();
		x.append(pal);
		y.append(pal);
		//System.out.println(x);
		//System.out.println(y);
		y=y.reverse();
		System.out.println(y);
		if(x.toString().equals(y.toString()))
			System.out.println("Is a palindrome");
		else
			System.out.println("is not a palindrome");*/
		
		
		
	}
	
	public static void palindrome() {
		StringBuilder input = new StringBuilder();
		StringBuilder input1 = new StringBuilder();
		int counter =0;
		for(int i=0; i<list.length; i++) {
			//System.out.println(list[i]);
			input.append(list[i]);
			input1.append(list[i]);
			input1 = input1.reverse();
			String x = input.toString();
			String y = input1.toString();
			if(input.toString().equals(input1.toString())) {
				palindromeList[counter] = input.toString();
				counter++;
			}
			/*if(x.equals(y))
			{
				System.out.println("Palindrome");
			}*/
			
			//System.out.println(counter);
				
		}
		
		
	}
	

}
