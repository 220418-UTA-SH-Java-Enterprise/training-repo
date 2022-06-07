import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  text = 'User Page';
  users: any; //this is initialized upon instantiation of this component from the service that we will set up

  constructor(private userService: UserService) { }
  
  ngOnInit(): void {
    this.users = this.userService.getUsers();
    console.log(this.users);
  }

}
