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

import { CamaraComponent } from './registro/camara/camara.component';

import { UsuarioAddComponent } from './usuario/usuario-add/usuario-add.component';
import { UsuarioEditComponent } from './usuario/usuario-edit/usuario-edit.component';
import { UsuarioListComponent } from './usuario/usuario-list/usuario-list.component';

import { PersonaAddComponent } from './persona/persona-add/persona-add.component';
import { PersonaEditComponent } from './persona/persona-edit/persona-edit.component';
import { PersonaListComponent } from './persona/persona-list/persona-list.component';
import { FotoComponent } from './persona/foto/foto.component';

import { JwtInterceptor } from './_helpers/jwt.interceptor';

const routes: Route[] = [
  {path: '', component: AppComponent},

  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  
  {path: 'camara', component: CamaraComponent},
  {path: 'fotos', component: FotoComponent},
  
  {path: 'usuario-add', component: UsuarioAddComponent},
  {path: 'usuario-edit', component: UsuarioEditComponent},
  {path: 'usuario-list', component: UsuarioListComponent},
  
  {path: 'persona-add', component: PersonaAddComponent},
  {path: 'persona-edit', component: PersonaEditComponent},
  {path: 'persona-list', component: PersonaListComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    CamaraComponent,
    FotoComponent,
    UsuarioAddComponent,
    UsuarioEditComponent,
    UsuarioListComponent,
    PersonaAddComponent,
    PersonaEditComponent,
    PersonaListComponent
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
