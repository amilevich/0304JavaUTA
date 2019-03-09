package Q4;
import java.util.Scanner;

public class Nfactorial {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("What N Factorial do you want?");
		int num = scan.nextInt(); //reads user input
		int total = num; //first num in pattern stored in a variable
		for (int i = 1; i < num - 1; i++) 
		{//iterates from second entry to last entry
			int holder = num - i; //variable to decrement by one as index increases
			total = total * holder; //multiplies n to (n-1) on first iteration and pushes into total
									//then on every other iteration, the entire previous sum is 
									//multiplied the to the holder variable and pushed into total			
		}
		System.out.println("Youre total is: " + total);

	}

}
