import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

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

  deleteUser(user_id){
    return this.http.delete('server/user-service/' + user_id);
  }

}
