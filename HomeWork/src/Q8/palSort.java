package Q8;

import java.util.ArrayList;

public class palSort {

	//some print lines that are commented were only added for testing purposes then commented out
	
	public static void main(String[] args) {
		ArrayList<stringCon> str = new ArrayList<stringCon>(); //creates ArrayList
		str.add(new stringCon("karan")); // creates new stringCon objects with a string 
		str.add(new stringCon("madam")); //for the constructor and adds each instance to the array list
		str.add(new stringCon("tom"));
		str.add(new stringCon("civic"));
		str.add(new stringCon("radar"));
		str.add(new stringCon("sexes"));
		str.add(new stringCon("jimmy"));
		str.add(new stringCon("kayak"));
		str.add(new stringCon("john"));
		str.add(new stringCon("refer"));
		str.add(new stringCon("billy"));
		str.add(new stringCon("did"));
		
		ArrayList<stringCon> palindr = new ArrayList<stringCon>();//new list for palindromes
		System.out.println("All strings");
		
		for(stringCon sc : str) //for each stringCon object in str ArrayList
		{
			sc.setTag(CheckPal(sc.strg)); //set each string tag
			if (sc.getTag() == 1) //if assigned tag from CheckPal equals 1 than add to palindrome array
			{				
				palindr.add(sc);
			}	
			System.out.println(sc.strg);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Palindrome strings");
		for (stringCon sc : palindr) {System.out.println(sc.strg);}
	}
	
	//reverse the string
	//look at the string and create to separate char array 
	//compare both strings
static int CheckPal (String str) 
	{//method that checks for palindromes and returns 1 or 2 depending on output
		StringBuilder stringb = new StringBuilder();
		StringBuilder stringb2 = new StringBuilder();
		stringb.append(str);//first string
		stringb = stringb.reverse();//reverses first string
		stringb2 = stringb2.append(str);
	
		//System.out.println(stringb);
		//System.out.println(stringb2);
		boolean bool = stringb.toString().equals(str.toString());//are strings in both stringbuilders equal
		//System.out.println(bool);
		if(bool == true) {/*System.out.println("Its a palindrome");*/ return 1; }//if true or false assign a tag
		else {/*System.out.println("Its not a palindrome");*/ return 2;}
	}
	

}
