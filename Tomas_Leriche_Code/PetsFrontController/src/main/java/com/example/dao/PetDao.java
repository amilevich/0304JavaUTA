package com.example.dao;

import java.util.List;

import com.example.model.Pet;
import com.example.model.Reimbursement1;

public interface PetDao {

	//CREATE
	public int insertPet(Pet p);
	
	//READ
	public Pet selectPetByName(String name);
	public List<Reimbursement1> selectReimbursementsByUserId(int id);
	
	//UPDATE
	public int updatePet(Pet p);
}
