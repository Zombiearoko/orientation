
import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';
import { RouterModule,Router, ActivatedRoute, ParamMap }   from '@angular/router';
@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css', '../../bootstrap/css/bootstrap.css']
})
export class NavigationComponent implements OnInit {
clientForm: FormGroup;
    status: number;
  private results: [any];
   private collectionJson: object;
 collection: any[] = [];
 lastElement: Object;
   submitted = false;
   public beginUrl = 'http://localhost:8092';
  constructor(public rest: RestProvider,  private router: Router, private http: Http) { }
  deconnexion(){
     const url = this.beginUrl + '/orientation/customer/deconnection'
    this.http.get(url).subscribe(resp => {
 this.results = resp['results'];
  this.collectionJson = resp.json();
this.collection.push(this.collectionJson);
console.log('******test*****'); 
  console.log(this.collectionJson); 
  if(this.collectionJson){
          this.router.navigate(['/home']);
          }
});
              
  }

  ngOnInit() {
  }

}
