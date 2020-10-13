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
	}


	ping() {
		console.log("Pinged ")
		this.loginService.ping().subscribe(
			data => { this.s = String(data) },
			err => { console.error(err); this.s = err.error.text },
		);
	}

	getBestMovie() {
		this.movieService.getBestMovie().subscribe(
			data => { console.log("Data"); this.movie = data[0] },
			err => { console.log("Error"); console.error(err); this.movie = err.error.text },
		);

	}

	getMovies() {
		console.log(" Getting movies ")
		this.movieService.getMovies().subscribe(
			data => { console.log("Data"); this.movies = data },
			err => { console.log("Err"); console.error(err); this.movie = err.error.text },
		);

	}
}


