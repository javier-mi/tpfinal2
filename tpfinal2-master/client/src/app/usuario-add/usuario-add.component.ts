import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuariosService } from '../shared/usuarios/usuarios.service';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-usuario-add',
  templateUrl: './usuario-add.component.html',
  styleUrls: ['./usuario-add.component.css']
})
export class UsuarioAddComponent implements OnInit {

  usuario: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private usuariosService: UsuariosService) {
  }

  ngOnInit() {

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
