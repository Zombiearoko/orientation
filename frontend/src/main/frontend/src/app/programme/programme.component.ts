import { NavigationComponent } from './../navigation/navigation.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-programme',
  templateUrl: './programme.component.html',
  styleUrls: ['./programme.component.css'],
  entryComponents: [NavigationComponent]
})
export class ProgrammeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
