package com.example.reflection;

public class Mirror {
	
	private String s;
	
	public Mirror() {
		s = "Andrew";
	}
	
	public void method1() {
		System.out.println("The string is " + s);
	}
	
	public void method2(int a) {
		System.out.println("The number is " + a);
	}
	
	private void method3() {
		System.out.println("private method invoked");
	}
	

}
