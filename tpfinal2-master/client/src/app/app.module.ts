import { ErrorInterceptor } from './_helpers/error.interceptor';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatIconModule, MatProgressSpinnerModule, MatGridListModule } from '@angular/material';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule} from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Route } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

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

import { JwtInterceptor } from './_helpers/jwt.interceptor';

const routes: Route[] = [
  {path: '', component: AppComponent},

  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  
  {path: 'camara', component: CamaraComponent},
  {path: 'fotos', component: FotosComponent},
  
  {path: 'usuario-add', component: UsuarioAddComponent},
  {path: 'usuario-edit', component: UsuarioEditComponent},
  {path: 'usuarios-list', component: UsuariosListComponent},
  
  {path: 'persona-add', component: PersonaAddComponent},
  {path: 'persona-edit', component: PersonaEditComponent},
  {path: 'personas-list', component: PersonasListComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    CamaraComponent,
    FotosComponent,
    UsuarioAddComponent,
    UsuarioEditComponent,
    UsuariosListComponent,
    PersonaAddComponent,
    PersonaEditComponent,
    PersonasListComponent
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
    MatIconModule,
    MatToolbarModule,
    MatProgressSpinnerModule,
    MatGridListModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

    // provider used to create fake backend
    //fakeBackendProvider
],
  bootstrap: [AppComponent]
})
export class AppModule { }
