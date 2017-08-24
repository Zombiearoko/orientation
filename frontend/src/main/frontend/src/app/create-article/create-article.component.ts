import { Article } from './article';
import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.css', '../../bootstrap/css/bootstrap.css']
})
export class CreateArticleComponent implements OnInit {
@Input() articleForm: FormGroup;
 private title: string;
private content: string;
private newArticle: Article;
   private results: [any];
   private collectionJson: Object;

  submitted = false;
  constructor( public rest: RestProvider, public formBuilder: FormBuilder, private http: Http) {
    this.createFormAddArticle();
     }

     createFormAddArticle() {
     const title = '';
      const articleContent = '';
      this.articleForm = this.formBuilder.group({
        title: [title, Validators.compose([Validators.required])],
        content: [articleContent, Validators.compose([Validators.required, Validators.maxLength(45), Validators.minLength(3)])]
      });
      }
    resetForm() {
    this.newArticle = new Article('', '');
    }

     onSubmit(value) {
      const article = new Article(value.title, value.articleContent);
    console.log(article);
     this.resetForm();
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
