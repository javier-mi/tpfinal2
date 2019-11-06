import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

import { PersonaService } from '../../_services/persona.service';

@Component({
  selector: 'app-persona-edit',
  templateUrl: './persona-edit.component.html',
  styleUrls: ['./persona-edit.component.css']
})
export class PersonaEditComponent implements OnInit, OnDestroy {

  persona: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private personaService: PersonaService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.personaService.get(id).subscribe((persona: any) => {
          if (persona) {
            this.persona.nombre = persona.nombre;
            this.persona.apellido = persona.apellido;
            this.persona.dni = persona.dni;
            this.persona.matricula = persona.matricula;
    	    alert("Se guardo correctamente");
          } else {
	        alert("Ha ocurrido un error");
          }
          this.gotoList();
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/persona/persona-list']);
  }

  save(form: NgForm) {
    this.personaService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.personaService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
}
