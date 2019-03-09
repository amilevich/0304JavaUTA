package com.problem20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		
		String fileName = "./Data.txt";
		
		Person person1 = new Person("Mickey Mouse", 35, "Arizona"); //created objects to write to a file ( I wanted practice with writing to one and creating objects)
		Person person2 = new Person("Hulk Hogan", 50, "Virginia");
		Person person3 = new Person("Roger",22, "California");
		Person person4 = new Person("WonderWoman",18, "Montana");
		
//		writeObject(fileName,person1);
//		writeObject(fileName,person2);
//		writeObject(fileName,person3);
//		writeObject(fileName,person4);
		
		readObject(fileName);

	}
	
	static void readObject (String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			Object object = ois.readObject();
			System.out.println(object);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void writeObject(String filename, Object obj) {
		try(ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(filename))) {
			oo.writeObject(obj);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
