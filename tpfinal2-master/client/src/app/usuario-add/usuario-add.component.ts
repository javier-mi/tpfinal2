import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';

import { UsuarioService } from '../_services/usuario.service';

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
              private usuarioService: UsuarioService) {
  }

  ngOnInit() {

  }

  gotoList() {
    this.router.navigate(['/usuarios-list']);
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
