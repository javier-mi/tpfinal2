import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../shared/usuarios/usuarios.service';

@Component({
  selector: 'app-usuarios-list',
  templateUrl: './usuarios-list.component.html',
  styleUrls: ['./usuarios-list.component.css']
})
export class UsuariosListComponent implements OnInit {
  usuarios: Array<any>;

  constructor(private usuariosService: UsuariosService) { }

  ngOnInit() {
    this.usuariosService.getAll().subscribe(data => {
      this.usuarios = data;
    });
  }

}
