import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-component2',
  templateUrl: './component2.component.html',
  styleUrls: ['./component2.component.css']
})
export class Component2Component implements OnInit {

  @Output() public displayText = new EventEmitter;
  sampleInput?: string;

  inputText() {
    this.displayText.emit(this.sampleInput);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
