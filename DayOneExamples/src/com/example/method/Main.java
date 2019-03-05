package com.example.method;

public class Main {

	public static void main(String[] args) {
		method("pizza",5);
	}

	public static void method() {
		System.out.println("method() called");
	}

	public static void method(String hello) {
		System.out.println("method(String) called with an argument " + hello + ".");
	}

	public static void method(String hello, int i) {
		System.out.println("method(String, int) called with arguments " + hello + ", " + i + ".");
	}

	public static void method(int i) {
		System.out.println("method(int) called with" + " argument " + i + ".");
	}
}
