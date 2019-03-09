package com.homework.question20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Notepad2 {

	public static void main(String[] args) { 
		try (BufferedReader br = new BufferedReader(new FileReader(
				"C:\\Users\\yos_m\\Documents\\workspace-sts-3.9.4.RELEASE\\Homework\\question20doc.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
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
