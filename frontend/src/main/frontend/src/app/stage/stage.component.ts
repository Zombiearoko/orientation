import { NavigationComponent } from './../navigation/navigation.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-stage',
  templateUrl: './stage.component.html',
  styleUrls: ['./stage.component.css'],
  entryComponents: [NavigationComponent]
})
export class StageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
