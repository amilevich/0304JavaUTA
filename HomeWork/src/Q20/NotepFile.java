package Q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import java.io.PrintWriter;

public class NotepFile {

	static String filename = "./Data.txt";
	public static void main(String[] args) {
		writeFile(filename);
		readFile(filename);

	}
	
	static void writeFile(String file) 
	{
		try {
			FileWriter filew = new FileWriter(file,true);//initialized File Writer
		filew.write("Mickey:Mouse:35:Arizona\r");//Wrote each line to file in try block
		filew.write("Hulk:Hogan:50:Virginia\r");
		filew.write("Roger:Rabbit:22:California\r");
		filew.write("Wonder:Woman:18:Montana");
		filew.close();
		
		}catch (FileNotFoundException e) {//if error is found throw FileNotFound Exception
			e.printStackTrace();
		}catch (IOException e) {//if error is found throw IOException
			e.printStackTrace();
		}
	}
	
	static void readFile(String file) {
		try {
			int i;//variable to determine if reader has reached end of output stream
			FileReader readw = new FileReader(file);//initializing file reader
			BufferedReader BR = new BufferedReader(readw); //initializing buffered reader
			ArrayList<String[]> StrList = new ArrayList<String[]>(); //list of string arrays
			
			
				while ((i = readw.read()) != -1) 
				{//while reader is still reading
					for (int j = 0; j < 4; j++) 
					{//for each line, read the line and store each line into a string str
					String str = BR.readLine();
					String [] s = str.split(":");//split string by the ":"
					StrList.add(s);//add string array to the string array list
					}
				}
			
			readw.close();//close buffer reader and file reader
			BR.close();

			
			for (String [] s : StrList) //for each string array in the string array list StrList
			{//Print out specific info from array depending on console print format
				System.out.println("Name: " + s[0] + " " + s[1]);
				//M will not show up for some reason, i spent close to an hour on the M
				System.out.println("Age: " + s[2] + " years");
				System.out.println("State: " + s[3] + " State");
				System.out.println();//empty line printed
			}
		} catch (FileNotFoundException e) {//if file not found exception during runtime, throw File not found exception
			e.printStackTrace();
		} catch (IOException e) {// if IO exception found during runtime, throw IO exception
		}
	}

}
