import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './specific-user.component.html',
  styleUrls: ['./../../app.component.css']
})
export class SpecificUserComponent implements OnInit {
  user_id;
  user;
  ratings;
  error;

  
  constructor(private userService: UserService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.user_id = this.route.snapshot.paramMap.get("id");
    this.getUserInfo();
    this.getRatingsFromUser();
  }

  getUserInfo(){
    this.userService.getUser(this.user_id).subscribe(
      data => {this.user = data},
      err => {console.error(err); this.error=err.err.error.text},
      () => console.log('users loaded in user.component.ts')
    );
  }

  getRatingsFromUser(){
    this.userService.getRatingsFromUser(this.user_id).subscribe(
			data => { console.log("Data"); console.log(data);  this.ratings = data },
			err => { console.log("Err"); console.error(err); this.ratings = err.error.text },
		);
  }

}
