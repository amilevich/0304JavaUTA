package com.example.problem20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) throws FileNotFoundException {
		File names = new File( System.getProperty("user.dir")+"\\src\\Names.txt");
		Scanner reader = new Scanner(names);
		
		while(reader.hasNextLine()) {
			String line = reader.nextLine();
			String[] tokens = line.split(":");
			
			System.out.println("Name: " + tokens[0] + " " + tokens[1]);
			System.out.println("Age: " + tokens[2]);
			System.out.println("State: " + tokens[3] + " State");
			System.out.println("");
			
		}
		
		reader.close();
		
	}

}
