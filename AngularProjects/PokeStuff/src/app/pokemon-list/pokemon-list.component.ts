import { Component, OnInit } from '@angular/core';
import { IPokemon } from '../pokemon';
import { PokemonService } from '../pokemon.service';

@Component({
  selector: 'app-pokemon-list',
  templateUrl: './pokemon-list.component.html',
  styleUrls: ['./pokemon-list.component.css']
})
export class PokemonListComponent implements OnInit {

  pageTitle = '3 Random Pokemon';
  imageWidth = 100;
  imageMargin = 2;
  tempId1 : number;
  tempId2 : number;
  tempId3 : number;

  pokemon: IPokemon[] = [];
    
  constructor(private _pokemonService: PokemonService) { 
    this.tempId1 = Math.floor( Math.random() * 809 )
    this.tempId2 = Math.floor( Math.random() * 809 )
    this.tempId3 = Math.floor( Math.random() * 809 )
    this.pokemon = _pokemonService.getCharacters(this.tempId1,this.tempId2,this.tempId3);
  }

  ngOnInit() {
  }

}
