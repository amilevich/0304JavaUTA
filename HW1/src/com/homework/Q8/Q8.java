package com.homework.Q8;
/* Christopher Collins
 * Storing Names and Palindromes
 */

import java.util.ArrayList;

public class Q8 {

	public static void main(String[] args) {
		
		ArrayList<String> Boo = new ArrayList();
		ArrayList<String> Pal = new ArrayList();
		
		Boo.add("karan");
		Boo.add("madam");
		Boo.add("tom");
		Boo.add("civic");
		Boo.add("radar");
		Boo.add("sexes");
		Boo.add("jimmy");
		Boo.add("kayak");
		Boo.add("john");
		Boo.add("refer");
		Boo.add("billy");
		Boo.add("did");
		
		
		for(int M = 0; M<Boo.size(); M++ ) {
			String Temp = Boo.get(M);
			String REV = "";
			for(int L = Temp.length() - 1; L >=0; L-- ) {
				REV = REV + Temp.charAt(L);			
			}
			if(Temp.equals(REV)) {
				Pal.add(REV);
			}
			
		}
		
		System.out.println("**1st Array**");
		for(int D = 0; D < Boo.size(); D++) {
			System.out.println(Boo.get(D));
		}
		
		System.out.println("**Palindrome Array**");
		for(int D = 0; D < Pal.size(); D++) {
			System.out.println(Pal.get(D));
		}
	}

}
