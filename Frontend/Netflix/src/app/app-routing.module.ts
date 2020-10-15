import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MovieComponent } from './components/movie/movie.component';
import { MainComponent } from './components/main/main.component';
import { UserComponent } from './components/user/user.component';
import { RouteComponent } from './components/route/route.component';
import { RatingComponent } from './components/rating/rating.component'
import { MovieDetailComponent } from './components/movie-detail/movie-detail.component';
import { SpecificUserComponent } from './components/specific-user/specific-user.component';
import { MovieStreamComponent } from './components/movie-stream/movie-stream.component';

const routes: Routes = [
	{
		path: 'movie',
		component: MovieComponent
	},
	{
		path: 'movie/detail',
		component: MovieDetailComponent
	},
	{
		path: 'movie/detail/:id',
		component: MovieDetailComponent
	},
	{
		path: 'movie/stream/:id',
		component: MovieStreamComponent
	},
	{
		path: '',
		component: MainComponent
	},
	{
		path: 'login',
		component: LoginComponent
	},
	{
		path: 'route',
		component: RouteComponent
	},
	{
		path: 'user',
		component: UserComponent
	},
	{
		path: 'user/:id',
		component: SpecificUserComponent
	},
	{
		path: 'rating',
		component: RatingComponent
	},


];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
