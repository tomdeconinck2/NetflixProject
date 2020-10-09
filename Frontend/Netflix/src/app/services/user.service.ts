import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getUsers(){
    console.log('Method getUsers in user.service.ts')
    return this.http.get('/server/user-service/all')
  }

  getWelcomeMessage(){
    return this.http.get('/server/user-service/')
  }

  //TODO delete/save/... methods

}
