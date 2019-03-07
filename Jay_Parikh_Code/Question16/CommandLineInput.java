package Question16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineInput {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter a string, I will find the number of characters in it.");
		String str = reader.readLine();
		System.out.println(str.length());
		System.out.println("Thank You have a nice day");
	}

}
