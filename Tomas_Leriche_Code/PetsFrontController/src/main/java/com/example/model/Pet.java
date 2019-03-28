package com.example.model;

public class Pet {

	String name, type;
	int age;

	public Pet() {		
	}
	
	public Pet(String name, String type, int age) {
		super();
		this.name = name;
		this.type = type;
		this.age = age;
	}

	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", type=" + type + ", age=" + age + "]";
	}

	
	
}
