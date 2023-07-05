import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { RoutingService } from 'src/app/services/routing.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  currentuser: any = null;
  currentuserid!: number;
  user: any;
  users: User[] = []
  constructor(private routingService: RoutingService, private userService: UserService) { }

  ngOnInit(): void {
    this.currentuser = this.routingService.getLoggedInUser();
    this.userService.fetchusers().subscribe(res => this.users = res);
  }

  getId() {
    return this.users.filter(obj => obj.username === this.currentuser).map(obj => obj.id)[0];

  }
  login() {
    this.routingService.accessLogin();

  }
  register() {
    this.routingService.accessregister();
  }
  logout() {
    sessionStorage.clear();
    alert("Logout successful");
    this.currentuser = null;
    this.routingService.accessLogin();

  }

}
