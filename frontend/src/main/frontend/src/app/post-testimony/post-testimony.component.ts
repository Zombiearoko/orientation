import { NavigationComponent } from './../navigation/navigation.component';
import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';

@Component({
  selector: 'app-post-testimony',
  templateUrl: './post-testimony.component.html',
  styleUrls: ['./post-testimony.component.css'],
  entryComponents: [NavigationComponent]
})
export class PostTestimonyComponent implements OnInit {
clientForm: FormGroup;
  post: any;
  testimonyAuthor: string;
   testimonyContent: string;
  private results: [any];
   private collectionJson: Object;
   submitted = false;
   collection: any[] = [];
  public beginUrl = 'https://www.google.com/url?q=https%3A%2F%2Fafternoon-reaches-41359.herokuapp.com%2Frencontre%2FInternetSurfer%2Fregistration&sa=D&sntz=1&usg=AFQjCNE4MIqkyr7cIswSLCD-1qWTGptEBw';


  constructor(public rest: RestProvider, public fb: FormBuilder, private http: Http) {

      this.clientForm = this.fb.group({
      'testimonyAuthor': [null, Validators.compose([Validators.required])],
      'testimonyContent': [null, Validators.compose([Validators.required, Validators.maxLength(60)])],
      });
  }

  onSubmit(post) {

      this.testimonyAuthor = post.testimonyAuthor;
      this.testimonyContent = post.testimonyContent;
const url = this.beginUrl  + '?testimonyAuthor=' + post.testimonyAuthor+ '&testimonyContent =' + post.testimonyContent ;
      const url1 = 'http://localhost:8092/customer/postTestimony' + '&testimonyAuthor=' + post.testimonyAuthor
    + '&testimonyContent =' + post.testimonyContent;
      const url2 = 'https://jsonplaceholder.typicode.com/post';
// console.log(this.firstNameCustomer);
this.rest.postTestimony( this.testimonyAuthor, this.testimonyContent)
.subscribe((data) => {

      //  console.log(this.firstNameCustomer);
        this.submitted = true;
       });

  }

  ngOnInit() {
  }

}
