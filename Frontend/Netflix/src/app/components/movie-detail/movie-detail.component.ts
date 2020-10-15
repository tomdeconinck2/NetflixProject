import { Component, OnInit, Input, NgModule } from '@angular/core';
import { MovieService } from 'src/app/services/movie.service';
import { ActivatedRoute } from '@angular/router';


@Component({
	selector: 'app-movie-detail',
	templateUrl: './movie-detail.component.html',
	styleUrls: ['./../../app.component.css']
})
export class MovieDetailComponent implements OnInit {

	id : string;
	details;


	constructor(private movieService: MovieService, private route: ActivatedRoute) {}


	ngOnInit(): void {
		this.id=this.route.snapshot.paramMap.get("id");
		this.getMovieDetails(this.id);
	}


	getMovieDetails(id) {
		this.movieService.getMovieDetails(id).subscribe(
			data => { console.log("Data"); console.log(data);  this.details = data[0] },
			err => { console.log("Err"); console.error(err); this.details = err.error.text },
		);

	}
	
	getMovieLink(){
		// return "https://www.imdb.com/title/tt" + this.details.imdbId;	
		return "imdb.com/title/tt0" + this.details.imdbId;	
	}

}
