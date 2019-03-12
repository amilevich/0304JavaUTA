package com.example.service;

import java.util.List;
import com.example.model.Pokemon;
public interface PokeService {
	//create
	public int insertPokemon(Pokemon p);
	//read
	public List<Pokemon> selectAllPokemon();
	public Pokemon selectPokemonById(int id);
	public Pokemon selectPokemonByName(String name);
	public List<Pokemon> selectByType(String type);
	//update
	public int updatePokemon(Pokemon pk);
	//delete
	public int deletePokemon(Pokemon p);
	
	
}
