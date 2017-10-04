import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './home.component.html',
  styleUrls: ['./../app.component.css', '../../bootstrap/css/bootstrap.css', './home.component.css'],
})
export class HomeComponent implements OnInit {
  private time: Date;

  constructor() { }

  ngOnInit() {
    this.time = new Date();
  }

}
