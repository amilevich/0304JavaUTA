package com.Homework1.Problem11Pt1;

import com.Homework1.Problem11Pt2.*;			// Need to import the other class

public class Main {

	public static void main(String[] args) {
		
												// I am going to read the values of both the static and instance
												// variables in the FloatsInClass class from another package
												// Two are public and two are private. I will also change their
												// values and demonstrate the changes.
		
	FloatsInClass obj1 = new FloatsInClass();				// Create new object
	
	System.out.print("Public static float " + FloatsInClass.easyToFind);
															// public static member accessed directly using 
	FloatsInClass.easyToFind = 5;							// ClassName.memberName
	System.out.println(" changed to " + FloatsInClass.easyToFind + "\n");
	
	System.out.print("Public instance float " + obj1.easyToSpot);	
															// public instance variable accessed using 
	obj1.easyToSpot = 6;									// objectName.memberName
	System.out.println(" changed to " + obj1.easyToSpot + "\n");
	
	System.out.print("Private static float " + FloatsInClass.getHardToFind());		
															// unable to access private static member directly,
	FloatsInClass.setHardToFind(7);							// need to use ClassName and setter/getter function
	System.out.println(" changed to " + FloatsInClass.getHardToFind() + "\n");
	
	System.out.print("Private instance float " + obj1.getHardToSpot());					
															// unable to access private instance variable directly,
	obj1.setHardToSpot(8);									// need to use objectName and setter/getter function
	System.out.println(" changed to " + obj1.getHardToSpot() + "\n");
	}

}
