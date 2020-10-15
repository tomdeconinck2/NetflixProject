import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
}

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  constructor(private http: HttpClient) { }

  getRatings(){
    return this.http.get('server/rating-service/all');
  }

  addRating(rating){
    let body = JSON.stringify(rating);
    return this.http.post('/server/rating-service/addRating', rating, httpOptions);
  }

  deleteRating(rating_id){
    return this.http.delete('server/rating-service/' + rating_id);
  }
}
