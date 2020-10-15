import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MovieDetail } from '../components/movie/movie.component';

@Injectable({
	providedIn: 'root'
})
export class MovieService {


	x;

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

	//Without casting
	getMovieDetailsWC(id: any) {
		return this.http.get('/server/db/detail?id=' + id)
	}
	
	getMovieDetails(id: any) {
		return this.http.get<MovieDetail>('/server/db/detail?id=' + id)
	}
	
	getMovieStream(){
		return this.http.get('/server/stream/test') //TODO use Id
	}

}
