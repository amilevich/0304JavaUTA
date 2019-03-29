import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../pokemon.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pokemon-profile',
  templateUrl: './pokemon-profile.component.html',
  styleUrls: ['./pokemon-profile.component.css'],
  providers: [PokemonService]
})
export class PokemonProfileComponent implements OnInit {

  name: string;
  height: number;
  id: number;
  weight: number;

  constructor(private route: ActivatedRoute, private _pokemon: PokemonService) { }

  ngOnInit() {
    this.name = this.route.snapshot.paramMap.get('name');
    if (this.name === 'Bulbasaur') {
      this._pokemon.getBulbasaur().subscribe(
        data => {
          this.height = data['height'];
          this.id = data['id'];
          this.weight = data['weight'];
        }
      );
    }
    if (this.name === 'Charmander') {
      this._pokemon.getCharmander().subscribe(
        data => {
          console.log(data['height']);
          this.height = data['height'];
          this.id = data['id'];
          this.weight = data['weight'];
        }
      );
    }
    if (this.name === 'Squirtle') {
      this._pokemon.getSquirtle().subscribe(
        data => {
          console.log(data['height']);
          this.height = data['height'];
          this.id = data['id'];
          this.weight = data['weight'];
        }
      );
    }
  }

}
