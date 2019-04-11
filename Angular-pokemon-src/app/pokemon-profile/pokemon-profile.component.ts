import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PokemonService } from '../pokemon.service';

@Component({
  selector: 'app-pokemon-profile',
  templateUrl: './pokemon-profile.component.html',
  styleUrls: ['./pokemon-profile.component.css']
})
export class PokemonProfileComponent implements OnInit 
{
  name: string;
  height: number;
  id: number;
  weight: number;

  constructor(private route: ActivatedRoute, private pokemon: PokemonService) 
  {
    
  }

  ngOnInit() 
  {
    this.id = <number><any>this.route.snapshot.paramMap.get('id');
    this.pokemon.getPokemon(this.id).subscribe(
      data =>
      {
        console.log(data)
        this.height = data['height'];
        this.weight = data['weight'];
        this.id = data['id'];
      }
    )
  }

  loadProfile()
  {
    
  }

}
