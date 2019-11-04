import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Route } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

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

const routes: Route[] = [
  {path: '', component: AppComponent},
  {path: 'login', component: LoginComponent},
  {path: 'camara', component: CamaraComponent},
  {path: 'fotos', component: FotosComponent},
  {path: 'usuario-add', component: UsuarioAddComponent},
  {path: 'usuario-edit', component: UsuarioEditComponent},
  {path: 'usuarios-list', component: UsuariosListComponent},
  {path: 'persona-add', component: PersonaAddComponent},
  {path: 'persona-edit', component: PersonaEditComponent},
  {path: 'personas-list', component: PersonasListComponent},
  {path: 'ingresos-list', component: IngresosListComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CamaraComponent,
    FotosComponent,
    UsuarioAddComponent,
    UsuarioEditComponent,
    UsuariosListComponent,
    PersonaAddComponent,
    PersonaEditComponent,
    PersonasListComponent,
    IngresosListComponent
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
