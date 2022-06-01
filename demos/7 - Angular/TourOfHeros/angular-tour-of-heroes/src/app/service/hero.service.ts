import { Injectable } from '@angular/core';
import { Hero } from '../components/heroes/hero';
import { HEROES } from '../components/heroes/mock-heroes';
import { Observable, of } from 'rxjs';
import { MessagesService } from './messages.service';

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  
  //inject our messageService within this service so it can produce messages to the quene
  //typical service-in-service injection
  constructor(private messageService: MessagesService) { }
  
  getHeroes(): Observable<Hero[]>{
   const heroes = of(HEROES);
   this.messageService.add('HeroService: fetched all heroes');
   return heroes;
  }
}
