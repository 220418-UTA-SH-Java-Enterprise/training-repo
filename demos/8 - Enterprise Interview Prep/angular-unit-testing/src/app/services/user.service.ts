import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  getUsers(): Array<{}>{
    return [
    {
      name: 'user1',
      username: 'username1'
    },
    {
      name: 'user2',
      username: 'username2'
    }
  ];
  }
}
