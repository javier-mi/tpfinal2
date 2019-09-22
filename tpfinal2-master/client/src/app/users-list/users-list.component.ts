import { Component, OnInit } from '@angular/core';
import { UsersService } from '../shared/users/users.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {
  users: Array<any>;

  constructor(private usersService: UsersService) { }

  ngOnInit() {
    this.usersService.getAll().subscribe(data => {
      this.users = data;
    });
  }

}
