package com.example;

import java.util.List;

import com.example.dao.PokeDaoImpl;
import com.example.model.Pokemon;
import com.example.service.PokeService;
import com.example.service.PokeServiceImpl;

public class Main {

	public static void main(String[] args) {
		
//		PokeDaoImpl pokeDaoImpl = new PokeDaoImpl();
//		System.out.println(pokeDaoImpl.selectPokemonByName("Squirtle"));
		
//		PokeDaoImpl pokeDaoImpl = new PokeDaoImpl();
//		
//		System.out.println(pokeDaoImpl.selectPokemonById(7));
//		
//		PokeService pokeService = new PokeServiceImpl();
//		
//		List<Pokemon> pokes = pokeService.getAllPokemon();
//		
//		for(Pokemon p: pokes) {
//			System.out.println(p);
//		}
//		
//		System.out.println("done");
//		
//		PokeDaoImpl pokeDaoImpl = new PokeDaoImpl();
//		System.out.println(pokeDaoImpl.selectByType("Water"));
		
		
		PokeService pokeService = new PokeServiceImpl();
		Pokemon pokemon = new Pokemon(25, "Dominic", "Grass");
		int poke = pokeService.updatePokemon(pokemon);
		
		System.out.println("done" + poke);


	}

}
