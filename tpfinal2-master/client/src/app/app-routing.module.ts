import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UsersListComponent } from './users-list/users-list.component';
import { UserEditComponent } from './user-edit/user-edit.component';

const routes: Routes = [
		{ path: '', redirectTo: '/login', pathMatch: 'full' },
		{
	    path: 'home',
	    component: HomeComponent
		},
		{
	    path: 'login',
	    component: LoginComponent
	  },
	  {
	    path: 'users-list',
	    component: UsersListComponent
	  },
	  {
	    path: 'user-add',
	    component: UserEditComponent
	  },
	  {
	    path: 'user-edit/:id',
	    component: UserEditComponent
	  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
