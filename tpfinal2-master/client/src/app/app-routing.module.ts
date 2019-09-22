import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersListComponent } from './users-list/users-list.component';
import { UserEditComponent } from './user-edit/user-edit.component';

const routes: Routes = [
	  { path: '', redirectTo: '/users-list', pathMatch: 'full' },
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
