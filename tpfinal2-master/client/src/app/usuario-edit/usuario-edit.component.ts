import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuariosService } from '../shared/usuarios/usuarios.service';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-usuario-edit',
  templateUrl: './usuario-edit.component.html',
  styleUrls: ['./usuario-edit.component.css']
})
export class UsuarioEditComponent implements OnInit {

  usuario: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private usuariosService: UsuariosService) {
  }

 ngOnInit() {
    alert('hola init');
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
      	this.usuariosService.get(id).subscribe(usuario => {
      		if (null) {
      		alert("entro hardcodeado");
            this.usuario.id = usuario.id;
            this.usuario.nombre = usuario.nombre;
            this.usuario.apellido = usuario.apellido;
            this.usuario.email = usuario.email;
            alert("Se guardo correctamente.");
          } else {
            alert("Ha ocurrido un error.");
          }
          alert('se va a la lista');
          this.gotoList();
    	}, error => console.error(error));
    	alert('despues del service');
      }
      alert('sale del if');
    }, error => console.error(error));
    alert('chau init');
  }

  gotoList() {
    alert('voy a la list');
    this.router.navigate(['/usuarios-list']);
  }

  save(form: NgForm) {
    alert('save');  
    this.usuariosService.save(form).subscribe(result => {
    alert("save complete");
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    alert("remove form id");
    alert(this.usuario.id);
    this.usuariosService.remove(this.usuario).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
  
}
