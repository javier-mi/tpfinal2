import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './_helpers/auth.guard';

import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
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
	{ path: '', redirectTo: '/home', pathMatch: 'full' },
	{ path: '', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'camara', component: CamaraComponent},
    { path: 'fotos', component: FotosComponent},
    { path: 'usuario-add', component: UsuarioAddComponent},
    { path: 'usuario-edit', component: UsuarioEditComponent},
    { path: 'usuarios-list', component: UsuariosListComponent},
    { path: 'persona-add', component: PersonaAddComponent},
    { path: 'persona-edit', component: PersonaEditComponent},
	{ path: 'personas-list', component: PersonasListComponent},
    // otherwise redirect to home
    { path: '**', redirectTo: '' }

];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
