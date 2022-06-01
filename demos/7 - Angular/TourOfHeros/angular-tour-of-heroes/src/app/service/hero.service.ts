import { Injectable } from '@angular/core';
import { Hero } from '../components/heroes/hero';
import { HEROES } from '../components/heroes/mock-heroes';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  getHeroes(): Observable<Hero[]>{
   const heroes = of(HEROES);
   return heroes;
  }

  constructor() { }
}
