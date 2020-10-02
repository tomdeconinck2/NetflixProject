import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { MovieComponent } from './components/movie/movie.component';

import { LoginService } from './services/login.service';
import { MovieService } from './services/movie.service';
import { MainComponent } from './components/main/main.component';

@NgModule({
	declarations: [
		AppComponent,
		LoginComponent,
		MovieComponent,
		MainComponent
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		HttpClientModule
	],
	providers: [LoginService, MovieService],
	bootstrap: [AppComponent]
})

export class AppModule { }
