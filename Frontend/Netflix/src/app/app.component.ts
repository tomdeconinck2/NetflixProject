import { Component } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Netflix';
  username='Not logged in';


	constructor(private loginService: LoginService) { }

	ngOnInit(): void {
	}


	getUserName() {
		console.log("Pinged ")
		this.loginService.ping();
		this.loginService.getUserName().subscribe(
			data => { this.username = String(data) },
			err => { console.error(err); this.username = err.error.text },
			() => console.log('Username fixed')
		);
	}
	



}
