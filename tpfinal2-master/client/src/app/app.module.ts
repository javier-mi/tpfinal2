import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Route } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { InicioComponent } from './inicio/inicio.component';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { FotosComponent } from './fotos/fotos.component';
import { UsuariosListComponent } from './usuarios-list/usuarios-list.component';
import { PersonasListComponent } from './personas-list/personas-list.component';
import { UsuarioAddComponent } from './usuario-add/usuario-add.component';
import { UsuarioEditComponent } from './usuario-edit/usuario-edit.component';
import { PersonaEditComponent } from './persona-edit/persona-edit.component';

const routes: Route[] = [
  {path: '', component: AppComponent},
  {path: 'inicio', component: InicioComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registro', component: RegistroComponent},
  {path: 'fotos', component: FotosComponent},
  {path: 'usuario-add', component: UsuarioAddComponent},
  {path: 'usuario-edit', component: UsuarioEditComponent},
  {path: 'persona-edit', component: PersonaEditComponent},
  {path: 'usuarios-list', component: UsuariosListComponent},
  {path: 'personas-list', component: PersonasListComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    LoginComponent,
    RegistroComponent,
    FotosComponent,
    UsuariosListComponent,
    PersonasListComponent,
    UsuarioAddComponent,
    UsuarioEditComponent,
    PersonaEditComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
