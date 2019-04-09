package com.example.model;

public class Villain {
	
	private String name;
	private String power;
	private boolean isEvil;
	
	public Villain() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public boolean isEvil() {
		return isEvil;
	}

	public void setEvil(boolean isEvil) {
		this.isEvil = isEvil;
	}

	@Override
	public String toString() {
		return "Villain [name=" + name + ", power=" + power + ", isEvil=" + isEvil + "]";
	}

	public Villain(String name, String power, boolean isEvil) {
		super();
		this.name = name;
		this.power = power;
		this.isEvil = isEvil;
	}
	
	
	

}
