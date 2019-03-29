import { Component, OnInit } from '@angular/core';
import { JokeService } from '../shared/joke.service';

@Component({
  selector: 'app-random-joke',
  templateUrl: './random-joke.component.html',
  styleUrls: ['./random-joke.component.css'],
  providers: [JokeService]
})
export class RandomJokeComponent implements OnInit {

  _joke = 'Click the button to get a random Joke';
  constructor(private _jokeService: JokeService) { }

  ngOnInit() {

  }

  randomJokeButtonClicked() {
    console.log('click random joke');
    this._jokeService.getJoke().subscribe(data => {
      this._joke = data['joke'];
    });
  }

}
