import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';
@Component({
  selector: 'app-article',
  templateUrl: './addArticle.html',
  styleUrls: ['./addArticle.css', '../../bootstrap/css/bootstrap.css']
})
export class AddArticleComponent implements OnInit {
  @Input() articleForm: FormGroup;
 private title: string;
private content: string;
   private results: [any];
   private collectionJson: Object;

  submitted = false;
  constructor( public rest: RestProvider, public formBuilder: FormBuilder, private http: Http) {
    this.createFormAddArticle();
     }

     createFormAddArticle() {
     const title = '';
      const content = '';
      this.articleForm = this.formBuilder.group({
        title: [title, Validators.compose([Validators.required])],
        content: [content, Validators.compose([Validators.required, Validators.maxLength(45), Validators.minLength(3)])]
      });
      }

     onSubmit() {
      const object = {title: this.title, content: this.content};
    this.results.push(object);
    console.log(this.results);
       }
 ngOnInit(): void  {
// la requette http de recupération des données
this.http.get('https://localhost:8092/administrator/createArticle').subscribe(resp => {
  this.results = resp['results'];
  this.collectionJson = resp.json();
  console.log(this.collectionJson);
});
}



}
