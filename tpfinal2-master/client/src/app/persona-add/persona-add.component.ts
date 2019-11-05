import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonasService } from '../_services/personas.service';
import { NgForm } from '@angular/forms';

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
              private personasService: PersonasService) {
  }

  ngOnInit() {

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
    this.personasService.remove(this.persona).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
  
}
