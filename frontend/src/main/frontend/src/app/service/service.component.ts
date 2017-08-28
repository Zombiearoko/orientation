import { FooterComponent } from './../footer/footer.component';
import { NavigationComponent } from './../navigation/navigation.component';
import { Component, OnInit } from '@angular/core';

@Component({
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css', '../../bootstrap/css/bootstrap.css'],
  entryComponents: [NavigationComponent, FooterComponent]
})
export class ServiceComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
