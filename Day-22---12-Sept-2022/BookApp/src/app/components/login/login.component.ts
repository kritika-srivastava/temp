import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { RoutingService } from 'src/app/services/routing.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userlist: User[] = []

  constructor(private userService: UserService, private routingService: RoutingService) { }

  login(username: any, password: any) {

    const user = this.userlist.find(obj => obj.username === username && obj.password === password);
    if (user != null) {
      alert("Login Successful");

      //  after login we store the username in the session storage
      sessionStorage.setItem("loginkey", user.username);
      // sessionStorage.getItem("loginkey");

      this.routingService.accessHome();
    }
    else {
      alert("User does not exist");
      return;
    }

  }
  ngOnInit(): void {
    this.userService.fetchusers().subscribe(res => this.userlist = res);
  }

}
