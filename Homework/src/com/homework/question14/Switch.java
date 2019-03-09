package com.homework.question14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Switch {
	public static void main(String[] args) {

		int n = 4;

		Math.sqrt(n);
		String switchcase = "todaysdate"; //input from the user selecting the case.

		switch (switchcase) { //Beginning of the switchcase
		case "squareroot": {
			Math.sqrt(n);
			System.out.println(Math.sqrt(n));
			break;
		}
		case "todaysdate": {
			DateFormat dateFormat = new SimpleDateFormat("MM:dd:yy");
			Date dateObj = new Date();
			System.out.println(dateObj);
			break;
		}

		case "sentence": {
			String s = "I am learning Core Java";
			String[] splitsentence = s.split(" ");

			for (int i = 0; i < splitsentence.length; i++) {
				{
					System.out.println(splitsentence[i]);
				}

			}
			break;
		}

		}

	}
}
