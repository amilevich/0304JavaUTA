package com.example.serialization;

import java.io.Serializable;

public class Person implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1964473272207936113L;
	/*
	 * SerialVersionUID
	 * represents your class's version
	 * 
	 * The serialization runtime associates 
	 * a version number with each Serializable class.
	 * It is used during deserialization to verify
	 * that the sender and receiver of serialized object
	 * have loaded class for that object which
	 * are compatible with respect to serialization.
	 * 
	 * If we have a different UID for sender/receiver,
	 * then IvalidClassException
	 * 
	 *generate default SerialVersionID = 1L;
	 *generate SerialVersionID -> unique
	 */
	private String name;
	private int age;
	private int numberOfLegs;
	private int ssn;
	
	public Person() {
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

	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", numberOfLegs=" + numberOfLegs + ", ssn=" + ssn + "]";
	}

	public Person(String name, int age, int numberOfLegs, int ssn) {
		super();
		this.name = name;
		this.age = age;
		this.numberOfLegs = numberOfLegs;
		this.ssn = ssn;
	}
	
	
}
