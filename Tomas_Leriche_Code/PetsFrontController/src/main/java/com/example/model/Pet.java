package com.example.model;

public class Pet {

	int user_id;
	String name, type;
	int age;
	String first_name, last_name, email;
	int role_id;

	public Pet() {		
	}
	
	public Pet(String name, String type, int age) {
		super();
		this.name = name;
		this.type = type;
		this.age = age;
	}

	
	public Pet(int user_id, String name, String type, int age, String first_name, String last_name, String email, int role_id) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.type = type;
		this.age = age;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role_id = role_id;
	}

	
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "Pet [name=" + name + ", type=" + type + ", age=" + age + ", first_name=" + first_name + ", last_name="
				+ last_name + ", email=" + email + ", role_id=" + role_id + "]";
	}


	
	
}
