package com.homework.question20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Q20 
{

	public static void main(String[] args)
	{
		String filename = "./Data.txt";
		
		//writeByteStream(filename);
		readByteStream(filename);
		
		for (int i = 0; i < 5; i++) {
			
		}
	}

	static void Display(String s)
	{
		String[] stringArray = s.split(":");
		
		System.out.println("Name: "+stringArray[0]+" "+stringArray[1]);
		System.out.println("Age: "+stringArray[2]+" years");
		System.out.println("State: "+stringArray[3].substring(0, stringArray[3].length()-1)+" State");
		System.out.println();
	}
	
	static void readByteStream(String filename)
	{
		String[] strings = new String[5];
		for (int i = 0; i < strings.length; i++) 
		{
			strings[i] = "";
		}
		try(InputStream is = new FileInputStream(filename))
		{
			int i;
			int lineCounter = 0;
			while((i = is.read()) != -1)
			{
				if((char)i != '\n')
					strings[lineCounter] += (char)i;
				
				if ((char)i == '\n' && lineCounter < strings.length)
				lineCounter++;
				
			}
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			
		}
		
		for (int i = 0; i < strings.length-1; i++)
		{
			Display(strings[i]);
		}
	}
	
	static void writeByteStream(String filename)
	{
		try(OutputStream os = new FileOutputStream(filename))
		{
			os.write(("Mickey:Mouse:35:Arizona").getBytes());
			os.write(("Hulk:Hogan:50:Virginia").getBytes());
			os.write(("Roger:Rabbit:22:California").getBytes());
			os.write(("Wonder:Woman:10:Montana").getBytes());
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			
		}
	}
}
