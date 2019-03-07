package Question14;

import java.util.Date;
import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);    
		System.out.println("Which case do you want? Chose from 1, 2, and 3.");
		
		//which case you want from the switch statement
		int i = scan.nextInt(); 
		
		//switch statement
		switch(i){
		//case 1 performs the square root of a double 
        case 1:   
        	double d = 9;       
            System.out.println(Math.sqrt(d));
            break;
        //case 2 prints out the date
        case 2: 
        	Date date = new Date();
            System.out.println("Today is " + date.toString());
            break; 
        //case 3 splits the sentence into an array of words that were separated by a space(" ") 
        case 3: 
            String str = "I am learning Core Java"; 
            String[] strSplit = str.split(" ");
            for(String s : strSplit) {   //print statement for all strings in the strSplit array
            	System.out.println(s);
            }
            break; 
		}
	}
}
