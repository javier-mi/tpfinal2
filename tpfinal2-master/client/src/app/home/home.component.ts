import { UsuarioService } from './../_services/usuario.service';
import { Component, OnInit } from '@angular/core';

import { Usuario } from '../_models/usuario';
import { first } from 'rxjs/operators';

export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {

  loading = false;
  usuarios: any;

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
      this.loading = true;
      this.usuarioService.getAll().pipe(first()).subscribe(usuarios => {
          this.loading = false;
          this.usuarios = usuarios;
      });
  }
}
