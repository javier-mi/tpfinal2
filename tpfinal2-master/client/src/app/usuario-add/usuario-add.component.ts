import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuariosService } from '../shared/usuarios/usuarios.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-usuario-add',
  templateUrl: './usuario-add.component.html',
  styleUrls: ['./usuario-add.component.css']
})
export class UsuarioAddComponent implements OnInit, OnDestroy {

  usuario: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private usuariosService: UsuariosService) {
  }

  ngOnInit() {

  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
  alert("gotolist users-list");
    this.router.navigate(['/usuarios-list']);
  }

  save(form: NgForm) {
  	alert("save start");
    this.usuariosService.save(form).subscribe(result => {
      alert("save complete");
      
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.usuariosService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
  
  submit() {
    alert("submitttt");
  }
  
}
