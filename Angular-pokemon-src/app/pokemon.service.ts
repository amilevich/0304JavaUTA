import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { IPokemon } from './pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokemonService 
{
  private _mew = 'https://pokeapi.co/api/v2/pokemon/151';
  private _typhlosion = 'https://pokeapi.co/api/v2/pokemon/157';
  private _bulbasaur = 'https://pokeapi.co/api/v2/pokemon/7';
  private _klinklang = 'https://pokeapi.com/api/v2/pokemon/601';

  constructor(private httpServ: HttpClient) { }

  // Observable provides support for passing messages b/n 
  // publishers and subscribers
  // - is a function defined for publishing values
  // - not executed until a consumer subscribes to it
  // - subscribers receive notifications until funciton completes or the subscriber unsubscribes
  /*
  ** To use observables, Obersvable must be imported from "rxjs" library **
  Promise - placeholder for a future value 

  Observables
      - declarative (do not execute until subscription)
      - cancellable
      - return many values
  Promises
      - execute upon creation
      - not cancellable
      - returns only one value
  */
  getMew(): Observable<string>
  {
    return this.httpServ.get(this._mew)
      .pipe(map(resp => resp as string));
  }

  getTyphlosion(): Observable<string>
  {
    return this.httpServ.get(this._typhlosion)
      .pipe(map(resp => resp as string));
  }

  getBulbasaur(): Observable<string>
  {
    return this.httpServ.get(this._bulbasaur)
      .pipe(map(resp => resp as string));
  }

  getKlinklang(): Observable<string>
  {
    return this.httpServ.get(this._klinklang)
      .pipe(map(resp => resp as string));
  }

  getPokemon(id: number): Observable<String> {
    console.log("in get pokemon id: " + id)
    return this.httpServ.get(`https://pokeapi.co/api/v2/pokemon/${id}`)
      .pipe(map(resp => resp as string));
  }

  getCharacters(): IPokemon[]
  {
    let pokemons = new Array<IPokemon>();
    
    return [ ]
  }
}
