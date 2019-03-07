package Question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		//file name
		String filename = "./Data.txt";
		
		try {
			//creating the reader objects
            FileReader reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
            //read the whole file
            while ((line = bufferedReader.readLine()) != null) {
            	//split the words separated by ":" into an array 
            	String[] str = line.split(":");
            	
            	//loop to print out in the format that we want
            	for(int j = 0; j < 4; j++) {
            		if(j == 0) {
            			System.out.println("Name: " + str[0] + " " + str[1]);
            		}else if(j == 1) {
            			System.out.println("Age: " + str[2] + " years");
            		}else if(j == 2) {
            			System.out.println("State: " + str[3] + " state");
            		}
            	}System.out.println();
            }   
        }catch (FileNotFoundException e) {
			e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
    }
}
