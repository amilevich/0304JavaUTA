import { Injectable } from '@angular/core';
import { Hero } from './hero';

@Injectable()
export class HeroService {

  heroes: Array<Hero> = [
    new Hero(1, 'Spider Man',
      'https://i.ytimg.com/vi/K4zm30yeHHE/maxresdefault.jpg', 3
    ),

    new Hero(2, 'Hulk',
      'https://thumbor.forbes.com/thumbor/1280x868/smart/https%3A%2F%2Fblogs-images.forbes.com%2Frobcain%2Ffiles%2F2017%2F07%2FHulk.jpeg',
      11),

    new Hero(3, 'Batman',
      'https://i.pinimg.com/originals/98/0a/27/980a27ca01c3e76edd2cf0f948d8a82e.jpg',
      1),

    new Hero(4, 'Black Panther',
      'http://cdn2us.denofgeek.com/sites/denofgeekus/files/black_panther_11.jpg',
      6
    ),
  ];
  constructor() { }
}
