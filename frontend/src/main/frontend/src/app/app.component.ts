import { CreateArticleComponent } from './create-article/create-article.component';
import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RestProvider } from '../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrls:  ['./app.component.css', '../bootstrap/css/bootstrap.css'],
  entryComponents: [CreateArticleComponent]
})
export class AppComponent implements OnInit {
title = 'Orientation';
image = './../img/dog.png';
clientForm: FormGroup;
  post: any;
  newsletterConcernEmail: string;
  private results: [any];
   private collectionJson: Object;
 collection: any[] = [];
 lastElement: Object;
   submitted = false;
public beginUrl = 'https://www.google.com/url?q=https%3A%2F%2Fafternoon-reaches-41359.herokuapp.com%2Frencontre%2FInternetSurfer%2Fregistration&sa=D&sntz=1&usg=AFQjCNE4MIqkyr7cIswSLCD-1qWTGptEBw';

  constructor(public rest: RestProvider, public fb: FormBuilder, private http: Http) {

      this.clientForm = this.fb.group({
      'newsletterConcernEmail': [null, Validators.compose([Validators.email])]
      });
  }

  onSubmit(post) {
      this. newsletterConcernEmail = post. newsletterConcernEmail;
       const url = this.beginUrl  + '?newsletterConcernEmail=' + post. newsletterConcernEmail;
      const url1 = 'http://192.168.9.102:8092/orientation/surfer/inscriptionToNewsletter'  +
       '?newsletterConcernEmail=' + post. newsletterConcernEmail;
      const url2 = 'https://jsonplaceholder.typicode.com/post';
// console.log(this.firstNameCustomer);
this.rest.postAccountNewsLetter(this.newsletterConcernEmail)
.subscribe((data) => {

      //  console.log(this.firstNameCustomer);
        this.submitted = true;
       });
       this.http.get(url1).subscribe(resp => {
 this.results = resp['results'];
  this.collectionJson = resp.json();
this.collection.push(this.collectionJson);
  console.log(this.collection);
});

  }

  ngOnInit() {

  }

}


