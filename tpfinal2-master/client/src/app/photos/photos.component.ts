import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { UsersService } from '../shared/users/users.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-photos',
  templateUrl: './photos.component.html',
  styleUrls: ['./photos.component.css']
})
export class PhotosComponent implements OnInit, OnDestroy {

  user: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private usersService: UsersService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.usersService.get(id).subscribe((user: any) => {
          if (user) {
            this.user = user;
            this.user.href = user._links.self.href;
            this.user.matricula = user.matricula;
          } else {
            console.log(`El usuario con id '${id}' no fue encontrado , volviendo a listado`);
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
    this.router.navigate(['/users-list']);
  }

  save(form: NgForm) {
    this.usersService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.usersService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
}
