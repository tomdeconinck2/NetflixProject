import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { MovieService } from 'src/app/services/movie.service';
import { MatTableDataSource } from '@angular/material/table';


@Component({
	selector: 'app-movie',
	templateUrl: './movie.component.html',
	//styleUrls: ['./../../app.component.css']
})
export class MovieComponent implements OnInit {



	constructor(private movieService: MovieService, private loginService: LoginService) { }
	ngOnInit(): void {
		this.getMoviesOfDb()
	}	
	

	movies;
	displayedColumns: string[] = ['id', 'title', 'genre', 'voteStats', 'link'];
	movieTable: Object [] = [];
	movieTableDS = new MatTableDataSource(this.movieTable);

	getMoviesOfDb() {
		console.log(" Getting movies ")
		this.movieService.getMoviesOfDb().subscribe(
			data => {
				console.log("Data: " + data);
				this.movies = data;
				
				this.movieTable = data as Object [];
				this.movieTableDS.data = this.movieTable;

				//TODO Using this line, leads to compile error. 
				//this.movieTableDS.data = data;
			}, 
			err => { console.log("Err"); console.error(err); this.movies = err.error.text },
		);
	}
}


//TODO is this nessecary? 
export interface MovieDetail {
	id: string;
	title: string;
	genre: string;
	score: string;
	nbOfVotes: string;
	
}





