import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.css']
})
export class PokemonComponent implements OnInit {

  pokemon: any;

  constructor(private client: HttpClient) { }

  ngOnInit() {
    this.getPokemon(272);
  }

  getPokemon(id: number): void {
    this.client.get(`https://pokeapi.co/api/v2/pokemon/${id}`)
      .subscribe(
        (succ) => {
          this.pokemon = succ;
          console.log(succ);
        },
        (err) => {
          alert('failed to retreive pokemon with id ' + id);
        }
      );
  }

}
