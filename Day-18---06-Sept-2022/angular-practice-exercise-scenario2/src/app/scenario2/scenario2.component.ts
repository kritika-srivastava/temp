import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-scenario2',
  templateUrl: './scenario2.component.html',
  styleUrls: ['./scenario2.component.css']
})
export class Scenario2Component implements OnInit {

  name?: string;
  surname?: string;

  displayContents() {
    return '{ NAME: ' + this.name + '<br>  SURNAME: ' + this.surname + ' }';
  }
  constructor() { }

  ngOnInit() {
  }

}
