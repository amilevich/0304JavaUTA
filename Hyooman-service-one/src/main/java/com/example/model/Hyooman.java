package com.example.model;

public class Hyooman {
	
	private String name;
	private String nickname;
	
	public Hyooman() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Hyooman [name=" + name + ", nickname=" + nickname + "]";
	}

	public Hyooman(String name, String nickname) {
		super();
		this.name = name;
		this.nickname = nickname;
	}
	
	

}
