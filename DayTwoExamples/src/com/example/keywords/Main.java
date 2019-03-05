package com.example.keywords;

public class Main {

	// public
	// private			-> access modifiers (restrict access)
	// protected
	
	// default -> with Java 8, allows for interface
				// methods to have implementation
				//(allows for concrete methods)
	// static -> object - instantiate it once
				//method - method can be invoked
						// without creating an instance
						// of the class
	// void	-> no return type
	// abstract -> no body/no implementation
	// final: 
			// variable -> cannot be changed(immutable)
			// method -> cannot be overridden 
			// class -> can not have children

	public static void main(String[] args) {

		new Animal(); //pure instantiation 
		
		Animal animal = new Animal(); 
		animal.setName("Pete-Bobh");
		animal.setColor("Green(Eco-friendly)");
		animal.setNumberOfLegs(8);
		
		System.out.println("His name is " +animal.getName() + " and he has " + animal.getNumberOfLegs() + " legs.");
		
		
	}
}
