import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';

import { CamaraComponent } from './camara/camara.component';
import { FotosComponent } from './fotos/fotos.component';

import { UsuarioAddComponent } from './usuario-add/usuario-add.component';
import { UsuarioEditComponent } from './usuario-edit/usuario-edit.component';
import { UsuariosListComponent } from './usuarios-list/usuarios-list.component';

import { PersonaAddComponent } from './persona-add/persona-add.component';
import { PersonaEditComponent } from './persona-edit/persona-edit.component';
import { PersonasListComponent } from './personas-list/personas-list.component';

import { IngresosListComponent } from './ingresos-list/ingresos-list.component';

const routes: Routes = [
	{path: '', redirectTo: '/login', pathMatch: 'full' },
	
	{path: 'login', component: LoginComponent},
	
	{path: 'camara', component: CamaraComponent},
	{path: 'fotos', component: FotosComponent},
	
	{path: 'usuario-add', component: UsuarioAddComponent},
	{path: 'usuario-edit/:id', component: UsuarioEditComponent},
	{path: 'usuarios-list', component: UsuariosListComponent},
	
    {path: 'persona-edit/:id', component: PersonaEditComponent},
    {path: 'persona-add', component: PersonaAddComponent},
    {path: 'personas-list', component: PersonasListComponent},
    
    {path: 'ingresos-list', component: IngresosListComponent}

];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
