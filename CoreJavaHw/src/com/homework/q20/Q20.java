package com.homework.q20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q20 {

	public static void main(String[] args) {

		try {
		@SuppressWarnings("resource")
		
		BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
	       String line;
	       
	       //loop that reads the file, splits the string into tokens and formats them. 
			while((line = reader.readLine()) != null) {
			       String tokens[] = line.split(":");
			       System.out.println("Name: " + tokens[0]+ " " + tokens[1]);
			       System.out.println("Age: " + tokens[2] + " years");
			       System.out.println("State: " + tokens[3] + " State\n");
			   }
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}

}
