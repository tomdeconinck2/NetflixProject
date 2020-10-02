import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';

@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./../../app.component.css']
})
export class LoginComponent implements OnInit {

	s = '/';
	movie = '/';

	constructor(private loginService: LoginService) { }

	ngOnInit(): void {
		//this.ping();
	}


	ping() {
		console.log("Pinged ")
		this.loginService.ping();
		this.loginService.ping().subscribe(
			data => { this.s = String(data) },
			err => { console.error(err); this.s = err.error.text },
			() => console.log('bikes loaded')
		);
	}


}
