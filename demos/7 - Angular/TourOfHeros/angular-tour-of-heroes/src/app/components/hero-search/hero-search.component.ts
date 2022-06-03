import { Component, OnInit } from '@angular/core';
import { debounceTime, distinctUntilChanged, Observable, Subject, switchMap } from 'rxjs';
import { Hero } from 'src/app/models/hero';
import { HeroService } from 'src/app/service/hero.service';

@Component({
  selector: 'app-hero-search',
  templateUrl: './hero-search.component.html',
  styleUrls: ['./hero-search.component.css']
})
export class HeroSearchComponent implements OnInit {
  //set properties here
  heroes$!: Observable<Hero[]>;

  //a subject is a special type of observable that allows values to be multicasted to many Observers
  //an observer is anything that subscribes to an observable
  private searchTerms = new Subject<string>();

  constructor(private heroService: HeroService) { }

  ngOnInit(): void {
    this.heroes$ = this.searchTerms.pipe(
      //wait 300ms after each keystroke before considering to do the search of that term
      debounceTime(300),
      //ignore new term if it is the same as the last term entered
      distinctUntilChanged(),
      //switch to new search observable each time the term changes
      switchMap((term: string) => this.heroService.searchHeroes(term))
    );
  }

  //set our methods here
  search(term: string): void{
    //push a term into the observable stream back in heroService
    this.searchTerms.next(term);
  }
}
