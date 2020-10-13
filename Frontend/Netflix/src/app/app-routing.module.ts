import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MovieComponent } from './components/movie/movie.component';
import { MainComponent } from './components/main/main.component';
import { UserComponent } from './components/user/user.component';
import { RouteComponent } from './components/route/route.component';
import { MovieDetailComponent } from './components/movie-detail/movie-detail.component';

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


];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
