package com.example.dao;

import java.util.List;

import com.example.model.Pokemon;

public interface PokeDao {
	
	/*
	 * CRUD methods only
	 */

	
	//create
	public int insertPokemon(Pokemon p);
	//read
	public List<Pokemon> selectAllPokemon();
	public Pokemon selectPokemonById(int id);
	public Pokemon selectPokemonByName(String name);
	public List<Pokemon> selectByType(String type);
	//update
	public int updatePokemon(Pokemon p);
	//delete
	public int deletePokemon(Pokemon p);
}
