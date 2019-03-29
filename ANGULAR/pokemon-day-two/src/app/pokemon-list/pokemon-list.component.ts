import { Component, OnInit } from '@angular/core';
import { IPokemon } from '../pokemon';
import { PokemonService } from '../pokemon.service';

@Component({
  selector: 'app-pokemon-list',
  templateUrl: './pokemon-list.component.html',
  styleUrls: ['./pokemon-list.component.css']
})
export class PokemonListComponent implements OnInit {

  pageTitle = 'Starter Pokemon';
  imageWidth = 50;
  imageMargin = 2;

  pokemon: IPokemon[] = [];

  constructor(private _pokemonService: PokemonService) {
  this.pokemon = _pokemonService.getCharacters();
  }

  ngOnInit() {
  }

}
