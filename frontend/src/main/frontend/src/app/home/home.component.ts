import { Component, OnInit } from '@angular/core';
import { Popup} from 'ng2-opd-popup';

@Component({
  selector: 'app-root',
  templateUrl: './home.component.html',
  styleUrls: ['./../app.component.css', '../../bootstrap/css/bootstrap.css', './home.component.css'],
})
export class HomeComponent implements OnInit {

  constructor(private popup: Popup) { }
  oneclick() {
    this.popup.show();
  }

  ngOnInit() {
  }

}
