package com.corejava.q20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HumanConverter
{

	public static void main(String[] args)
	{
		// target file must be in Java project folder (Java_HW)
		String filename = "Data.txt";		
		try(BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
			// iterate over each person in file
		    for(String line; (line = br.readLine()) != null; ) {
		    	// Isolate each field in a line
		    	String[] tokens = line.split(":");
		    	
		    	// Format and print results
		    	System.out.println("\nName: " + tokens[0] + " " + tokens[1]);
		    	System.out.println("Age: " + tokens[2] + " years");
		    	System.out.println("State: " + tokens[3] + " State");
		    }
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
