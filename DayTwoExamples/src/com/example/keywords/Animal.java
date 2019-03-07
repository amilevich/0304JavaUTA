package com.example.keywords;

public class Animal {

	public String name;
	public String color;
	public int numberOfLegs;
	
	// variables should be private
	// getters/setters should be public
	
	// what is a constructor?
	// they return an instance of the class
	// do not have a return type
	// if no constructor is explicitly provided,
	// the JVM provides you a no-argument
	// constructor by default
	// first line in any constructor is either
	// this() or super()
	
	public Animal() {
	}
	
	// getters -> accessors
	// setters -> mutators
	// if access modifiers are placed following
	// best practices, this is the process of
	// encapsulation
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", color=" + color + ", numberOfLegs=" + numberOfLegs + "]";
	}
	
	
	// access modifiers
	// - restrict access to variables/methods/certain
	// members/etc.. 
	
	// "private" - class itself
	// default - class itself, package
	// "protected" - class itself, package, children
	// "public" - class itself, package, children, everything
	
	// "new" keyword - instantiate 
	// instantiation - when memory is allocated for an object
	
	// initialization - when values are put into
					// the memory that was allocated
	
	// declaration - when you state to the program
			// that there will be an object of a certain
			//type existing and what the name of that 
			//object will be
	
//	Animal a = null;	// only declared and initialized
						// not instantiated 
	
	
}
