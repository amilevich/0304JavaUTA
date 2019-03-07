package com.example.inheritance;

public class Main {

	private static SuperHero superVillain;
	
	public static void main(String[] args) {

		
		SuperHero superH = new SuperVillain();
//		System.out.println(superH.alias); //The Mysterio
		
	//	System.out.println(((SuperVillain)superH).alias);
		// Yousef The PizzaMan
		
		// casting - taking an object of one particular
		// type and turning it into another object type
		
		// upcasting - casting a subtype to supertype
		// when we want to write general code that deals
		// only with the supertype
		
		// downcasting - casting to a subtype from a supertype
		// when we want to access specific behavior of a subtype
		
		superH.alterweakness();
		//System.out.println(superH.getWeakness());
		//avocados
		
		System.out.println(((SuperVillain)superH).weakness);
	}

}
