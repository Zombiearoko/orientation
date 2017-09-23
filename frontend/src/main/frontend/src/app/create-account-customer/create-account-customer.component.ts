import { NavigationComponent } from './../navigation/navigation.component';
import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';

@Component({
  templateUrl: './create-account-customer.component.html',
  styleUrls: ['./create-account-customer.component.css', '../../bootstrap/css/bootstrap.css'],
  entryComponents: [NavigationComponent]
})
export class CreateAccountCustomerComponent implements OnInit {
  clientForm: FormGroup;
  post: any;
  firstNameCustomer: string;
  lastNameCustomer: string;
  emailAddress: string;
    password: string;
    phoneNumber: string;
  private results: [any];
   private collectionJson: Object;
 collection: any[] = [];
 lastElement: Object;
   submitted = false;

  constructor(public rest: RestProvider, public fb: FormBuilder, private http: Http) {

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
      const url = 'http://192.168.9.102:8092/orientation/surfer/inscription' + '?firstNameCustomer='
    + post.firstNameCustomer + '&lastNameCustomer='
     + post.lastNameCustomer + '&phoneNumber=' + post.phoneNumber + '&emailAddress=' + post.emailAddress
    + '&password =' + post.password;
    const urlSaph = 'https://www.google.com/url?q=https%3A%2F%2Fafternoon-reaches-41359.herokuapp.com%2Frencontre%2FInternetSurfer%2Fregistration&sa=D&sntz=1&usg=AFQjCNE4MIqkyr7cIswSLCD-1qWTGptEBw';
      const url2 = 'https://jsonplaceholder.typicode.com/post';
// console.log(this.firstNameCustomer);
this.rest.postAccount(this.firstNameCustomer , this.lastNameCustomer,  this.emailAddress, this.password, this.phoneNumber  )
.subscribe((data) => {

      //  console.log(this.firstNameCustomer);
        this.submitted = true;
       });
       this.http.get(url).subscribe(resp => {
 this.results = resp['results'];
  this.collectionJson = resp.json();
this.collection.push(this.collectionJson);
  console.log(this.collection);
});

  }

  ngOnInit() {

  }

}
