import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, fromEvent } from 'rxjs';
import { map } from 'rxjs/operators';
import { IPokemon } from './pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  private _pokemon = 'https://pokeapi.co/api/v2/pokemon/';
  private _rayquaza = 'https://pokeapi.co/api/v2/pokemon/384/';
  private _garbador = 'https://pokeapi.co/api/v2/pokemon/569/';
  private _sawsbuck = 'https://pokeapi.co/api/v2/pokemon/586/';

  constructor(private httpServ: HttpClient) { }

  myName: string;
  myType: string;
  myId: number;
  myImage: string;

  myName2: string;
  myType2: string;
  myId2: number;
  myImage2: string;

  myName3: string;
  myType3: string;
  myId3: number;
  myImage3: string;


  /*
  Observable - provides support for passing messages between publishers and subscribers in an application
  A function is defined for publishing values, but it is not executed until a consumer subscribes to it.
  They receive notifications until the function completes or the subscriber unsubstribes.

  To use them, you must import Observable from "rxjs" library. *****IMPORTANT FOR QCs*****
  
  Promise - is a placeholder for a future value

  Observables are declarative (they don't execute until subscription)
  while promises execute upon creation.
  Observable are cancellable, while Promises are not.
  Observables return many values while a promise returns one.
  */

   getPokemon(id): Observable<string> {
    return this.httpServ.get(this._pokemon + id + '/').pipe(map(resp => resp as string)
    );
  }

  getRayquaza(): Observable<string> {
    return this.httpServ.get(this._rayquaza).pipe(map(resp => resp as string)
    );
  }

  getGarbador(): Observable<string> {
    return this.httpServ.get(this._garbador).pipe(map(resp => resp as string)
    );
  }

  getSawsbuck(): Observable<string> {
    return this.httpServ.get(this._sawsbuck).pipe(map(resp => resp as string)
    );
  }

  getCharacters(id1, id2, id3): IPokemon[] {
    
    this.getPokemon(id1).subscribe(
        data => {  
        let myName = data['name'];
        let char = myName.charAt(0);
        char = char.toUpperCase();
        myName = char + myName.substr(1);
        let myType = data['types'];
        let res;
        if(myType.length > 1){
          res = myType;
        }
        myType = myType['0'];
        myType = myType['type'];
        myType = myType['name'];
        let char2 = myType.charAt(0);
        char2 = char2.toUpperCase();
        myType = char2 + myType.substr(1);
        let myId = data['id'];
        let myImage = data['sprites'];
        myImage = myImage['front_default'];
        if(res){
          res = res['1'];
          res = res['type'];
          res = res['name'];
          let char3 = res.charAt(0);
          char3 = char3.toUpperCase();
          res = char3 + res.substr(1);
          myType = myType + ', ' + res;
        }
        this.myName = myName;
        this.myId = myId;
        this.myType = myType;
        this.myImage = myImage;
      }
      );

      this.getPokemon(id2).subscribe(
        data => {  
        let myName = data['name'];
        let char = myName.charAt(0);
        char = char.toUpperCase();
        myName = char + myName.substr(1);
        let myType = data['types'];
        let res;
        if(myType.length > 1){
          res = myType;
        }
        myType = myType['0'];
        myType = myType['type'];
        myType = myType['name'];
        let char2 = myType.charAt(0);
        char2 = char2.toUpperCase();
        myType = char2 + myType.substr(1);
        let myId = data['id'];
        let myImage = data['sprites'];
        myImage = myImage['front_default'];
        if(res){
          res = res['1'];
          res = res['type'];
          res = res['name'];
          let char3 = res.charAt(0);
          char3 = char3.toUpperCase();
          res = char3 + res.substr(1);
          myType = myType + ', ' + res;
        }
        this.myName2 = myName;
        this.myId2 = myId;
        this.myType2 = myType;
        this.myImage2 = myImage;
      }
      );

      this.getPokemon(id3).subscribe(
        data => {  
        let myName = data['name'];
        let char = myName.charAt(0);
        char = char.toUpperCase();
        myName = char + myName.substr(1);
        let myType = data['types'];
        let res;
        if(myType.length > 1){
          res = myType;
        }
        myType = myType['0'];
        myType = myType['type'];
        myType = myType['name'];
        let char2 = myType.charAt(0);
        char2 = char2.toUpperCase();
        myType = char2 + myType.substr(1);
        let myId = data['id'];
        let myImage = data['sprites'];
        myImage = myImage['front_default'];
        if(res){
          res = res['1'];
          res = res['type'];
          res = res['name'];
          let char3 = res.charAt(0);
          char3 = char3.toUpperCase();
          res = char3 + res.substr(1);
          myType = myType + ', ' + res;
        }
        this.myName3 = myName;
        this.myId3 = myId;
        this.myType3 = myType;
        this.myImage3 = myImage;
      }
      );
      
    return [
      {
        'name' : this.myName,
        'type' : this.myType,
        'id' : this.myId,
        'image' : this.myImage
      },
      {
        'name' : this.myName2,
        'type' : this.myType2,
        'id' : this.myId2,
        'image' : this.myImage2
      },
      {
        'name' : this.myName3,
        'type' : this.myType3,
        'id' : this.myId3,
        'image' : this.myImage3
      }
    ] // make a call to API in real assignment

  }

}
