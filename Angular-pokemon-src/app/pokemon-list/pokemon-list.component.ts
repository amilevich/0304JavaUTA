import { Component, OnInit } from '@angular/core';
import { IPokemon } from '../pokemon';
import { PokemonService } from '../pokemon.service';

@Component({
  selector: 'app-pokemon-list',
  templateUrl: './pokemon-list.component.html',
  styleUrls: ['./pokemon-list.component.css']
})
export class PokemonListComponent implements OnInit
{

  pageTitle = "Fav Pokemans";
  imageWidth = 100;
  imageMargin = 2;

  pokemon: IPokemon[] = [];
  pokemonID: string;

  constructor(private _pokemonService: PokemonService) 
  {
    this.pokemon = _pokemonService.getCharacters();
  }

  ngOnInit()
  {
  }

  addPokemon(e)
  {
    console.log("in add pokemon")
    console.log(this.pokemonID);

    if (<number><any>this.pokemonID > 0 && <number><any>this.pokemonID < 808)
    {
      this._pokemonService.getPokemon(<number><any>this.pokemonID).subscribe(
        data =>
        {
          let types = data['types']
          let typestring: string = types[0].type.name
          if (types.length > 1)
            typestring += ", " + types[1].type.name;

          this.pokemon.push({
            'name': data['name'], 'type': typestring,
            'id': data['id'], 'image': data['sprites'].front_default
          });
        }
      )
    }
    else
      alert("Please enter a valid pokemond ID [1-807]")
  }

}
