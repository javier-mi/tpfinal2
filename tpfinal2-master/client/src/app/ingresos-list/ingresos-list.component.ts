import { Component, OnInit } from '@angular/core';
import { PersonasService } from '../shared/personas/personas.service';

@Component({
  selector: 'app-ingresos-list',
  templateUrl: './ingresos-list.component.html',
  styleUrls: ['./ingresos-list.component.css']
})
export class IngresosListComponent implements OnInit {
  personas: Array<any>;

  constructor(private personasService: PersonasService) { }

  ngOnInit() {
    this.personasService.getAll().subscribe(data => {
      this.personas = data;
    });
  }

}
