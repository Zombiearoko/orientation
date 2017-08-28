import { NavigationComponent } from './../navigation/navigation.component';
import { FooterComponent } from '../footer/footer.component';
import { Component, OnInit } from '@angular/core';

@Component({
  templateUrl: './administrator-login.component.html',
  styleUrls: ['./administrator-login.component.css', '../../bootstrap/css/bootstrap.css'],
   entryComponents: [FooterComponent, NavigationComponent]
})
export class AdministratorLoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
