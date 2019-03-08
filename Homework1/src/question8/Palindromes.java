//may the Lord have mercy on my soul

package question8;

import java.util.ArrayList; //import this package in order to use ArrayList

public class Palindromes {
	
	public static void main(String[] args) {
		ArrayList regularArray = new ArrayList(); //ArrayList class
		regularArray.add("karan");
		regularArray.add("madam");
		regularArray.add("tom");
		regularArray.add("civic");
		regularArray.add("radar");
		regularArray.add("sexes");
		regularArray.add("jimmy");
		regularArray.add("kayak");
		regularArray.add("john");
		regularArray.add("refer");
		regularArray.add("billy");
		regularArray.add("did");
		
		String[] tempArray0 = new String[12];
		String[] tempArray1 = new String[12];
		String[] tempArray2 = new String[12];
		String[] tempArray3 = new String[12];
		String[] tempArray4 = new String[12];
		String[] tempArray5 = new String[12];
		String[] tempArray6 = new String[12];
		String[] tempArray7 = new String[12];
		String[] tempArray8 = new String[12];
		String[] tempArray9 = new String[12];
		String[] tempArray10 = new String[12];
		String[] tempArray11 = new String[12];
		
		//0
		tempArray0[0] = String.valueOf(regularArray.get(0)); //String.valueOf() converts the "karan" object in regularArray.get(0) into a string
		char[] charArray0 = tempArray0[0].toCharArray(); //.toCharArray() converts the "karan" string inside tempArray[0] into an array of characters (letters)
		char[] originalArray0 = tempArray0[0].toCharArray(); //initialize a new character array called "originalArray" to store the original value of tempArray
		//char[] originalArray = charArray; //this does NOT work; changing charArray will result in originalArray being changed too
		
		int j0 = 1;
		for(int i = 0; i<charArray0.length - 1; i++) {
			charArray0[i] = charArray0[charArray0.length - j0];
			j0++;
		}
		
		String charArray02 = String.valueOf(charArray0);
		String originalArray02 = String.valueOf(originalArray0);
		
		System.out.println(originalArray02);
		System.out.println(charArray02);
		
		if(originalArray02.equals(charArray02)) {
			System.out.println(String.valueOf(originalArray0) + " is a palindrome");
		}
		else {
			System.out.println(String.valueOf(originalArray0) + " is NOT a palindrome");
		}
		//1
		tempArray1[1] = String.valueOf(regularArray.get(1)); //String.valueOf() converts the "karan" object in regularArray.get(0) into a string
		char[] charArray1 = tempArray1[1].toCharArray(); //.toCharArray() converts the "karan" string inside tempArray[0] into an array of characters (letters)
		char[] originalArray1 = tempArray1[1].toCharArray(); //initialize a new character array called "originalArray" to store the original value of tempArray
		//char[] originalArray = charArray; //this does NOT work; changing charArray will result in originalArray being changed too
		
		int j1 = 1;
		for(int i = 0; i<charArray1.length - 1; i++) {
			charArray1[i] = charArray1[charArray1.length - j1];
			j1++;
		}
		
		String charArray12 = String.valueOf(charArray1);
		String originalArray12 = String.valueOf(originalArray1);
		
		System.out.println(originalArray12);
		System.out.println(charArray12);
		
		if(originalArray12.equals(charArray12)) {
			System.out.println(String.valueOf(originalArray1) + " is a palindrome");
		}
		else {
			System.out.println(String.valueOf(originalArray1) + " is NOT a palindrome");
		}
		//2
		tempArray2[2] = String.valueOf(regularArray.get(2)); //String.valueOf() converts the "karan" object in regularArray.get(0) into a string
		char[] charArray2 = tempArray2[2].toCharArray(); //.toCharArray() converts the "karan" string inside tempArray[0] into an array of characters (letters)
		char[] originalArray2 = tempArray2[2].toCharArray(); //initialize a new character array called "originalArray" to store the original value of tempArray
		//char[] originalArray = charArray; //this does NOT work; changing charArray will result in originalArray being changed too
		
		int j2 = 1;
		for(int i = 0; i<charArray2.length - 1; i++) {
			charArray2[i] = charArray2[charArray2.length - j2];
			j1++;
		}
		
		String charArray22 = String.valueOf(charArray2);
		String originalArray22 = String.valueOf(originalArray2);
		
		System.out.println(originalArray22);
		System.out.println(charArray22);
		
		if(originalArray22.equals(charArray22)) {
			System.out.println(String.valueOf(originalArray2) + " is a palindrome");
		}
		else {
			System.out.println(String.valueOf(originalArray2) + " is NOT a palindrome");
		}
		//3
		tempArray3[3] = String.valueOf(regularArray.get(3)); //String.valueOf() converts the "karan" object in regularArray.get(0) into a string
		char[] charArray3 = tempArray3[3].toCharArray(); //.toCharArray() converts the "karan" string inside tempArray[0] into an array of characters (letters)
		char[] originalArray3 = tempArray3[3].toCharArray(); //initialize a new character array called "originalArray" to store the original value of tempArray
		//char[] originalArray = charArray; //this does NOT work; changing charArray will result in originalArray being changed too
		
		int j3 = 1;
		for(int i = 0; i<charArray3.length - 1; i++) {
			charArray3[i] = charArray3[charArray3.length - j3];
			j3++;
		}
		
		String charArray32 = String.valueOf(charArray3);
		String originalArray32 = String.valueOf(originalArray3);
		
		System.out.println(originalArray32);
		System.out.println(charArray32);
		
		if(originalArray32.equals(charArray32)) {
			System.out.println(String.valueOf(originalArray3) + " is a palindrome");
		}
		else {
			System.out.println(String.valueOf(originalArray3) + " is NOT a palindrome");
		}
		//4
		tempArray4[4] = String.valueOf(regularArray.get(4)); //String.valueOf() converts the "karan" object in regularArray.get(0) into a string
		char[] charArray4 = tempArray4[4].toCharArray(); //.toCharArray() converts the "karan" string inside tempArray[0] into an array of characters (letters)
		char[] originalArray4 = tempArray4[4].toCharArray(); //initialize a new character array called "originalArray" to store the original value of tempArray
		//char[] originalArray = charArray; //this does NOT work; changing charArray will result in originalArray being changed too
		
		int j4 = 1;
		for(int i = 0; i<charArray4.length - 1; i++) {
			charArray4[i] = charArray4[charArray4.length - j4];
			j4++;
		}
		
		String charArray42 = String.valueOf(charArray4);
		String originalArray42 = String.valueOf(originalArray4);
		
		System.out.println(originalArray42);
		System.out.println(charArray42);
		
		if(originalArray42.equals(charArray42)) {
			System.out.println(String.valueOf(originalArray4) + " is a palindrome");
		}
		else {
			System.out.println(String.valueOf(originalArray4) + " is NOT a palindrome");
		}
		//5
		tempArray5[5] = String.valueOf(regularArray.get(5)); //String.valueOf() converts the "karan" object in regularArray.get(0) into a string
		char[] charArray5 = tempArray5[5].toCharArray(); //.toCharArray() converts the "karan" string inside tempArray[0] into an array of characters (letters)
		char[] originalArray5 = tempArray5[5].toCharArray(); //initialize a new character array called "originalArray" to store the original value of tempArray
		//char[] originalArray = charArray; //this does NOT work; changing charArray will result in originalArray being changed too
		
		int j5 = 1;
		for(int i = 0; i<charArray5.length - 1; i++) {
			charArray5[i] = charArray5[charArray5.length - j5];
			j5++;
		}
		
		String charArray52 = String.valueOf(charArray5);
		String originalArray52 = String.valueOf(originalArray5);
		
		System.out.println(originalArray52);
		System.out.println(charArray52);
		
		if(originalArray52.equals(charArray52)) {
			System.out.println(String.valueOf(originalArray5) + " is a palindrome");
		}
		else {
			System.out.println(String.valueOf(originalArray5) + " is NOT a palindrome");
		}
		//6
		tempArray6[6] = String.valueOf(regularArray.get(6)); //String.valueOf() converts the "karan" object in regularArray.get(0) into a string
		char[] charArray6 = tempArray6[6].toCharArray(); //.toCharArray() converts the "karan" string inside tempArray[0] into an array of characters (letters)
		char[] originalArray6 = tempArray6[6].toCharArray(); //initialize a new character array called "originalArray" to store the original value of tempArray
		//char[] originalArray = charArray; //this does NOT work; changing charArray will result in originalArray being changed too
		
		int j6 = 1;
		for(int i = 0; i<charArray6.length - 1; i++) {
			charArray6[i] = charArray6[charArray6.length - j6];
			j6++;
		}
		
		String charArray62 = String.valueOf(charArray6);
		String originalArray62 = String.valueOf(originalArray6);
		
		System.out.println(originalArray62);
		System.out.println(charArray62);
		
		if(originalArray62.equals(charArray62)) {
			System.out.println(String.valueOf(originalArray6) + " is a palindrome");
		}
		else {
			System.out.println(String.valueOf(originalArray6) + " is NOT a palindrome");
		}
		//7
		tempArray7[7] = String.valueOf(regularArray.get(7)); //String.valueOf() converts the "karan" object in regularArray.get(0) into a string
		char[] charArray7 = tempArray7[7].toCharArray(); //.toCharArray() converts the "karan" string inside tempArray[0] into an array of characters (letters)
		char[] originalArray7 = tempArray7[7].toCharArray(); //initialize a new character array called "originalArray" to store the original value of tempArray
		//char[] originalArray = charArray; //this does NOT work; changing charArray will result in originalArray being changed too
		
		int j7 = 1;
		for(int i = 0; i<charArray7.length - 1; i++) {
			charArray7[i] = charArray7[charArray7.length - j7];
			j7++;
		}
		
		String charArray72 = String.valueOf(charArray7);
		String originalArray72 = String.valueOf(originalArray7);
		
		System.out.println(originalArray72);
		System.out.println(charArray72);
		
		if(originalArray72.equals(charArray72)) {
			System.out.println(String.valueOf(originalArray7) + " is a palindrome");
		}
		else {
			System.out.println(String.valueOf(originalArray7) + " is NOT a palindrome");
		}
		//8
		tempArray8[8] = String.valueOf(regularArray.get(8)); //String.valueOf() converts the "karan" object in regularArray.get(0) into a string
		char[] charArray8 = tempArray8[8].toCharArray(); //.toCharArray() converts the "karan" string inside tempArray[0] into an array of characters (letters)
		char[] originalArray8 = tempArray8[8].toCharArray(); //initialize a new character array called "originalArray" to store the original value of tempArray
		//char[] originalArray = charArray; //this does NOT work; changing charArray will result in originalArray being changed too
		
		int j8 = 1;
		for(int i = 0; i<charArray8.length - 1; i++) {
			charArray8[i] = charArray8[charArray8.length - j8];
			j8++;
		}
		
		String charArray82 = String.valueOf(charArray8);
		String originalArray82 = String.valueOf(originalArray8);
		
		System.out.println(originalArray82);
		System.out.println(charArray82);
		
		if(originalArray82.equals(charArray82)) {
			System.out.println(String.valueOf(originalArray8) + " is a palindrome");
		}
		else {
			System.out.println(String.valueOf(originalArray8) + " is NOT a palindrome");
		}
		//9
		tempArray9[9] = String.valueOf(regularArray.get(9)); //String.valueOf() converts the "karan" object in regularArray.get(0) into a string
		char[] charArray9 = tempArray9[9].toCharArray(); //.toCharArray() converts the "karan" string inside tempArray[0] into an array of characters (letters)
		char[] originalArray9 = tempArray9[9].toCharArray(); //initialize a new character array called "originalArray" to store the original value of tempArray
		//char[] originalArray = charArray; //this does NOT work; changing charArray will result in originalArray being changed too
		
		int j9 = 1;
		for(int i = 0; i<charArray9.length - 1; i++) {
			charArray9[i] = charArray9[charArray9.length - j9];
			j9++;
		}
		
		String charArray92 = String.valueOf(charArray9);
		String originalArray92 = String.valueOf(originalArray9);
		
		System.out.println(originalArray92);
		System.out.println(charArray92);
		
		if(originalArray92.equals(charArray92)) {
			System.out.println(String.valueOf(originalArray9) + " is a palindrome");
		}
		else {
			System.out.println(String.valueOf(originalArray9) + " is NOT a palindrome");
		}
		//10
		tempArray10[10] = String.valueOf(regularArray.get(10)); //String.valueOf() converts the "karan" object in regularArray.get(0) into a string
		char[] charArray10 = tempArray10[10].toCharArray(); //.toCharArray() converts the "karan" string inside tempArray[0] into an array of characters (letters)
		char[] originalArray10 = tempArray10[10].toCharArray(); //initialize a new character array called "originalArray" to store the original value of tempArray
		//char[] originalArray = charArray; //this does NOT work; changing charArray will result in originalArray being changed too
		
		int j10 = 1;
		for(int i = 0; i<charArray10.length - 1; i++) {
			charArray10[i] = charArray10[charArray10.length - j10];
			j10++;
		}
		
		String charArray102 = String.valueOf(charArray10);
		String originalArray102 = String.valueOf(originalArray10);
		
		System.out.println(originalArray102);
		System.out.println(charArray102);
		
		if(originalArray102.equals(charArray102)) {
			System.out.println(String.valueOf(originalArray10) + " is a palindrome");
		}
		else {
			System.out.println(String.valueOf(originalArray10) + " is NOT a palindrome");
		}
		//11
		tempArray11[11] = String.valueOf(regularArray.get(11)); //String.valueOf() converts the "karan" object in regularArray.get(0) into a string
		char[] charArray11 = tempArray11[11].toCharArray(); //.toCharArray() converts the "karan" string inside tempArray[0] into an array of characters (letters)
		char[] originalArray11 = tempArray11[11].toCharArray(); //initialize a new character array called "originalArray" to store the original value of tempArray
		//char[] originalArray = charArray; //this does NOT work; changing charArray will result in originalArray being changed too
		
		int j11 = 1;
		for(int i = 0; i<charArray11.length - 1; i++) {
			charArray11[i] = charArray11[charArray11.length - j11];
			j11++;
		}
		
		String charArray112 = String.valueOf(charArray11);
		String originalArray112 = String.valueOf(originalArray11);
		
		System.out.println(originalArray112);
		System.out.println(charArray112);
		
		if(originalArray112.equals(charArray112)) {
			System.out.println(String.valueOf(originalArray11) + " is a palindrome");
		}
		else {
			System.out.println(String.valueOf(originalArray11) + " is NOT a palindrome");
		}
	}
}