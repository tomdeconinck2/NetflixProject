import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { MovieService } from 'src/app/services/movie.service';


@Component({
	selector: 'app-route',
	templateUrl: './route.component.html',
	styleUrls: ['./../../app.component.css']
})
export class RouteComponent implements OnInit {

	s = '/';
	movie = '/';
	movies;

	constructor(private movieService: MovieService, private loginService: LoginService) { }

	ngOnInit(): void {
		//this.ping();
	}


	ping() {
		console.log("Pinged ")
		this.loginService.ping();
		this.loginService.ping().subscribe(
			data => { this.s = String(data) },
			err => { console.error(err); this.s = err.error.text },
			() => console.log('bikes loaded')
		);
	}

	getBestMovie() {
		console.log(" Getting best movie ")
		//this.loginService.ping();
		this.movieService.getBestMovie();

		this.movieService.getBestMovie().subscribe(
			data => { console.log("Data"); this.movie = data },
			err => { console.log("Error"); console.error(err); this.movie = err.error.text },
			() => console.log('bikes loaded')
		);

	}


	getMovies() {
		console.log(" Getting movies ")
		//this.loginService.ping();
		this.movieService.getMovies();

		this.movieService.getMovies().subscribe(
			data => { console.log("Data"); this.movies = data },
			err => { console.log("Err"); console.error(err); this.movie = err.error.text },
		);

	}
}


