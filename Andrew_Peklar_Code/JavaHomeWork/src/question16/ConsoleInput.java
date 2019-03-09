package question16;

import java.util.Arrays;

public class ConsoleInput {
	// Takes input and concatenates them into one string for counting
	// Example: [hello, World] --> helloworld --> 10 characters
	public static void main(String[] args) {
		System.out.println(Arrays.stream(args)
					 .reduce("", String::concat)
					 .length());
	}
}



//White space inclusive version:
//System.out.println(Arrays.stream(args)
//			   .reduce("", String::concat)
//                         .length() + args.length-1);
