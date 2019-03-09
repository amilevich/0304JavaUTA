package question20;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class FileRead {
	
	private static Scanner scan;
	private  enum Fields{Name, Age, State}
	
	public static void main(String[] args) throws IOException {
		
		File file = new File(System.getProperty("user.dir")+"\\src\\question20\\Data.txt");
		scan = new Scanner(file);
		
		String newLine;
		
		while(scan.hasNextLine()) {
			newLine = scan.nextLine();
			String[] personInfo = newLine.split(":");
			
			System.out.println(Fields.Name + ": \t" + personInfo[0] + " " + personInfo[1]);
			System.out.println(Fields.Age + ": \t" + personInfo[2] + " years");
			System.out.println(Fields.State + ": \t" + personInfo[3] + " State\n");
		}
		scan.close();
	}

}
