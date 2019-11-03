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
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
      	this.usuariosService.get(id).subscribe(usuario => {
      		if (null) {
            this.usuario.id = usuario.id;
            this.usuario.nombre = usuario.nombre;
            this.usuario.apellido = usuario.apellido;
            this.usuario.email = usuario.email;
          }
          this.gotoList();
    	}, error => console.error(error));
      }
    }, error => console.error(error));
  }

  gotoList() {
    this.router.navigate(['/usuarios-list']);
  }

  save(form: NgForm) {
    this.usuariosService.save(form).subscribe(result => {
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
