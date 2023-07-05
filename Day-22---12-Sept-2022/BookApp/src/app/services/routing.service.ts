import { Location } from '@angular/common';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RoutingService {

  constructor(private route: Router, private location: Location) { }

  accessLogin() {
    this.route.navigate(['login']);
  }
  accessHome() {
    this.route.navigate(['home']);
  }
  accessregister() {
    this.route.navigate(['user']);
  }
  goBack() {
    this.location.back();
  }

  getLoggedInUser(){
    return sessionStorage.getItem("loginkey");
  }
}
