import { Component, OnInit } from '@angular/core';
import { JokeService } from '../shared/joke.service';

@Component({
  selector: 'app-search-joke',
  templateUrl: './search-joke.component.html',
  styleUrls: ['./search-joke.component.css'],
  providers: [JokeService]
})
export class SearchJokeComponent implements OnInit {

  _searchTerm: string;
  constructor(private _jokeService: JokeService) { }
  data: any;
  set searchTerm(search: string) {
    this._searchTerm = search;
  }
  get searchTerm() {
    return this._searchTerm;
  }

  ngOnInit() {
  }

  onSearch() {
    console.log('searching joke');
    this._jokeService.searchJoke(this._searchTerm).subscribe(data => {
      console.log(data['results']);
      this.data = data['results'];
    });
  }
  clickSearch(): void {
    this.onSearch();
  }

}

