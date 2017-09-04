import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';

@Component({
  selector: 'app-librairie',
  templateUrl: './librairie.component.html',
  styleUrls: ['./librairie.component.css', '../../bootstrap/css/bootstrap.css']
})
export class LibrairieComponent implements OnInit {
private results: [any];
   private collectionJson: Object;
   private bookName: string;
   submitted = false;
  constructor(public rest: RestProvider, private http: Http) {

  }
  onSubmit() {

  }

  ngOnInit() {
  const url2 = 'https://jsonplaceholder.typicode.com/posts';
      this.http.get(url2).subscribe(resp => {
 this.results = resp['results'];
  this.collectionJson = resp.json();
  console.log(this.collectionJson);
});
}
addInBasket(post) {
   this.bookName = post.bookName;
      const url = 'http://192.168.8.102:8092/customer/addInBasket' + '?bookName='
    + post.firstNameCustomer;
    const urlSaph = 'http://192.168.8.105:8091/rencontre/Member/registration';
     const urlInno = 'http://localhost:8092/customer/addCustomer';
      const url2 = 'https://jsonplaceholder.typicode.com/post';
 console.log(this.bookName);
this.rest.postBookInBasket(this.bookName)
.subscribe((data) => {

        this.submitted = true;
       });

}
}
