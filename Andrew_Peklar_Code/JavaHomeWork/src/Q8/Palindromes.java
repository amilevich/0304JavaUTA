package Q8;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.IntStream;


public class Palindromes {
	
	//requisite ArrayLists
	private static ArrayList<String> Palindromes = new ArrayList<>();
	private static ArrayList<String> nonPalindromes = new ArrayList<>();
	
	//Strings to sort
	private static String[] wordBank  = {	"karan",	"madam",	"tom",		"civic",
						"radar",	"sexes",	"jimmy",	"kayak", 
						"john",		"refer",	"billy",	"did"	  };
	
	public static void main(String[] args) {
		//for each item in wordBank, add to either list 
		//depending on if it is a palindrome or not
		Arrays.stream(wordBank)
		      .forEach((x) -> ((isPalindrome(x)) ? Palindromes : nonPalindromes).add(x));
		
		//print both lists to check
		System.out.println(Palindromes);
		System.out.println(nonPalindromes);
	}
	
	private static boolean isPalindrome(String s) {
		//check half the word
		return IntStream.range(0, s.length()/2)
				.allMatch(i -> s.charAt(i) == s.charAt(s.length()-i-1));
	}
}
