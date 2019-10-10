import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuariosService } from '../shared/usuarios/usuarios.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-usuario-edit',
  templateUrl: './usuario-edit.component.html',
  styleUrls: ['./usuario-edit.component.css']
})
export class UsuarioEditComponent implements OnInit, OnDestroy {

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
        this.usuariosService.get(id).subscribe((usuario: any) => {
          if (usuario) {
            this.usuario = usuario;
            this.usuario.href = usuario._links.self.href;
            this.usuario.matricula = usuario.matricula;
          } else {
            console.log(`El usuario con id '${id}' no fue encontrado , volviendo a listado`);
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/users-list']);
  }

  save(form: NgForm) {
    this.usuariosService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.usuariosService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
}
