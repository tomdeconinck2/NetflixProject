import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';

@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

	s = '/';

	constructor(private loginService: LoginService) { }

	ngOnInit(): void {
		this.ping();
	}


	ping() {
		console.log("Pinged ")
		this.loginService.ping();
		this.loginService.ping().subscribe(
			data => { this.s = data },
			err => console.error(err),
			() => console.log('bikes loaded')
		);
	}


}
