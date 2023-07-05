import { Component, OnInit } from '@angular/core';
import { Hero } from 'src/app/Hero';
import { Heroes } from './mock-heroes';
@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  heroes=Heroes;

  selectedHero?:Hero;

  constructor() { }

  ngOnInit(): void {
  }

  onSelect(hero:Hero){
    this.selectedHero=hero;
  }
}
