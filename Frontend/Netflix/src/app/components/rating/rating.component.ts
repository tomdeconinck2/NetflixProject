import { Component, OnInit } from '@angular/core';
import { RatingService } from 'src/app/services/rating.service';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./../../app.component.css']
})
export class RatingComponent implements OnInit {
  ratings;

  constructor(private ratingService: RatingService) { 
    this.getRatings();
  }

  ngOnInit(): void {
  }

  getRatings(){
    this.ratingService.getRatings().subscribe(
      data => {this.ratings = data},
      err => console.error(err),
      () => console.log('users loaded in user.component.ts')
    );
  }

}
