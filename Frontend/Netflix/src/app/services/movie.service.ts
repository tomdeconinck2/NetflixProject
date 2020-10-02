import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
	providedIn: 'root'
})
export class MovieService {
	x;

	constructor(private http: HttpClient) { }

	getMovies() {
		this.x = this.http.get('/movieserver/movies');
		console.log(this.x);
		return this.x;
	}

	getBestMovie() {

		this.x = this.http.get('/movieserver/');
		console.log(this.x);
		return this.x;
	}
}
