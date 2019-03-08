package com.Homework1.Problem11Pt2;

public class FloatsInClass {

	static public float easyToFind = 1;				// this static float can be easily accessed using the 
													// classname and the variable name
	static private float hardToFind = 2;			// this static float can only be read using a getter function
	
	public float easyToSpot = 3;					// this float can be easily accessed using an object's name
													// and the variable name
	
	private float hardToSpot = 4;					// this float can only be read through its getter function
	
	public static float getEasyToFind() {
		return easyToFind;
	}
	public static void setEasyToFind(float easyToFind) {
		FloatsInClass.easyToFind = easyToFind;
	}
	public static float getHardToFind() {
		return hardToFind;
	}
	public static void setHardToFind(float hardToFind) {
		FloatsInClass.hardToFind = hardToFind;
	}
	public float getEasyToSpot() {
		return easyToSpot;
	}
	public void setEasyToSpot(float easyToSpot) {
		this.easyToSpot = easyToSpot;
	}
	public float getHardToSpot() {
		return hardToSpot;
	}
	public void setHardToSpot(float hardToSpot) {
		this.hardToSpot = hardToSpot;
	}
	
}
