package com.example.service;

import java.util.List;

import com.example.dao.PokeDao;
import com.example.dao.PokeDaoImpl;
import com.example.model.Pokemon;

public class PokeServiceImpl implements PokeService {
	
	private PokeDao p = new PokeDaoImpl();

	@Override
	public int insertPokemon(Pokemon p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Pokemon> selectAllPokemon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pokemon selectPokemonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pokemon selectPokemonByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pokemon> selectByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePokemon(Pokemon pk) {
		// TODO Auto-generated method stub
		return p.updatePokemon(pk);
	}

	@Override
	public int deletePokemon(Pokemon p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
