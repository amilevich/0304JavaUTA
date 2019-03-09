package com.homework.q20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\pjhsm\\Documents\\workspace-pjhoward\\CoreJavaHomework\\"
				+ "src\\com\\homework\\q20\\Data.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {					//Reads line by line splitting the ":" into a " "
				String fields[] = line.split(":");
				System.out.println("Name: " + fields[0] + " " + fields[1]);
				System.out.println("Age: " + fields[2] + " years");
				System.out.println("State: " + fields[3]);
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}