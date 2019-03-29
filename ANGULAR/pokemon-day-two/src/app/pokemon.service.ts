import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { IPokemon } from './pokemon';


@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  private _squirtle = 'https://pokeapi.co/api/v2/pokemon/7/';
  private _charmander = 'https://pokeapi.co/api/v2/pokemon/4/';
  private _bulbasaur = 'https://pokeapi.co/api/v2/pokemon/1/';

  constructor(private httpServ: HttpClient) { }

  /*
  Observable - provides support for passing messages between
  publishers and subscribers in an application.
  A function is defined for publishing values, but it is not
  executed until a consumer subscribes to it.
  They receive notifications until the function completes or
  the subscriber unsubsribes.

  To use them, you must import Observable from "rxjs" library

  Promise - is a placeholder for a future value

  Observables are declarative (they don't execute until subscription)
  while Promises execute upon creation.
  Observables are cancellable, while Promises are not.
  Observables return many values, while a promise returns one.
  */
  getSquirtle(): Observable<string> {
    return this.httpServ.get(this._squirtle).pipe(map(resp => resp as string)
    );
  }

  getCharmander(): Observable<string> {
    return this.httpServ.get(this._charmander).pipe(map(resp => resp as string)
    );
  }

  getBulbasaur(): Observable<string> {
    return this.httpServ.get(this._bulbasaur).pipe(map(resp => resp as string)
    );
  }

  getCharacters(): IPokemon[] {

    return [
      {
        'name': 'Bulbasaur',
        'type': 'Grass',
        'id': 1,
        'image': 'https://cdn.bulbagarden.net/upload/thumb/2/21/001Bulbasaur.png/250px-001Bulbasaur.png'
      },
      {
        'name': 'Charmander',
        'type': 'Fire',
        'id': 4,
        'image': 'https://cdn.bulbagarden.net/upload/thumb/7/73/004Charmander.png/250px-004Charmander.png'
      },
      {
        'name': 'Squirtle',
        'type': 'Water',
        'id': 7,
        'image': 'https://cdn.bulbagarden.net/upload/thumb/3/39/007Squirtle.png/250px-007Squirtle.png'
      }
    ];
  }
}
