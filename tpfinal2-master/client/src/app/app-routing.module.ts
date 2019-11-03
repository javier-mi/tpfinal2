import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InicioComponent } from './inicio/inicio.component';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { FotosComponent } from './fotos/fotos.component';
import { UsuariosListComponent } from './usuarios-list/usuarios-list.component';
import { PersonasListComponent } from './personas-list/personas-list.component';
import { UsuarioEditComponent } from './usuario-edit/usuario-edit.component';
import { UsuarioAddComponent } from './usuario-add/usuario-add.component';
import { PersonaEditComponent } from './persona-edit/persona-edit.component';

const routes: Routes = [
	{path: '', redirectTo: '/inicio', pathMatch: 'full' },
	{path: 'inicio', component: InicioComponent},
	{path: 'login', component: LoginComponent},
	{path: 'fotos', component: FotosComponent},
	{path: 'registro', component: RegistroComponent},
	{path: 'usuarios-list', component: UsuariosListComponent},
	{path: 'usuario-add', component: UsuarioAddComponent},
	{path: 'usuario-edit/:id', component: UsuarioEditComponent},
	{path: 'personas-list', component: PersonasListComponent},
    {path: 'persona-edit/:id', component: PersonaEditComponent}
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
