import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RatingService } from 'src/app/services/rating.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './specific-user.component.html',
  styleUrls: ['./../../app.component.css']
})
export class SpecificUserComponent implements OnInit {
  user_id: number;
  rating_value_options: number[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  ratingForm: FormGroup;
  user;
  ratings;
  error = "/";

  validMessage: string = "/";

  
  constructor(private userService: UserService, private route: ActivatedRoute, private ratingService: RatingService) { }

  ngOnInit(): void {
    this.user_id = Number(this.route.snapshot.paramMap.get("id"));
    this.getUserInfo();
    this.getRatingsFromUser();
    this.initialiseRatingForm();
  }

  initialiseRatingForm(){
    this.ratingForm = new FormGroup({
      userId: new FormControl(this.user_id),
      movieId: new FormControl('', Validators.required),
      rating: new FormControl('', Validators.required)
    })
  }

  getUserInfo(): void{
    this.userService.getUser(this.user_id).subscribe(
      data => {this.user = data},
      err => {console.error(err); this.error=err.err.error.text},
      () => console.log('users loaded in user.component.ts')
    );
  }

  getRatingsFromUser(): void{
    this.userService.getRatingsFromUser(this.user_id).subscribe(
			data => { console.log("Data"); console.log(data);  this.ratings = data },
			err => { console.log("Err"); console.error(err); this.error = err.error.text },
    );
  }

  addRating(){
    this.validMessage = "Your new rating has been succesfully added. Thank you!";
    this.ratingService.addRating(this.ratingForm.value).subscribe();
    this.ratingForm.reset();
    this.initialiseRatingForm();
    this.getRatingsFromUser();
  }

  //TODO update the page so the deleted rating is not visible anymore.
  // window.location.reload() does not work because it is run before the deleteRating function terminates...
  deleteRating(rating_id){
    this.ratingService.deleteRating(rating_id).subscribe();
    this.getRatingsFromUser();
  }

}
