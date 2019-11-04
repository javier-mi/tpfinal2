import { Component, OnInit } from '@angular/core';
import { Usuario } from '../_models/usuario';
import { Router } from '@angular/router';
import { AuthenticationService } from '../_services/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

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

  ngOnInit() {
  }

}
