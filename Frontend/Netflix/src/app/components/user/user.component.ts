import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service'

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./../../app.component.css']
})
export class UserComponent implements OnInit {
  welcomeMessage;
  users;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getUsers;
  }

  getWelcomeMessage(){
    this.userService.getWelcomeMessage().subscribe(
      data => {this.welcomeMessage = data},
      err => console.error(err),
      () => console.log('Welcome message loaded in user.components.ts')
    );
  }

  getUsers(){
    this.userService.getUsers().subscribe(
      data => {this.users = data},
      err => console.error(err),
      () => console.log('users loaded in user.component.ts')
    );
  }

}
