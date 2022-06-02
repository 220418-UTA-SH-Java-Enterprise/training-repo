import { Location } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HeroService } from 'src/app/service/hero.service';
import { Hero } from '../../models/hero';

@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {

  @Input() 
  hero?:Hero;

  constructor(private route: ActivatedRoute, private location: Location, private heroService: HeroService) { }

  ngOnInit(): void {
    //render the hero info after component initialization
    this.getHero();
  }

  getHero(): void{
    //capture the id from the URL path
    const id = Number(this.route.snapshot.paramMap.get('id'));
    //make a call to our hero service to get our hero's information
    this.heroService.getHero(id).subscribe(hero => {
      this.hero = hero;
    });
  }

  goBack(): void{
    this.location.back();
  }

  save(): void{
    if(this.hero){
      this.heroService.updateHero(this.hero).subscribe(() => this.goBack());
    }
  }
}
