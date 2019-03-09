package Q18;

import java.util.Scanner;

public class subClass extends superClass {
static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		superClass sc = new subClass();//instantiated subClass extended by superClass
		System.out.println("Enter a string: \n");
			String string = scan.nextLine();//read user string input
			scan.close();
			
			//calls methods from super class
			sc.ConceptInfo();
			
			boolean check = sc.CheckUC(string);//variable from method return 
			System.out.println("\n Contains UpperCase Letters: " + check);
			
			String testString = sc.UpperCase(string); //variable from method return 
			System.out.println("\n String with all UpperCase: \n" + testString);
			
			int num = sc.Convert(string); //variable from method return 
			System.out.println("\n String Integer Notation with 10 added: " + num);
	}

	@Override
	public boolean CheckUC(String str) {
		boolean bool = false;//initialize bool variable
		String teststring = str.toUpperCase(); //create a new string to compare input string to
		for (int i = 0; i<str.length()-1 ;i++) 
		{//for each char in both strings push to temporary char variables
			char c = str.charAt(i);
			char tc = teststring.charAt(i);
			
			if(c == tc) {bool = true;break;} //if characters are equal, bool is true
		}

		return bool;//returns boolean bool
	}

	@Override
	public String UpperCase(String str) {
		String teststring = str.toUpperCase(); //converts characters in string to characters in uppercase string
		return teststring; //returns string teststring
	}

	@Override
	public int Convert(String str) {
		int num = Integer.parseInt(str);//converts string to Integer
		num = num + 10;//adds 10 to num integer
		return num; //returns int num
	}



}

