import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule, } from '@angular/material/paginator';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSortModule, } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { ReactiveFormsModule} from '@angular/forms'


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


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
import { RatingComponent } from './components/rating/rating.component';
import { RatingService } from './services/rating.service';
import { SpecificUserComponent } from './components/specific-user/specific-user.component';

@NgModule({
	declarations: [
		AppComponent,
		LoginComponent,
		MovieComponent,
		MainComponent,
		UserComponent,
		RouteComponent,
		MovieDetailComponent,
		RatingComponent,
		SpecificUserComponent
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		HttpClientModule,
		MatInputModule,
		MatTableModule,
		MatPaginatorModule,
		MatSortModule,
		MatProgressSpinnerModule,
		BrowserAnimationsModule,
		ReactiveFormsModule
	],
	providers: [LoginService, MovieService, UserService, RatingService],
	bootstrap: [AppComponent]
})

export class AppModule { }
