package com.corejavahw.q20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Create a notepad file called Data.txt and enter the following:
 * 
 * Mickey:Mouse:35:Arizona
 * Hulk:Hogan:50:Virginia
 * Roger:Rabbit:22:California
 * Wonder:Woman:18:Montana
 * 
 * Write a program that would read from the file and print it out to the screen in the
 * following format:
 * 
 * Name: Mickey Mouse
 * Age: 35 years
 * State: Arizona State
 */

public class Q20 {

	// readStream method to read from Data.txt file
	static void readCharacterStream(String filename) {
        //try, catch blocks to read the file with FileReader
        try (BufferedReader reader = new BufferedReader(new FileReader((filename)))) {
            //Initialize String to read into
            String str = null;

            while ((str = reader.readLine()) != null) {
				// System.out.println(str);
				String[] strArr = str.split(":");

				// loop to print out and format split string array
				for (int j = 0; j < 4; j++) {
					if (j == 0) {
						System.out.println("Name: " + strArr[0] + " " + strArr[1]);
					} else if (j == 1) {
						System.out.println("Age: " + strArr[2]);
					} else if (j == 2) {
						System.out.println("State: " + strArr[3] + " State\n");
					}
				}
			}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
    }

	// program driver
	public static void main(String[] args) {

		// Initialize filename
		String filename = "./Data.txt";
		// call to read file to console
		readCharacterStream(filename);

		// try,catch blocks to write the file with a buffered writer
		try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter(filename, false))) {
			buffWriter.write("Mickey:Mouse:35:Arizona");
			buffWriter.newLine();
			buffWriter.write("Hulk:Hogan:50:Virginia");
			buffWriter.newLine();
			buffWriter.write("Roger:Rabbit:22:California");
			buffWriter.newLine();
			buffWriter.write("Wonder:Woman:18:Montana");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		}

	}
}
