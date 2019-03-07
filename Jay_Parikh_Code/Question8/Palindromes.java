package Question8;

import java.util.ArrayList;

public class Palindromes {

	public static void main(String[] args) {
		
		//Lists
		ArrayList<String> notPalindromes = new ArrayList<String>(); 
		ArrayList<String> palindromes = new ArrayList<String>();
		
		//List to sort
		String[] words = {"karan", "madam",	"tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",	"refer", "billy", "did"}; 
		
		for(int i = 0; i < words.length; i++) {			//Loop through array of words
			boolean bo = false;							//boolean checker
			String str = new String();		
			str = words[i];								//str becomes each name as we loop through "words" array
			int y = str.length();						// y becomes the length
			for(int j = 0; j < words[i].length()/2 - 1; j++) { //Loop through half the length of a specific name in the array	
				if(str.charAt(j) == str.charAt(y - j - 1)) {	//Palindrome check
					bo = true;										//boolean check, 0 is true
				}
			}
			if(bo) {				//if true then add the palindrome to the list
				palindromes.add(str);
			}else {
				notPalindromes.add(str);	//if not then add to not palindrome list
			}
		}
		
		//print statements
		System.out.println("***Palindromes***");			
		for(int l = 0; l < palindromes.size(); l++) {
			System.out.println(palindromes.get(l));
		}
		System.out.println();
		
		System.out.println("***Not Palindromes***");
		for(int m = 0; m < notPalindromes.size(); m++) {
			System.out.println(notPalindromes.get(m));
		}

	}

}
