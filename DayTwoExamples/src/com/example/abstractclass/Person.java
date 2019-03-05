package com.example.abstractclass;

public abstract class Person {
	
	protected int a;
	// variables from an abstract class
	// work the same as variables from
	// a non abstract class
	
	public Person() {
		System.out.println("in Person Constructor");
	}
	
	public abstract void breathe();
	
	private void eat() {
		System.out.println("in person eat method");
	}

}
