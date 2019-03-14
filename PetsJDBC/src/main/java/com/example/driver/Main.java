package com.example.driver;

import com.example.dao.PetDaoImpl;
import com.example.model.Pet;

public class Main {

	public static void main(String[] args) {

		//populate some data
	Pet petOne = new Pet("Jarvis","Robo-Pet");
	Pet petTwo = new Pet("Jimmy","Centipede");
	Pet petThree = new Pet("Frank","Doggo");
	
	PetDaoImpl petDaoImpl = new PetDaoImpl();
//	petDaoImpl.insertPet(petOne);
//	petDaoImpl.insertPet(petTwo);
//	petDaoImpl.insertPet(petThree);
	
	
	//System.out.println(petDaoImpl.selectPetByName("Frank"));
	//Pet petFour = petDaoImpl.selectPetByName("Frank");
	//System.out.println("Pet's Name is: " + petFour.getName());
	//System.out.println(petDaoImpl.selectAllPets());
	
	petTwo.setType("Hamster");
	petDaoImpl.updatePet(petTwo);
	System.out.println("done");
	
	}

}
