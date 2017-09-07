import { NavigationComponent } from './../navigation/navigation.component';
import { Component, OnInit } from '@angular/core';
@Component({
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css'],
  entryComponents: [NavigationComponent]
})
export class ContactsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
