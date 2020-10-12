import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { MovieService } from 'src/app/services/movie.service';
//import { MovieService} from '../../services/movie.service'

@Component({
	selector: 'app-movie',
	templateUrl: './movie.component.html',
	styleUrls: ['./../../app.component.css']
})
export class MovieComponent implements OnInit {

	s = '/';
	movie = '/';
	movies;

	constructor(private movieService: MovieService, private loginService: LoginService) { }

	ngOnInit(): void {
		this.getMoviesOfDb()
	}



	getMoviesOfDb() {
		console.log(" Getting movies ")
		this.movieService.getMoviesOfDb();

		this.movieService.getMoviesOfDb().subscribe(
			data => { console.log("Data"); this.movies = data },
			err => { console.log("Err"); console.error(err); this.movie = err.error.text },
		);

	}
}


