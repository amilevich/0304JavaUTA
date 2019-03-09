package Q3;
import java.util.Scanner;

public class Reverse {
	static Scanner scan = new Scanner(System.in);//instantiates scanner
	

	public static void main(String[] args) 
	{
		System.out.println("Enter a string if you dare.");
		String str = scan.nextLine(); //reads user input
		System.out.println("This your string: " + str);
		StringBuilder sb = Flip(str); //calls flip method while instantiating a stringbuilder equal
									  //equal to the Flip method output
		System.out.println("This is the Reverse:" + sb);//prints result
	}
	
	static StringBuilder Flip (String string ) 
	{
		char[] chars = new char[string.length()];
		StringBuilder strBuild = new StringBuilder();// makes string builder
		strBuild.setLength(string.length());
		for (int i = chars.length -1; i == 0; i-- ) 
		{// for the end to the beginning of user's string
			chars[i] = string.charAt(i); // current string value is push into char [] chars
										//char ch is added to the string builder
		}
		strBuild.append(chars.toString());//char [] char is converted to a string and push to the stringbuilder
		return strBuild;
	}

}
