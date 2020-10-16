import { Component, OnInit } from '@angular/core';
import { MovieService } from 'src/app/services/movie.service';

@Component({
	selector: 'app-movie-stream',
	templateUrl: './movie-stream.component.html',
	styleUrls: ['./movie-stream.component.css']
})

// Component that shows full screen video
export class MovieStreamComponent implements OnInit {

	movieStreamLocation
	
	constructor(private movieService: MovieService) { }

	ngOnInit(): void {
		this.movieStreamLocation = this.movieService.getMovieStreamLocation();
	}

}
