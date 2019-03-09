package Q16;


public class commandLine {
	
	public static void main (String[] args) 
	{
		//Arguments were passed in the Run configurations 
		
		System.out.println("The printed arguments as strings");
		for (String str : args) {//prints out arguments as strings
			System.out.print(str); 
		}
		System.out.println();
		System.out.println("The printed arguments character by character");
		for (String str : args) { //accesses each string in args string array
		for (int i = 0; i< str.length(); i++) 
		{//for each string print out each char on at a time.
			System.out.print(str.charAt(i) + "  "); 
		}
		}
	}
}
