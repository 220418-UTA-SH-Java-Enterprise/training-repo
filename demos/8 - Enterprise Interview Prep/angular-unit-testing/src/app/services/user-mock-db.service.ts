import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserMockDbService {

  /*
    This service is a dummy db service that we created that will return dummy data to run the tests of this component.
  */ 

  constructor() { }

  getUsers(): Array<{}>{
    return [{
      //return one object literal here
      name: 'user1',
      username: 'username1'
    }];
  }
}
