package homework.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String filename = "./Data.txt";

		//read the text file Data.txt and store result in an ArrayList
		List<String> strs = null;
		try {
			strs = readFile(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Iterate through each line, break the line into pieces separated by :
		// and print in the proper format.
		for(String str : strs)
		{
			String[] vals = str.split(":");
			System.out.println("Name: " + vals[0] + " " + vals[1]);
			System.out.println("Age: " + vals[2] + " years");
			System.out.println("State: " + vals[3] + " State");
		}
	}
	
	//read the text file Data.txt and store each line separately in an ArrayList
	public static List<String> readFile(String filename)
			throws Exception
	{
		String line = null;
		List<String> records = new ArrayList<String>();

		// create a new BufferedReader with the text file
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

		// read each line from the text file and store it into the arraylist
		while ((line = bufferedReader.readLine()) != null)
		{
			records.add(line);
		}

		// close the BufferedReader when done
		bufferedReader.close();
		return records;
	}

}
