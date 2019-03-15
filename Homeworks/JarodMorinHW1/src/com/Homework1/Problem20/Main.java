package com.Homework1.Problem20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> strList = new ArrayList<String>();
		String fileName = "./Data.txt";						// setting string so that Data text file will be read
		readCharacterStream(fileName, strList);				// call function that stores each line of the text file
															// as a separate string in the string arraylist 2nd argument
		
		for(String origStr : strList) {
			int index = origStr.indexOf(":");				// searching for first ':' as an endpoint for the firstname
			String first = origStr.substring(0,index);		// create a substring from the beginning of the line
															// to just before the index of the first :, which is the 
															// corresponds to the first name, and store it in first
			
			int index2 = origStr.indexOf(":",index+1);		// find the first occurrence of ':' after the location of 
															// the previous one, which is the second occurence
															// this serves as the endpoint for the last name
			String last = origStr.substring(index+1,index2);// Use the previous index +1 as a startpoint for the 
															// substring and index2 as an endpoint to get last name
			index = index2;
			index2 = origStr.indexOf(":",index+1);			// the same process as above is repeated, where the location
															// of the next element is a substring from index+1 to index2
			int age = Integer.parseInt(origStr.substring(index+1,index2));
															// this time we need an int for age, so we use the
															// parseInt method in the integer class to convert 
															// from String to int
			String state = origStr.substring(index2+1,origStr.length());
															// finally, the remaining substring in origStr after the 
															// 3rd colon corresponds to the user's state
			System.out.println("Name: " + first + " " + last);
			System.out.println("Age: " + age + " years");
			System.out.println("State: " + state + " State\n");	// These sysout statements follow the format of the 
																// example and substitute the appropriate variables
																// that we found above into the output
		}
		
	}
	
	static void readCharacterStream(String filename, ArrayList<String> strList) {
		try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String newLine = null;							// This method accepts a filename and arraylist of strings
															// It tries to read a file specified by filename
															// and catches any exceptions that may occur
			while((newLine = reader.readLine()) != null) {	// this loop continuously reads the file line-by-line
				strList.add(newLine);						// using readLine() until there are no more lines to read
			}												// each line is added to the string arraylist argument
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {							// exception catches
			e.printStackTrace();
		}
	}

}
