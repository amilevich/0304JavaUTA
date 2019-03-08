package com.example.covariance;

/*
 * Covariant return types are an extension of method
 * overriding.
 * A covariant return type occurs when an overriden
 * method in a child class has a return type
 * that is a subclass of the parent method's return 
 * type.
 * 
 * Object can be a String, but a String may not be
 * Object
 */
class A {
}
class B extends A {
}
class C{

}
class Base extends C{
	A fun() {
		System.out.println("Base fun()");
		return new B();
	}
}
class Derived extends Base {
	B fun() {
		System.out.println("Derived fun()");
		return new B();
	}
}

public class Main {
	public static void main(String[] args) {
		Base base = new Base();
		base.fun();
		
		Derived derived = new Derived();
		derived.fun();
		}

}
