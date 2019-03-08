package com.example.generics;

// Generics
// generic methods and generic classes enable
// programmers to specify, with a single method
// declaration, a set of related methods, or
// a set of related types.

// Generics enforce compile time safety by allowing you
// to use parameterized types.
// sybtax: <>

// to use generics with methods:
// public static <T> void method1() {}

class GenericClass<T> {
	private T value;

	public GenericClass(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}

public class Main {
	public static void main(String[] args) {

		/*
		 * Naming conventions: Type Parameters can be named anything you want, but the
		 * convention is to use single, uppercase letters to make it obvious that they
		 * are not real class names
		 * 
		 * T => Generic Data type 
		 * E => Element 
		 * K => Map Key 
		 * V => Map Value 
		 * N => Number
		 */

		// GenericClass<String> genericClass = new GenericClass<String>("GenClass");
		// GenericClass<Integer> genericClass = new GenericClass<>(5);

		// bad practice to do so, because
		// you want to restrict the data type
		// so that you don't get unexpected object types

		// using chevrons gives you compile time safety

		GenericClass genericClass = new GenericClass<>("Eggnog");
		// defaults to Object
		
		System.out.println(genericClass.getValue());
	}

}
