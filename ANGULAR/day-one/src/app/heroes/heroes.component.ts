import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';
import { HeroService } from '../hero.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  heroes: Array<Hero>;
  newHero = new Hero();

  constructor(private heroService: HeroService) { }

  ngOnInit() {
    this.heroes = this.heroService.heroes;
  }

  addHero(hero: Hero) {
    this.heroes.unshift(hero);
    this.heroes = this.heroes.splice(0);
    this.newHero = new Hero();
  }

}
