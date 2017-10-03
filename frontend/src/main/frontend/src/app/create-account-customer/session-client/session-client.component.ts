import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RestProvider } from '../../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';
// import { RouterModule,Router, ActivatedRoute } from '@angular/router';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'app-session-client',
  templateUrl: './session-client.component.html',
   inputs: ['item'],
  styleUrls: ['./session-client.component.css', '../../../bootstrap/css/bootstrap.css']
})
export class SessionClientComponent implements OnInit {
  @Input() item: any;
  private results: [any];
  name: any;
   collectionJson: Object;
collection: any[] = [];
  public beginUrl = 'http://localhost:8092';
  constructor(public rest: RestProvider, private http: Http) {

  }
  onSubmit() {

  }

  ngOnInit() {
   /* const url = this.beginUrl + '/orientation/customer/authentication';
  const url2 = 'https://jsonplaceholder.typicode.com/posts';
      this.http.get(url).subscribe(resp => {
 this.results = resp['results'];
  this.collectionJson = resp.json();
this.collection.push(this.collectionJson);
  console.log(this.collection);
});
this.name = this.route.ParamMap
    .switchMap((ParamMap: ParamMap) =>
      this.rest.getName(ParamMap.get('firstNameCustomer')))
       this.name = this.route.snapshot.ParamMap['firstNameCustomer'];
      */ 
     // this.name = this.route.snapshot.params['this.firstNameCustomer'];
 
    
  }

}