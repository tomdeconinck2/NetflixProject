import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform browser/animations';
import { MatInputModule, MatPaginatorModule, MatProgressSpinnerModule, MatSortModule, MatTableModule } from "@angular/material";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { MovieComponent } from './components/movie/movie.component';

import { LoginService } from './services/login.service';
import { MovieService } from './services/movie.service';
import { MainComponent } from './components/main/main.component';
import { UserService } from './services/user.service';
import { UserComponent } from './components/user/user.component';
import { RouteComponent } from './components/route/route.component';
import { MovieDetailComponent } from './components/movie-detail/movie-detail.component';

@NgModule({
	declarations: [
		AppComponent,
		LoginComponent,
		MovieComponent,
		MainComponent,
		UserComponent,
		RouteComponent,
		MovieDetailComponent
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		HttpClientModule,
		MatInputModule,
        MatTableModule,
        MatPaginatorModule,
        MatSortModule,
        MatProgressSpinnerModule
	],
	providers: [LoginService, MovieService, UserService],
	bootstrap: [AppComponent]
})

export class AppModule { }
