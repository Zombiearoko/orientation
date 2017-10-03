import { NavigationComponent } from './../navigation/navigation.component';
import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';
import { SessionClientComponent } from './session-client/session-client.component';
import { RouterModule,Router, ActivatedRoute, ParamMap }   from '@angular/router';
import 'rxjs/add/operator/switchMap';

@Component({
  templateUrl: './create-account-customer.component.html',
  styleUrls: ['./create-account-customer.component.css', '../../bootstrap/css/bootstrap.css'],
  entryComponents: [NavigationComponent, SessionClientComponent]
})
export class CreateAccountCustomerComponent implements OnInit {
   
  clientForm: FormGroup;
  post: any;
  firstNameCustomer: string = 'test';
  lastNameCustomer: string;
  emailAddress: string;
    password: string;
    phoneNumber: string;
    status: number;
  private results: [any];
   private collectionJson: Object;
 collection: any[] = [];
 lastElement: Object;
   submitted = false;
public beginUrl = 'http://localhost:8092';
  constructor(public rest: RestProvider, public fb: FormBuilder, private router: Router, private http: Http) {

      this.clientForm = this.fb.group({
        'firstNameCustomer': [null, Validators.compose([Validators.required, Validators.maxLength(45)])],
       'lastNameCustomer': [null, Validators.compose([Validators.required, Validators.maxLength(45)])],
      'emailAddress': [null, Validators.compose([Validators.email])],
      'password': [null, Validators.compose([Validators.required])],
      'phoneNumber': [null, Validators.compose([Validators.required])]
      });
  }

  onSubmit(post) {
      this.firstNameCustomer = post.firstNameCustomer;
      this.lastNameCustomer = post.lastNameCustomer;
      this.emailAddress = post.emailAddress;
      this.password = post.password;
      this.phoneNumber = post.phoneNumber;
this.rest.postAccount(this.firstNameCustomer , this.lastNameCustomer,  this.emailAddress, this.password, this.phoneNumber  )
.subscribe((data) => {
        console.log('*****************Before******************');
       console.log(data.status);
       this.collection.push(data);
        if(data.status==0){
          this.router.navigate(['/account']);
          }
          else{
            if(data.status==1){
                // this.router.navigate(['/sessionCostumer/:this.firstNameCustomer']);
                this.router.navigate(['/sessionCostumer']);
            }
          }
        
        
        
        
        this.submitted = true;
       });
     /*  this.http.get(url).subscribe(resp => {
 this.results = resp['results'];
  this.collectionJson = resp.json();
this.collection.push(this.collectionJson);
  // console.log(this.collection); 
}); */
  //  const inscrit = document.getElementById('signup');
 // inscrit.innerHTML = this.firstNameCustomer + ' ' + 'vous etes bien inscrit';
// document.body.innerHTML = '<h3 class="pub">publicité </h3>'

  }

  ngOnInit() {

  }

}
