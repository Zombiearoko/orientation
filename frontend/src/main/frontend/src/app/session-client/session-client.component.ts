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
public beginUrl = 'https://www.google.com/url?q=https%3A%2F%2Fafternoon-reaches-41359.herokuapp.com%2Frencontre%2FInternetSurfer%2Fregistration&sa=D&sntz=1&usg=AFQjCNE4MIqkyr7cIswSLCD-1qWTGptEBw';


  constructor(public rest: RestProvider, private http: Http) {

  }
  onSubmit() {

  }

  ngOnInit() {
    const url = this.beginUrl;
    const url1 = 'http://localhost:8092/customer/addCustomer';
  const url2 = 'https://jsonplaceholder.typicode.com/posts';
      this.http.get(url1).subscribe(resp => {
 this.results = resp['results'];
  this.collectionJson = resp.json();
this.collection.push(this.collectionJson);
  console.log(this.collection);
});

  }

}

