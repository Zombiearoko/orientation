import { NavigationComponent } from './../navigation/navigation.component';
import { FooterComponent } from '../footer/footer.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './home.component.html',
  styleUrls: ['./../app.component.css', '../../bootstrap/css/bootstrap.css', './home.component.css'],
    entryComponents: [FooterComponent, NavigationComponent]
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
