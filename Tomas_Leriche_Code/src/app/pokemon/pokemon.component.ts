import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { temporaryAllocator } from '@angular/compiler/src/render3/view/util';

let randos: number[] = [];

let rand: number = Math.floor(Math.random() * 251) + 1;
let rand1: number = Math.floor(Math.random() * 251) + 1;
let rand2: number = Math.floor(Math.random() * 251) + 1;
let rand3: number = Math.floor(Math.random() * 251) + 1;
let rand4: number = Math.floor(Math.random() * 251) + 1;
let rand5: number = Math.floor(Math.random() * 251) + 1;

randos[0] = rand;
randos[1] = rand1;
randos[2] = rand2;
randos[3] = rand3;
randos[4] = rand4;
randos[5] = rand5;



@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.css']
})
export class PokemonComponent implements OnInit {
  pokemon: any;
  pokemon1: any;
  team: any[] = [];

  constructor(private client: HttpClient) { }



  ngOnInit() {
      this.getPokemon(randos);
  }

  onClickMe(){
    this.getPokemon(randos);
  }

  getPokemon(id: number[]): void {
    for (let num in id){
        this.client.get(`https://pokeapi.co/api/v2/pokemon/${id[num]}`).subscribe(
          (succ) => {
            this.pokemon = succ;
            this.team[num] = succ;
          },
          (err) => {
            alert('failed to retrieve pokemon with id ' + id[num]);
          }
        );
    }
  }
}
