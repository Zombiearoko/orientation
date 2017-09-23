import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';


@Component({
  selector: 'app-login-costumer',
  templateUrl: './login-costumer.component.html',
  styleUrls: ['./login-costumer.component.css', '../../bootstrap/css/bootstrap.css']
})
export class LoginCostumerComponent implements OnInit {

  clientForm: FormGroup;
  post: any;
  emailAdress: string;
    password: string;
  private results: [any];
   private collectionJson: Object;
   submitted = false;
   collection: any[] = [];
  public beginUrl = 'https://www.google.com/url?q=https%3A%2F%2Fafternoon-reaches-41359.herokuapp.com%2Frencontre%2FInternetSurfer%2Fregistration&sa=D&sntz=1&usg=AFQjCNE4MIqkyr7cIswSLCD-1qWTGptEBw';


  constructor(public rest: RestProvider, public fb: FormBuilder, private http: Http) {

      this.clientForm = this.fb.group({
      'emailAddress': [null, Validators.compose([Validators.email])],
      'password': [null, Validators.compose([Validators.required])],
      });
  }

  onSubmit(post) {

      this.emailAdress = post.emailAdress;
      this.password = post.password;
       const url = this.beginUrl + '&emailAddress=' + post.emailAddress + '&password =' + post.password;
      const url1 = 'http://localhost:8092/customer/loginCustomer' + '&emailAddress=' + post.emailAddress
    + '&password =' + post.password;
     const urlInno = 'http://192.168.9.100:8092/customer/addCustomer';
      const url2 = 'https://jsonplaceholder.typicode.com/post';
// console.log(this.firstNameCustomer);
this.rest.postLoginCostumer( this.emailAdress, this.password)
.subscribe((data) => {

      //  console.log(this.firstNameCustomer);
        this.submitted = true;
       });

  }

  ngOnInit() {
  }

}
