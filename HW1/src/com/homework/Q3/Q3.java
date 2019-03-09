package com.homework.Q3;
/* Christopher Collins
 * String Reverse
 */

public class Q3 {
	
	public static void main(String[] args) {
		
		// Established String
		String Champ = "AND HIS NAME IS JOHN CENA!!!";
		// Create string for reverse to go into
		String Pmahc = "";
		
		// Print Original string
		System.out.println(Champ);
		
		// Reverse String
		for(int T = Champ.length() - 1; T >=0; T-- ) {
			Pmahc = Pmahc + Champ.charAt(T);
		}
		
		// Print Reverse
		System.out.println(Pmahc);
		
	}

}
