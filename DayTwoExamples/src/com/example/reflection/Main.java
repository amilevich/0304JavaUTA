package com.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		// Reflection API
		// library that allows us to inspect
		// and/or modify runtime attributes
		// of classes, interfaces, fields,
		// and methods.
		// used mostly for debugging/information
		// purposes

		// create an object whose property is to be checked
		Mirror obj = new Mirror();

		// create the class object from the
		// object using getClass method
		Class cls = obj.getClass();
		System.out.println("The name of the class is " + cls.getName());

		// get the constructor of the class through the object
		// of the class
		Constructor con = cls.getConstructor();
		System.out.println("The name of the constructor is " + con.getName());

		// get the methods of the class through the object
		// of the class by using getMethods
		
		Method[] methods = cls.getMethods();
		
		//printing the method names
		for(Method method : methods)
			System.out.println(method.getName());
	}

}
