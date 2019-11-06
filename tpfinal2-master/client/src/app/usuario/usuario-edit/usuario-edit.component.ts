import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';

import { UsuarioService } from '../../_services/usuario.service';

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
              private usuarioService: UsuarioService) {
  }

 ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
      	this.usuarioService.get(id).subscribe(usuario => {
      		if (null) {

          }
          this.gotoList();
    	}, error => console.error(error));
      }
    }, error => console.error(error));
  }

  gotoList() {
    this.router.navigate(['/usuario/usuarios-list']);
  }

  save(form: NgForm) {
    this.usuarioService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    alert("remove form id");
    alert(this.usuario.id);
    this.usuarioService.remove(this.usuario).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
  
}
