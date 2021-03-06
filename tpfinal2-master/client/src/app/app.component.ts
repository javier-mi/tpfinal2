import { Component } from '@angular/core';
import { Usuario } from './_models/usuario';
import { Router } from '@angular/router';
import { AuthenticationService } from './_services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Thea';
  currentUsuario: Usuario;

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
  ) {
    this.authenticationService.currentUsuario.subscribe(x => this.currentUsuario = x);
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }
}