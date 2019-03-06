package com.example.problem14;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;    

public class SwitchMe {
	public static void main(String[] args) {
		for(int i = 0; i < 3; i++)
		{
			switch(i) {
			case 0:
				System.out.println(Math.sqrt(66));
				break;
				
			case 1:
				 DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				   LocalDateTime now = LocalDateTime.now();  
				   System.out.println(date.format(now));
				   break;
				   
			case 2:
				String splitter = new String("I'm learning core java");
				String[] tokens = splitter.split(" ");
				for(String s :tokens) {
					System.out.println("The string contains token " + s);
				}
				break;
				
				default:
					break;
				
			}
		}
	}
}
