import { NavigationComponent } from './navigation/navigation.component';
import { FooterComponent } from './footer/footer.component';
import { CreateArticleComponent } from './create-article/create-article.component';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrls:  ['./app.component.css', '../bootstrap/css/bootstrap.css'],
  entryComponents: [FooterComponent, NavigationComponent]
})
export class AppComponent {
title = 'Orientation';
}

