import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./../../app.component.css']
})
export class UserComponent implements OnInit {
  users;
  userForm: FormGroup;
  validMessage: string = "/";

  constructor(private userService: UserService) { 
  }

  ngOnInit(): void {
    this.getUsers();
    this.initialiseUserForm();
  }

  initialiseUserForm(){
    this.userForm = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required)
    })
  }

  getUsers(){
    this.userService.getUsers().subscribe(
      data => {this.users = data},
      err => console.error(err),
      () => console.log('users loaded in user.component.ts')
    );
  }

  addUser(){
    this.validMessage = "The new user has been succesfully added.";
    this.userService.addRating(this.userForm.value).subscribe();
    this.initialiseUserForm();
    this.getUsers();
  }


  deleteUser(user_id){
    this.userService.deleteUser(user_id).subscribe();
    this.getUsers();
  }
}
