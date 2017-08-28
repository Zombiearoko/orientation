import { NavigationComponent } from './../navigation/navigation.component';
import { FooterComponent } from '../footer/footer.component';
import { Component, OnInit } from '@angular/core';

@Component({
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css', '../../bootstrap/css/bootstrap.css'],
   entryComponents: [FooterComponent, NavigationComponent]
})
export class ContactsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
