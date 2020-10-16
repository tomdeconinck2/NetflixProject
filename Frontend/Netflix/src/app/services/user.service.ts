import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
}


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getUsers(){
    console.log('Method getUsers in user.service.ts');
    return this.http.get('/server/user-service/all');
  }

  getUser(id){
    return this.http.get('/server/user-service/' + id)
  }

  getRatingsFromUser(id){
    return this.http.get('/server/user-service/' + id + '/ratings')
  }

  addRating(user){
    let body = JSON.stringify(user);
    return this.http.post('/server/user-service/addUser', user, httpOptions);
  }

  deleteUser(user_id){
    return this.http.delete('server/user-service/' + user_id);
  }

}
