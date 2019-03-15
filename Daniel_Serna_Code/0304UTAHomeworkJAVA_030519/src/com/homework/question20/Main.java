package com.homework.question20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Main {

	public static void main(String[] args) {
		// Q20. Create a notepad file called Data.txt and 
		// enter the following:  
		//
		// 	Mickey:Mouse:35:Arizona 
		// 	Hulk:Hogan:50:Virginia 
		// 	Roger:Rabbit:22:California 
		// 	Wonder:Woman:18:Montana 
				 
		// Write a program that would read from the file 
		// and print it out to the screen in the following
		// format: 
				 
				// Name: Mickey Mouse 
				// Age: 35 years 
				// State: Arizona State
				
//		String a = "Mickey:Mouse:35:Arizona"; 
//		String b = "Hulk:Hogan:50:Virginia"; 
//		String c = "Roger:Rabbit:22:California"; 
//		String d = "Wonder:Woman:18:Montana";
		
		String filename = "./TestFile.txt";
		
		// writeToFile(filename); // write to the file
		readFromFile(filename); 
		
	}
	
	// Reference: https://www.guru99.com/buffered-reader-in-java.html
	// Read from text file with while loop, and use for loop to organize output
	static void readFromFile(String filename)
	{
		BufferedReader fileReader = null; 
		String textFileLine = ""; 
		
		try {
			fileReader = new BufferedReader(new FileReader(filename));
			
			while((textFileLine = fileReader.readLine()) != null)
			{
				String [] myPlaceHolder = textFileLine.split(":"); 
				
				for(int j = 0; j < 4; j++)
				{
					if(j == 0)
					{
						System.out.println("Name: "+myPlaceHolder[0]+" "+myPlaceHolder[1]);
					}
					else if(j == 1)
					{
						System.out.println("Age: "+myPlaceHolder[2]);
					}
					else if(j == 3)
					{
						System.out.println("State: "+myPlaceHolder[3]+" State"); 
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void writeToFile(String filename)
	{
			
		
		FileWriter fw; 
		
		try
		{
			fw = new FileWriter(filename); 
			
			BufferedWriter bw; 
			
			bw = new BufferedWriter(fw); 
			System.out.println("Buffered Writer start writing :)");
			
			bw.write("Mickey:Mouse:35:Arizona");
			bw.newLine();
			
			bw.write("Hulk:Hogan:50:Virginia");
			bw.newLine();
			
			bw.write("Roger:Rabbit:22:California");
			bw.newLine(); 
			
			bw.write("Wonder:Woman:18:Montana");
			
			bw.close(); 
			System.out.println("Writing to text file complete");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
