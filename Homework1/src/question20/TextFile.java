package question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TextFile {
	
	public static void main(String[] args) throws IOException {
		
		PrintWriter myWriter = new PrintWriter("AwesomeTextFile.txt"); //import PrintWriter class to 
		myWriter.println("Mickey:Mouse:35:Arizona");
		myWriter.println("Hulk:Hogan:50:Virginia");
		myWriter.println("Roger:Rabbit:22:California");
		myWriter.println("Wonder:Woman:18:Montana");
		myWriter.close();
		
		try(BufferedReader originalBufferedReader = new BufferedReader(new FileReader("AwesomeTextFile.txt"))) {
			
			String originalLineReader = originalBufferedReader.readLine();
			while(originalLineReader != null) {
		        System.out.println(originalLineReader);
		        originalLineReader = originalBufferedReader.readLine();
			}
		
			System.out.println("\n");	
		} catch (FileNotFoundException e) {
			
		}
		
		try(BufferedReader myBufferedReader = new BufferedReader(new FileReader("AwesomeTextFile.txt"))) {
			
			String lineReader = myBufferedReader.readLine();
			//System.out.println(lineReader);
			String[] splitStringArray = lineReader.split(":");
			System.out.println("Name: " + splitStringArray[0] + " " + splitStringArray[1]);
			System.out.println("Age: " + splitStringArray[2]);
			System.out.println("State: " + splitStringArray[3] + "\n");
			
			String lineReader2 = myBufferedReader.readLine();
			//System.out.println(lineReader2);
			String[] splitStringArray2 = lineReader2.split(":");
			System.out.println("Name: " + splitStringArray2[0] + " " + splitStringArray2[1]);
			System.out.println("Age: " + splitStringArray2[2]);
			System.out.println("State: " + splitStringArray2[3] + "\n");
			
			String lineReader3 = myBufferedReader.readLine();
			//System.out.println(lineReader2);
			String[] splitStringArray3 = lineReader3.split(":");
			System.out.println("Name: " + splitStringArray3[0] + " " + splitStringArray3[1]);
			System.out.println("Age: " + splitStringArray3[2]);
			System.out.println("State: " + splitStringArray3[3] + "\n");
			
			String lineReader4 = myBufferedReader.readLine();
			//System.out.println(lineReader2);
			String[] splitStringArray4 = lineReader4.split(":");
			System.out.println("Name: " + splitStringArray4[0] + " " + splitStringArray4[1]);
			System.out.println("Age: " + splitStringArray4[2]);
			System.out.println("State: " + splitStringArray4[3] + "\n");
			
			//lineReader = myBufferedReader.readLine();
			//lineReader = myBufferedReader.readLine();
		    /*
			while(lineReader != null) {
		        System.out.println(lineReader);
		        lineReader = myBufferedReader.readLine();
		    }*/
		} catch (FileNotFoundException e) {
			
		}
		
	}
}