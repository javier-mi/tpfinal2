import { Component, OnInit } from '@angular/core';
import { FotoService } from '../../_services/foto.service';

@Component({
  selector: 'fotos',
  templateUrl: './foto.component.html',
  styleUrls: ['./foto.component.css']
})
export class FotoComponent implements OnInit {
  fotos: Array<any>;

  constructor(private fotoService: FotoService) { }

  ngOnInit() {
    this.fotoService.getAll().subscribe(data => {
      this.fotos = data;
    });
  }

}
