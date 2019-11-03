import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonasService } from '../shared/personas/personas.service';
import { NgForm } from '@angular/forms';

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
              private personasService: PersonasService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.personasService.get(id).subscribe((persona: any) => {
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
    this.router.navigate(['/personas-list']);
  }

  save(form: NgForm) {
    this.personasService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.personasService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
}
