package com.example.dao;

import java.util.List;

import com.example.model.Pet;

public interface PetDao {

	//CREATE
	public int insertPet(Pet p);
	
	//READ
	public Pet selectPetByName(String name);
	public Pet selectPetById(int id);
	public List<Pet> selectAllPets();
	
	//UPDATE
	public int updatePetTypeWhereName(Pet p);
	public int updatePetNameWhereId(Pet p);
	
	//DELETE
	public int deletePetByName(Pet p);
	public int deletePetById(Pet p);
	
}
