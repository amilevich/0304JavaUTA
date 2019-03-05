package com.example.inheritance;

public class SuperVillain extends SuperHero {

	String alias = "Yousef The PizzaMan";
	// shadowing
	
	// refers to the practice of using
	// two variables with the same name
	// within scopes that overlap.
	
	//when you do this, the variable with the
	// higher scope is hidden, because the 
	// variable with the lower scope "shadows"
	// it 
	
	// from within child class super.something
	// and cast it to the parent class
	
	public SuperVillain() {
		super("give it a string");
		System.out.println("***In SuperVillain constructor***");
	}
	
	@Override
	public void alterweakness() {
		weakness = "avocados";
	}
	
	@Override
	public String getName() {
		return new String();
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	
	
}
