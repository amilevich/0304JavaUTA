package com.example.sorting;

import java.time.LocalDate;

public class Student implements Comparable<Student>{
	
	private int studentId;
	private int numberOfLegs;
	private String name;
	private double gpa;
	private LocalDate dob;
	
	public Student() {
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", numberOfLegs=" + numberOfLegs + ", name=" + name + ", gpa=" + gpa
				+ ", dob=" + dob + "]";
	}

	public Student(int studentId, int numberOfLegs, String name, double gpa, LocalDate dob) {
		super();
		this.studentId = studentId;
		this.numberOfLegs = numberOfLegs;
		this.name = name;
		this.gpa = gpa;
		this.dob = dob;
	}

	@Override
	public int compareTo(Student o) {
		return this.getStudentId()-o.getStudentId();
	}
	
	

}
