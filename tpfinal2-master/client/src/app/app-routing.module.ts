import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { PhotosComponent } from './photos/photos.component';
import { UsersListComponent } from './users-list/users-list.component';
import { UserEditComponent } from './user-edit/user-edit.component';

const routes: Routes = [
	{path: '', redirectTo: '/home', pathMatch: 'full' },
	{path: 'home', component: HomeComponent},
	{path: 'login', component: LoginComponent},
	{path: 'photos', component: PhotosComponent},
	{path: 'register', component: RegisterComponent},
	{path: 'users-list', component: UsersListComponent},
	{path: 'user-add', component: UserEditComponent},
	{path: 'user-edit/:id', component: UserEditComponent}
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
