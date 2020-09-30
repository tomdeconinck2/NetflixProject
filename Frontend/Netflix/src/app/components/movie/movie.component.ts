import { Component, OnInit } from '@angular/core';
import { MovieService} from '../../services/movie.service'

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  public s = "default";

  constructor(private movieService : MovieService) { }

  ngOnInit(): void { }//this.getBikes()}

getBikes(){
	this.movieService.getMovies().subscribe(
		data => {this.s = String(data)}
	)
}

}
