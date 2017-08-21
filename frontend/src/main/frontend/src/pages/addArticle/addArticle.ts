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
  @Input('group')
public articleForm: FormGroup;
  public name: string;
  public surname: string;
  private title: string;
   private results: string[];
   private collectionJson: Object;
  public valrecu = {
    name: 'test',
    surname: 'test',
    application_type: 'test'
  };
  submitted = false;
  constructor( public rest: RestProvider, public formBuilder: FormBuilder, private http: Http) {
    this.createForm1();
     }

     createForm1() {
     const title = '';
      const content = '';
      this.articleForm = this.formBuilder.group({
        title: [title, Validators.compose([Validators.required])],
        content: [content, Validators.compose([Validators.required, Validators.maxLength(45), Validators.minLength(3)])]
      });
      }

     onSubmit() {
       this.rest.getHello(this.articleForm.value.title, this.articleForm.value.content).subscribe((data) => {
        this.valrecu = data;
        this.submitted = true;
       });
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
