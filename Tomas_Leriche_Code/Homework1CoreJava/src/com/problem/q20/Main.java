package com.problem.q20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String filename = "./Data.txt";
		readFile(filename);
	}

	public static void readFile(String filename) {
		// make new bufferReader
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(filename));
			String textFileLine = "";
			while ((textFileLine = fileReader.readLine()) != null) {
				// split words of line into String[] by ":"
				String[] lWords = textFileLine.split(":");

				// loop over each word in line and format accordingly
				for (int x = 0; x < lWords.length; x++) {
					if (x == 0) {
						System.out.println("Name: " + lWords[0] + " " + lWords[1]);
					} else if (x == 1) {
						System.out.println("Age: " + lWords[2] + " years");
					} else if (x == 3) {
						System.out.println("State: " + lWords[3] + " State\n");
					}
				}
			}
		} catch (IOException e) {
			System.out.println("File Not Found");
		}
	}
}
