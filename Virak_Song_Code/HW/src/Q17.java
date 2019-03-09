import java.util.Scanner;  // Import the Scanner class
public class Q17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter Principal");
	    float Prin = input.nextFloat();   // Read user input
	    
	    System.out.println("Enter Rate %");
	    float Rate = input.nextFloat();   // Read user input
	    
	    System.out.println("Enter Time");
	    float Time = input.nextFloat();  // Read user input
	    
	    System.out.println("Your interest is $: " + Prin * Rate * Time);  // Output user input
	    
	    input.close();
	}

}


