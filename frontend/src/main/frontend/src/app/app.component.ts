import { CreateArticleComponent } from './create-article/create-article.component';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrls:  ['./app.component.css', '../bootstrap/css/bootstrap.css'],
  entryComponents: [CreateArticleComponent]
})
export class AppComponent {
title = 'Orientation';
}

