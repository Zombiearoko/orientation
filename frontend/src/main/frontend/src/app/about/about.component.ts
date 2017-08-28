import { NavigationComponent } from './../navigation/navigation.component';
import { FooterComponent } from '../footer/footer.component';
import { Component, OnInit } from '@angular/core';

@Component({
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css', '../../bootstrap/css/bootstrap.css'],
  entryComponents: [FooterComponent, NavigationComponent]
})
export class AboutComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
