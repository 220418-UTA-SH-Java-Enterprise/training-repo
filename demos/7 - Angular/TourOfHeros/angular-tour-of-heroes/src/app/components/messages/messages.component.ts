import { Component, OnInit } from '@angular/core';
import { MessagesService } from 'src/app/service/messages.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  //injection of service into our component
  constructor(public messageService: MessagesService) { }

  ngOnInit(): void {
  }

}
