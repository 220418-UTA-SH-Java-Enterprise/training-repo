import { Component, OnInit } from '@angular/core';
import { Hero } from './hero';
import { HEROES } from './mock-heroes';
import { HeroService } from 'src/app/service/hero.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  // hero = 'Windstorm';

  // hero: Hero = {
  //   id:1,
  //   name:'Windstorm'
  // };

  heroes:Hero[]=[];

  selectedHero?:Hero;

  onSelect(hero:Hero):void {
    this.selectedHero = hero;
  }

  getHeroes():void{
    this.heroService.getHeroes()
    .subscribe(heroes => this.heroes = heroes)
  }

  constructor(private heroService:HeroService) { }

  ngOnInit(): void {
    this.getHeroes();
  }

}
