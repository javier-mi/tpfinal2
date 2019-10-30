import { Component, OnInit } from '@angular/core';
import { PersonasService } from '../shared/personas/personas.service';

@Component({
  selector: 'app-personas-list',
  templateUrl: './personas-list.component.html',
  styleUrls: ['./personas-list.component.css']
})
export class PersonasListComponent implements OnInit {
  personas: Array<any>;

  constructor(private personasService: PersonasService) { }

  ngOnInit() {
    this.personasService.getAll().subscribe(data => {
      this.personas = data;
    });
  }

}
