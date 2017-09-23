import { NavigationComponent } from './../navigation/navigation.component';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-bourse',
  templateUrl: './bourse.component.html',
  styleUrls: ['./bourse.component.css'],
  entryComponents: [NavigationComponent]
})
export class BourseComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
