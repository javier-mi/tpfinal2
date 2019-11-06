import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './_helpers/auth.guard';

import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

import { CamaraComponent } from './registro/camara/camara.component';

import { UsuarioAddComponent } from './usuario/usuario-add/usuario-add.component';
import { UsuarioEditComponent } from './usuario/usuario-edit/usuario-edit.component';
import { UsuarioListComponent } from './usuario/usuario-list/usuario-list.component';

import { PersonaAddComponent } from './persona/persona-add/persona-add.component';
import { PersonaEditComponent } from './persona/persona-edit/persona-edit.component';
import { PersonaListComponent } from './persona/persona-list/persona-list.component';
import { FotoComponent } from './persona/foto/foto.component';

const routes: Routes = [
	{ path: '', redirectTo: '/home', pathMatch: 'full' },
	{ path: '', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'camara', component: CamaraComponent},
    { path: 'fotos', component: FotoComponent},
    { path: 'usuario-add', component: UsuarioAddComponent},
    { path: 'usuario-edit', component: UsuarioEditComponent},
    { path: 'usuarios-list', component: UsuarioListComponent},
    { path: 'persona-add', component: PersonaAddComponent},
    { path: 'persona-edit', component: PersonaEditComponent},
	{ path: 'personas-list', component: PersonaListComponent},
    { path: '**', redirectTo: '' } // otherwise redirect to home
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
