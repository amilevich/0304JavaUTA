package Q5;
import java.util.Scanner;
public class sbStr {
static Scanner scan = new Scanner(System.in);
	public static void main (String[] args) 
	{
		System.out.println("Enter a string");
		String str = scan.nextLine();//Read Integer
		System.out.println("Enter a Integer");
		int num = scan.nextInt();//Read Index number
		int i = 0;//initialize index
		
		while (i < num) 
		{//As long as i is less than index
			
			if (str == null) {break;} //if string is null break
			if (num > i) 
			{
				System.out.println("Can't be done");
				break;
			}
			System.out.print(str.charAt(i)); //print out characters in string			
			i++;//increment index by one
			
		}
		
	}
}
