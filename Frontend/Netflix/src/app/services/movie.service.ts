import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
	providedIn: 'root'
})
export class MovieService {
	x;

	constructor(private http: HttpClient) { }

	getMovies() {
		this.x = this.http.get('/server/movie/movies');
		console.log(this.x);
		return this.x;
	}

	getBestMovie() {

		this.x = this.http.get('/server/movie/');
		console.log(this.x);
		return this.x;
	}

	getMoviesOfDb() {
		this.x = this.http.get('/server/db/explore');
		console.log(this.x);
		return this.x;
	}


}
