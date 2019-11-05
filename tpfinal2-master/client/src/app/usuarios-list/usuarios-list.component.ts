import { Component, OnInit } from '@angular/core';

import { NgForm } from '@angular/forms';

import { UsuarioService } from '../_services/usuario.service';

@Component({
  selector: 'app-usuarios-list',
  templateUrl: './usuarios-list.component.html',
  styleUrls: ['./usuarios-list.component.css']
})
export class UsuariosListComponent implements OnInit {

 usuarios: Array<any>;

 constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
    this.usuarioService.getAll().subscribe(data => {
      alert(data);
      this.usuarios = data;
    }, error => console.error(error));
  }

  remove(href) {
    this.usuarioService.remove(href).subscribe(result => {
    }, error => console.error(error));
  }
  
  submit() {

  }

}
