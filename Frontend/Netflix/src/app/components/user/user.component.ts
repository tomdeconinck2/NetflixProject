import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./../../app.component.css']
})
export class UserComponent implements OnInit {
  users;

  constructor(private userService: UserService) { 
    this.getUsers();
  }

  ngOnInit(): void {
  }

  getUsers(){
    this.userService.getUsers().subscribe(
      data => {this.users = data},
      err => console.error(err),
      () => console.log('users loaded in user.component.ts')
    );
  }
}
