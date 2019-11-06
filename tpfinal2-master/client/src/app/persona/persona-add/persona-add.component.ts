import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

import { PersonaService } from '../../_services/persona.service';

@Component({
  selector: 'app-persona-add',
  templateUrl: './persona-add.component.html',
  styleUrls: ['./persona-add.component.css']
})
export class PersonaAddComponent implements OnInit {

  persona: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private personaService: PersonaService) {
  }

  ngOnInit() {

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
    this.personaService.remove(this.persona).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
  
}
