package com.problem20;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6289013386287436785L;
	
	private String name;
	private int age;
	private String state;
	
	public Person(String name, int age, String state) {
		super();
		this.name = name;
		this.age = age;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Person [name:" + name + "\n" + " age:" + age + "\n" +  " state:" + state + "]";
	}
	
	
	
}
