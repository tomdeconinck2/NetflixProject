import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
	providedIn: 'root'
})
export class MovieService {


	x; y;

	constructor(private http: HttpClient) { }

	getMovies() {
		return this.http.get('/server/movie/movies');
	}

	getBestMovie() {
		return this.http.get('/server/movie/');
	}


	getMoviesOfDb() {
		return this.http.get('/server/db/explore');
	}

	getMovieDetails(id: any) {
		return this.http.get('/server/db/detail?id=' + id)
	}

}
