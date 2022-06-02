import { Component, OnInit } from '@angular/core';
import { Hero } from '../../models/hero';
import { HEROES } from '../../models/mock-heroes';
import { HeroService } from 'src/app/service/hero.service';
import { MessagesService } from 'src/app/service/messages.service';

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

  
  constructor(private heroService:HeroService, private messageService: MessagesService) { }
  
  ngOnInit(): void {
    this.getHeroes();
  }

  // selectedHero?:Hero;

  // onSelect(hero:Hero):void {
  //   this.selectedHero = hero;
  //   this.messageService.add(`HeroesComponent: User selected hero with id=${hero.id}`);
  // }

  getHeroes():void{
    this.heroService.getHeroes()
    .subscribe(heroes => this.heroes = heroes)
  }

  delete(hero: Hero): void{
    //filtering out our removed hero from the hero array
    this.heroes = this.heroes.filter(h => h !== hero);

    //making the server call to remove hero from the database
    this.heroService.deleteHero(hero.id).subscribe();
    //if we don't add subscribe() here, then the service will not send the delete request to the server
    //RULE to Observables: they do nothing until something subscribes
  }

  add(name: string): void{
    name = name.trim();
    if(!name){ return; }

    this.heroService.addHero({ name } as Hero).subscribe(hero => {
      this.heroes.push(hero);
    })
  }

}
