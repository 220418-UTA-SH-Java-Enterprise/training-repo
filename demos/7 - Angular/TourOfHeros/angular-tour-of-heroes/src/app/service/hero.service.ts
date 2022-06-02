import { Injectable } from '@angular/core';
import { Hero } from '../models/hero';
import { HEROES } from '../models/mock-heroes';
import { catchError, Observable, of, tap } from 'rxjs';
import { MessagesService } from './messages.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HeroService {
  //two ways to set our HTTP headers
  //1) set a class field called httpOptions that will hold our header values in it
  //2) create an CORS Interceptor and add it as a provider to our entire app
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  //define our server URL string
  private serverURL = 'api/heroes';
  
  //inject our messageService within this service so it can produce messages to the quene
  //typical service-in-service injection
  constructor(private messageService: MessagesService, private http: HttpClient) { }
  
  getHeroes(): Observable<Hero[]>{
  //  const heroes = of(HEROES);
  //  this.messageService.add('HeroService: fetched all heroes');
  //  return heroes;

    //getting data now from our server
    //HTTPClient operates similar to the FETCH API in regards to making asynchrous HTTP requests from our frontend to our backend, however it differs from FETCH because it returns Observables instead of Promises.
    return this.http.get<Hero[]>(this.serverURL).pipe(
      //tapping into the flow of my observable value and send a message to messageService
      tap(_ => this.log('fetched all heroes')),
      //catchError will be intercepting any Observable that failed to return viable response data
      catchError(this.handleError<Hero[]>('getHeroes', []))
    );
  }

  //return a single hero
  getHero(id: number): Observable<Hero>{
    //OLD WAY
    //for now, assume that a hero with a specified id always exists
    //error handling will be added later
    //const hero = HEROES.find(h => h.id === id)!;
    //send a message of this activity to the messageService\
    //this.messageService.add(`HeroService: fetched hero id=${id}`);
    //return of(hero);

    //NEW WAY WITH HttpClient
    const url = `${this.serverURL}/${id}`;
    return this.http.get<Hero>(url).pipe(
      tap( _ => this.log(`fetched hero id=${id}`)),
      catchError(this.handleError<Hero>(`getHero id=${id}`))
    );
  }

  //CRUD operations

  //update hero
  updateHero(hero: Hero): Observable<any>{
    return this.http.put(this.serverURL, hero, this.httpOptions).pipe(
      tap(_ => this.log(`updated hero id=${hero.id}`)),
      catchError(this.handleError<any>('updateHero'))
    );
  }

  //delete hero
  deleteHero(id: number): Observable<Hero>{
    const url = `${this.serverURL}/${id}`;

    return this.http.delete<Hero>(url, this.httpOptions).pipe(
      tap(_ => this.log(`deleted hero id=${id}`)),
      catchError(this.handleError<any>('deleteHero'))
    );
  }
  //add hero
  addHero(hero: Hero): Observable<Hero>{
    return this.http.post<Hero>(this.serverURL, hero, this.httpOptions).pipe(
      tap((newHero: Hero) => this.log(`added hero with id=${newHero.id}`)),
      catchError(this.handleError<any>('addHero'))
    );
  }

  //log a heroservice message using our messageService
  private log(message: string){
    this.messageService.add(`HeroService: ${message}`);
  }

  private handleError<T>(operation = 'operation', result?: T){
    //send error messages to the log() which in turn record that error in our messageService
    return(error: any): Observable<T> => {
      console.error(error);

      this.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    };
  }
}
