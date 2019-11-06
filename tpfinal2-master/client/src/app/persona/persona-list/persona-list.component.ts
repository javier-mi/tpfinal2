import { Component, OnInit } from '@angular/core';

import { PersonaService } from '../../_services/persona.service';

@Component({
  selector: 'app-personas-list',
  templateUrl: './persona-list.component.html',
  styleUrls: ['./persona-list.component.css']
})
export class PersonaListComponent implements OnInit {
  personas: Array<any>;

  constructor(private personaService: PersonaService) { }

  ngOnInit() {
    this.personaService.getAll().subscribe(data => {
      this.personas = data;
    });
  }

}
