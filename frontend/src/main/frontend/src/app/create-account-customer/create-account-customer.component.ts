import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';

@Component({
  templateUrl: './create-account-customer.component.html',
  styleUrls: ['./create-account-customer.component.css', '../../bootstrap/css/bootstrap.css']
})
export class CreateAccountCustomerComponent implements OnInit {
  clientForm: FormGroup;
  post: any;
  firstNameCustomer: string;
  lastNameCustomer: string;
  emailAdress: string;
    password: string;
    phoneNumber: string;
  private results: [any];
   private collectionJson: Object;
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
      this.emailAdress = post.emailAdress;
      this.password = post.password;
      this.phoneNumber = post.phoneNumber;
      const url = 'http://localhost:8092/customer/addCustomer' + '?firstNameCustomer='
    + post.firstNameCustomer + '&lastNameCustomer='
     + post.lastNameCustomer + '&phoneNumber=' + post.phoneNumber + '&emailAddress=' + post.emailAddress
    + '&password =' + post.password;
     const urlInno = 'http://192.168.9.100:8092/customer/addCustomer';
      const url2 = 'https://jsonplaceholder.typicode.com/post';
// console.log(this.firstNameCustomer);
this.rest.postAccount(this.firstNameCustomer , this.lastNameCustomer,  this.emailAdress, this.password, this.phoneNumber  )
.subscribe((data) => {

      //  console.log(this.firstNameCustomer);
        this.submitted = true;
       });

  }

  ngOnInit() {

  }

}
