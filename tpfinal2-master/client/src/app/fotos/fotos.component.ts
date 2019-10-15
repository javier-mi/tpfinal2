import { Component, OnInit } from '@angular/core';
import { FotosService } from '../shared/fotos/fotos.service';

@Component({
  selector: 'fotos',
  templateUrl: './fotos.component.html',
  styleUrls: ['./fotos.component.css']
})
export class FotosComponent implements OnInit {
  fotos: Array<any>;

  constructor(private fotosService: FotosService) { }

  ngOnInit() {
    this.fotosService.getAll().subscribe(data => {
      this.fotos = data;
    });
  }

}
