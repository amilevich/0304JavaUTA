package com.project.startupscreen;

public class UserLogin {

	String un; 
	String pw; 
	int priv; 

	public UserLogin(String username, String password, int priviledges) {
		this.un = username; 
		this.pw = password;
		this.priv = priviledges; 
	}

	public int getPriv() {
		return priv;
	}

	public void setPriv(int priv) {
		this.priv = priv;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
