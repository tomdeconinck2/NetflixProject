import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MovieComponent } from './components/movie/movie.component';
import { MainComponent } from './components/main/main.component';

const routes: Routes = [
	{
		path: 'movies',
		component: MovieComponent
	},
	 {
		path: '',
		component: MainComponent
	},
		{
		path: 'login',
		component: LoginComponent
	},


];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
