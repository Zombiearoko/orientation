import { NavigationComponent } from './../navigation/navigation.component';
import { Component, OnInit } from '@angular/core';

@Component({
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css'],
  entryComponents: [NavigationComponent]
})
export class ServiceComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
