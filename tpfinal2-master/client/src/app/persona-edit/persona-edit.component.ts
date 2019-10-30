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
            this.persona = persona;
            this.persona.href = persona._links.self.href;
            this.persona.matricula = persona.matricula;
          } else {
            console.log(`La persona con id '${id}' no fue encontrada , volviendo al listado`);
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
