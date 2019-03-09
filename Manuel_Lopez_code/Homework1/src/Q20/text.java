package Q20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class text {

	public static void main(String[] args) throws IOException {
		readAndPrintFile();																								//call readAndPrintFile method
	}
	
	public static void readAndPrintFile() throws IOException {															//
		String fileName = "C:\\Users\\manlo\\Documents\\workspace-sts-3.9.4.RELEASE\\Homework1\\src\\Q20\\file.txt";	//create string fileName and store textfile path
		File file = new File(fileName);																					//create new file with path of fileName(path of text file)
		FileReader fr = new FileReader(file);																			//create FileReader fr to read from file
		BufferedReader br = new BufferedReader(fr);																		//create BufferedReader br to read from from file with FileReader
		String line;																									//temp String line
		while((line = br.readLine()) != null) {																			//iterate through file and store each line in temp variable line euntil end of file 
			String[] temp_array = line.split(":");																		//deliminate line with : and store in temp_array
			for(int i=0; i<4; i++) {																					//for loop to print in out in specific order
				if(i==0) 																								//
					System.out.println("Name: "+temp_array[0]+" "+temp_array[1]);										//if i=0 print first two strings n array which are name
				if(i==2)																								//
					System.out.println("Age: "+temp_array[2]+" years");													//if i=2 print third string in array which is age
				if(i==3)																								//
					System.out.println("State: "+temp_array[3]+" State");												//if i=3 print fourth string array which is state 
			}																											//
			System.out.println();																						//println to skip line before printing next person
		}																												//
	}																													//
}
