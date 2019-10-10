import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InicioComponent } from './inicio/inicio.component';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { FotosComponent } from './fotos/fotos.component';
import { UsuariosListComponent } from './usuarios-list/usuarios-list.component';
import { UsuarioEditComponent } from './usuario-edit/usuario-edit.component';

const routes: Routes = [
	{path: '', redirectTo: '/inicio', pathMatch: 'full' },
	{path: 'inicio', component: InicioComponent},
	{path: 'login', component: LoginComponent},
	{path: 'fotos', component: FotosComponent},
	{path: 'registro', component: RegistroComponent},
	{path: 'usuarios-list', component: UsuariosListComponent},
	{path: 'usuario-add', component: UsuarioEditComponent},
	{path: 'usuario-edit/:id', component: UsuarioEditComponent}
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
