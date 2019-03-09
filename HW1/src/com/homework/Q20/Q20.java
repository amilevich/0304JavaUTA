package com.homework.Q20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q20 {
	
	public static void main(String[] args) {
		
		BufferedReader br = null;
        try {
        	// connect to File
            br = new BufferedReader(new FileReader("Data.txt"));
            // Store Text into String
            String line=br.readLine();
            
            // Split string into array
            String[] Section  = line.split(":");
            
                        
            // print Section
            System.out.println("Name: " + Section[0] + " " + Section[1]);
            System.out.println("Age: " + Section[2]);
            System.out.println("State: " + Section[3] + " State");
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}

}
