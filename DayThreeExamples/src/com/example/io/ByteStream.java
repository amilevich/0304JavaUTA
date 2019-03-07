package com.example.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStream {

	public static void main(String[] args) {

		String filename = "./ByteFile.txt";
		
		// C:/Users/User... 
		// or you can do ./src/com.example
		//writeByteStream(filename);
		readByteStream(filename);
	}


static void readByteStream(String filename) {
	try (InputStream is = new FileInputStream(filename)) {
		int i;
		while ((i = is.read()) != -1) {
			System.out.println(i + " ");
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
	}
}

static void writeByteStream(String filename) {
	try (OutputStream os = new FileOutputStream(filename)) {
		os.write(65);
		os.write(66);
		os.write(67);
		os.write(200);
		os.write(300);		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
	}

}
}
