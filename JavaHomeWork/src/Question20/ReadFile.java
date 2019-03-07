package Question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		String filename = "./Data.txt";
		
		try {
            FileReader reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
            	String[] str = line.split(":");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
