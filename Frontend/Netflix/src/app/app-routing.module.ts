import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MovieComponent } from './components/movie/movie.component';

const routes: Routes = [
	{
		path: 'movie',
		component: MovieComponent
	},
	 {
		path: '',
		component: LoginComponent
	},
		{
		path: 'huts',
		component: LoginComponent
	},


];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
