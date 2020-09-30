import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
//import {Observable} from 'rxjs/Observable';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  getLogin() {
    let token = localStorage.getItem('access_token');
    return this.http.get('/server/login'//,
     // {headers: new HttpHeaders().set('Authorization', 'Bearer ' + token)}
    );
  }
}
