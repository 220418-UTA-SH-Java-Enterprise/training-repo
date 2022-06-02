import { Component, OnInit } from '@angular/core';
import { Hero } from 'src/app/models/hero';
import { HeroService } from 'src/app/service/hero.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  //set up my properties
  heroes: Hero[] = [];

  //inject our heroService into this component so we can display our top heroes
  //dependency injection of a service to a component
  constructor(private heroService: HeroService) { }

  //this is a lifecycle hook to our component to where we call after the component is initialized
  ngOnInit(): void {
    this.getTopHeroes();
  }

  getTopHeroes(): void{
    this.heroService.getHeroes().subscribe(heroes => {
      this.heroes = heroes.slice(1, 5);
    })
  }

}
