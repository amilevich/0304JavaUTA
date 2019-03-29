import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class JokeService {
  private _url = 'https://icanhazdadjoke.com/';
  private _urlSearch = 'https://icanhazdadjoke.com/search?';
  private temp: string;
  private httpOptions = {
    headers: new HttpHeaders ({
      'Accept':  'application/json'
    })
  };

  constructor(private httpServ: HttpClient) { }

  getJoke(): Observable<string> {
    // return this.httpServ.post(this._url, null, this.httpOptions).pipe(
    //   map(res => res as string)
    // );
    return this.httpServ.get(this._url, this.httpOptions).pipe(
      map(res => res as string)
    );
    // return this.httpServ.post(this._url, this.httpOptions).pipe(
    //   map(res => res as string)
    // );
  }

  searchJoke(search: string): Observable<string> {
    this.temp = this._urlSearch + 'term=' + search;
    return this.httpServ.get(this.temp, this.httpOptions).pipe(
      map(res => res as string)
    );
  }
}
