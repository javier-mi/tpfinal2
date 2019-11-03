import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../shared/usuarios/usuarios.service';
import { NgForm } from '@angular/forms';

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
    }, error => console.error(error));
  }

  remove(href) {
  alert (href);
  alert ("entro al remove");
    this.usuariosService.remove(href).subscribe(result => {
    alert ("corrio remove");
    }, error => console.error(error));
  }
  
  submit() {

  }

}
