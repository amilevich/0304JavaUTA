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
    this.id = Number(this.route.snapshot.paramMap.get('tempId'));
    this._pokemon.getPokemon(this.id).subscribe(
      data => {
        this.height = data['height'];
        this.id = data['id'];
        this.weight = data['weight'];
      }
    );
  }
}
