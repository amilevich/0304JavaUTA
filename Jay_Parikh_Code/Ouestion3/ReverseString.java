package Ouestion3;

public class ReverseString {
	
	public static void main(String[] args) {
		
		String s = "Hello";				//String
		char [] arr = s.toCharArray();	//convert string to array of characters
		for(int i = arr.length - 1; i >= 0 ; i--) {  //Loop that starts at array length - 1 and descends to 0 because we
													 // want to reverse from the last letter not from outside the array
			System.out.print(arr[i]);		//Print
		}
		
	}
}
