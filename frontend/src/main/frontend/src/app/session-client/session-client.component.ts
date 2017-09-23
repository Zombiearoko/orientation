import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';

@Component({
  selector: 'app-session-client',
  templateUrl: './session-client.component.html',
  styleUrls: ['./session-client.component.css', '../../bootstrap/css/bootstrap.css']
})
export class SessionClientComponent implements OnInit {
  private results: [any];
   collectionJson: Object;
collection: any[] = [];

  constructor(public rest: RestProvider, private http: Http) {

  }
  onSubmit() {

  }

  ngOnInit() {
    const url = 'http://localhost:8092/customer/addCustomer';
  const url2 = 'https://jsonplaceholder.typicode.com/posts';
      this.http.get(url2).subscribe(resp => {
 this.results = resp['results'];
  this.collectionJson = resp.json();
this.collection.push(this.collectionJson);
  console.log(this.collection);
});

  }

}

