package homework.q16;

public class Main {

	public static void main(String[] args) {
		
		//take the command line arguments and print their lengths
		for(int i = 0; i < args.length; i++)
		{
			System.out.println("The length of String " + args[i] + 
					" is " + args[i].length());
		}
	}

}
