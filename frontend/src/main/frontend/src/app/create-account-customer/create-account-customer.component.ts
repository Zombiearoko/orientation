import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';

@Component({
  selector: 'app-create-account-customer',
  templateUrl: './create-account-customer.component.html',
  styleUrls: ['./create-account-customer.component.css']
})
export class CreateAccountCustomerComponent implements OnInit {
  clientForm: FormGroup;
  private results: [any];
   private collectionJson: Object;

  constructor(public fb: FormBuilder, private http: Http) { }

  onSubmit() {
 console.log(this.clientForm);
  }

  ngOnInit() {
   const firstNameCustomer = '';
      const lastNameCustomer = '';
      this.clientForm = this.fb.group({
        nom: [firstNameCustomer, Validators.compose([Validators.required])],
       prenom: [lastNameCustomer, Validators.compose([Validators.required, Validators.maxLength(45), Validators.minLength(3)])]
      });
      const url = 'http://192.168.8.110:8092/administrator/createArticle';
this.http.get('https://jsonplaceholder.typicode.com/posts').subscribe(resp => {
 this.results = resp['results'];
  this.collectionJson = resp.json();
  console.log(this.collectionJson);
});
  }

}
